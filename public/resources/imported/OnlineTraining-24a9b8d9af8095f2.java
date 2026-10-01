
public class OnlineTraining extends Training {
	private String meetingLink;

	public OnlineTraining() {
		meetingLink = "https://www.oracle.zoom.us/35454";
	}

	public OnlineTraining(String moduleName, int duration, String meetingLink) {
		super(moduleName, duration);
		this.meetingLink = meetingLink;
	}

	public String getMeetingLink() {
		return meetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}
	public void conductTraining() {
		System.out.println(
				"Conducting a training on " + getModuleName() + 
				" for " + getDuration() + " hours using the link: " + 
						meetingLink);
	}
	@Override
	public String getInfo() {
		String info = super.getInfo() + "\nMeeting Link: " + meetingLink;
		return info;
	}
	
	
}
