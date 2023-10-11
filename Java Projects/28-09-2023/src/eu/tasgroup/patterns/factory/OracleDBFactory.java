package eu.tasgroup.patterns.factory;

public class OracleDBFactory extends DAOFactory {

	@Override
	// restituisce l'oggetto concreto dietro all'oggetto astratto
	public DAOConn createDAO() {
		return new OracleDB();
	}

}
