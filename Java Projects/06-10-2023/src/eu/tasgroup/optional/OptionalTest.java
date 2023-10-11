package eu.tasgroup.optional;

import java.util.List;
import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		List<String> lista = List.of("1", "2", "3");
		Optional<String> optStringa2 = lista.stream().filter(e -> e.equals("ciao!")).findAny();

		optStringa2.or(() -> Optional.of("valore non trovato")).ifPresent(System.out::println);
	}
}
