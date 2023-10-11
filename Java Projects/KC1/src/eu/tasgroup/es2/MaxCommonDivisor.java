package eu.tasgroup.es2;

import java.util.Scanner;

public class MaxCommonDivisor {
	public static void main(String[] args) {
		// Scrivere un programma che calcola il MCD di due numeri positivi immessi
		// attraverso Scanner.
		Scanner in = new Scanner(System.in);
		System.out.println("Inserire due valori:");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		in.close();
		System.out.println(findMCD(num1, num2));
	}

	private static int findMCD(int num1, int num2) {
		int min = num1 > num2 ? num2 : num1;
		for (int i = min; i > 0; i--) {
			if (num1 % i == 0 && num2 % i == 0)
				return i;
		}
		return 1;
	}
}
