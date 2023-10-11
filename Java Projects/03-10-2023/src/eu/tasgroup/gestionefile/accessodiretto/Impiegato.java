package eu.tasgroup.gestionefile.accessodiretto;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Impiegato implements Serializable {
	private static final long serialVersionUID = -5843123334192353122L;
	private int id;
	private String nome;
	private String cognome;
	private double stipendio;

	public Impiegato() {
		this(0, "", "", 0.0);
	}

	public Impiegato(int id, String nome, String cognome, double stipendio) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
	}

	public void scrivi(RandomAccessFile file) throws IOException {
		file.writeInt(id);
		scriviNominativo(file, nome);
		scriviNominativo(file, cognome);
		file.writeDouble(stipendio);
	}

	public void leggi(RandomAccessFile file) throws IOException {
		this.setId(file.readInt());
		this.setNome(leggiNominativo(file));
		this.setCognome(leggiNominativo(file));
		this.setStipendio(file.readDouble());
	}

	private String leggiNominativo(RandomAccessFile file) throws IOException {
		char nominativo[] = new char[20];
		char tmp;
		for (int i = 0; i < nominativo.length; i++) {
			tmp = file.readChar();
			nominativo[i] = tmp;
		}
		return new String(nominativo).replace('\0', ' ');
	}

	private void scriviNominativo(RandomAccessFile file, String nominativo) throws IOException {
		StringBuffer buffer = null;
		if (nominativo == null)
			buffer = new StringBuffer(20);
		else
			buffer = new StringBuffer(nominativo);
		buffer.setLength(20);
		file.writeChars(buffer.toString());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", stipendio=" + stipendio + "]";
	}
}
