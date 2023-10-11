package eu.tasgroup.patterns.factorymethod;

public class MySQLDBFactory extends DAOFactory {

	@Override
	public DAOConn createDAO() {
		return new MySQLDB();
	}

}
