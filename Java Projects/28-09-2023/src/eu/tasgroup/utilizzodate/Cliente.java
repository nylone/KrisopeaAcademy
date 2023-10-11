package eu.tasgroup.utilizzodate;

import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	private String nome;
	private String cognome;
	private Date nascita;

	public Cliente(String nome, String cognome, int anno, int mese, int giorno) {
		this.nome = nome;
		this.cognome = cognome;
		GregorianCalendar c = new GregorianCalendar(anno, mese, giorno);
		this.nascita = c.getTime();
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita + "]";
	}

	public final String getNome() {
		return nome;
	}

	public final String getCognome() {
		return cognome;
	}

	public final Date getNascita() {
		return nascita;
	}

	public final void setNascita(Date nascita) {
		this.nascita = nascita;
	}

}
