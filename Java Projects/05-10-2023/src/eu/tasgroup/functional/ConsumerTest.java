package eu.tasgroup.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		// Consumer<String> stampa = System.out::println;
		Consumer<String> stampa = e -> System.out.println(e);
		stampa.accept("ciao");
		stampa = stampa.andThen(e -> System.out.println(e + " da andThen"));
		stampa.accept("ciao");
		List<String> studenti = Arrays.asList("Paolo", "paolino", "giorgio", "gianfrancioschio");
		studenti.forEach(stampa);
	}
}
