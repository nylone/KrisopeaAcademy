package eu.tasgroup.collections.liste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	private final String[] ELEMENTI1 = { "E1", "E2", "E4", "E17", "E9", "E1", "E4" };
	private final String[] ELEMENTI2 = { "E3", "E2", "E4", "E7", "E7", "E6", "E0" };

	public static void main(String[] args) {
		new ArrayListTest();
	}

	public ArrayListTest() {
		ArrayList<String> lista = new ArrayList<>(200); // capacità initiale 200

		for (String e : ELEMENTI1) {
			lista.add(e);
		}

		List<String> lista2 = Arrays.asList(ELEMENTI2);

		stampa(lista);
		modifica(lista, lista2);
		Collections.sort(lista);
		stampa(lista);
	}

	private void modifica(ArrayList<String> lista1, List<String> lista2) {
		Iterator<String> iteratore1 = lista1.iterator();
		
		while (iteratore1.hasNext()) {
			if (lista2.contains(iteratore1.next()))
				iteratore1.remove();
		}
		
	}

	private void stampa(ArrayList<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i) + " ");
		}

	}
}
