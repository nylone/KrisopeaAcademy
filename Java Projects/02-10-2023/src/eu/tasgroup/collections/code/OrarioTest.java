package eu.tasgroup.collections.code;

import java.util.ArrayList;
import java.util.Collections;

public class OrarioTest {

	public static void main(String[] args) {
		ArrayList<Orario> list = new ArrayList<>();
		list.add(new Orario(10, 02, 0));
		list.add(new Orario(1, 02, 51));
		list.add(new Orario(5, 52, 55));
		list.add(new Orario(5, 12, 56));
		list.add(new Orario(7, 06, 10));
		list.add(new Orario(0, 40, 25));
		list.add(new Orario(6, 04, 5));

		Collections.sort(list);

		for (Orario orario : list) {
			System.out.println(orario);
		}

		System.out.println();

		Collections.sort(list, new OrarioComparator());

		for (Orario orario : list) {
			System.out.println(orario);
		}
	}
}
