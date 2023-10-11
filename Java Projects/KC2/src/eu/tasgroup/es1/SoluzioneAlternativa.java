package eu.tasgroup.es1;

import java.util.Arrays;

public class SoluzioneAlternativa {
	/*
	 * In una matrice sono presenti i seguenti dati: riga: nome studente colonna:
	 * valutazione studente Calcolare le seguenti statistiche: voto più basso voto
	 * più alto media per studente stampa complessiva dei voti per sudente ordinando
	 * da studente più meritevole a meno meritevole.
	 */
	public static void main(String[] args) {
		Object[][] valutazioni = { { "Matteo", 1, 0, 3, 4, 19, 20 }, { "Luca", 1, 6, 5, 4 },
				{ "Gianmarco", 1, 7, 4 }, };
		
		Arrays.sort(valutazioni, (a,b) -> {
			double ma = media(a);
			double mb = media(b);

			if (ma > mb) return 1;
			else if (ma < mb)
				return -1;
			else
				return 0;
		});

		for (Object[] studente : valutazioni) {

			Integer[] voti = Arrays.copyOfRange(studente, 1, studente.length, Integer[].class);
			int minimo = Integer.MAX_VALUE;
			int massimo = Integer.MIN_VALUE;
			for (int voto : voti) {
				minimo = voto < minimo ? voto : minimo;
				massimo = voto > massimo ? voto : massimo;
			}

			System.out.println("Voto minimo di " + studente[0] + " è " + minimo);
			System.out.println("Voto massimo di " + studente[0] + " è " + massimo);
			System.out.println("Media di " + studente[0] + " è " + media(studente));
			
		}
	}

	public static double media(Object[] studente) {
		double media = 0.0;

		for (int i = 1; i < studente.length; i++) {
			media += (Integer) studente[i];
		}

		media /= studente.length - 1;

		return media;
	}
}
