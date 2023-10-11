package eu.tasgroup.patterns.factorymethod;

public class MySQLDB extends DAOConn {

	@Override
	public String create() {
		return "Richiamato Create di MySQLDB";
	}

	@Override
	public String update() {
		return "Richiamato Update di MySQLDB";
	}

	@Override
	public String delete() {
		return "Richiamato Delete di MySQLDB";
	}

}
