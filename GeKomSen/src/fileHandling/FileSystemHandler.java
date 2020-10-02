package fileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;

import app.AppCore;
import model.GeKomSenSettings;
import model.LooseDirs;
import treeNodeModels.ProjectTreeModel;

public class FileSystemHandler {
	
public static void deleteFileSystem(File f){
	if(!f.exists())return;
	Stack<File> st=new Stack<>();
	st.push(f);
	File tmp;
	while(!st.empty()){
		tmp=st.peek();
		if(tmp.isFile()){tmp.delete();st.pop();}
		else{
			if(tmp.isDirectory()){
				if(tmp.listFiles().length==0){tmp.delete();st.pop();}
				else{
					for(File i:tmp.listFiles())st.push(i);
				}
			}
		}
	}
}

public static String trimLastDirectory(String s){
	return s.substring(0,s.lastIndexOf("\\"));
}

public static void getSettings(){
	GeKomSenSettings.getInstance().setLoadingSettings(true);
	
	File fl= new File(AppCore.SETTINGS_FILE);
	if(!fl.exists()){
		GeKomSenSettings.getInstance().restoreDefaults();
		return;
		}
	BufferedReader br;
	try {
		br = new BufferedReader(new FileReader(fl));
		String s;
		while((s=br.readLine())!=null){
			if(s.startsWith("["))continue;
			String[] par= s.split("=");
			if(par.length!=2)continue;
			
			
			switch(par[0]){
			
			case("workspacePath"):
				GeKomSenSettings.getInstance().setWorkspacePath(par[1]);
				break;
			case("workspaceName"):
				GeKomSenSettings.getInstance().setWorkspaceName(par[1]);
				break;
			case("workspaceDialogOnStart"):
				if(par[1].equals("true")){
				GeKomSenSettings.getInstance().setWorkspaceDialogOnStart(true);
				}
				if(par[1].equals("false")){
				GeKomSenSettings.getInstance().setWorkspaceDialogOnStart(false);
				}
				break;
			default:
				System.out.println("Found unknown setting: "+par[0]);
				break;
			}
		}
		br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally{
		GeKomSenSettings.getInstance().setLoadingSettings(false);
	}
	
}

public static void writeSettings(){
	if(GeKomSenSettings.getInstance().isLoadingSettings())return;
	try {
		PrintWriter pr=new PrintWriter(new File(AppCore.SETTINGS_FILE));
		pr.write("[WORKSPACE]\n");
		pr.write("workspacePath="+GeKomSenSettings.getInstance().getWorkspacePath()+"\n");
		pr.write("workspaceName="+GeKomSenSettings.getInstance().getWorkspaceName()+"\n");
		pr.write("workspaceDialogOnStart="+GeKomSenSettings.getInstance().isWorkspaceDialogOnStart());
		pr.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static String[] parsePathAndName(String s){
	String[] a=new String[2];
	a[0]=FileSystemHandler.trimLastDirectory(s);
	a[1]=new File(s).getName();
	
	
	return a;
}

public static void saveStringArray(ArrayList<String> lst, String s){
	if(lst==null) { new File(s).mkdir(); return; }
	try {
		PrintWriter pr=new PrintWriter(new File(s));
		for(String i: lst){
			pr.write(i+"\n");
		}
		pr.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

public static ArrayList<String> loadStringArray(String file){
	try {
		BufferedReader br=new BufferedReader(new FileReader(file));
		String s;
		ArrayList<String> lst=new ArrayList<>();
		while((s=br.readLine())!=null)lst.add(s);
		br.close();
		return lst;
	} catch (FileNotFoundException e) {
		try {
			PrintWriter pr=new PrintWriter(new File(file));
			pr.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return new ArrayList<>();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public static void deleteProject(ProjectTreeModel ptm){
	File target=new File(ptm.getInfo().getAbsoluteFilePath()+"\\docs");
	if(!target.exists())return;
	for(File i:target.listFiles()){
		if(ptm.getInfo().getDocuments().contains(i.getName()))i.delete();
	}
	
	target.delete();
	target=new File(ptm.getInfo().getAbsoluteFilePath()+"\\"+ptm.getInfo().getName()+".prjinfo");
	target.delete();
	target=target.getParentFile();
	target.delete();
}

public static boolean validFileName(String s){
	if(s.contains("*"))return false;
	if(s.contains("<"))return false;
	if(s.contains(">"))return false;
	if(s.contains("|"))return false;
	if(s.contains(":"))return false;
	if(s.contains("/"))return false;
	if(s.contains("\\"))return false;
	if(s.contains("\""))return false;
	return true;
}
}
