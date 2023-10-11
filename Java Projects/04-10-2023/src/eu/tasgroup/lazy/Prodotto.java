package eu.tasgroup.lazy;

import java.util.HashMap;
import java.util.Map;

public class Prodotto {
	private static Map<String, Prodotto> tipi = new HashMap<>();

	private String tipo;

	private Prodotto(String tipo) {
		this.tipo = tipo;
		tipi.put(tipo, this);
	}

	public static Prodotto getProdotto(String tipologia) {
		Prodotto prodotto;
		if (tipi.containsKey(tipologia))
			prodotto = tipi.get(tipologia);
		else
			prodotto = new Prodotto(tipologia);
		return prodotto;
	}
}
