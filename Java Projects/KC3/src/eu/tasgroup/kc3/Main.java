package eu.tasgroup.kc3;

public class Main {
	public static void main(String[] args) {
		Memoria mem = new Memoria();

		System.out.println("Prodotto\t1\t2\t3\t4");
		for (int p = 0; p < 5; p++) {
			System.out.print(p + "\t\t");
			for (int i = 0; i < 4; i++) {
				int v = mem.getVenditePerVenditoreProdotto(i, p);
				System.out.print(v + "\t");
			}
			System.out.println();
			System.out.println("Totale " + p + "\t" + mem.getVenditePerProdotto(p));
		}
		System.out.print("Totale\t\t");
		for (int i = 0; i < 4; i++) {
			System.out.print(mem.getVenditePerVenditore(i) + "\t");
		}
		System.out.println();

	}
}
