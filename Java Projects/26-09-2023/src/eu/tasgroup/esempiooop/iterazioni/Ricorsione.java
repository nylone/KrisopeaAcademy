package eu.tasgroup.esempiooop.iterazioni;

public class Ricorsione {
	public static void main(String[] args) {
		potenza(2, 3);
		potenza(5, 19);
	}

	public static void potenza(long a, long b) {
		long ris;
		ris = calcola(a, b);
		System.out.println("risultato: " + ris);
	}

	public static long calcola(long a, long b) {
		if (b <= 1) {
			return a;
		}
		return a * calcola(a, b--);

	}
}
