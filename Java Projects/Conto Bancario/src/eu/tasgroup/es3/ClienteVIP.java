package eu.tasgroup.es3;

public class ClienteVIP extends Richiedente implements OffertaCredito {
	private int idoneitàMinima;

	public ClienteVIP(String nome, double reddito) {
		super(nome, reddito, 100);
		this.idoneitàMinima = 50;
	}

	public ClienteVIP(String nome, double reddito, int idoneitàMinima) {
		this(nome, reddito);
		this.idoneitàMinima = idoneitàMinima;
	}

	@Override
	public boolean calcolaIdoneitàCredito() {
		return this.getPunteggio() >= this.idoneitàMinima || this.getReddito() > 200_000;
	}

	@Override
	public void riduciIdoneitàCredito(int punteggio) {
		if (this.getPunteggio() < this.idoneitàMinima)
			return;
		this.setPunteggio(this.getPunteggio() - punteggio);
	}

	@Override
	public void aumentaIdoneitàCredito(int punteggio) {
		int base = this.getPunteggio();
		this.setPunteggio(base < this.idoneitàMinima ? punteggio : base + punteggio);
	}

	public int getIdoneitàMinima() {
		return idoneitàMinima;
	}

	public void setIdoneitàMinima(int idoneitàMinima) {
		this.idoneitàMinima = idoneitàMinima;
	}

	@Override
	public double getCredito() {
		double base = this.getPunteggio();
		if (this.calcolaIdoneitàCredito()) {
			return this.getReddito() * (base < 10 ? 0.20 : (base / 50));
		}
		return this.getReddito() / 4;
	}

	@Override
	public double getInteresse() {
		if (this.calcolaIdoneitàCredito()) {
			return 2.00 / 100;
		}
		return 4.00 / 100;
	}

}
