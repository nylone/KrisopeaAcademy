package eu.tasgroup.gestionefile.accessosequenziale;

import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreaFile {
	private static Formatter file;
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
					file.format("%d %s %s %.2f\r\n", record.getId(), record.getNome(), record.getCognome(),
							record.getStipendio());
				} else {
					System.out.println("Id non valido");
				}
			} catch (FormatterClosedException e) {
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
			file = new Formatter("C:\\Users\\ramponem\\Desktop\\oggetti serializzati\\impiegati.txt");
		} catch (IOException e) {
			System.out.println("Errore in apertura del file");
		}
	}

	private static void chiudiFile() {
		if (file != null)
			file.close();
	}
}
