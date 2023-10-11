package eu.tasgroup.persone;

public class Persona {
	private final String nome;
	private final String professione;
	private final int età;

	public Persona(String nome, String professione, int età) {
		this.nome = nome;
		this.professione = professione;
		this.età = età;
	}

	public String getNome() {
		return nome;
	}

	public String getProfessione() {
		return professione;
	}

	public int getEtà() {
		return età;
	}

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", professione=" + professione + ", età=" + età + "]";
	}
}
