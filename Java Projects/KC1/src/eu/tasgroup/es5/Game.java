package eu.tasgroup.es5;

import java.util.Random;

public class Game {
	/*
	 * Ogni giocatore lancia due dadi.
	 * 
	 * Se la somma al primo tiro è 7 o 11 il giocatore ha vinto. Se la somma al
	 * primo tiro è 2,3 o 12 il giocatore ha perso.
	 * 
	 * Se la somma al primo tiro è 4,5,6,8,9 o 10 questa somma diventa il punteggio.
	 * Per vincere è necessario continuare a tirare i dati finchè non si totalizza
	 * il punteggio realizzato con il primo tiro. Il giocatore perde se totalizza 7
	 * prima di raggiungere il punteggio del primo tiro.
	 */

	public static void main(String[] args) {
		int sum = throwDice();
		switch (sum) {
		case 7, 11: {
			System.out.println("Hai vinto!");
			break;
		}
		case 2, 3, 12: {
			System.out.println("Hai perso!");
			break;
		}
		default: {
			int punteggio = sum;
			for (sum = throwDice(); sum != punteggio; sum = throwDice()) {
				if (sum == 7) {
					System.out.println("Hai perso!");
					return;
				}
			}
			System.out.println("Hai vinto!");
		}
		}
	}

	private static int throwDice() {
		Random die = new Random();
		int d1 = die.nextInt(6) + 1;
		int d2 = die.nextInt(6) + 1;
		int sum = d1 + d2;
		System.out.println("sum: " + sum);
		return sum;
	}
}
