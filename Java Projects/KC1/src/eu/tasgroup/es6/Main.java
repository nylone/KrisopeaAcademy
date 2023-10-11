package eu.tasgroup.es6;

import java.util.Scanner;

public class Main {
	// Scrivere un programma che calcoli il valore negativo in binario dato un
	// intero unsigned.
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Inserisci un numero in binario, lo negherò con le regole del complemento a 2:");
			System.out.println(c2(in.next()));
		}
	}

	public static String c2(String in) {
		boolean found1 = false;
		String out = "";
		int i;
		for (i = 0; i < in.length(); i++) {
			String bit = in.substring(i, i + 1);
			if (bit.equals("1")) {
				found1 = true;
				out = out.concat("0");
			} else {
				out = out.concat("1");
				if (found1) {
					i++;
					break;
				}
			}
		}
		out = out.concat(in.substring(i, in.length()));
		return out;
	}
}
