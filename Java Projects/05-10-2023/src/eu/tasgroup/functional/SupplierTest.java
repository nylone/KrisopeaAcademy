package eu.tasgroup.functional;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		int input = 10;
		int limite = 20;

		Supplier<Integer> supply10 = () -> input;
		Predicate<Integer> minoreDi20 = i -> i < limite;
		Consumer<String> stampa = stampaConPrefix("Prefisso! ");
		stampa.accept(String.valueOf(minoreDi20.test(supply10.get())));
	}

	private static Consumer<String> stampaConPrefix(String string) {
		// TODO Auto-generated method stub
		return s -> System.err.println(string + s);
	}
}
