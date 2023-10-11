package eu.tasgroup.patterns.factorymethod;

// Abstract Product
public abstract class DAOConn {
	// definisco il comportamento dei prodotti

	public abstract String create();

	public abstract String update();

	public abstract String delete();

}
