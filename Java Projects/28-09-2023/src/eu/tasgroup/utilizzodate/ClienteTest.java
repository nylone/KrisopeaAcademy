package eu.tasgroup.utilizzodate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ClienteTest {
	public static void main(String[] args) {
		Cliente c = new Cliente("Mario", "Rossi", 2000, 11, 1);
		System.out.println(c);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(c.getNascita());

		System.out.println(c);

		System.out.println("Anno: " + cal.get(Calendar.YEAR));
		System.out.println("Mese: " + cal.get(Calendar.MONTH));
		System.out.println("Giorno: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Settimana: " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Ora: " + cal.get(Calendar.HOUR_OF_DAY));

		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.HOUR_OF_DAY, 14);
		System.out.println("Anno: " + cal.get(Calendar.YEAR));
		System.out.println("Mese: " + cal.get(Calendar.MONTH));
		System.out.println("Giorno: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("Settimana: " + cal.get(Calendar.WEEK_OF_YEAR));
		System.out.println("Ora: " + cal.get(Calendar.HOUR_OF_DAY));

		c.setNascita(cal.getTime());

		System.out.println(c);

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd-MM-yyyy - HH:mm:ss");
		System.out.println(sdf.format(c.getNascita()));

		DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.getDefault());

		System.out.println(df1.format(c.getNascita()));

		DateFormat df2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG, Locale.GERMAN);

		System.out.println(df2.format(c.getNascita()));

		String dataTesto = "12/10/2002";
		SimpleDateFormat convertitore = new SimpleDateFormat("dd/MM/yyyy");
		try {
			c.setNascita(convertitore.parse(dataTesto));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(sdf.format(c.getNascita()));
	}
}
