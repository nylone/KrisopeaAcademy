package eu.tasgroup.oop;

public class Calcoli {
	// usato per evitare l'instanziazione
	// di un oggetto che ha solo metodi statici
	private Calcoli() {

	}

	public static int sum(int x, int y) {
		return x + y;
	}

	public static int diff(int x, int y) {
		return x - y;
	}
}
