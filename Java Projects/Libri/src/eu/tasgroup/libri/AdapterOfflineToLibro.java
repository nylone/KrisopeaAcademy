package eu.tasgroup.libri;

import java.time.LocalDate;
import java.util.Scanner;

public class AdapterOfflineToLibro extends AdapterToLibro {
	private String titolo;
	private String autore;
	private String editore;
	private LocalDate pubblicazione;

	public AdapterOfflineToLibro(DataSourceOffline source) {
		Scanner in = new Scanner(source.ottieniDati()).useDelimiter(", ");
		titolo = in.next();
		autore = in.next();
		editore = in.next();
		pubblicazione = LocalDate.parse(in.next());
	}

	@Override
	public void buildTitolo() {
		super.libro.setTitolo(titolo);
	}

	@Override
	public void buildEditore() {
		super.libro.setEditore(editore);
	}

	@Override
	public void buildAutore() {
		super.libro.setAutore(autore);
	}

	@Override
	public void buildPubblicazione() {
		super.libro.setPubblicazione(pubblicazione);
	}

}
