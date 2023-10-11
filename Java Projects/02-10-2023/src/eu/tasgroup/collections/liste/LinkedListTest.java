package eu.tasgroup.collections.liste;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
	private final String[] ELEMENTI1 = { "E1", "E2", "E4", "E17", "E9", "E1", "E4" };
	private final String[] ELEMENTI2 = { "E3", "E2", "E4", "E7", "E7", "E6", "E0" };

	public static void main(String[] args) {
		new LinkedListTest();
	}

	public LinkedListTest() {
		LinkedList<String> lista1 = new LinkedList<>();


		for (String e : ELEMENTI1) {
			lista1.add(e);
		}

		LinkedList<String> lista2 = new LinkedList<>();

		for (String e : ELEMENTI2) {
			lista2.add(e);
		}

		lista1.offerFirst("Primo Elemento");
		System.out.println("Primo elemento: " + lista1.peekFirst());

		lista1.offerLast("UltimoElemento");
		System.out.println("Ultimo elemento: " + lista1.peekLast());

		lista1.addAll(lista2);
		stampa(lista1);
		modifica(lista1);
		Collections.sort(lista1);
		stampa(estraiSubList(lista2, 3, 5));
		stampaReverse(lista2);
	}

	private void stampaReverse(LinkedList<String> lista) {
		/*
		 * Iterator<String> iteratore = lista.descendingIterator(); while
		 * (iteratore.hasNext()) { System.out.println(iteratore.next() + " ");
		 * 
		 * }
		 */
		ListIterator<String> iteratore = lista.listIterator();
		while (iteratore.hasPrevious()) {
			System.out.print(iteratore.previous() + " ");
		}
		System.out.println();
	}

	private List<String> estraiSubList(LinkedList<String> lista2, int s, int e) {
		return lista2.subList(s, e);
	}

	private void modifica(LinkedList<String> lista) {
		ListIterator<String> iteratore = lista.listIterator();

		while (iteratore.hasNext()) {
			String elemento = iteratore.next();
			iteratore.set("ciao mondo!" + elemento.trim());
		}

	}

	private void stampa(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + " ");
		}
		System.out.println();
	}
}
