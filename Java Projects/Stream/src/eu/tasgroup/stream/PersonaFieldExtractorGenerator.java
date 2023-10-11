package eu.tasgroup.stream;

import java.util.function.Function;

public class PersonaFieldExtractorGenerator {
	public static Function<Persona, String> getStringExtractor(PersonaExtractionInstruction instruction) {
		return switch (instruction) {
		case NOME:
			yield Persona::getNome;
		case COGNOME:
			yield Persona::getCognome;
		case PROFESSIONE:
			yield Persona::getProfessione;
		default:
			yield (p) -> "";
		};
	}

	public static Function<Persona, Integer> getIntegerExtractor(PersonaExtractionInstruction instruction) {
		return switch (instruction) {
		case ETA:
			yield Persona::getEtà;
		case STIPENDIO:
			yield Persona::getStipendio;
		default:
			yield (p) -> 1;
		};
	}
}
