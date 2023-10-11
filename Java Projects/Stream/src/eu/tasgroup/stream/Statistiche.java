package eu.tasgroup.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

public class Statistiche {
	private long numeroMaggiorenni;
	private long numeroMinorenni;
	private long numeroOmonimi;
	private long numeroSosia;
	private long numeroCoscritti;
	private long numeroColleghi;
	private double mediaStipendio;
	private double mediaEtà;
	private String nomePopolare;
	private String cognomePopolare;
	private String professionePopolare;
	private String etàPopolare;
	private String stipendioPopolare;

	public Statistiche(List<Persona> persone) {
		Predicate<Persona> isMaggiorenne = p -> p.getEtà() >= 18;
		numeroMaggiorenni = persone.stream().filter(isMaggiorenne).count();
		numeroMinorenni = persone.stream().filter(isMaggiorenne.negate()).count();
		numeroOmonimi = countSameItems(persone, Statistiche::isOmonimo);
		numeroSosia = countSameItems(persone, Statistiche::isSosia);
		numeroCoscritti = countSameItems(persone, Statistiche::isCoscritto);
		numeroColleghi = countSameItems(persone, Statistiche::isCollega);
		mediaStipendio = averageElements(persone, p -> p.getStipendio());
		mediaEtà = averageElements(persone, p -> p.getEtà());
		nomePopolare = mostPopularItem(persone, Statistiche::isOmonimo, Persona::getNome);
		cognomePopolare = mostPopularItem(persone, Statistiche::isParente, Persona::getCognome);
		professionePopolare = mostPopularItem(persone, Statistiche::isCollega, Persona::getProfessione);
		etàPopolare = mostPopularItem(persone, Statistiche::isCoscritto, p -> Integer.toString(p.getEtà()));
		stipendioPopolare = mostPopularItem(persone, Statistiche::isUgualmenteRetribuito,
				p -> Integer.toString(p.getStipendio()));
	}

	private static Predicate<Persona> isOmonimo(Persona p) {
		return np -> np.getNome().equals(p.getNome());
	}

	private static Predicate<Persona> isParente(Persona p) {
		return np -> np.getCognome().equals(p.getCognome());
	}

	private static Predicate<Persona> isSosia(Persona p) {
		return isOmonimo(p).and(isParente(p));
	}

	private static Predicate<Persona> isCoscritto(Persona p) {
		return np -> np.getEtà() == p.getEtà();
	}

	private static Predicate<Persona> isCollega(Persona p) {
		return np -> np.getProfessione().equals(p.getProfessione());
	}
	
	private static Predicate<Persona> isUgualmenteRetribuito(Persona p) {
		return np -> np.getStipendio() == p.getStipendio();
	}

	private static long countSameItems(List<Persona> persone,
			Function<Persona, Predicate<Persona>> predicateGenerator) {
		return persone.stream()
			.map(p -> persone.stream()
							.filter(predicateGenerator.apply(p))
							.toList())
			.distinct()
			.mapToLong(s -> s.size())
			.filter(c -> c > 1)
			.sum();
	}

	private static double averageElements(List<Persona> persone, ToIntFunction<Persona> mapper) {
		Supplier<IntStream> intStream = () -> persone.stream().mapToInt(mapper);
		return ((double) intStream.get().sum()) / intStream.get().count();
	}
	
	private static String mostPopularItem(List<Persona> persone,
			Function<Persona, Predicate<Persona>> predicateGenerator,
			Function<Persona, String> extractor) {
		var personePopolari = persone.stream()
			.map(p -> persone.stream()
							.filter(predicateGenerator.apply(p))
							.toList())
			.distinct()
			.filter(l -> l.size() > 1)
			.max((l1, l2) -> l1.size() - l2.size())
			.orElse(List.of());
		return personePopolari.size() > 0 ? extractor.apply(personePopolari.get(0))
				: "nessun elemento popolare";
	}

	@Override
	public String toString() {
		return "numero maggiorenni = " + numeroMaggiorenni + ",\nnumero minorenni = " + numeroMinorenni
				+ ",\nnumero omonimi = " + numeroOmonimi + ",\nnumero sosia = " + numeroSosia + ",\nnumero coscritti = "
				+ numeroCoscritti + ",\nnumero colleghi = " + numeroColleghi + ",\nmedia stipendio = "
				+ String.format("%.2f", mediaStipendio) + ",\nmedia età = " + String.format("%.2f", mediaEtà)
				+ ",\nnome popolare = " + nomePopolare + ",\ncognome popolare = "
				+ cognomePopolare + ",\nprofessione popolare = " + professionePopolare + ",\netà popolare = "
				+ etàPopolare + ",\nstipendio popolare = " + stipendioPopolare;
	}

}
