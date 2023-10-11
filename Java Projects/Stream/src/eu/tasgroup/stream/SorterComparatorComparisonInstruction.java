package eu.tasgroup.stream;

public enum SorterComparatorComparisonInstruction {
	NATURAL_ORDER,
	INTEGER_MOST_DIVISORS,
	INTEGER_GREATEST_FIRST_DIGIT,
	INTEGER_GREATEST_LAST_DIGIT,
	STRING_GREATEST_LENGTH,
	STRING_MOST_VOWELS,
	STRING_MOST_CONSONANTS;

	public static SorterComparatorComparisonInstruction valueOf(int i) {
		var values = SorterComparatorComparisonInstruction.values();
		if (i >= 0 && i < values.length) {
			return values[i];
		}
		return null;
	}
}
