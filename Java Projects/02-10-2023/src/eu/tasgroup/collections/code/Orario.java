package eu.tasgroup.collections.code;

public class Orario implements Comparable<Orario> {
	private int ore;
	private int minuti;
	private int secondi;

	public Orario(int ore, int minuti, int secondi) {
		this.ore = ore;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	public int getOre() {
		return ore;
	}

	public void setOre(int ore) {
		this.ore = ore;
	}

	public int getMinuti() {
		return minuti;
	}

	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	public int getSecondi() {
		return secondi;
	}

	public void setSecondi(int secondi) {
		this.secondi = secondi;
	}

	@Override
	public String toString() {
		return "Orario [ore=" + ore + ", minuti=" + minuti + ", secondi=" + secondi + "]";
	}

	@Override
	public int compareTo(Orario o) {
		int compOre = this.ore - o.getOre();
		int compMinuti = this.minuti - o.getMinuti();
		int compSecondi = this.secondi - o.getSecondi();
		if (compOre != 0)
			return compOre;
		else if (compMinuti != 0)
			return compMinuti;
		else
			return compSecondi;
	}

}
