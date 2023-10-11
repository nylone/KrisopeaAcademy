package eu.tasgroup.oop;

public class ClienteTest {
	public static void main(String[] args) {
		Cliente c1 = new Cliente("AC432", "Massimo", 1999, 10, 1);
		Cliente c2 = new Cliente("AC431", "Rampeo", 2000, 3, 11);
		Cliente c3 = new Cliente("AC555", "Anna", 2011, 0, 12);

		Cliente[] clienti = { c1, c2, c3 };

		for (Cliente c : clienti) {
			System.out.println(c);
		}

		System.out.println("Conteggio clienti: " + Cliente.getConteggioClienti());

	}
}
