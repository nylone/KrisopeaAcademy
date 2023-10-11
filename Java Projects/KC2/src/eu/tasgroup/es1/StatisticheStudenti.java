package eu.tasgroup.es1;

import java.util.Arrays;

public class StatisticheStudenti {
	/*
	 * In una matrice sono presenti i seguenti dati: riga: nome studente colonna:
	 * valutazione studente Calcolare le seguenti statistiche: voto più basso voto
	 * più alto media per studente stampa complessiva dei voti per sudente ordinando
	 * da studente più meritevole a meno meritevole.
	 */
	public static void main(String[] args) {
		Studente valutazioni[] = { new Studente("Rampeo", 1, 2, 3, 4, 5, 6, 7, 8, 9),
				new Studente("Test", 2, 4, 8, 5, 1, 7, 9, 3, 6), new Studente("Caio", 5, 6, 8, 8, 9, 7),
				new Studente("Mario", 8, 4, 7, 8, 4, 5, 7), };
		Arrays.sort(valutazioni);
		for (int i = valutazioni.length - 1; i >= 0; i--) {
			Studente studente = valutazioni[i];
			System.out.printf("Voto minimo per %s: %d%n", studente.getNome(), studente.votoMin());
			System.out.printf("Voto massimo per %s: %d%n", studente.getNome(), studente.votoMax());
			System.out.printf("Media per %s: %.2f%n", studente.getNome(), studente.media());
			System.out.printf("Voti per %s: ", studente.getNome());
			for (int voto : studente.getVoti()) {
				System.out.printf("%d ", voto);
			}
			System.out.println("\n");
		}
	}
}
