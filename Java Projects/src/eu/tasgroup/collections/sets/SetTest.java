package eu.tasgroup.collections.sets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	private final String[] ELEMENTI = { "e1", "e1", "e4", "e2", "e6" };

	public SetTest() {
		List<String> lista = Arrays.asList(ELEMENTI);

		Set<String> set = new TreeSet<String>(lista);

		for (String s : set)
			System.out.printf("%s ", s);
		System.out.println();

		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			System.out.printf("%s ", iter.next());
		}
	}

	public static void main(String[] args) {
		new SetTest();
	}

}
