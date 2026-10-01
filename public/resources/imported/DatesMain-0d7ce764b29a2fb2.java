package utility_classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatesMain {

	public static void main(String[] args) {
		Date today = new Date();
		System.out.println(today);
		int currentYear = today.getYear() + 1900;
		System.out.println(currentYear);
		
		Date firstDayOfTraining = new Date(126, 2, 9);
		System.out.println(firstDayOfTraining);
		
		String pattern = "dd-MM-yy HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String formattedDate = formatter.format(today);
		System.out.println(formattedDate);
		
		Calendar dateToday = Calendar.getInstance();
		System.out.println(dateToday.getTime());

	}

}







