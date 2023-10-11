package eu.tasgroup.patterns.factorymethod;

public class FactoryTest {
	public static void main(String[] args) {
		DAOFactory factory = DAOFactory.getFactory("MySQL");
		DAOConn connessione = factory.createDAO();

		System.out.println(connessione.create());
		System.out.println(connessione.update());
		System.out.println(connessione.delete());
	}
}
