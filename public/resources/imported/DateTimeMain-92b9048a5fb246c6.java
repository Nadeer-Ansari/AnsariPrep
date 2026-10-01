package date_time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeMain {

	public static void main(String[] args) {
		LocalDate sysDate = LocalDate.now();
		System.out.println(sysDate);
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		LocalDateTime currentTimeStamp = LocalDateTime.now();
		System.out.println(currentTimeStamp);

	}

}
