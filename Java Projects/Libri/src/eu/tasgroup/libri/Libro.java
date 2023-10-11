package eu.tasgroup.libri;

import java.time.LocalDate;

public class Libro {
	private String titolo;
	private String autore;
	private String editore;
	private LocalDate pubblicazione;

	public Libro() {
		this("", "", "", LocalDate.now());
	}

	public Libro(String titolo, String autore, String editore, LocalDate pubblicazione) {
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
		this.pubblicazione = pubblicazione;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public String getEditore() {
		return editore;
	}

	public LocalDate getPubblicazione() {
		return pubblicazione;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setEditore(String editore) {
		this.editore = editore;
	}

	public void setPubblicazione(LocalDate pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	@Override
	public String toString() {
		return "Libro [titolo=" + titolo + ", autore=" + autore + ", editore=" + editore + ", pubblicazione="
				+ pubblicazione + "]";
	}
}
