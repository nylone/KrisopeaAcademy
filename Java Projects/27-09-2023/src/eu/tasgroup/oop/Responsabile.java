package eu.tasgroup.oop;

public class Responsabile extends Impiegato {
	private double premio;

	public Responsabile(String enterpriseID, String nome, String cognome, int giorno, int mese, int anno,
			double stipendio, double premio) {
		super(enterpriseID, nome, cognome, giorno, mese, anno, stipendio);
		this.premio = premio;
	}

	@Override
	public double getStipendio() {
		return super.getStipendio() + this.premio;
	}

	public double getPremio() {
		return premio;
	}

	public void setPremio(double premio) {
		this.premio = premio;
	}

}
