package eu.tasgroup.collections.maps;

import java.util.Enumeration;
import java.util.Hashtable;

public class ListaArticoli {

	private Hashtable<String, String[]> prodotti = new Hashtable<>();
	private int articoli;

	public ListaArticoli() {
		articoli = 0;
	}

	public int getArticoli() {
		return articoli;
	}

	public void aggiungiArticolo(String id, String marca, String modello, double prezzo) {
		String[] record = { marca, modello, Double.toString(prezzo), "1", id };
		articoli++;
		if (prodotti.containsKey(id)) {
			String[] dati = prodotti.get(id);
			int qta = Integer.parseInt(dati[3]);
			dati[3] = Integer.toString(qta + 1);
		} else {
			prodotti.put(id, record);
		}
	}

	public void rimuoviArticolo(String id) {
		if (prodotti.containsKey(id)) {
			if (--articoli == 0)
				prodotti.remove(id);
			else {
				String[] dati = prodotti.get(id);
				int qta = Integer.parseInt(dati[3]);
				dati[3] = Integer.toString(qta - 1);
			}
		}
	}

	public double totaleComplessivo() {
		double totale = 0.00;

		Enumeration<String[]> dettaglioProdotti = prodotti.elements();
		String[] dati;
		while (dettaglioProdotti.hasMoreElements()) {
			dati = dettaglioProdotti.nextElement();
			totale += Double.parseDouble(dati[2]) * Integer.parseInt(dati[3]);
		}

		return totale;
	}

	public double totaleParziale(String id) {
		String[] dati = prodotti.get(id);
		return Double.parseDouble(dati[2]) * Integer.parseInt(dati[3]);
	}

	public Enumeration<String[]> dettaglioProdotti() {
		return prodotti.elements();
	}
}
