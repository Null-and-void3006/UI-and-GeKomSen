package controller;


public class ActionManager {
	private static ActionManager instance = null;
	
	public static ActionManager getInstance(){
		if(instance==null){
			instance = new ActionManager();
		}
		
		return instance;

	}
	

	private AboutAction aboutAction;
	private NextPanelAction nextPanelAction;
	private PreviousPanelAction previousPanelAction;
	private ExitAction exitAction;
	private ParametarSelectAction parametarSelectAction;
	private AddNodeAction addNodeAction;
	private DeleteNodeAction deleteNodeAction;
	private EditNodeAction editNodeAction;
	private SaveParametarAction saveParametarAction;
	private CancelAction cancelAction;
	private CancelModuoAction cancelModuoAction;
	private SaveModuoAction saveModuoAction;
	private PreviewAction previewAction;
	private LogoAction logoAction;
	private FinishAction finishAction;
	private SaveSoftwareAction saveSoftwareAction;
	private SaveSoftwareCompanyAction saveSoftwareCompanyAction;
	private HelpAction helpAction;
	private CancelSoftwareAction cancelSoftwareAction;
	
	private ActionManager() {
		aboutAction = new AboutAction();
		nextPanelAction = new NextPanelAction();
		previousPanelAction = new PreviousPanelAction();
		exitAction= new ExitAction();
		parametarSelectAction= new ParametarSelectAction();
		addNodeAction= new AddNodeAction();
		deleteNodeAction= new DeleteNodeAction();
		editNodeAction= new EditNodeAction();
		saveParametarAction= new SaveParametarAction();
		cancelAction= new CancelAction();
		cancelModuoAction= new CancelModuoAction();
		saveModuoAction= new SaveModuoAction();
		previewAction=new PreviewAction();
		logoAction=new LogoAction();
		finishAction=new FinishAction();
		saveSoftwareAction=new SaveSoftwareAction();
		saveSoftwareCompanyAction=new SaveSoftwareCompanyAction();
		helpAction = new HelpAction();
		cancelSoftwareAction=new CancelSoftwareAction();
	}
	

	
	
	public CancelSoftwareAction getCancelSoftwareAction() {
		return cancelSoftwareAction;
	}




	public SaveSoftwareCompanyAction getSaveSoftwareCompanyAction() {
		return saveSoftwareCompanyAction;
	}




	public SaveSoftwareAction getSaveSoftwareAction() {
		return saveSoftwareAction;
	}




	public FinishAction getFinishAction() {
		return finishAction;
	}




	public LogoAction getLogoAction() {
		return logoAction;
	}




	public PreviewAction getPreviewAction() {
		return previewAction;
	}




	public SaveModuoAction getSaveModuoAction() {
		return saveModuoAction;
	}




	public CancelModuoAction getCancelModuoAction() {
		return cancelModuoAction;
	}




	public AddNodeAction getAddNodeAction() {
		return addNodeAction;
	}




	public DeleteNodeAction getDeleteNodeAction() {
		return deleteNodeAction;
	}

	


	public CancelAction getCancelAction() {
		return cancelAction;
	}




	public EditNodeAction getEditNodeAction() {
		return editNodeAction;
	}

	public SaveParametarAction getSaveParametarAction() {
		return saveParametarAction;
	}




	public ParametarSelectAction getParametarSelectAction() {
		return parametarSelectAction;
	}




	public PreviousPanelAction getPreviousPanelAction() {
		return previousPanelAction;
	}




	public AboutAction getAboutAction() {
		return aboutAction;
	}


	public NextPanelAction getNextPanelAction() {
		return nextPanelAction;
	}



	public ExitAction getExitAction() {
		return exitAction;
	}
	
	public HelpAction getHelpAction() {
		return helpAction;
	}
	

}
