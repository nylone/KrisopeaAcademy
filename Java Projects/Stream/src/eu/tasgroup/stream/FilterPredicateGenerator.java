package eu.tasgroup.stream;

import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getIntegerExtractor;
import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getStringExtractor;

import java.util.function.Function;
import java.util.function.Predicate;

public class FilterPredicateGenerator {
	private FilterPredicateComparisonInstruction comparison;
	private PersonaExtractionInstruction extraction;
	private Object comparisonObj;

	public FilterPredicateGenerator() {
	}

	private <T> T getCastArgument(Class<T> type) {
		return type.cast(comparisonObj);
	}

	public Predicate<Persona> generate() {
		Predicate<Persona> predicate;
		switch (extraction) {
		case NOME, COGNOME, PROFESSIONE:
			Function<Persona, String> stringExtractor = getStringExtractor(extraction);
			predicate = switch (comparison) {
			case STRING_AVOIDS: {
				var arg = getCastArgument(String.class);
				yield (p) -> !stringExtractor.apply(p).toLowerCase().contains(arg.toLowerCase());
			}
			case STRING_CONTAINS: {
				var arg = getCastArgument(String.class);
				yield (p) -> stringExtractor.apply(p).toLowerCase().contains(arg.toLowerCase());
			}
			case STRING_LENGTH_AT_LEAST: {
				var arg = getCastArgument(Integer.class);
				yield (p) -> stringExtractor.apply(p).length() >= arg;
			}
			case STRING_LENGTH_AT_MOST: {
				var arg = getCastArgument(Integer.class);
				yield (p) -> stringExtractor.apply(p).length() <= arg;
			}
			default:
				yield (p) -> false;
			};
			break;
		case ETA, STIPENDIO:
			Function<Persona, Integer> intExtractor = getIntegerExtractor(extraction);
			predicate = switch (comparison) {
			case INTEGER_AT_LEAST: {
				var arg = getCastArgument(Integer.class);
				yield (p) -> intExtractor.apply(p) >= arg;
			}
			case INTEGER_AT_MOST: {
				var arg = getCastArgument(Integer.class);
				yield (p) -> intExtractor.apply(p) <= arg;
			}
			case INTEGER_DIVISIBLE_BY: {
				var arg = getCastArgument(Integer.class);
				yield (p) -> intExtractor.apply(p) % arg == 0;
			}
			case INTEGER_PRIME: {
				yield (p) -> {
					int num = intExtractor.apply(p);
					for (int d = num - 1; d > 1; d--) {
						if (num % d == 0)
							return false;
					}
					return true;
				};
			}
			default:
				yield (p) -> false;
			};
			break;
		default:
			predicate = (p) -> false;
		}
		return predicate;
	}

	public void setComparison(FilterPredicateComparisonInstruction instruction) {
		this.comparison = instruction;
	}

	public void setExtraction(PersonaExtractionInstruction extraction) {
		this.extraction = extraction;
	}

	public void setComparisonObj(Object comparisonObj) {
		this.comparisonObj = comparisonObj;
	}

}
