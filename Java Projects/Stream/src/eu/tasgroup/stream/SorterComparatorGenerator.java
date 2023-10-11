package eu.tasgroup.stream;

import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getIntegerExtractor;
import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getStringExtractor;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Stream;

public class SorterComparatorGenerator {
	private static IntPredicate isVowel = c -> {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	};
	private static IntPredicate isConsonant = isVowel.negate().and(c -> Character.isAlphabetic(c));

	private SorterComparatorComparisonInstruction ordering;
	private PersonaExtractionInstruction extraction;

	public SorterComparatorGenerator() {
	}

	public Comparator<Persona> generate() {
		Comparator<Persona> comparator;
		switch (extraction) {
		case NOME, COGNOME, PROFESSIONE:
			Function<Persona, String> stringExtractor = getStringExtractor(extraction);
			comparator = switch (ordering) {
			case NATURAL_ORDER: {
				yield (p1, p2) -> stringExtractor.apply(p1).compareTo(stringExtractor.apply(p2));
			}
			case STRING_GREATEST_LENGTH: {
				yield (p1, p2) -> stringExtractor.apply(p1).length() - stringExtractor.apply(p2).length();
			}
			case STRING_MOST_VOWELS: {
				yield (p1,
						p2) -> (int) (countVowels(stringExtractor.apply(p1)) - countVowels(stringExtractor.apply(p2)));
			}
			case STRING_MOST_CONSONANTS: {
				yield (p1, p2) -> (int) (countConsonants(stringExtractor.apply(p1))
						- countConsonants(stringExtractor.apply(p2)));
			}
			default:
				yield (p1, p2) -> 0;
			};
			break;
		case ETA, STIPENDIO:
			Function<Persona, Integer> intExtractor = getIntegerExtractor(extraction);

			comparator = switch (ordering) {
			case NATURAL_ORDER: {
				yield (p1, p2) -> intExtractor.apply(p1).compareTo(intExtractor.apply(p2));
			}
			case INTEGER_MOST_DIVISORS: {
				yield (p1, p2) -> {
					Integer i1 = intExtractor.apply(p1);
					Integer i2 = intExtractor.apply(p2);
					long c1 = countDivisors(i1);
					long c2 = countDivisors(i2);
					return (int) (c1 - c2);
				};
			}
			case INTEGER_GREATEST_FIRST_DIGIT:
				yield (p1, p2) -> {
					int i1 = firstDigit(intExtractor.apply(p1));
					int i2 = firstDigit(intExtractor.apply(p2));
					return i1 - i2;
				};
			case INTEGER_GREATEST_LAST_DIGIT:
				yield (p1, p2) -> {
					int i1 = lastDigit(intExtractor.apply(p1));
					int i2 = lastDigit(intExtractor.apply(p2));
					return i1 - i2;
				};
			default:
				yield (p1, p2) -> 0;
			};
			break;
		default:
			comparator = (p1, p2) -> 0;
		}
		return comparator;
	}

	public void setComparison(SorterComparatorComparisonInstruction instruction) {
		this.ordering = instruction;
	}

	public void setExtraction(PersonaExtractionInstruction extraction) {
		this.extraction = extraction;
	}

	private static long countVowels(String word) {
		return word.chars().filter(isVowel).count();
	}

	private static long countConsonants(String word) {
		return word.chars().filter(isConsonant).count();
	}

	private long countDivisors(Integer i) {
		return Stream.iterate(1, j -> j < i, j -> j + 1).filter(j -> i % j == 0).count();
	}

	private int firstDigit(Integer i) {
		i = i >= 0 ? i : -i;
		String s = i.toString();
		i = Integer.parseInt(s, 0, 1, 10);
		return i;
	}

	private int lastDigit(Integer i) {
		String s = i.toString();
		i = Integer.parseInt(s, s.length() - 1, s.length(), 10);
		return i;
	}

}
