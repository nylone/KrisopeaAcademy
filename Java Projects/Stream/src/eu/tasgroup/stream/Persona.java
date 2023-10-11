package eu.tasgroup.stream;

public class Persona {
	private String nome;
	private String cognome;
	private String professione;
	private int età;
	private int stipendio;

	public Persona(String nome, String cognome, String professione, int età, int stipendio) {
		this.nome = nome;
		this.cognome = cognome;
		this.professione = professione;
		this.età = età;
		this.stipendio = stipendio;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getProfessione() {
		return professione;
	}

	public int getEtà() {
		return età;
	}

	public int getStipendio() {
		return stipendio;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", professione=" + professione + ", età=" + età
				+ ", stipendio=" + stipendio + "]";
	}

}
