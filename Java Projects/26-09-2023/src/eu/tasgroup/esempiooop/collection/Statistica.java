package eu.tasgroup.esempiooop.collection;

public class Statistica {
	public static void main(String[] args) {
		int valori[] = { 8, 5, 8, 7, 4, 9, 6, 4, 6, 8, 5, 7, 9, 0, 1, 2, 3, 5, 4, 7, 8, 6 };
		int statistica[] = new int[valori.length];

		String out = "Valore\tFrequenza\n";
		for (int i = 0; i < valori.length; i++) {
			++statistica[valori[i]];
		}

		for (int i = 0; i < statistica.length; i++) {
			if (statistica[i] == 0)
				continue;
			out += i + "\t" + statistica[i] + "\n";
		}

		System.out.println(out);
	}
}
