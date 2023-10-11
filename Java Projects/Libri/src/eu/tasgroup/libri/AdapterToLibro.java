package eu.tasgroup.libri;

import java.time.LocalDate;

public abstract class AdapterToLibro extends LibroBuilder {

	@Override
	public void buildTitolo() {
		libro.setTitolo("Non specificato");
	}

	@Override
	public void buildEditore() {
		libro.setEditore("Non specificato");
	}

	@Override
	public void buildAutore() {
		libro.setAutore("Non specificato");
	}

	@Override
	public void buildPubblicazione() {
		libro.setPubblicazione(LocalDate.now());
	}

}
