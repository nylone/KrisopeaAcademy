package eu.tasgroup.pattern.creazionali;

public class Ordine {
	private int idOrdine;
	private double totale;

	private static Ordine istanza;

	private Ordine() {

	}

	public static Ordine getInstance() {
		if (istanza == null) {
			istanza = new Ordine();
		}
		return istanza;
	}

	public int getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}
}
