package eu.tasgroup.es3;

public class ClienteRegolare extends Richiedente implements OffertaCredito {

	public ClienteRegolare(String nome, double reddito) {
		super(nome, reddito, 0);
	}

	@Override
	public boolean calcolaIdoneitàCredito() {
		return this.getPunteggio() > 0 && this.getReddito() > 1400;
	}

	@Override
	public void riduciIdoneitàCredito(int punteggio) {
		this.setPunteggio(this.getPunteggio() - punteggio);
	}

	@Override
	public void aumentaIdoneitàCredito(int punteggio) {
		this.setPunteggio(this.getPunteggio() + punteggio);
	}

	@Override
	public double getCredito() {
		if (this.calcolaIdoneitàCredito()) {
			return this.getReddito() * this.getPunteggio() / 100;
		}
		return 0;
	}

	@Override
	public double getInteresse() {
		return 3.00 / 100;
	}

}
