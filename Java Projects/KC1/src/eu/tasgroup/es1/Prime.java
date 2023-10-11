package eu.tasgroup.es1;

public class Prime {
	// Scrivere un programma che stampa i numeri primi minori di 100
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (isPrime(i))
				System.out.println(i);
		}
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
