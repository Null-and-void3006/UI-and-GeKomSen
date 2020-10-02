package model;

import java.awt.Image;
import java.util.ArrayList;

public class InstallerSpec {
	private String CompanyName;
	private String SoftwareName;
	private String Version;
	private String Description;
	private String Author;
	private String ToU;
	private String LnF;
	
	private boolean deskSh;
	private boolean pokPosInst;
	
	private String InstallDirectory;
	private Image CompanyLogo;
	private ArrayList<Language> languages= new ArrayList<>();
	
	
	
	public InstallerSpec() {
		super();
	}
	
	
	public InstallerSpec(String companyName, String softwareName, String version, 
			String description, String author, String tou, String LnF, String installDirectory,
			boolean deskSh, boolean pokPosInst,
			Image companyLogo, ArrayList<Language> languages) {
		super();
		CompanyName = companyName;
		SoftwareName = softwareName;
		Version = version;
		Description = description;
		Author = author;
		ToU = tou;
		LnF = LnF;
		deskSh = deskSh;
		pokPosInst = pokPosInst;
		
		InstallDirectory = installDirectory;
		
		CompanyLogo = companyLogo;
		this.languages = languages;
	}
	
	
	
	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getToU() {
		return ToU;
	}


	public void setToU(String toU) {
		ToU = toU;
	}


	public String getLnF() {
		return LnF;
	}


	public void setLnF(String lnF) {
		LnF = lnF;
	}


	public boolean isDeskSh() {
		return deskSh;
	}


	public void setDeskSh(boolean deskSh) {
		this.deskSh = deskSh;
	}


	public boolean isPokPosInst() {
		return pokPosInst;
	}


	public void setPokPosInst(boolean pokPosInst) {
		this.pokPosInst = pokPosInst;
	}


	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getSoftwareName() {
		return SoftwareName;
	}
	public void setSoftwareName(String softwareName) {
		SoftwareName = softwareName;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getInstallDirectory() {
		return InstallDirectory;
	}
	public void setInstallDirectory(String installDirectory) {
		InstallDirectory = installDirectory;
	}
	
	public Image getCompanyLogo() {
		return CompanyLogo;
	}
	public void setCompanyLogo(Image companyLogo) {
		CompanyLogo = companyLogo;
	}
	public ArrayList<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(ArrayList<Language> languages) {
		this.languages = languages;
	}
}
