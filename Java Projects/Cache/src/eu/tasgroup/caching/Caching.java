package eu.tasgroup.caching;

public interface Caching {
	<T> void aggiungi(Class<T> tipo, T elemento);

	<T> T recupera(Class<T> tipo) throws NeverCachedException;
}
