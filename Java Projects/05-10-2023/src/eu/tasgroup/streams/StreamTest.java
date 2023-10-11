package eu.tasgroup.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		String[] stringhe = { "ciao", "pippo", "come", "va" };
		Stream<String> stream = Arrays.asList(stringhe).stream();
		List<String> lista = stream.filter(e -> e.contains("p")).collect(Collectors.toList());
		var stampaEVaiACapo = ((Consumer<String>) System.out::print).andThen(System.out::println);
		stream = Arrays.asList(stringhe).stream();
		stream.map(String::toUpperCase).forEach(stampaEVaiACapo);
		lista.stream().forEach(stampaEVaiACapo);
		var mappa = new HashMap<String, Integer>();
		stream = Arrays.asList(stringhe).stream();
		var stream2 = Arrays.asList(stringhe).stream();
		System.out.println("==============");
		var streamDiStream = Stream.of(stream, stream2);
		streamDiStream.flatMap(e -> e).forEach(System.out::println);
		stream2 = Arrays.asList(stringhe).stream();
		System.out.println("==============");
		stream2.flatMap(e -> Stream.of(e)).forEach(System.out::println);
		Set<String> viste = new HashSet<>();
		stream = Arrays.asList(stringhe).stream();
		stream2 = Arrays.asList(stringhe).stream();
		var stream3 = Stream.of("fanculo");
		System.out.println("==============");
		streamDiStream = Stream.of(stream, stream2, stream3);
		streamDiStream.flatMap(e -> e).filter(e -> {
			if (viste.contains(e))
				return false;
			viste.add(e);
			return true;
		}).forEach(e -> System.out.println(e));
	}
}
