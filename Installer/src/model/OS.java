package model;

public class OS {
	private String Name;
	private Boolean supported;
	
	
	
	
	public OS(String name) {
		super();
		Name = name;
		this.supported = false;
	}
	
	public OS(String name, Boolean supported) {
		super();
		Name = name;
		this.supported = supported;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Boolean getSupported() {
		return supported;
	}
	public void setSupported(Boolean supported) {
		this.supported = supported;
	}
}
