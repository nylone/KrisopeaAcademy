package eu.tasgroup.patterns.builder;

// è il Prodotto
public class Auto {

	private String cilindrata;
	private String modello;

	public final String getCilindrata() {
		return cilindrata;
	}

	public final void setCilindrata(String cilindrata) {
		this.cilindrata = cilindrata;
	}

	public final String getModello() {
		return modello;
	}

	public final void setModello(String modello) {
		this.modello = modello;
	}

}
