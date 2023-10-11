package eu.tasgroup.patterns.factorymethod;

// Abstract Factory
public abstract class DAOFactory {
	// restituisce l'oggetto che poi genererà il mio prodotto
	// (decide quale factory concreta usare)
	public static DAOFactory getFactory(String typeDB) {
		if (typeDB.equals("ORACLE")) {
			return new OracleDBFactory();
		} else if (typeDB.equals("MySQL")) {
			return new MySQLDBFactory();
		} else {
			return new ODBCFactory();
		}
	}

	// istanzia il prodotto
	public abstract DAOConn createDAO();
}
