package eu.tasgroup.es3;

public enum Classe {
	PRIMA("Prima"), SECONDA("Seconda");

	private String val;

	Classe(String val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return val;
	}
}