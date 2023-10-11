package eu.tasgroup.gestionefile.accessodiretto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreaRecord implements ImpiegatoConstants {
	private static RandomAccessFile file;
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		apriFile();
		aggiungiRecord();
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

				if (id > 0 && id <= DIMENSIONE_DATI) {
					record = new Impiegato(id, nome, cognome, stipendio);
					file.seek((id - 1) * DIMENSIONE_RECORD);
					record.scrivi(file);
				} else {
					System.out.println("Id non valido");
				}
			} catch (IOException e) {
				System.out.println("Errore nella scrittura del file:\n" + e.getMessage());
			} catch (NoSuchElementException e) {
				System.out.println("Input errato");
				in.nextLine();
			}
		}
		in.close();
	}

	private static void apriFile() {
		try {
			file = new RandomAccessFile(PERCORSO_FILE, "rw");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
