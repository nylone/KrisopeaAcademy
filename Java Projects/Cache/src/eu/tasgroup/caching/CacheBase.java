package eu.tasgroup.caching;

import java.util.HashMap;
import java.util.Map;

public class CacheBase implements Caching {
	private static Map<String, CacheBase> istanze = new HashMap<>();
	private Map<Class<?>, Object> cache;

	private CacheBase() {
		cache = new HashMap<Class<?>, Object>();
	}

	@Override
	public <T> void aggiungi(Class<T> tipo, T oggetto) {
		cache.put(tipo, oggetto);
	}

	@Override
	public <T> T recupera(Class<T> tipo) throws NeverCachedException {
		if (cache.containsKey(tipo)) {
			Object obj = cache.get(tipo);
			var val = tipo.cast(obj);
			return val;
		} else
			throw new NeverCachedException(tipo);
	}

	public static CacheBase getInstance(String chiave) {
		CacheBase istanza = istanze.get(chiave);
		if (istanza == null) {
			istanza = new CacheBase();
			istanze.put(chiave, istanza);
		}
		return istanza;
		
	}

}
