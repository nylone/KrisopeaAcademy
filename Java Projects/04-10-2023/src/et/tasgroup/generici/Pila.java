package et.tasgroup.generici;

public class Pila<T> {
	private T[] array;

	@SuppressWarnings("unchecked")
	public Pila() {
		array = (T[]) new Object[10];
	}
}
