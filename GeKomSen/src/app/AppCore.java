package app;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.MissingFormatArgumentException;
import java.util.Stack;
import java.util.logging.FileHandler;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import fileHandling.FileSystemHandler;
import fileHandling.SerializationHandler;
import model.GeKomSenSettings;
import model.LooseDirs;
import model.MissingDocsModel;
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
import view.AboutDialog;
import view.MainFrame;
import view.MissingDocsDialog;
import view.NewDocumentDialog;
import view.NewELCView;
import view.NewProjectDialog;
import view.OpenDocumentDialog;
import view.OpenProjectDialog;
import view.RemoveFromJTreeDialog;
import view.WorkspaceChangeDialog;

public class AppCore {
	private static final boolean GENERATE_NEW_DUMMY=false;
	public static final String SETTINGS_FILE="geKomSem.settings";
	public static final String LOOSE="looseDirs.gksdirs";
	public static final String BLACKLIST="blackDirs.gksdirs";
	
	
	private static AppCore instance=null;
	private MainFrame mainFrame = null;
	private Stack<JDialog> dialogStack = null;
	private ArrayList<MissingDocsModel> errorQueue=null;
	private ArrayList<String> loadedProjects=null;
	private ArrayList<String> loadedDocuments=null;
	
	private LoadHandler loadHandler;
	
	private AppCore(){
		errorQueue=new ArrayList<>();
		loadedProjects=new ArrayList<>();
		loadedDocuments=new ArrayList<>();
		loadHandler= new LoadHandler();
	}
	public void initMainFrame(){
		mainFrame=new MainFrame();
	}
	
	private AppCore init(){
		dialogStack= new Stack<>();
		
		
		if(GeKomSenSettings.getInstance().isWorkspaceDialogOnStart()){
			new WorkspaceChangeDialog();
		}
		else{

		mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		emptyErrorQueue();
		}
		
		
		return this;
	}
	
	
	
	public ArrayList<String> getLoadedProjects() {
		return loadedProjects;
	}

	public ArrayList<String> getLoadedDocuments() {
		return loadedDocuments;
	}

	public static AppCore getInstance(){
		if(instance==null){
			instance = new AppCore();
			instance.init();
		}
		return instance;
	}

	public void showMissingFileDialog(MissingDocsModel s){
		if(mainFrame!=null) {MissingDocsDialog.makeMissingDocsDialog(s);}
		else errorQueue.add(s);
		
	}
	public void emptyErrorQueue(){
		for(MissingDocsModel i:errorQueue){
			MissingDocsDialog.makeMissingDocsDialog(i);
		}
		errorQueue.clear();
	}
	
	public void seeAbout(){
		new AboutDialog();
	}
	
	
	private WorkspaceTreeModel getDummy(){
		return loadHandler.getDummy();
	}
	public WorkspaceTreeModel getWorkspaceRoot() {
		
		WorkspaceTreeModel wtm=null;
		return loadHandler.getWorkSpaceRoot(wtm, GENERATE_NEW_DUMMY);
	}
	
	public WorkspaceTreeModel getLooseProjectsRoot(){
		return loadHandler.getLooseProjectsRoot(loadedProjects);
	}
	
	public ProjectTreeModel getLooseDocumentsRoot(){
		return loadHandler.getLooseDocumentsRoot(loadedDocuments);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public void removeNodeFromJTree(TreeNodeOverrides target){
		removeNodeFromJTree(target, ((TreeNodeOverrides)(target).getParent()));
		
	}
	public void removeNodeFromJTree(TreeNodeOverrides target, TreeNodeOverrides parent){
		parent.remove((MutableTreeNode)target);
		SwingUtilities.updateComponentTreeUI(getMainFrame().getTreePanel().getJTree());
		
	}
	
	private void reorganizeDialogStack(){
		if(!dialogStack.isEmpty())
		while(dialogStack.peek()==null)dialogStack.pop();
	}
	
	public void pushDialog(JDialog jj){
		reorganizeDialogStack();
		dialogStack.push(jj);
	}
	
	public JDialog popDialog(){
		reorganizeDialogStack();
		return dialogStack.pop();
	}
	
	public JDialog getCurrentDialog(){
		reorganizeDialogStack();
		return dialogStack.peek();
	}
	
	public void closeCurrentDialog(){
		reorganizeDialogStack();
		popDialog().dispose();
	}
	public void moveToLoose(TreeNodeOverrides s){
		loadHandler.moveToLoose(s);
	}
	public void handleDelete() {
		
		loadHandler.handleDelete(loadedDocuments, loadedProjects);
		
	}
	
	public void initWorkspace(){
		loadHandler.initWorkspace(loadedProjects, loadedDocuments);
	}
	
	public void addNewProject(){
		loadHandler.addNewProject(loadedProjects);
				
	}
	
	public void addNewDocument(){
		loadHandler.addNewDocument();
	}
	
	public void importDocument(){
		loadHandler.importDocument();
	}
	
	public void importProject(){
		loadHandler.importProject(loadedProjects);
	}
	
	public void showErrorDialog(String s){
		JOptionPane.showMessageDialog(new JFrame(),s,"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void addElement(){
		System.out.println("ERROR: FUNCTION addElement() DELETED");
		return;
		//NewELCView elcv=(NewELCView) popDialog();
	/*	if(elcv.addElem()){
			SwingUtilities.updateComponentTreeUI(mainFrame.getTreePanel().getWorkspaceJTree());
			SwingUtilities.updateComponentTreeUI(mainFrame.getTreePanel().getLooseProjectsJTree());
			SwingUtilities.updateComponentTreeUI(mainFrame.getTreePanel().getLooseDocumentsJTree());
		}*/
		//elcv.dispose();
	}
}
