package eu.tasgroup.es1;

public class Studente implements Comparable<Studente> {
	public String getNome() {
		return nome;
	}

	public int[] getVoti() {
		return voti;
	}

	private String nome;
	private int[] voti;

	public Studente(String nome, int... voti) {
		this.voti = voti.clone();
		this.nome = nome;
	}

	public int votoMax() {
		int max = Integer.MIN_VALUE;
		for (int voto : this.voti) {
			if (voto > max)
				max = voto;
		}
		return max;
	}

	public int votoMin() {
		if (this.voti.length == 0) {
			return -1;
		}
		int min = Integer.MAX_VALUE;
		for (int voto : this.voti) {
			if (voto < min)
				min = voto;
		}
		return min;
	}

	public double media() {
		if (this.voti.length == 0) {
			return -1;
		}
		int sum = 0;
		for (int voto : this.voti) {
			sum += voto;
		}
		double media = (double) sum / this.voti.length;
		return media;
	}

	@Override
	public int compareTo(Studente o) {
		if (this.media() == o.media())
			return 0;
		if (this.media() > o.media())
			return 1;
		return -1;
	}
}
