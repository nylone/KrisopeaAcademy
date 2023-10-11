package eu.tasgroup.oop;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Impiegato {
	private String enterpriseID;
	private String nome;
	private String cognome;
	private Date assunzione;
	private double stipendio;

	public Impiegato(String enterpriseID, String nome, String cognome, int giorno, int mese, int anno,
			double stipendio) {
		this.enterpriseID = enterpriseID;
		this.nome = nome;
		this.cognome = cognome;
		Calendar c = new GregorianCalendar(giorno, mese, anno);
		this.assunzione = c.getTime();
		this.stipendio = stipendio;
	}

	public String getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(String enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getAssunzione() {
		return assunzione;
	}

	public void setAssunzione(Date assunzione) {
		this.assunzione = assunzione;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public String toString() {
		return "Impiegato [enterpriseID=" + enterpriseID + ", nome=" + nome + ", cognome=" + cognome + ", assunzione="
				+ assunzione + ", stipendio=" + stipendio + "]";
	}
}
