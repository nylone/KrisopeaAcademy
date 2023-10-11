package eu.tasgroup.pattern.creazionali;

public class SingletonTest {
	public static void main(String[] args) {
		Ordine o1 = Ordine.getInstance();

		o1.setTotale(10000);

		Ordine o2 = Ordine.getInstance();

		o2.setTotale(0);

		System.out.println("o1 " + o1.getTotale());
		System.out.println("o2 " + o2.getTotale());
	}
}
