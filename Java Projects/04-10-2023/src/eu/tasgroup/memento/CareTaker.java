package eu.tasgroup.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	private List<Memento> memento = new ArrayList<>();

	public void add(Memento stato) {
		memento.add(stato);
	}

	public Memento get(int indice) {
		return memento.get(indice);
	}
}
