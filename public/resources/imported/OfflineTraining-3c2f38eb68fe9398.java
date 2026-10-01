
public class OfflineTraining extends Training {
	private String venueDetails;

	public OfflineTraining() {
		venueDetails = "Bhujbal Knowledge City, MET, Nashik";
	}

	public OfflineTraining(String moduleName, int duration, String venueDetails) {
		super(moduleName, duration);
		this.venueDetails = venueDetails;
	}

	public String getVenueDetails() {
		return venueDetails;
	}

	public void setVenueDetails(String venueDetails) {
		this.venueDetails = venueDetails;
	}
	
	public void conductTraining() {
		System.out.println(
				"Conducting a training on " + getModuleName() + 
				" for " + getDuration() + " hours at " + 
						venueDetails);
	}
	public String getInfo() {
		String info = super.getInfo() + "\nVenue: " + venueDetails;
		return info;
	}
	
}


















