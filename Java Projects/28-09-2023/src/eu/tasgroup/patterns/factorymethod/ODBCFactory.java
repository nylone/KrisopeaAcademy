package eu.tasgroup.patterns.factorymethod;

public class ODBCFactory extends DAOFactory {

	@Override
	public DAOConn createDAO() {
		return new ODBCDB();
	}

}
