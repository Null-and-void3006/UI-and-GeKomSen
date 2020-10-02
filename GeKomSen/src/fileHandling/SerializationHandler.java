package fileHandling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.ArrayList;

import app.AppCore;
import model.LooseDirs;
import treeInfoModels.ProjectInfoModel;
import treeInfoModels.WorkspaceInfoModel;
import treeInfoModels.DocumentInfoModel;
import treeNodeModels.DocumentTreeModel;
import treeNodeModels.ElementTreeModel;
import treeNodeModels.PageTreeModel;
import treeNodeModels.ProjectTreeModel;
import treeNodeModels.SlotTreeModel;
import treeNodeModels.WorkspaceTreeModel;

public class SerializationHandler {
	
	public static ObjectOutputStream getObjectOutputStream(String s){
	
		
		try {
			return new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(s))));
			
		} catch (IOException e) {
			System.out.println("IOException while accessing "+s);
			return null;
		}
	}
	
public static ObjectInputStream getObjectInputStream(String s){
	
		
		try {
			return new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(s))));
			
		} catch (IOException e) {
			System.out.println("IOException while accessing "+s);
			return null;
		}
	}

public static <T extends Object> T readObject(String file, Class<T> type){
	
	if(type==WorkspaceTreeModel.class){
		File root= new File(file);
		if(!root.exists())return null;
		WorkspaceTreeModel wtm=new WorkspaceTreeModel();
		WorkspaceInfoModel wim=new WorkspaceInfoModel();
		wim.setName(root.getName());
		wtm.setInfo(wim);
		
		File[] list=root.listFiles();
		ArrayList<String> looseProjects=new ArrayList<>();
		ArrayList<String> looseDocuments=new ArrayList<>();
		for(File i:list){
			if(!i.isFile()){
			ProjectTreeModel ptm=readObject(i.getAbsolutePath(), ProjectTreeModel.class);
			if(ptm!=null){
				if(ptm.getInfo().isAssociateWithWorkspace()){wtm.add(ptm);}
				else {
					looseProjects.add(i.getAbsolutePath());
					AppCore.getInstance().getLoadedProjects().remove(i.getAbsolutePath());
					for(DocumentTreeModel k:ptm.getChildren()){
						AppCore.getInstance().getLoadedDocuments().remove(k.getInfo().getAbsoluteFilePath());
					}
				}
				}
			}
			else{
				if(i.isFile()&&i.getName().endsWith(".gedoc")){
					looseDocuments.add(i.getAbsolutePath());
				}
			}
		}
		LooseDirs.getInstance().addLooseDirs(looseProjects);
		LooseDirs.getInstance().addLooseDirs(looseDocuments);
		return type.cast(wtm);
	}
	
	else{
		if(type==ProjectTreeModel.class){
			File root= new File(file);
			if(!root.exists())return null;
			File infoSource=new File(root.getAbsolutePath()+"\\"+root.getName()+".prjinfo");
			if(!infoSource.exists())return null;
			ProjectInfoModel pim=readObject(infoSource.getAbsolutePath(), ProjectInfoModel.class);
			ProjectTreeModel ptm=new ProjectTreeModel();
			ptm.setInfo(pim);
			File dirFolder = new File(root.getAbsolutePath()+"\\docs");
			if(!dirFolder.exists())dirFolder.mkdir();
			File[] list=dirFolder.listFiles();
			ArrayList<String> looseDocuments=new ArrayList<>();
			ArrayList<String> foundDocuments=new ArrayList<>();
			for(File i:list){
				if(i.isFile()&&i.getName().endsWith(".gedoc")){
					if(!pim.getDocuments().contains(i.getName())){looseDocuments.add(i.getAbsolutePath());}
					else{
						DocumentTreeModel dtm=readObject(i.getAbsolutePath(), DocumentTreeModel.class);
						if(dtm!=null){
							ptm.add(dtm);
							foundDocuments.add(i.getName());
							}
					}
				}
					
			}
			
			
			ptm.missingDocumentsError(foundDocuments);
			LooseDirs.getInstance().addLooseDirs(looseDocuments);
			AppCore.getInstance().getLoadedProjects().add(file);
			return type.cast(ptm);
		}
	}
	
	//Standard Read
	ObjectInputStream ois=getObjectInputStream(file);
	if(ois==null)return null;
	T result=null;
	try {
		result= type.cast( ois.readObject());
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Non regular code
	if(result instanceof ProjectInfoModel){ 
		//Sta je najgore bio sam trezan kad sam napisao ovu drugu liniju
		((ProjectInfoModel)result).setAbsoluteFilePath(FileSystemHandler.trimLastDirectory(file));
		((ProjectInfoModel)result).setName(FileSystemHandler.parsePathAndName(FileSystemHandler.trimLastDirectory(file))[1]);
		}
	if(result instanceof DocumentTreeModel){
		((DocumentTreeModel)result).getInfo().setAbsoluteFilePath(file);
		((DocumentTreeModel)result).getInfo().setName(FileSystemHandler.parsePathAndName(file)[1]);
		AppCore.getInstance().getLoadedDocuments().add(file);
	}
	
	return result;
}

public static void writeObject(String file,Object s){
	
	if(s instanceof WorkspaceTreeModel){
		File root=new File(file+"\\"+s.toString());
		root.mkdirs();
		WorkspaceTreeModel wtm=(WorkspaceTreeModel) s;
		for(ProjectTreeModel i:wtm.getChildren()){
			writeObject(root.getAbsolutePath(), i);
		}
	}
	else if(s instanceof ProjectTreeModel){
		File root =new File(file+"\\"+s.toString());
		root.mkdirs();
		ProjectTreeModel ptm=(ProjectTreeModel) s;
		writeObject(root.getAbsolutePath(), ptm.getInfo());
		File docfile= new File(root.getAbsolutePath()+"\\docs");
		docfile.mkdir();
		for(DocumentTreeModel i:ptm.getChildren()){
			writeObject(docfile.getAbsolutePath(),i);
		}
	}
	else{
	
		if(s instanceof DocumentTreeModel && (!file.endsWith(".gedoc")||new File(file).isDirectory())){file=file+"\\"+s.toString();}
		else if (s instanceof ProjectInfoModel){file=file+"\\"+s.toString()+".prjinfo";}
		
		//Standard Write
	ObjectOutputStream ous=getObjectOutputStream(file);
	
	try {
		ous.writeObject(s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		try {
			ous.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
}
}
