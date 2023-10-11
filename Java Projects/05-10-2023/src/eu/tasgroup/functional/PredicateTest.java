package eu.tasgroup.functional;

import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		//var predicate = (Predicate<String>) e -> e.equals("ciao");
		var predicate = Predicate.isEqual("ciao");
		System.out.println(predicate.negate().test("boh"));
	}
}
