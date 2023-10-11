package eu.tasgroup.es2;

public class ContoCorrente extends ContoBancario {

	public ContoCorrente(Cliente proprietario) {
		super(0, proprietario);
	}

	@Override
	public void deposita(double importo) throws OperazioneBancariaException {
		if (importo > 5) {
			super.setSaldo(importo - 1);
			return;
		}
		throw new OperazioneBancariaException("l'importo è minore di 5");
	}

	@Override
	public void preleva(double importo) throws OperazioneBancariaException {
		double saldo = super.getSaldo();
		if (importo < 0) {
			throw new OperazioneBancariaException("l'importo è negativo");
		} else if (saldo - 100 < importo) {
			throw new OperazioneBancariaException("giacenza minima non garantita a fronte dell'importo specificato");
		}
		super.setSaldo(saldo - importo - 1);
		return;
	}

	@Override
	public boolean validazioneDeposita(double importo) {
		return importo > 5;
	}

	@Override
	public boolean validazionePreleva(double importo) {
		// TODO Auto-generated method stub
		return importo >= 0 && getSaldo() - 100 >= importo;
	}

}
