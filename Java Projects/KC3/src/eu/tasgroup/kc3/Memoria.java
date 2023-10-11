package eu.tasgroup.kc3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Memoria {
	private List<Tagliando> tagliandi;

	public Memoria() {
		this.tagliandi = new ArrayList<Tagliando>();
		Random r = new Random();

		// per ogni giorno del mese
		for (int g = 0; g < 31; g++) {
			// per ogni venditore
			for (int v = 0; v < 4; v++) {
				// scegli quanti tagliandi generare
				int numTag = r.nextInt(6);
				for (int i = 0; i <= numTag; i++) {
					int quantità = r.nextInt(100);
					Tagliando t = new Tagliando(v, i, quantità);
					this.tagliandi.add(t);
				}
			}
		}
	}

	public Tagliando[] getTagliandi() {
		return this.tagliandi.toArray(new Tagliando[0]);
	}

	public int getVenditePerVenditore(int venditore) {
		int vendite = 0;
		for (Tagliando t : this.tagliandi) {
			if (t.getVenditore() == venditore)
				vendite += t.getTotale();
		}
		return vendite;
		/*
		 * return this.tagliandi.stream().filter(t -> t.getVenditore() ==
		 * venditore).map(t -> t.getTotale()).reduce(0, Integer::sum);
		 */
	}

	public int getVenditePerVenditoreProdotto(int venditore, int prodotto) {
		int vendite = 0;
		for (Tagliando t : this.tagliandi) {
			if (t.getVenditore() == venditore && t.getProdotto() == prodotto)
				vendite += t.getTotale();
		}
		return vendite;
		// return this.tagliandi.stream().filter(t -> t.getProdotto() == prodotto)
		// .filter(t -> t.getVenditore() == venditore).map(t -> t.getTotale()).reduce(0,
		// Integer::sum);

	}

	public int getVenditePerProdotto(int prodotto) {
		int vendite = 0;
		for (Tagliando t : this.tagliandi) {
			if (t.getProdotto() == prodotto)
				vendite += t.getTotale();
		}
		return vendite;
		/*
		 * return this.tagliandi.stream().filter(t -> t.getProdotto() == prodotto).map(t
		 * -> t.getTotale()).reduce(0, Integer::sum);
		 */
	}
}
