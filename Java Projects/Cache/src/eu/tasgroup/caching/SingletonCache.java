package eu.tasgroup.caching;

public class SingletonCache extends CacheDecorator implements Caching {
	private static SingletonCache cache;

	private SingletonCache() {
		super("singleton");
	}

	public static SingletonCache getInstance() {
		if (cache == null) {
			cache = new SingletonCache();
		}
		return cache;
	}
}
