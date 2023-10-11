package eu.tasgroup.caching;

public class NeverCachedException extends Exception {
	private static final long serialVersionUID = -271440639677463744L;
	private Class<?> tipo;

	public NeverCachedException(Class<?> tipo) {
		this.tipo = tipo;
	}

	@Override
	public String getMessage() {
		return String.format("Il tipo %s non è mai stato cachato", tipo.getSimpleName());
	}

}
