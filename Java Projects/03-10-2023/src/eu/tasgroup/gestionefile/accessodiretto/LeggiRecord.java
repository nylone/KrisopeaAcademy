package eu.tasgroup.gestionefile.accessodiretto;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeggiRecord implements ImpiegatoConstants {
	private static RandomAccessFile file;

	public static void main(String[] args) {
		apriFile();
		leggiFile();
		chiudiFile();
	}

	private static void leggiFile() {
		Impiegato record = new Impiegato();
		try {
			while (true) {
				do {
					record.leggi(file);
				} while (record.getId() == 0);
				System.out.printf("%-20d%-20s%-20s%10.2f\n", record.getId(), record.getNome(), record.getCognome(),
						record.getStipendio());
			}
		} catch (EOFException e) {
			System.out.println("end");
			return;
		} catch (IOException e) {
			System.out.println("Errore in lettura del file " + e.getMessage());
		}
	}

	private static void apriFile() {
		try {
			file = new RandomAccessFile(PERCORSO_FILE, "rw");
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
