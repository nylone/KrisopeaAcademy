package eu.tasgroup.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClienteTest {
	class Cliente {
		String id;
		String nome;
		int eta;
	}

	public static void main(String[] args) {
		Stream<String> stream = Stream.of("25, M ax", " 27, Anna", "30, Fe deri co");
		stream = stream.filter(s -> s.contains("a"));

		var ct = new ClienteTest();
		List<?> listaClienti = stream.map(s -> s.split(",")).map(arr -> {
			var c = ct.new Cliente();
			c.eta = Integer.valueOf(arr[0].replaceAll("\\s", ""));
			c.nome = arr[1].replaceAll("\\s", "");
			return c;
		}).collect(Collectors.toList());

	}
}
