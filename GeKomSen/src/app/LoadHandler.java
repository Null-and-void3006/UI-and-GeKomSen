package app;

import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultTreeModel;

import fileHandling.FileSystemHandler;
import fileHandling.SerializationHandler;
import model.GeKomSenSettings;
import model.LooseDirs;
import treeInfoModels.DocumentInfoModel;
import treeInfoModels.ElementInfoModel;
import treeInfoModels.PageInfoModel;
import treeInfoModels.ProjectInfoModel;
import treeInfoModels.SlotInfoModel;
import treeInfoModels.WorkspaceInfoModel;
import treeNodeModels.DocumentTreeModel;
import treeNodeModels.ElementTreeModel;
import treeNodeModels.PageTreeModel;
import treeNodeModels.ProjectTreeModel;
import treeNodeModels.SlotTreeModel;
import treeNodeModels.TreeNodeOverrides;
import treeNodeModels.WorkspaceTreeModel;
import view.MainFrame;
import view.NewDocumentDialog;
import view.NewProjectDialog;
import view.OpenDocumentDialog;
import view.OpenProjectDialog;
import view.RemoveFromJTreeDialog;
import view.WorkspaceChangeDialog;

public class LoadHandler {
	
	public WorkspaceTreeModel getDummy(){
		
		WorkspaceInfoModel wim= new WorkspaceInfoModel();
		wim.setName(GeKomSenSettings.getInstance().getWorkspaceName());
		ProjectInfoModel pim=new ProjectInfoModel();
		pim.setName("Proj1");
		ProjectInfoModel pim2=new ProjectInfoModel();
		pim2.setName("Proj2");
		DocumentInfoModel dim=new DocumentInfoModel();
		dim.setName("Doc1.gedoc");
		DocumentInfoModel dim2=new DocumentInfoModel();
		dim2.setName("Doc2.gedoc");
		PageInfoModel paim=new PageInfoModel();
		paim.setName("Page1");
		SlotInfoModel sim =new SlotInfoModel();
		sim.setName("Slot1 - Sta god to bilo");
		ElementInfoModel eim=new ElementInfoModel();
		eim.setName("Elem1");
		
		
		WorkspaceTreeModel wtm= new WorkspaceTreeModel(wim);
		ProjectTreeModel ptm=new ProjectTreeModel(pim);
		ProjectTreeModel ptm2=new ProjectTreeModel(pim2);
		DocumentTreeModel dtm=new DocumentTreeModel(dim);
		DocumentTreeModel dtm2=new DocumentTreeModel(dim2);
		PageTreeModel patm=new PageTreeModel(paim);
		SlotTreeModel stm =new SlotTreeModel(sim);
		ElementTreeModel etm=new ElementTreeModel(eim);
		
		
		
		wtm.addChild(ptm);
		wtm.addChild(ptm2);
		ptm.addChild(dtm);
		ptm2.addChild(dtm2);
		dtm.add(patm);
		patm.addChild(stm);
		stm.addChild(etm);
		
		
		return wtm;
	}
	public WorkspaceTreeModel getWorkSpaceRoot(WorkspaceTreeModel wtm, boolean GENERATE_NEW_DUMMY){
		if(GENERATE_NEW_DUMMY){
			wtm=getDummy();
			SerializationHandler.writeObject(GeKomSenSettings.getInstance().getWorkspacePath(), wtm);
		}
		File tst= new File(GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName());
		if(!tst.exists())tst.mkdirs();
		wtm=SerializationHandler.readObject(GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName(), WorkspaceTreeModel.class);
		
		return wtm;
	}
	
	public WorkspaceTreeModel getLooseProjectsRoot(ArrayList<String> loadedProjects){
		WorkspaceTreeModel wtm=new WorkspaceTreeModel();
		WorkspaceInfoModel wim=new WorkspaceInfoModel();
		wim.setName("\\LooseProjects");
		wtm.setInfo(wim);
		ArrayList<String> projects=LooseDirs.getInstance().getLooseProjects();
		for(String i:projects){
			if(loadedProjects.contains(i)){
				
				System.out.println("Detected double load of project at:");
				System.out.println(i);
				System.out.println("Removing it from "+AppCore.LOOSE);
				LooseDirs.getInstance().removeFromLoose(i);
				continue;
			}
			ProjectTreeModel ptm=SerializationHandler.readObject(i, ProjectTreeModel.class);
			if(ptm!=null)wtm.add(ptm);
			else{
				//TODO: Handle Failiures
				System.out.println("Loose Project read fail: "+i);
				System.out.println("Removing it from "+AppCore.LOOSE);
				LooseDirs.getInstance().removeFromLoose(i);
			}
		}
		
		return wtm;
	}
	
	public ProjectTreeModel getLooseDocumentsRoot(ArrayList<String> loadedDocuments){
		ProjectTreeModel ptm=new ProjectTreeModel();
		ProjectInfoModel pim=new ProjectInfoModel();
		pim.setName("\\LooseDocuments");
		ptm.setInfo(pim);
		ArrayList<String> projects=LooseDirs.getInstance().getLooseDocuments();
		for(String i:projects){
			if(loadedDocuments.contains(i)){
				System.out.println("Detected double load of document at:");
				System.out.println(i);
				System.out.println("Removing it from "+AppCore.LOOSE);
				LooseDirs.getInstance().removeFromLoose(i);
				continue;
			}
			DocumentTreeModel dtm=SerializationHandler.readObject(i, DocumentTreeModel.class);
			if(dtm!=null)ptm.add(dtm);
			else{
				//TODO: Handle Failiures
				System.out.println("Loose Document read fail: "+i);
				System.out.println("Removing it from "+AppCore.LOOSE);
				LooseDirs.getInstance().removeFromLoose(i);
			}
		}
		
		return ptm;
	}
	
	public void moveToLoose(TreeNodeOverrides s){
		if(s instanceof ProjectTreeModel){
			((WorkspaceTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree().getModel().getRoot()).add((ProjectTreeModel)s);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree());
			LooseDirs.getInstance().addToLoose(((ProjectTreeModel)s).getInfo().getAbsoluteFilePath());
			}
		else if(s instanceof DocumentTreeModel){
			((ProjectTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getLooseDocumentsJTree().getModel().getRoot()).add((DocumentTreeModel)s);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseDocumentsJTree());
			LooseDirs.getInstance().addToLoose(((DocumentTreeModel)s).getInfo().getAbsoluteFilePath());
			}
	}
	
public void handleDelete(ArrayList<String> loadedDocuments, ArrayList<String> loadedProjects) {
		
		//Funkcija pod pretpostavkom da postoje samo 3 stabla u projektu
		
		TreeNodeOverrides target=AppCore.getInstance().getMainFrame().getTreePanel().getSelection();
		RemoveFromJTreeDialog dialog=(RemoveFromJTreeDialog) AppCore.getInstance().popDialog();
		TreeNodeOverrides parent=(TreeNodeOverrides) target.getParent();
		
		boolean workspaceDelete=AppCore.getInstance().getMainFrame().getTreePanel().getJTree()==AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree();
		boolean looseProjectsDelete=AppCore.getInstance().getMainFrame().getTreePanel().getJTree()==AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree();
		boolean looseDocumentsDelete=(!workspaceDelete) && (!looseProjectsDelete);
		boolean perma=dialog.getCB();
		
		if(target instanceof ElementTreeModel){
			AppCore.getInstance().removeNodeFromJTree(target, parent);
			((DocumentTreeModel)target.getParent().getParent().getParent()).updateSelf();
			
		}
		
	else if(target instanceof SlotTreeModel){
		AppCore.getInstance().removeNodeFromJTree(target, parent);
			((DocumentTreeModel)target.getParent().getParent()).updateSelf();
			
		}
		
	else if(target instanceof PageTreeModel){
		AppCore.getInstance().removeNodeFromJTree(target, parent);
			((DocumentTreeModel)target.getParent()).updateSelf();
			
		}
		
	else if(target instanceof DocumentTreeModel){
		AppCore.getInstance().removeNodeFromJTree(target, parent);
		AppCore.getInstance().getMainFrame().removalOfDocument((DocumentTreeModel) target);
			String filePath=((DocumentTreeModel)target).getInfo().getAbsoluteFilePath();
			if(!looseDocumentsDelete)((ProjectTreeModel)parent).updateProjectData();
			if(perma){
				FileSystemHandler.deleteFileSystem(new File(filePath));
				if(looseDocumentsDelete)LooseDirs.getInstance().removeFromLoose(filePath);
				loadedDocuments.remove(filePath);
			}
			else{
				if(!looseDocumentsDelete)moveToLoose(target);
				else {
					LooseDirs.getInstance().addToBlacklist(filePath);
					loadedDocuments.remove(filePath);
				}
			}
			
		}
		
	else if(target instanceof ProjectTreeModel){
		AppCore.getInstance().removeNodeFromJTree(target, parent);
			String filePath=((ProjectTreeModel)target).getInfo().getAbsoluteFilePath();
			for(DocumentTreeModel i:((ProjectTreeModel) target).getChildren()){
				AppCore.getInstance().getMainFrame().removalOfDocument(i);
			}
			if(perma){
				FileSystemHandler.deleteProject((ProjectTreeModel) target);
				if(looseProjectsDelete)LooseDirs.getInstance().removeFromLoose(filePath);
				loadedProjects.remove(filePath);
			}
			else{
				((ProjectTreeModel)target).getInfo().setAssociateWithWorkspace(false);
				((ProjectTreeModel)target).updateProjectData();
				if(!looseProjectsDelete)moveToLoose(target);
				else {
					LooseDirs.getInstance().addToBlacklist(filePath);
					loadedProjects.remove(filePath);
				}
			}
		}
		
		dialog.dispose();
		
	}

	public void initWorkspace(ArrayList<String> loadedProjects, ArrayList<String> loadedDocuments){
		WorkspaceChangeDialog dialog=(WorkspaceChangeDialog) AppCore.getInstance().popDialog();
	
		String[] pr=FileSystemHandler.parsePathAndName(dialog.getWorkspacePath());
	
	
		GeKomSenSettings.getInstance().setWorkspacePath(pr[0]);
		GeKomSenSettings.getInstance().setWorkspaceName(pr[1]);
	
		if(AppCore.getInstance().getMainFrame()==null){
			GeKomSenSettings.getInstance().setWorkspaceDialogOnStart(dialog.getShowOnStartup());
			AppCore.getInstance().initMainFrame();
			AppCore.getInstance().getMainFrame().setVisible(true);
			AppCore.getInstance().emptyErrorQueue();
			}
		else{
			ArrayList<String> tet=AppCore.getInstance().getMainFrame().getTreePanel().getWorkspacePaths();
			loadedDocuments.removeAll(tet);
			loadedProjects.removeAll(tet);
		
			WorkspaceTreeModel wtm=(WorkspaceTreeModel) AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree().getModel().getRoot();
			for(ProjectTreeModel i:wtm.getChildren()){
				for(DocumentTreeModel j:i.getChildren()){
					AppCore.getInstance().getMainFrame().removalOfDocument(j);
				}
			}
		
			wtm=AppCore.getInstance().getWorkspaceRoot();
			AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree().setModel(new DefaultTreeModel(wtm));
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree());
			}

		dialog.dispose();
	}
	
	public void addNewProject(ArrayList<String> loadedProjects){
		ProjectTreeModel ptm=((NewProjectDialog)AppCore.getInstance().getCurrentDialog()).generateProject();
		File f=new File(ptm.getInfo().getAbsoluteFilePath());
		if(!FileSystemHandler.validFileName(ptm.toString())){AppCore.getInstance().showErrorDialog("Invalid project name");}
		else if(f.exists()){AppCore.getInstance().showErrorDialog("Name already taken");}
		else{
			SerializationHandler.writeObject(GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName(), ptm);
			loadedProjects.add(ptm.getInfo().getAbsoluteFilePath());
			((WorkspaceTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree().getModel().getRoot()).add(ptm);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree());
			}
		AppCore.getInstance().closeCurrentDialog();
				
	}
	
	public void addNewDocument(){
		DocumentTreeModel dtm=((NewDocumentDialog)AppCore.getInstance().getCurrentDialog()).generateDocument();
		ProjectTreeModel target=null;
		String s;
		AppCore.getInstance().closeCurrentDialog();
		if(AppCore.getInstance().getMainFrame().getTreePanel().getSelection()!=null && AppCore.getInstance().getMainFrame().getTreePanel().getSelection() instanceof ProjectTreeModel)target=(ProjectTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getSelection();
		if(!FileSystemHandler.validFileName(dtm.toString())){AppCore.getInstance().showErrorDialog("Invalid file name");return;}
		if(target!=null){
			dtm.getInfo().setAbsoluteFilePath(target.getInfo().getAbsoluteFilePath()+"\\docs\\"+dtm.toString());
			s=target.getInfo().getAbsoluteFilePath()+"\\docs";
			File f=new File(dtm.getInfo().getAbsoluteFilePath());
			if(f.exists()){AppCore.getInstance().showErrorDialog("File name taken");return;}
			target.add(dtm);
			target.updateProjectData();
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree());
			}
		else {
			dtm.getInfo().setAbsoluteFilePath(GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName()+"\\"+dtm.toString());
			s=GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName();
			File f=new File(dtm.getInfo().getAbsoluteFilePath());
			if(f.exists()){AppCore.getInstance().showErrorDialog("File name taken");return;}
			LooseDirs.getInstance().addToLoose(dtm.getInfo().getAbsoluteFilePath());
			((ProjectTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getLooseDocumentsJTree().getModel().getRoot()).add(dtm);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseDocumentsJTree());
		}
		SerializationHandler.writeObject(s, dtm);
	}
	
	public void importDocument(){
		String path=((OpenDocumentDialog)AppCore.getInstance().getCurrentDialog()).getPath();
		ProjectTreeModel target=null;
		AppCore.getInstance().closeCurrentDialog();
		DocumentTreeModel dtm=null;
		if(AppCore.getInstance().getMainFrame().getTreePanel().getSelection()!=null && AppCore.getInstance().getMainFrame().getTreePanel().getSelection() instanceof ProjectTreeModel)target=(ProjectTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getSelection();
		
		if(LooseDirs.getInstance().getLooseDocuments().contains(path)){AppCore.getInstance().showErrorDialog("Document already loaded");return;}
		dtm=SerializationHandler.readObject(path, DocumentTreeModel.class);
		if(dtm==null){AppCore.getInstance().showErrorDialog("Error: Cannot deserialize document");return;}
		dtm.getInfo().setAbsoluteFilePath(path);
		
		if(target==null){
			((ProjectTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getLooseDocumentsJTree().getModel().getRoot()).add(dtm);
			LooseDirs.getInstance().addToLoose(path);
		}
		else{
			target.add(dtm);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree());
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree());
			
			dtm.getInfo().setAbsoluteFilePath(target.getInfo().getAbsoluteFilePath()+"\\docs\\"+dtm.toString());
			FileSystemHandler.deleteFileSystem(new File(path));
			SerializationHandler.writeObject(target.getInfo().getAbsoluteFilePath()+"\\docs", dtm);
			target.updateProjectData();
		}
	}
	
	public void importProject(ArrayList<String> loadedProjects){
		String path=((OpenProjectDialog)AppCore.getInstance().getCurrentDialog()).getPath();
		AppCore.getInstance().closeCurrentDialog();
		ProjectTreeModel ptm=null;
		File f=null;
		if(path.endsWith(".prjinfo")){f=new File(path).getParentFile();}
		else f=new File(path);
		path=f.getAbsolutePath();
		
		if(loadedProjects.contains(path)){AppCore.getInstance().showErrorDialog("Attempted double load of project");return;}
		ptm=SerializationHandler.readObject(path, ProjectTreeModel.class);
		if(ptm==null){AppCore.getInstance().showErrorDialog("Failed to deserialize project");return;}
		loadedProjects.add(path);
		
		if(path.startsWith(GeKomSenSettings.getInstance().getWorkspacePath()+"\\"+GeKomSenSettings.getInstance().getWorkspaceName())){
			((WorkspaceTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree().getModel().getRoot()).addChild(ptm);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getWorkspaceJTree());
			ptm.getInfo().setAssociateWithWorkspace(true);
			ptm.updateProjectData();
		}
		else{
			((WorkspaceTreeModel)AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree().getModel().getRoot()).addChild(ptm);
			SwingUtilities.updateComponentTreeUI(AppCore.getInstance().getMainFrame().getTreePanel().getLooseProjectsJTree());
			LooseDirs.getInstance().addToLoose(path);
		}
	}

}
