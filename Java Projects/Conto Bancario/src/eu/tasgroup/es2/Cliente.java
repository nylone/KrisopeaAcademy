package eu.tasgroup.es2;

public class Cliente {
	private String nome;
	private String cognome;
	private String indirizzo;

	public Cliente(String nome, String cognome, String indirizzo) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
	}

	public final String getNome() {
		return nome;
	}

	public final String getCognome() {
		return cognome;
	}

	public final String getIndirizzo() {
		return indirizzo;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente c = (Cliente) obj;
		return c.getNome().equals(this.getNome()) && c.getCognome().equals(this.getCognome())
				&& c.getIndirizzo().equals(this.getIndirizzo());
	}
}
