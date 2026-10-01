package date_time_api;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateMain {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate trgStartDate = LocalDate.of(2026, 3, 9);
		int lastDay = today.getDayOfMonth();
		int firstDay = trgStartDate.getDayOfMonth();
		int trgDuration = lastDay - firstDay;
		System.out.println("Training Duration (Days): " + trgDuration);
		
		LocalDate dateAfter2Months = today.plus(2, ChronoUnit.MONTHS);
		System.out.println(dateAfter2Months);
		LocalDate startDateOfWebBasedJava = dateAfter2Months.plus(3, ChronoUnit.DAYS);
		System.out.println(startDateOfWebBasedJava);

	}

}














