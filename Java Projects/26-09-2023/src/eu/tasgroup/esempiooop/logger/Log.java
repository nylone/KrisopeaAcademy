package eu.tasgroup.esempiooop.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
	public static void main(String[] args) {
		assert 1 < 2;

		Logger l1 = Logger.getLogger("log1"); // console - file
		Logger l2 = Logger.getLogger("log2"); // console

		FileHandler fh;

		try {
			fh = new FileHandler("C:\\Users\\ramponem\\Desktop\\log\\logfile.log", true);
			l1.addHandler(fh);

			l1.setLevel(Level.ALL);

			// di base il file viene usato per scrivere i dati in formato xml
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			int x = 10;
			l1.log(Level.INFO, "Logger su console e file. La variabile x vale: " + x);
			l2.log(Level.INFO, "logger su console. La variabile x vale: " + x);

			// performo una azione illegale
			int y = 0 / 0;
			System.out.println(y);
		} catch (SecurityException e) { // tentativo di scrivere su un file senza clearance
			l1.log(Level.SEVERE, e.getMessage());
		} catch (IOException e) {
			l2.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			l1.log(Level.SEVERE, e.getMessage());
		}
	}
}
