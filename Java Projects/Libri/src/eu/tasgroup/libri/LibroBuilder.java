package eu.tasgroup.libri;

public abstract class LibroBuilder {
	protected Libro libro;

	public LibroBuilder() {
		libro = new Libro();
	}

	public Libro getLibro() {
		return libro;
	}

	public abstract void buildTitolo();

	public abstract void buildEditore();

	public abstract void buildAutore();

	public abstract void buildPubblicazione();
}
