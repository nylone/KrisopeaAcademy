package eu.tasgroup.patterns.factory;

public class ODBCFactory extends DAOFactory {

	@Override
	public DAOConn createDAO() {
		return new ODBCDB();
	}

}
