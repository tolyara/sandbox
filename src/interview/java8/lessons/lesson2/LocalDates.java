package interview.java8.lessons.lesson2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class LocalDates {

	public static void main(String[] args) throws ParseException {
		LocalDate localDate = LocalDate.now();
		localDate.minusDays(5);
		localDate.plusMonths(5);
		
//		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMM uuuu");
		
		System.out.println(localDate.format(dateTimeFormatter));
		
		LocalDate localDate2 = LocalDate.parse("24 мар. 2017", dateTimeFormatter);
		System.out.println(localDate2);
	}
	
	private static void old() throws ParseException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 2);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(simpleDateFormat.format(date));
		
		Date date2 = simpleDateFormat.parse("21/02/2017");
	}
	
}
