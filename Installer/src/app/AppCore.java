package app;

import java.util.Locale;
import java.util.ResourceBundle;

import model.InstallerSpec;
import model.Moduo;
import model.Parametar;
import model.Softver;
import model.SoftverskaKompanija;
import view.MainFrame;

public class AppCore {
	
	private static AppCore instance = null;
	
	private MainFrame mainFrame = null;
	
	private InstallerSpec installerspec=null;
	
	private SoftverskaKompanija root;
	
	private Locale lokal;
	private ResourceBundle rb;
	
	private AppCore() {
		
	}
	
	public static AppCore getInstance(){
		if(instance == null){
			instance = new AppCore();
			instance.init();			
		}
		return instance;
	}
	
	private void init(){
		lokal=new Locale("en", "US");
		rb=ResourceBundle.getBundle("resources/MessageResources",lokal);
		root=new SoftverskaKompanija();
		mainFrame = new MainFrame(root);
		mainFrame.setVisible(true);
		installerspec=new InstallerSpec();
		
	}
	
	public Locale getLokal() {
		return lokal;
	}

	public void setLokal(Locale lokal) {
		this.lokal = lokal;
	}

	public ResourceBundle getRb() {
		return rb;
	}

	public void setRb(ResourceBundle rb) {
		this.rb = rb;
	}

	public MainFrame getMainFrame(){
		return mainFrame;
	}
	
	
	public SoftverskaKompanija getRoot() {
		return root;
	}

	public SoftverskaKompanija getDummy(){
		SoftverskaKompanija sk = new SoftverskaKompanija("kompanija", "", null, "", "", "");
		Softver sf = new Softver("softver1");
		Softver sf1 = new Softver("softver2");
		Softver sf2 = new Softver("softver3");
		
		Moduo m1 = new Moduo("Moduo1");
		Moduo m2 = new Moduo("Moduo2");
		Moduo m3 = new Moduo("Moduo3");
		
		Parametar p1 = new Parametar("Parametar 1");
		Parametar p2 = new Parametar("Parametar 2");
		Parametar p3 = new Parametar("Parametar 3");
		
		m1.addParametar(p1);
		m1.addParametar(p2);
		m1.addParametar(p3);
		
		sf.addModul(m1);
		sf.addModul(m2);
		sf.addModul(m3);
		
		sk.addSoftware(sf);
		sk.addSoftware(sf1);
		sk.addSoftware(sf2);
		
		sf.saveAll();
		
		return sk;
	}
	public void updateAll(){
		
	}

}
