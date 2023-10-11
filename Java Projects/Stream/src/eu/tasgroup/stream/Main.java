package eu.tasgroup.stream;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		Formatter file;
		System.out.print("Nome da dare al file di output: ");
		try {
			file = new Formatter("./" + in.next() + ".txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		var persone = creaLista();
		file.format("%s\r\n", "|=== persone ===|");
		persone.forEach(p -> file.format("%s\r\n", p));
		System.out.println("|=== persone ===|");
		persone.forEach(System.out::println);
		System.out.println();

		var statistiche = new Statistiche(persone);
		file.format("%s\r\n", "|=== statistiche persone ===|");
		file.format("%s\r\n", statistiche);
		System.out.println("|=== statistiche persone ===|");
		System.out.println(statistiche);
		System.out.println();

		persone = filtraLista(persone);
		file.format("%s\r\n", "|=== persone filtrate ===|");
		persone.forEach(p -> file.format("%s\r\n", p));
		System.out.println("|=== persone filtrate ===|");
		persone.forEach(System.out::println);
		System.out.println();

		statistiche = new Statistiche(persone);
		file.format("%s\r\n", "|=== persone filtrate filtrate ===|");
		persone.forEach(p -> file.format("%s\r\n", p));
		System.out.println("|=== statistiche persone filtrate ===|");
		System.out.println(statistiche);
		System.out.println();

		persone = ordinaLista(persone);
		file.format("%s\r\n", "|=== persone ordinate ===|");
		persone.forEach(p -> file.format("%s\r\n", p));
		System.out.println("|=== persone ordinate ===|");
		persone.forEach(System.out::println);
		System.out.println();

		var formattate = formattaLista(persone);
		file.format("%s\r\n", "|=== persone ordinate ===|");
		formattate.forEach(p -> file.format("%s\r\n", p));
		System.out.println("|=== persone formattate ===|");
		formattate.forEach(System.out::println);
		System.out.println();

		in.close();
		file.close();
	}

	private static List<Persona> creaLista() {
		return List.of(
				new Persona("Matteo", "Rampone", "Studente universitario", 23, 0),
				new Persona("Carlo", "Christian", "Docente universitario", 36, 2000),
				new Persona("Christian", "Carlo", "Spazzino universitario", 45, 4000),
				new Persona("Celestino", "Caro", "Comodino universitario", 1, 5432),
				new Persona("Luca", "Mattei", "Automobilista", 45, 5334),
				new Persona("Antonio", "Rampone", "Automobile", 24, 90000),
				new Persona("Carlo", "Alfredo Rampone", "Venditore", 67, 2),
				new Persona("Romboide", "Scaleno", "Banditore d'asta", 50, 532),
				new Persona("Pesticida", "Anti zanzare", "Lattina", 3, 25432),
				new Persona("Gertrude", "Simona", "Atleta", 23, 543),
				new Persona("Forse mi  chiamo Giovanni", "O forse ero matilda", "Confuso", 23, 0),
				new Persona("Giovanni", "Falcone", "Magistrato", 67, 3121),
				new Persona("Luca", "Rampone", "Inesistente", 23, 5324),
				new Persona("Ludovico", "Einaudi", "Lattino", 34, 0),
				new Persona("Lodovico", "Einoudi", "Lattante", 1, 0),
				new Persona("Ludopatico", "Frenetico", "Giocatore d'azzardo", 93, -1000));
	}

	private static List<Persona> filtraLista(List<Persona> persone) {
		Predicate<Persona> predicato = null;
		FilterPredicateGenerator predicatoGen = new FilterPredicateGenerator();
		boolean cont;
		do {
			System.out.println("Scegli il campo su cui filtrare:");
			System.out.println("\t1 - nome");
			System.out.println("\t2 - cognome");
			System.out.println("\t3 - professione");
			System.out.println("\t4 - età");
			System.out.println("\t5 - stipendio");
			System.out.print("La tua scelta: ");
			int scelta = in.nextInt();
			var estrazione = PersonaExtractionInstruction.valueOf(scelta - 1);
			predicatoGen.setExtraction(estrazione);

			System.out.println("Scegli il tipo di comparatore da applicare:");
			switch (scelta) {
			case 4, 5:
				System.out.println("\t1 - valore minimo");
				System.out.println("\t2 - valore massimo");
				System.out.println("\t3 - divisibile per");
				System.out.println("\t4 - numero primo");
				break;
			case 1, 2, 3:
				System.out.println("\t5 - ricerca token");
				System.out.println("\t6 - evita token");
				System.out.println("\t7 - lunghezza minima");
				System.out.println("\t8 - lunghezza massima");
				break;
			}
			System.out.print("La tua scelta: ");
			scelta = in.nextInt();
			var comparatore = FilterPredicateComparisonInstruction.valueOf(scelta - 1);
			predicatoGen.setComparison(comparatore);

			System.out.print("Scegli il valore da usare come argomento del filtro: ");
			Object argScelto = switch (scelta) {
			case 5, 6:
				yield in.next();
			case 1, 2, 3, 7, 8:
				yield in.nextInt();
			default:
				yield null;
			};
			predicatoGen.setComparisonObj(argScelto);

			if (predicato == null)
				predicato = predicatoGen.generate();
			else
				predicato = predicato.and(predicatoGen.generate());

			System.out.print("Vuoi continuare? (true/false) ");
			cont = in.nextBoolean();
		} while (cont);

		return persone.stream().filter(predicato).toList();
	}

	private static List<Persona> ordinaLista(List<Persona> persone) {
		SorterComparatorGenerator comparatoreGen = new SorterComparatorGenerator();
		Comparator<Persona> comparatore = null;
		boolean cont;
		do {
			System.out.println("Scegli il campo su cui ordinare:");
			System.out.println("\t1 - nome");
			System.out.println("\t2 - cognome");
			System.out.println("\t3 - professione");
			System.out.println("\t4 - età");
			System.out.println("\t5 - stipendio");
			System.out.print("La tua scelta: ");
			int scelta = in.nextInt();
			var estrazione = PersonaExtractionInstruction.valueOf(scelta - 1);
			comparatoreGen.setExtraction(estrazione);

			System.out.println("Scegli il tipo di comparatore da applicare:");
			System.out.println("\t1 - ordinamento naturale");
			switch (scelta) {
			case 4, 5:
				System.out.println("\t2 - conteggio divisori");
				System.out.println("\t3 - massima cifra più significativa");
				System.out.println("\t4 - massima cifra meno significativa");
				break;
			case 1, 2, 3:
				System.out.println("\t5 - lunghezza");
				System.out.println("\t6 - conteggio vocali");
				System.out.println("\t7 - conteggio consonanti");
				break;
			}
			System.out.print("La tua scelta: ");
			scelta = in.nextInt();
			var comparazione = SorterComparatorComparisonInstruction.valueOf(scelta - 1);
			comparatoreGen.setComparison(comparazione);

			if (comparatore == null)
				comparatore = comparatoreGen.generate();
			else
				comparatore = comparatore.thenComparing(comparatoreGen.generate());

			System.out.print("Vuoi continuare? (true/false) ");
			cont = in.nextBoolean();
		} while (cont);

		return persone.stream().sorted(comparatore).toList();
	}

	private static List<String> formattaLista(List<Persona> persone) {
		PersonaFormatter formatter = new PersonaFormatter();
		boolean cont;
		do {
			System.out.println("Scegli il campo da formattare:");
			System.out.println("\t1 - nome");
			System.out.println("\t2 - cognome");
			System.out.println("\t3 - professione");
			System.out.println("\t4 - età");
			System.out.println("\t5 - stipendio");
			System.out.print("La tua scelta: ");
			int campo = in.nextInt();
			var estrazione = PersonaExtractionInstruction.valueOf(campo - 1);

			System.out.println("Scegli il tipo di formattazione da applicare:");
			switch (campo) {
			case 1, 2, 3:
				System.out.println("\t1 - campo completo");
				System.out.println("\t2 - campo accorciato");
				System.out.println("\t3 - iniziali");
				System.out.print("La tua scelta: ");
				var formatInstruction = StringFormatInstruction.valueOf(in.nextInt() - 1);
				formatter.addStringFormatting(estrazione, formatInstruction);
				break;
			case 4, 5:
				System.out.println("In che base vuoi formattare il campo numerico?");
				System.out.print("La tua scelta: ");
				formatter.addIntegerFormatting(estrazione, in.nextInt());
				break;
			}
			System.out.print("Vuoi continuare? (true/false) ");
			cont = in.nextBoolean();
		} while (cont);

		return persone.stream().map(formatter::format).toList();
	}

}
