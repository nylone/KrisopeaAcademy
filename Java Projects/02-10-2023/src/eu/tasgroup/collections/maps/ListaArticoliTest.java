package eu.tasgroup.collections.maps;

import java.util.Enumeration;

public class ListaArticoliTest {

	public static void main(String[] args) {
		ListaArticoli lista = new ListaArticoli();
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.aggiungiArticolo("1", "krisopea", "academy", 0);
		lista.rimuoviArticolo("1");
		lista.rimuoviArticolo("1");
		lista.aggiungiArticolo("2", "mazda", "macchina", 13850);
		lista.aggiungiArticolo("2", "mazda", "macchina", 13850);
		lista.aggiungiArticolo("2", "mazda", "macchina", 13850);
		lista.aggiungiArticolo("2", "mazda", "macchina", 13850);
		lista.aggiungiArticolo("2", "mazda", "macchina", 13850);

		Enumeration<String[]> iter = lista.dettaglioProdotti();
		while (iter.hasMoreElements()) {
			String[] dati = iter.nextElement();
			System.out.println(lista.totaleParziale(dati[4]));
			System.out.printf("%s %s %s %s%n", dati[0], dati[1], dati[2], dati[3]);
		}
		System.out.println(lista.totaleComplessivo());
	}

}
