package eu.tasgroup.reflection;

import java.util.Objects;

public class Elemento {
	private String nome;
	public String descrizione;

	public Elemento(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Elemento other = (Elemento) obj;
		return Objects.equals(descrizione, other.descrizione) && Objects.equals(nome, other.nome);
	}
}
