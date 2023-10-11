package eu.tasgroup.methodreference;

import java.util.ArrayList;

public class Main {
	private static void faiQualcosa(String s) {
		System.out.println(s);
	}

	private String last = "";

	private void faiQualcosAltro(String s) {
		System.out.println(last + s);
		last = s;
	}

	public static void main(String[] args) {
		ArrayList<String> stringhe = new ArrayList<String>();
		String[] stringArray = { "mario", "rossi", "matteo", "rampone" };
		for (String s : stringArray) {
			stringhe.add(s);
		}
		stringhe.forEach((var e) -> System.out.println(e));
		stringhe.forEach(Main::faiQualcosa);
		stringhe.forEach((new Main())::faiQualcosAltro);

	}
}
