package eu.tasgroup.gestionefile.accessosequenziale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LeggiSequenziale {
	private static Scanner file;

	public static void main(String[] args) {
		apriFile();
		leggiRecord();
		chiudiFile();
	}

	private static void leggiRecord() {
		Impiegato record = new Impiegato();
		try {
			while(file.hasNext()) {
				record.setId(file.nextInt());
				record.setNome(file.next());
				record.setCognome(file.next());
				record.setStipendio(file.nextDouble());
				System.out.println(record);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Input non valido");
		}
	}

	private static void apriFile() {
		try {
			file = new Scanner(new File("C:\\Users\\ramponem\\Desktop\\oggetti serializzati\\impiegati.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Errore in apertura del file");
		}
	}

	private static void chiudiFile() {
		if (file != null)
			file.close();
	}
}
