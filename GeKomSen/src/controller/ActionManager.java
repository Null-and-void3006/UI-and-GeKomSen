package controller;

import javax.swing.JDialog;

import commands.ElcvRedo;
import commands.ElcvUndo;
import treeNodeModels.TreeNodeOverrides;

public class ActionManager {
	private static ActionManager instance = null;
	
	public static ActionManager getInstance(){
		if(instance==null){
			instance = new ActionManager();
		}
		return instance;
	}
	
	private AboutAction aboutAction;
	private CloseAllDocumentsAction closeAllDocumentsAction;
	private CloseProjectAction closeProjectAction;
	private NewDocumentAction newDocumentAction;
	private NewProjectAction newProjectAction;
	private OpenProjectAction openProjectAction;
	private OpenWorkspaceAction openWorkspaceAction;
	private SaveDocumentAction saveDocumentAction;
	private SaveProjectAction saveProjectAction;
	private SaveWorkspaceAction saveWorkspaceAction;
	private DeleteNodeAction deleteNodeAction;
	private CloseDialogAction closeDialogAction;
	private ConfirmDeleteNodeAction confirmDeleteNodeAction;
	private InitializeWorkspaceAction initializeWorkspaceAction;
	private AddProjectFromDialogAction addProjectFromDialogAction;
	private ImportProjectAction importProjectAction;
	private AddDocumentFromDialogAction addDocumentFromDialogAction;
	private OpenDocumentAction openDocumentAction;
	private ImportDocumentAction importDocumentAction;
	private NewElementDialogAction newElementDialogAction;
	private AddElementAction addElementAction;
	private ElcvRedo redo;
	private ElcvUndo undo;
	
	public ActionManager()
	{
		aboutAction = new AboutAction();
		closeAllDocumentsAction=new CloseAllDocumentsAction();
		closeProjectAction=new CloseProjectAction();
		newDocumentAction=new NewDocumentAction();
		newProjectAction=new NewProjectAction();
		openProjectAction=new OpenProjectAction();
		openWorkspaceAction=new OpenWorkspaceAction();
		saveDocumentAction=new SaveDocumentAction();
		saveProjectAction=new SaveProjectAction();
		saveWorkspaceAction=new SaveWorkspaceAction();
		deleteNodeAction=new DeleteNodeAction();
		closeDialogAction=new CloseDialogAction();
		confirmDeleteNodeAction=new ConfirmDeleteNodeAction();
		initializeWorkspaceAction=new InitializeWorkspaceAction();
		addProjectFromDialogAction=new AddProjectFromDialogAction();
		importProjectAction=new ImportProjectAction();
		addDocumentFromDialogAction=new AddDocumentFromDialogAction();
		openDocumentAction=new OpenDocumentAction();
		importDocumentAction=new ImportDocumentAction();
		newElementDialogAction=new NewElementDialogAction();
		addElementAction=new AddElementAction();
		redo=new ElcvRedo();
		undo=new ElcvUndo();
	}

	public ElcvRedo getRedo() {
		return redo;
	}

	public ElcvUndo getUndo() {
		return undo;
	}

	public AddElementAction getAddElementAction() {
		return addElementAction;
	}

	public NewElementDialogAction getNewElementDialogAction() {
		return newElementDialogAction;
	}

	public ImportDocumentAction getImportDocumentAction() {
		return importDocumentAction;
	}

	public OpenDocumentAction getOpenDocumentAction() {
		return openDocumentAction;
	}

	public AddDocumentFromDialogAction getAddDocumentFromDialogAction() {
		return addDocumentFromDialogAction;
	}

	public ImportProjectAction getImportProjectAction() {
		return importProjectAction;
	}

	public AddProjectFromDialogAction getAddProjectFromDialogAction() {
		return addProjectFromDialogAction;
	}

	public CloseAllDocumentsAction getCloseAllDocumentsAction() {
		return closeAllDocumentsAction;
	}

	public CloseProjectAction getCloseProjectAction() {
		return closeProjectAction;
	}

	public NewDocumentAction getNewDocumentAction() {
		return newDocumentAction;
	}

	public NewProjectAction getNewProjectAction() {
		return newProjectAction;
	}

	public OpenProjectAction getOpenProjectAction() {
		return openProjectAction;
	}

	public OpenWorkspaceAction getOpenWorkspaceAction() {
		return openWorkspaceAction;
	}

	public SaveDocumentAction getSaveDocumentAction() {
		return saveDocumentAction;
	}

	public SaveProjectAction getSaveProjectAction() {
		return saveProjectAction;
	}

	public SaveWorkspaceAction getSaveWorkspaceAction() {
		return saveWorkspaceAction;
	}

	public AboutAction getAboutAction() {
		return aboutAction;
	}


	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}
	
	public CloseDialogAction getCloseDialogAction(){
		return closeDialogAction;
	}

	public ConfirmDeleteNodeAction getConfirmDeleteNodeAction() {
		return confirmDeleteNodeAction;
	}

	public InitializeWorkspaceAction getInitializeWorkspaceAction() {
		return initializeWorkspaceAction;
	}
	
}
