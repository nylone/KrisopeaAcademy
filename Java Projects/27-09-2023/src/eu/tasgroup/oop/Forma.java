package eu.tasgroup.oop;

public interface Forma {
	String DESCRIZIONE = "TIPOLOGIA FORMA: ";

	double area();

	double volume();

	String getTipo();

	default String getDescrizione() {
		return this.getClass().getSimpleName();
	}
}
