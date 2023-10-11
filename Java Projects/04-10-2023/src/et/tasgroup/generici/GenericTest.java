package et.tasgroup.generici;

import java.util.Arrays;

public class GenericTest {
	public static void main(String[] args) {
		Integer[] iArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Double[] dArr = { 1.1, 1.2, 1.2, 1.4, 1.5, 1.6 };
		Character[] cArr = { 'A', 'B', 'C' };

		elabora(iArr);
		elabora(dArr);
		elabora(cArr);

		System.out.println(max(1, 2, 3, 8, 4));
		System.out.println(max(1.1, 4.5, 2.3, 6.7, 9.0));
		System.out.println(max('A', 'M', '@'));

	}

	private static <T extends Comparable<T>> String max(T... dati) {
		if (dati.length == 0)
			return null;
		Arrays.sort(dati);
		return dati[dati.length - 1].toString();
	}

	public static <E> void elabora(E[] dati) {
		for (E e : dati) {
			System.out.printf("%s, ", e);
		}
		System.out.println();
	}
}
