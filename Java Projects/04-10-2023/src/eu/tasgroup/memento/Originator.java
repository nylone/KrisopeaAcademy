package eu.tasgroup.memento;

public class Originator {
	private String stato;

	public Memento salvaStatoMemento() {
		return new Memento(stato);
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public void getStatoMemento(Memento memento) {
		this.stato = memento.getStato();
	}
}
