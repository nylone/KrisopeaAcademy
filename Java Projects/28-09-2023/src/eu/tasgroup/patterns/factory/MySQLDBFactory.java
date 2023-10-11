package eu.tasgroup.patterns.factory;

public class MySQLDBFactory extends DAOFactory {

	@Override
	public DAOConn createDAO() {
		return new MySQLDB();
	}

}
