package eu.tasgroup.persone;

import java.util.Comparator;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		var gestore = new GestorePersone();
		gestore.aggiungiPersona(new Persona("matteo", "disoccupato", 23));
		gestore.aggiungiPersona(new Persona("riccardo", "spazzino", 24));
		gestore.aggiungiPersona(new Persona("luca", "professore", 55));
		gestore.aggiungiPersona(new Persona("francesco", "avvocato", 60));
		gestore.aggiungiPersona(new Persona("mattia", "atleta", 19));
		gestore.aggiungiPersona(new Persona("leonardo", "youtuber", 25));
		gestore.aggiungiPersona(new Persona("carmelo", "ricercatore", 32));

		System.out.println(gestore.cercaPersone(p -> p.getNome().length() > 5));
		var predicato = (Predicate<Persona>) p -> p.getProfessione().contains("a");
		predicato = predicato.and(p -> p.getNome().contains("r"));
		System.out.println(gestore.cercaPersone(predicato));
		var ordinatore = (Comparator<Persona>) (p1, p2) -> p1.getEtà() - p2.getEtà();
		System.out.println(gestore.ordinaPersone(ordinatore));

	}
}
