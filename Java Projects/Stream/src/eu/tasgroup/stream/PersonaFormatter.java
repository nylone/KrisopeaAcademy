package eu.tasgroup.stream;

import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getIntegerExtractor;
import static eu.tasgroup.stream.PersonaFieldExtractorGenerator.getStringExtractor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PersonaFormatter {
	private List<Function<Persona, String>> operazioni;

	public PersonaFormatter() {
		this.operazioni = new ArrayList<>();
	}

	private void addOperazione(PersonaExtractionInstruction field, Function<Persona, String> formatter) {
		operazioni.add(p -> String.format("%s: %s", field.toString(), formatter.apply(p)));
	}

	public void addStringFormatting(PersonaExtractionInstruction field, StringFormatInstruction instruction) {
		var extractor = getStringExtractor(field);
		Function<String, String> formatter = switch (instruction) {
		case FULL:
			yield s -> s;
		case SHORTENED:
			yield s -> {
				if (s.length() < 5)
					return s;
				return s.substring(0, 5) + "...";
			};
		case INITIALS:
			yield s -> {
				var splits = s.split(" +");
				String out = null;
				for (String split : splits) {
					if (split.length() == 0)
						continue;
					if (out == null)
						out = s.substring(0, 1) + ".";
					else
						out = out + " " + split.substring(0, 1) + ".";
				}
				return out;
			};
		};
		addOperazione(field, p -> formatter.apply(extractor.apply(p)));
	}

	public void addIntegerFormatting(PersonaExtractionInstruction field, int base) {
		var extractor = getIntegerExtractor(field);
		Function<Integer, String> formatter = i -> Integer.toString(i, base);
		addOperazione(field, p -> formatter.apply(extractor.apply(p)));
	}

	public String format(Persona p) {
		return operazioni.stream()
				.map(o -> o.apply(p))
				.collect(Collectors.joining(", "));
	}
}
