package eu.tasgroup.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Studente[] studenti = new Studente[3];
		Esame[] esami = new Esame[7];
		Scanner in = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.printf("Inserire dati per lo studente #%d%n", i + 1);
			System.out.print("Nome: ");
			String nome = in.next();
			System.out.print("Cognome: ");
			String cognome = in.next();
			boolean corretto = false;
			String matricola = "non inizializzata";
			LOOP: do {
				System.out.print("Matricola: ");
				matricola = in.next();
				for (int j = 0; j < i; j++) {
					if (studenti[j].getMatricola().equals(matricola)) {
						System.out.println("Matricola già esistente.\nRiprovare.");
						continue LOOP;
					}
				}
				corretto = true;
			} while (!corretto);
			studenti[i] = new Studente(matricola, nome, cognome);
		}
		for (int i = 0; i < 7; i++) {
			System.out.printf("Inserire dati per l'esame #%d%n", i + 1);
			System.out.print("Materia: ");
			String materia = in.next();
			System.out.print("Matricola: ");
			String matricola = in.next();
			System.out.print("Voto: ");
			int voto = in.nextInt();
			esami[i] = new Esame(matricola, materia, voto);
		}
		in.close();
		for (Studente studente : studenti) {
			int ripetizioni = 0;
			for (Studente altroStudente : studenti) {
				if (studente.getMatricola().equals(altroStudente.getMatricola()))
					ripetizioni++;
			}
			assert ripetizioni == 1;
		}
		for (Studente studente : studenti) {
			System.out.println();
			System.out.printf("Riepilogo per %s %s %s:%n", studente.getCognome(), studente.getNome(),
					studente.getMatricola());
			Esame[] sostenuti = esamiSostenuti(esami, studente);
			for (Esame esame : sostenuti) {
				System.out.printf("Esame: %s - voto: %d%n", esame.getEsame(), esame.getVoto());
			}
		}
		System.out.println();
	}

	private static Esame[] esamiSostenuti(Esame[] esami, Studente studente) {
		List<Esame> sostenuti = new ArrayList<Esame>();
		for (Esame esame : esami) {
			if (esame.getMatricola().equals(studente.getMatricola())) {
				sostenuti.add(esame);
			}
		}
		return sostenuti.toArray(new Esame[0]);
	}
}
