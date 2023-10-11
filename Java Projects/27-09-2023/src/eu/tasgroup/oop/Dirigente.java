package eu.tasgroup.oop;

public class Dirigente extends Responsabile {
	private String auto;
	private double fatturato;

	public Dirigente(String enterpriseID, String nome, String cognome, int giorno, int mese, int anno, double stipendio,
			double premio, String auto, double fatturato) {
		super(enterpriseID, nome, cognome, giorno, mese, anno, stipendio, premio);
		this.auto = auto;
		this.fatturato = fatturato;
	}

	@Override
	public double getStipendio() {
		return super.getStipendio() + fatturato;
	}

	public String getAuto() {
		return auto;
	}

	public void setAuto(String auto) {
		this.auto = auto;
	}

	public double getFatturato() {
		return fatturato;
	}

	public void setFatturato(double fatturato) {
		this.fatturato = fatturato;
	}

}
