package eu.tasgroup.stream;

public enum PersonaExtractionInstruction {
	NOME,
	COGNOME,
	PROFESSIONE,
	ETA,
	STIPENDIO;

	public static PersonaExtractionInstruction valueOf(int i) {
		var values = PersonaExtractionInstruction.values();
		if (i >= 0 && i < values.length) {
			return values[i];
		}
		return null;
	}
}
