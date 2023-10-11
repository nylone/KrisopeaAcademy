package eu.tasgroup.es3;

public class Vagone {
	private int ultimoPrimaClasse = 0;
	private int ultimoSecondaClasse = 0;

	public int assegnaPosto(Classe c) {
		switch (c) {
		case PRIMA: {
			if (this.ultimoPrimaClasse >= 20)
				break;
			return ++this.ultimoPrimaClasse;
		}
		case SECONDA: {
			if (this.ultimoSecondaClasse >= 30)
				break;
			return ++this.ultimoSecondaClasse;
		}
		}
		return -1;
	}
}
