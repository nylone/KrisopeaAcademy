package eu.tasgroup.libri;

public class FabbricaLibro {
	private LibroBuilder builder;

	public FabbricaLibro(LibroBuilder builder) {
		this.builder = builder;
	}

	public Libro getLibro() {
		return builder.getLibro();
	}

	public void buildLibro() {
		builder.buildTitolo();
		builder.buildAutore();
		builder.buildEditore();
		builder.buildPubblicazione();
	}
}
