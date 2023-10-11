package eu.tasgroup.es3;

public abstract class Richiedente implements OffertaCredito {
	private String nome;
	private double reddito;
	private int punteggio;

	public Richiedente(String nome, double reddito, int punteggio) {
		this.nome = nome;
		this.reddito = reddito;
		this.punteggio = punteggio;
	}

	public abstract boolean calcolaIdoneitàCredito();

	public abstract void riduciIdoneitàCredito(int punteggio);

	public abstract void aumentaIdoneitàCredito(int punteggio);

	public String getNome() {
		return nome;
	}

	public double getReddito() {
		return reddito;
	}

	public int getPunteggio() {
		return punteggio;
	}

	protected final void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	@Override
	public String toString() {
		return this.getNome();
	}

}
