package eu.tasgroup.gestionefile;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ApriFIle {
	private static ObjectInputStream file;

	public static void main(String[] args) {
		apriFile();
		leggiRecord();
		chiudiFile();
	}

	private static void leggiRecord() {
		Impiegato record;
		try {
			while(true) {
				record = (Impiegato) file.readObject();
				System.out.printf("%-20d%-20s%-20s%10.2f\n", record.getId(), record.getNome(), record.getCognome(), record.getStipendio());
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Impossibile deserializzare");
		} catch (EOFException e) {
			return;
		} catch (IOException e) {
			System.out.println("Errore in lettura del file " + e.getMessage());
		}
	}

	private static void apriFile() {
		try {
			file = new ObjectInputStream(
					new FileInputStream("C:\\Users\\ramponem\\Desktop\\oggetti serializzati\\impiegati.ser"));
		} catch (IOException e) {
			System.out.println("Errore in apertura del file");
		}
	}

	private static void chiudiFile() {
		try {
			if (file != null)
				file.close();
		} catch (IOException e) {
			System.out.println("Errore in chiusura del file");
		}
	}
}
