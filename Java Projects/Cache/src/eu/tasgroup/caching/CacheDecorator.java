package eu.tasgroup.caching;

public class CacheDecorator implements Caching{
	private Caching cache;

	public CacheDecorator(String chiave) {
		cache = CacheBase.getInstance(chiave);
	}

	@Override
	public <T> void aggiungi(Class<T> tipo, T elemento) {
		cache.aggiungi(tipo, elemento);
	}

	@Override
	public <T> T recupera(Class<T> tipo) throws NeverCachedException {
		return cache.recupera(tipo);
	}
}
