package eu.tasgroup.oop;

public class Studente extends Persona {

	private String studio;

	public Studente(String nome, String cognome, String studio) {
		super(nome, cognome);
		this.studio = studio;
	}

	@Override
	public String getSaluto() {
		return this.getClass().getName() + " titolo: " + studio;
	}

}
