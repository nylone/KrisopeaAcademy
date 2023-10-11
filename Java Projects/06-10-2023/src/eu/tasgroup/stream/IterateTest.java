package eu.tasgroup.stream;

import java.util.List;
import java.util.stream.Stream;

public class IterateTest {
	public static void main(String[] args) {
		// Stream.iterate(1, i -> i++); // stream infinito da 1 in su
		var stream1 = Stream.iterate(1, i -> i + 1).limit(15); // come prima ma limito ai primi 15 elementi
		// var stream1 = Stream.iterate(1, i -> ++i).limit(15); // come sopra
		// var stream1 = Stream.iterate(1, i -> i++).limit(15); // stream di 15
		// elementi, tutti uguali a 1

		var stream2 = Stream.iterate(1, i -> i <= 15, i -> ++i); // stessa cosa ma
		// implementato con un predicato che fa
		// checking
		stream1.forEach(System.out::print);
		System.out.println();
		stream2.forEach(System.out::print);

		Stream.<String>builder().add("test").add("ciao").add("caro").build().forEach(System.out::println);

		Stream.Builder<String> builder = Stream.builder();
		List.of("1", "2", "3").stream().forEach(builder);
		builder.build().skip(0).forEach(System.out::println);

		Stream.of("1", "2", "3", "56", "3", "a", "b", "A", "C").distinct().map(s -> s + " ").skip(3).limit(4)
				.forEach(System.out::print);
		Stream.of(1, 23, 4, 5, 12, 4, 53, 76, 4, 7, 437, 4, 9).distinct().filter(e -> e % 3 == 0)
				.forEach(System.out::println);

		Stream.of("1", "2", "3", "56", "3", "a", "b", "A", "C").distinct().filter(s -> {
			try {
				Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}).mapToInt(Integer::parseInt).mapToObj(i -> Integer.toString(i) + " ").forEach(System.out::println);

		Stream.of("1", "2", "3", "56", "3", "a", "b", "A", "C").sorted().map(s -> s + " ").forEach(System.out::print);
		// var stessoRisultato = List.of("1", "2", "3", "56", "3", "a", "b", "A", "C");
		// stessoRisultato.sort(String::compareTo);
		// stessoRisultato.forEach(System.out::println);
		
		var toPeek = Stream.of("1", "2", "3", "56", "3", "a", "b", "A", "C");
		toPeek.peek(s -> System.out.print("3".equals(s) ? 3 : 0)).map(s -> s + " ").forEach(System.out::println);


	}
}
