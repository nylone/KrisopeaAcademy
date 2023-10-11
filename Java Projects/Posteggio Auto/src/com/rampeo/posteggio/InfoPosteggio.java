package com.rampeo.posteggio;
import java.time.Duration;
import java.time.LocalDateTime;

public class InfoPosteggio implements Comparable<InfoPosteggio> {
	private String targa;
	private LocalDateTime entrata;
	private Duration prenotazione;

	public InfoPosteggio(String targa, LocalDateTime entrata, Duration prenotazione) {
		this.targa = targa;
		this.entrata = entrata;
		this.prenotazione = prenotazione;
	}

	public String getTarga() {
		return targa;
	}

	public LocalDateTime getEntrata() {
		return entrata;
	}

	public Duration getPrenotazione() {
		return prenotazione;
	}

	@Override
	public int compareTo(InfoPosteggio o) {
		LocalDateTime uscitaThis = this.getEntrata().plus(this.getPrenotazione());
		LocalDateTime uscitaOther = o.getEntrata().plus(o.getPrenotazione());

		return uscitaThis.compareTo(uscitaOther);
	}

	@Override
	public String toString() {
		return "targa=" + targa + ", entrata=" + entrata + ", prenotazione=" + prenotazione + ", uscita="
				+ this.getEntrata().plus(this.getPrenotazione());
	}
}
