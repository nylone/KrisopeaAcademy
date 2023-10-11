package eu.tasgroup.oop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Cliente {
	@Override
	public String toString() {
		return "Cliente [idCiente=" + idCiente + ", nome=" + nome + ", nascita=" + nascita + "]";
	}

	private String idCiente;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdCiente() {
		return idCiente;
	}

	public Date getNascita() {
		return nascita;
	}

	public static int getConteggioClienti() {
		return conteggioClienti;
	}

	private Date nascita;
	private static int conteggioClienti;

	public Cliente(String idCiente, String nome, int anno, int mese, int giorno) {
		this.idCiente = idCiente;
		this.nome = nome;
		Calendar c = new GregorianCalendar(anno, mese, giorno);
		this.nascita = c.getTime();
		conteggioClienti++;
	}

}
