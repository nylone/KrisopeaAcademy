package eu.tasgroup.esempiooop.iterazioni;

public class Ricorsione2 {
	public static void main(String[] args) {
		int x = 3;
		System.out.println("fibonacci di " + x + ": " + fibonacci(x));
	}

	public static int fibonacci(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
