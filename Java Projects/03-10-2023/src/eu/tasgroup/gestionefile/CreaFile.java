package eu.tasgroup.gestionefile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreaFile {
	private static ObjectOutputStream file;
	private static Scanner in;

	public static void main(String[] args) {
		apriFile();
		aggiungiRecord();
		chiudiFile();
	}

	private static void aggiungiRecord() {
		Impiegato record;
		in = new Scanner(System.in);
		int id;
		String nome, cognome;
		double stipendio;

		System.out.println("Inserire: id, nome, cognome, stipendio\n");

		while (in.hasNext()) {
			try {
				id = in.nextInt();
				nome = in.next();
				cognome = in.next();
				stipendio = in.nextDouble();

				if (id > 0) {
					record = new Impiegato(id, nome, cognome, stipendio);
					file.writeObject(record);
				} else {
					System.out.println("Id non valido");
				}
			} catch (IOException e) {
				System.out.println("Errore nella scrittura del file");
			} catch (NoSuchElementException e) {
				System.out.println("Input errato");
				in.nextLine();
			}
		}
		in.close();
	}

	private static void apriFile() {
		try {
			file = new ObjectOutputStream(
					new FileOutputStream("C:\\Users\\ramponem\\Desktop\\oggetti serializzati\\impiegati.ser"));
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
