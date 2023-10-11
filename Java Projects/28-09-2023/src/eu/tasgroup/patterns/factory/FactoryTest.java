package eu.tasgroup.patterns.factory;

public class FactoryTest {
	public static void main(String[] args) {
		DAOFactory factory = DAOFactory.getFactory();
		DAOConn connessione = factory.createDAO();

		System.out.println(connessione.create());
		System.out.println(connessione.update());
		System.out.println(connessione.delete());
	}
}
