package eu.tasgroup.es2;

public class Esame {
	private String matricola;
	private String esame;
	private int voto;

	public Esame(String matricola, String esame, int voto) {
		this.matricola = matricola;
		this.esame = esame;
		this.voto = voto;
	}

	public String getMatricola() {
		return matricola;
	}

	public String getEsame() {
		return esame;
	}

	public int getVoto() {
		return voto;
	}
}
