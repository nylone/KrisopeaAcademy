package eu.tasgroup.oop;

public class Dipendente extends Persona {

	private double stipendio;

	public Dipendente(String nome, String cognome, double stipendio) {
		super(nome, cognome);
		this.stipendio = stipendio;
	}

	@Override
	public String getSaluto() {
		return this.getClass().getSimpleName();
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

}
