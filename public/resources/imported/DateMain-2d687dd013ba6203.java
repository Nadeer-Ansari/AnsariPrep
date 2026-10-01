
public class DateMain {

	public static void main(String[] args) {
		Date today = 
				new Date(9, "March", 2026);
		System.out.println(today.getDate());
		Date lastYearEnd = 
				new Date(31, "December", 2025);
		System.out.println(lastYearEnd.getDate());
		
		Date firstDay = new Date();
		System.out.println(firstDay.getDate());

	}

}
