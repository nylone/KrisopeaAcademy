package eu.tasgroup.gestionefile.accessodiretto;

import java.io.IOException;
import java.io.RandomAccessFile;

public class CreaFile implements ImpiegatoConstants {
	public static void main(String[] args) {
		creaFile();
	}

	private static void creaFile() {
		RandomAccessFile file = null;
		try {
			file = new RandomAccessFile(PERCORSO_FILE, "rw");

			Impiegato record = new Impiegato();

			for (int i = 0; i < DIMENSIONE_DATI; i++)
				record.scrivi(file);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e) {
				System.out.println("help: " + e.getMessage());
			}
		}
	}
}
