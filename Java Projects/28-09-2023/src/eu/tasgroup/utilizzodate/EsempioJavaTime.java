package eu.tasgroup.utilizzodate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class EsempioJavaTime {
	public static void main(String[] args) {
		LocalDate lc1 = LocalDate.parse("2023-09-28");
		System.out.println(lc1);

		LocalDate lc2 = LocalDate.parse("23231205", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(lc2);

		System.out.println(lc1.isBefore(lc2));

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM-yyyy");
		LocalDate lc3 = LocalDate.parse("23/09-2208", fmt);
		System.out.println(lc3);

		LocalDate lc4 = LocalDate.of(2003, 2, 1);
		System.out.println(lc4);

		LocalDate lc5 = LocalDate.of(2003, Month.APRIL, 1);
		System.out.println(lc5);

		LocalDate lc6 = LocalDate.ofYearDay(2003, 54);
		System.out.println(lc6);

		System.out.println(lc1.getDayOfYear());
		lc1 = lc1.plusMonths(2);
		lc1 = lc1.minusMonths(-2);
		System.out.println(lc1.getDayOfMonth());

		// period e duration
		LocalDate ld1 = LocalDate.parse("2023-02-03");
		LocalDate ld2 = LocalDate.parse("2023-02-25");
		Period p = Period.between(ld1, ld2);
		System.out.println(p.getDays());
		System.out.println(p.getMonths());

		LocalTime lt1 = LocalTime.parse("2023-02-03");
		LocalTime lt2 = LocalTime.parse("2023-02-25");
		Duration d = Duration.between(lt1, lt2);
		System.out.println(p.getDays());
		System.out.println(p.getMonths());
	}
}
