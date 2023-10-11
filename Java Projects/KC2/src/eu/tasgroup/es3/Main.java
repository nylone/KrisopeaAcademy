package eu.tasgroup.es3;

import java.util.Scanner;

public class Main {
	/*
	 * Scrivere un programma di assegnamento posti. (capienza massima vagone: 50
	 * posti, 20 prima classe 30 seconda classe. Totale vagoni 3.) Visualizzare le
	 * seguenti opzioni di prenotazione: 1 - per la prima classe 2 - per la seconda
	 * classe Dopo la pronatozione visualizzare una schematica piantina con il posto
	 * assegnato. I vagoni vanno occupati progressivamente. Quando la sezione prima
	 * classe (per tutti i vagoni) è terminata chiedere al passeggero se vuole
	 * passare in seconda e viceversa. Se i posti sono tutti occupati visualizzare
	 * il rispettivo messaggio.
	 */
	public static void main(String[] args) {
		int numVagoni = 3;
		Treno treno = new Treno(numVagoni);

		Scanner in = new Scanner(System.in);

		boolean nuovaPrenotazione = true;
		while (nuovaPrenotazione) {
			System.out.println("Dove prenotare? ( p / S )");
			String classe = in.next();
			int[] prenotazione = null;
			Classe scelta;
			if (classe.equalsIgnoreCase("p")) {
				scelta = Classe.PRIMA;
			} else if (classe.equalsIgnoreCase("s")) {
				scelta = Classe.SECONDA;
			} else {
				System.out.println("Errore");
				return;
			}

			Classe alternativa = scelta == Classe.PRIMA ? Classe.SECONDA : Classe.PRIMA;

			prenotazione = treno.prenotaPosto(scelta);
			if (prenotazione == null) {
				System.out
						.println("Nessun posto in " + scelta + " classe.\nPrenotare in " + alternativa + "? ( s / N )");
				String fb = in.next();
				if (fb.equalsIgnoreCase("s")) {
					scelta = alternativa;
					prenotazione = treno.prenotaPosto(scelta);
				}
			}

			if (prenotazione == null) {
				System.out.println("Non è stato trovato un posto prenotabile");
			} else {
				System.out.printf("Il tuo posto si trova nel vagone %d, posto %d%n", prenotazione[0], prenotazione[1]);
				for (int i = 0; i < numVagoni; i++) {
					System.out.println("|===P===|");
					for (int j = 0; j < 4; j++) {
						System.out.print("| ");
						for (int k = 1; k <= 5; k++) {
							if (scelta == Classe.PRIMA && i == prenotazione[0] && j * 5 + k == prenotazione[1]) {
								System.out.print("x");
							} else {
								System.out.print("o");
							}
						}
						System.out.println(" |");
					}
					System.out.println("|===S===|");
					for (int j = 0; j < 6; j++) {
						System.out.print("| ");
						for (int k = 1; k <= 5; k++) {
							if (scelta == Classe.SECONDA && i == prenotazione[0] && j * 4 + k == prenotazione[1]) {
								System.out.print("x");
							} else {
								System.out.print("o");
							}
						}
						System.out.println(" |");
					}
					System.out.println("|=======|");
				}
			}

			System.out.println("Nuova prenotazione? ( s / N )");
			String fb = in.next();
			if (fb.equalsIgnoreCase("n")) {
				nuovaPrenotazione = false;
			}
		}

		in.close();

	}
}
