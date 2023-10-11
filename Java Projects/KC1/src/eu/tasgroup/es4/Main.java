package eu.tasgroup.es4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		 * Scrivete un programma che legga una sequenza di al massimo 100 date, nella
		 * forma dd/mm/yyyy, terminata dalla data 00/00/0000, che non è considerata
		 * parte della sequenza. Alla fine il programma deve stampare la data più
		 * recente.
		 */
		System.out.println("Inserisci le date:");
		LocalDate earliest = LocalDate.MAX;
		try (Scanner in = new Scanner(System.in)) {
			for (int i = 0; i < 100; i++) {
				String input = in.next();
				int giorno = Integer.parseInt(input.substring(0, 2), 10);
				int mese = Integer.parseInt(input.substring(3, 5), 10);
				int anno = Integer.parseInt(input.substring(6), 10);
				if (giorno == 0 && mese == 0 && anno == 0) {
					break;
				}
				LocalDate date = LocalDate.of(anno, mese, giorno);
				earliest = earliest.isAfter(date) ? date : earliest;
			}
		}
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(f.format(earliest));
	}

}
