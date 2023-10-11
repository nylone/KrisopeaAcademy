package eu.tasgroup.kc3;

public class Tagliando {
	private final int venditore;
	private final int prodotto;
	private final int totale;

	public Tagliando(int venditore, int prodotto, int totale) {
		this.venditore = venditore;
		this.prodotto = prodotto;
		this.totale = totale;
	}

	public int getVenditore() {
		return venditore;
	}

	public int getProdotto() {
		return prodotto;
	}

	public int getTotale() {
		return totale;
	}
}
