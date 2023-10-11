package eu.tasgroup.functional;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionTest {
	public static void main(String[] args) {
		Function<Integer, Double> operazione = i -> i * 1.01;
		System.out.println(operazione.apply(101));

		BiFunction<Integer, Integer, Double> operazione2 = (i1, i2) -> i1 / i2 * 1.01;
		System.out.println(operazione2.apply(101, 12));

		Function<Double, Long> dividiPer2 = d -> Double.valueOf(d / 2).longValue();
		Function<Long, String> incrementaECreaStringa = l -> String.valueOf(l + 20);
		Function<Double, String> dividiPer2EIncrementaECreaStringa = dividiPer2.andThen(incrementaECreaStringa);
		Consumer<String> stampa = System.out::println;
		stampa.accept(dividiPer2EIncrementaECreaStringa.apply(10.0));
	}
}
