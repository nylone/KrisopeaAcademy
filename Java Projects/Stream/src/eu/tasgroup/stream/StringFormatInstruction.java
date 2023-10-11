package eu.tasgroup.stream;

public enum StringFormatInstruction {
	FULL,
	SHORTENED,
	INITIALS;

	public static StringFormatInstruction valueOf(int i) {
		var values = StringFormatInstruction.values();
		if (i >= 0 && i < values.length) {
			return values[i];
		}
		return null;
	}
}
