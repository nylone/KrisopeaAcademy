package eu.tasgroup.social.backend;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private String titolo;
	private String testo;
	private LocalDateTime pubblicazione;
	private List<Commento> commenti;
	private boolean archiviato;

	public Post(String titolo, String testo, LocalDateTime pubblicazione) {
		this.titolo = titolo;
		this.testo = testo;
		this.pubblicazione = pubblicazione;
		this.archiviato = false;
		this.commenti = new ArrayList<>();
	}

	public Post(String titolo, String testo) {
		this(titolo, testo, LocalDateTime.now());
	}

	public void archivia() {
		this.archiviato = true;
	}

	public void commenta(Commento commento) {
		this.commenti.add(commento);
	}

	public List<Commento> getCommenti() {
		return this.commenti;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getTesto() {
		return testo;
	}

	public LocalDateTime getPubblicazione() {
		return pubblicazione;
	}

	public boolean isArchiviato() {
		return archiviato;
	}
}
