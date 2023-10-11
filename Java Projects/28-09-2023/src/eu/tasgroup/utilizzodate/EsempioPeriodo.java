package eu.tasgroup.utilizzodate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EsempioPeriodo {
	public static void main(String[] args) {
		LocalDateTimeFormat("2023-03-23T05:18:30.123123", "MM-dd-yyyy h a");
		LocalDateTimeFormat("2023-03-23T09:12:01.1223", "h B");

		LocalTime lt1 = LocalTime.parse("2023-03-23T09:12:01.1223");
		LocalTime lt2 = LocalTime.parse("2020-03-23T09:12:01.1223");

		System.out.println(Duration.between(lt1, lt2));
	}

	static void LocalDateTimeFormat(String time, String pattern) {
		LocalDateTime date = LocalDateTime.parse(time);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
		System.out.println(date.format(fmt));
	}

	static void LocalDateFormat(String time, String pattern) {
		LocalTime date = LocalTime.parse(time);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
		System.out.println(date.format(fmt));
	}
}
