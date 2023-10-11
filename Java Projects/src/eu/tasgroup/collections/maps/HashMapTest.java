package eu.tasgroup.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class HashMapTest {
	private Map<String, Integer> mappa;
	private final String[] ELEMENTI = { "e1", "e1", "e4", "e2", "e6" };

	public HashMapTest() {
		mappa = new HashMap<String, Integer>();
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("inserire dei dati intevallati di \" , \":");
			String input = in.next();
			StringTokenizer tokenizer = new StringTokenizer(input, ",");
			while (tokenizer.hasMoreElements()) {
				String parola = tokenizer.nextToken().toLowerCase();
				int contatore = 0;
				if (mappa.containsKey(parola))
					contatore = mappa.get(parola);
				mappa.put(parola, ++contatore);
			}
		}
		Set<String> chiavi = mappa.keySet();
		for (String chiave : chiavi)
			System.out.printf("| %s : %d |", chiave, mappa.get(chiave));
	}

	public static void main(String[] args) {
		new HashMapTest();
	}

}
