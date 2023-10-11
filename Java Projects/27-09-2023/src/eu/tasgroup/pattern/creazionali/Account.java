package eu.tasgroup.pattern.creazionali;

// esempio prototype
public class Account implements Cloneable {
	private String nome;
	private String cognome;
	private String credito;

	@Override
	protected Object clone() {
		try {
			Account a = (Account) super.clone();
			return a;
		} catch (CloneNotSupportedException e) {
			return null;
		}
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

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	@Override
	public String toString() {
		return "Account [nome=" + nome + ", cognome=" + cognome + ", credito=" + credito + "]";
	}

}
