package eu.tasgroup.oop;

public class CalcoliTest {
	public static void main(String[] args) {
		// esempio di imprecisione
		// Calcoli c = new Calcoli(); // non compila perchè il costruttore è privato
		// System.out.println(c.sum(0, 0));
		// System.out.println(c.diff(0, 0));

		// esempio di metodi statici
		System.out.println(Calcoli.sum(0, 0));
		System.out.println(Calcoli.diff(0, 0));
	}
}
