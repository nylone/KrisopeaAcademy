package eu.tasgroup.social.backend;

public class Commento {
	private User utente;
	private String testo;

	public Commento(User utente, String testo) {
		this.utente = utente;
		this.testo = testo;
	}

	public User getUtente() {
		return utente;
	}

	public String getTesto() {
		return testo;
	}

}
