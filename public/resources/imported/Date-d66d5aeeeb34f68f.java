
public class Date {
	private int day;
	private String month;
	private int year;
	public Date() {
		day = 1;//this.day = 1;
		month = "January";
		year = 2026;
	}
	
	public Date(int day, String month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	//Getters and Setters
	public String getDate() {
		String dateInfo = day + " " + month + ", " + year;
		return dateInfo;
	}

}
