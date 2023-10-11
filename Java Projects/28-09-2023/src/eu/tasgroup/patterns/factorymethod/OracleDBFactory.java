package eu.tasgroup.patterns.factorymethod;

public class OracleDBFactory extends DAOFactory {

	@Override
	// restituisce l'oggetto concreto dietro all'oggetto astratto
	public DAOConn createDAO() {
		return new OracleDB();
	}

}
