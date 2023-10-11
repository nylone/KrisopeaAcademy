package eu.tasgroup.es1;

public class ContoSavings extends ContoBancario implements Interessi {

	public ContoSavings(double deposito, int numeroConto) {
		super(deposito, numeroConto);
	}

	@Override
	public void deposita(double importo) throws OperazioneBancariaException {
		if (importo <= 0) {
			throw new OperazioneBancariaException("l'importo è negativo");
		}
		if (importo % 50 != 0) {
			throw new OperazioneBancariaException("l'importo non è un multiplo di 50");
		}
		super.setSaldo(importo);

	}

	@Override
	public double preleva(double importo) throws ImpossibilePrelevareException {
		double saldo = super.getSaldo();
		if (importo < 0) {
			throw new ImpossibilePrelevareException("l'importo è negativo");
		} else if (importo % 50 != 0) {
			throw new ImpossibilePrelevareException("l'importo non è un multiplo di 50");
		} else if (saldo - 50 < importo) {
			throw new ImpossibilePrelevareException("giacenza minima non garantita a fronte dell'importo specificato");
		} else {
			super.setSaldo(saldo - importo - 50);
			return super.getSaldo();
		}
	}

	@Override
	public double calcolaInteressi() {
		return super.getSaldo() * 2 / 100;
	}

}
