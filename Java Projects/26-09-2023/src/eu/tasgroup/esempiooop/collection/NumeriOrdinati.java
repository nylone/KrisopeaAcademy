package eu.tasgroup.esempiooop.collection;

import static java.lang.Math.random;

import java.util.Arrays;
import java.util.Scanner;

public class NumeriOrdinati {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Quanti valori vuoi inserire? ");
		int k = in.nextInt();

		System.out.println("Qual è il valore pi\u00F9 alto? ");
		int m = in.nextInt();

		in.close();

		int[] numeri = new int[m];
		for (int i = 0; i < numeri.length; i++) {
			numeri[i] = i + 1;
		}

		int[] risultato = new int[k];
		for (int i = 0; i < risultato.length; i++) {
			int r = (int) random() * m;
			risultato[i] = numeri[r];
			numeri[r] = numeri[m - 1];
			m--;
		}

		Arrays.sort(risultato);

		for (int r : risultato) {
			System.out.println(r);
		}
	}
}
