package eu.tasgroup.stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		System.out.println("Stamperemo delle liste nulle:");
		List<String> lista = null;
		// causa NullPointerException
		// lista.stream().forEach(System.out::println);
		printListSafe(lista);
	}

	public static void printListSafe(List<String> lista) {
		Stream.ofNullable(lista).flatMap(l -> l.stream()).forEach(System.out::println);
	}
}
