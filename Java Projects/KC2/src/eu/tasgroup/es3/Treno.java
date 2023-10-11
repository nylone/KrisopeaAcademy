package eu.tasgroup.es3;

public class Treno {
	private Vagone[] vagoni;

	public Treno(int vagoni) {
		this.vagoni = new Vagone[vagoni];
		for (int i = 0; i < vagoni; i++) {
			this.vagoni[i] = new Vagone();
		}
	}

	public int[] prenotaPosto(Classe c) {
		for (int i = 0; i < this.vagoni.length; i++) {
			int posto = this.vagoni[i].assegnaPosto(c);
			if (posto >= 0) {
				int[] prenotazione = { i, posto };
				return prenotazione;
			}
		}
		return null;
	}
}
