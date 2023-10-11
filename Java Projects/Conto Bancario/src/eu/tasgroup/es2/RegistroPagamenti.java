package eu.tasgroup.es2;

import java.util.ArrayList;
import java.util.List;

public class RegistroPagamenti {
	private List<String> registro;
	private static RegistroPagamenti istanza;

	private RegistroPagamenti() {
		registro = new ArrayList<String>();
	}
	
	public static RegistroPagamenti getInstance() {
		if (istanza == null) {
			istanza = new RegistroPagamenti();
		}
		return istanza;
	}

	public void aggiungiEntry(String entry) {
		registro.add(entry);
	}

	public List<String> getRegistro() {
		return registro;
	}
}
