package eu.tasgroup.es2;

public class ContoSavings extends ContoBancario {

	public ContoSavings(double deposito, Cliente proprietario) {
		super(deposito, proprietario);
	}

	@Override
	public void deposita(double importo) throws OperazioneBancariaException {
		if (importo < 0) {
			throw new OperazioneBancariaException("l'importo è negativo");
		}
		if (importo % 50 != 0) {
			throw new OperazioneBancariaException("l'importo non è un multiplo di 50");
		}
		super.setSaldo(importo);

	}

	@Override
	public void preleva(double importo) throws OperazioneBancariaException {
		double saldo = super.getSaldo();
		if (importo < 0) {
			throw new OperazioneBancariaException("l'importo è negativo");
		} else if (importo % 50 != 0) {
			throw new OperazioneBancariaException("l'importo non è un multiplo di 50");
		} else if (saldo - 50 < importo) {
			throw new OperazioneBancariaException("giacenza minima non garantita a fronte dell'importo specificato");
		} else {
			super.setSaldo(saldo - importo - 50);
			return;
		}
	}

	@Override
	public boolean validazioneDeposita(double importo) {
		return importo >= 0 && importo % 50 == 0;
	}

	@Override
	public boolean validazionePreleva(double importo) {
		return importo >= 0 && importo % 50 == 0 && super.getSaldo() - 50 >= importo;
	}
}
