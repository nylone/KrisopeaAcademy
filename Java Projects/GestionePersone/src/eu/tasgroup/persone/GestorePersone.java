package eu.tasgroup.persone;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class GestorePersone {
	private List<Persona> lista;

	public GestorePersone() {
		lista = new ArrayList<>();
	}

	public void aggiungiPersona(Persona persona) {
		lista.add(persona);
	}

	public List<Persona> cercaPersone(Predicate<Persona> predicato) {
		List<Persona> trovate = new ArrayList<>();
		lista.forEach(e -> {
			if (predicato.test(e))
				trovate.add(e);
		});
		return trovate;

		// return lista.stream().filter(predicato).toList();
	}

	public List<Persona> ordinaPersone(Comparator<Persona> comparatore) {
		List<Persona> ordinate = new ArrayList<>(lista);
		ordinate.sort(comparatore);
		return ordinate;
	}
}
