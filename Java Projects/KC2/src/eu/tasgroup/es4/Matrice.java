package eu.tasgroup.es4;

import java.util.Random;

public class Matrice {
	// In una matrice con due colonne e dieci righe, visualizzare quella con maggior
	// numero di elementi pari.
	public static void main(String[] args) {
		int[][] matrice = new int[10][2];
		Random gen = new Random();
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				matrice[i][j] = gen.nextInt(256);
				System.out.printf("%3d ", matrice[i][j]);
			}
			System.out.println();
		}
		System.out.println("Colonna che massimizza i numeri pari:");
		int maxColonne = 0;
		for (int[] riga : matrice) {
			if (maxColonne < riga.length)
				maxColonne = riga.length;
		}
		int[] conteggioPari = new int[maxColonne];
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				if (matrice[i][j] % 2 == 0) {
					conteggioPari[j]++;
				}
			}
		}
		int colonnaMaxPari = 0;
		for (int i = 0; i < conteggioPari.length; i++) {
			if (conteggioPari[i] > conteggioPari[colonnaMaxPari])
				colonnaMaxPari = i;
		}
		for (int i = 0; i < matrice.length; i++) {
			System.out.println(matrice[i][colonnaMaxPari]);
		}
	}
}
