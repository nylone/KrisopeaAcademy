package eu.tasgroup.stream;

public enum FilterPredicateComparisonInstruction {
	INTEGER_AT_LEAST,
	INTEGER_AT_MOST,
	INTEGER_DIVISIBLE_BY,
	INTEGER_PRIME,
	STRING_CONTAINS,
	STRING_AVOIDS,
	STRING_LENGTH_AT_LEAST,
	STRING_LENGTH_AT_MOST;

	public static FilterPredicateComparisonInstruction valueOf(int i) {
		var values = FilterPredicateComparisonInstruction.values();
		if (i >= 0 && i < values.length) {
			return values[i];
		}
		return null;
	}
}
