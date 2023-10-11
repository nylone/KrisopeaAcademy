package eu.tasgroup.caching;

public class Main {
	public static void main(String[] args) {
		Caching cache = SingletonCache.getInstance();

		String stringa = "ciao";
		Integer numero = 26;

		try {
			cache.aggiungi(String.class, stringa);
			System.out.println(cache.recupera(String.class));
			cache.aggiungi(Integer.class, numero);
			System.out.println(cache.recupera(Integer.class));

			cache = SingletonCache.getInstance();

			System.out.println(cache.recupera(String.class));
			stringa = "nuovamente ciao";
			cache.aggiungi(String.class, stringa);
			System.out.println(cache.recupera(String.class));

			System.out.println(cache.recupera(Double.class));
		} catch (NeverCachedException e) {
			System.out.println(e.getMessage());
		}

	}
}
