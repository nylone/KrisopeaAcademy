package eu.tasgroup.patterns.factorymethod;

public class ODBCDB extends DAOConn {

	@Override
	public String create() {
		return "Richiamato Create di ODBCDB";
	}

	@Override
	public String update() {
		return "Richiamato Update di ODBCDB";
	}

	@Override
	public String delete() {
		return "Richiamato Delete di ODBCDB";
	}

}
