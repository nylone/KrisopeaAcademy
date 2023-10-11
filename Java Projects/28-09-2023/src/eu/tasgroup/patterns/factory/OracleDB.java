package eu.tasgroup.patterns.factory;

public class OracleDB extends DAOConn {

	@Override
	public String create() {
		return "Richiamato Create di OracleDB";
	}

	@Override
	public String update() {
		return "Richiamato Update di OracleDB";
	}

	@Override
	public String delete() {
		return "Richiamato Delete di OracleDB";
	}

}
