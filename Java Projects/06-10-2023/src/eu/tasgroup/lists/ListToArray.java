package eu.tasgroup.lists;

import java.util.Arrays;
import java.util.List;

public class ListToArray {
	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4);
		Integer[] arr = list.toArray(Integer[]::new);
		// oppure
		Integer[] arrConStream = (Integer[]) list.stream().toArray(Integer[]::new);
		Arrays.stream(arrConStream).forEach(System.out::print);

		var str = List.of("1", "2");
		// oppure
		String[] strConStream = (String[]) str.stream().toArray(String[]::new);
	}
}
