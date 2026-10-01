
public class Training {
	private String moduleName;
	private int duration;//Hours
	public Training() {
		moduleName = "RDBMS";
		duration = 40;
	}
	public Training(String moduleName, int duration) {
		this.moduleName = moduleName;
		this.duration = duration;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void conductTraining() {
		System.out.println("Conducting a training on " + moduleName + " for " + duration + " hours.");
	}
	
	public String getInfo() {
		String info = "Module Name: " + moduleName + 
				"\nDuration (Hrs): " + duration;
		return info;
	}
	
	
	
}
