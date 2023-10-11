package eu.tasgroup.es2;

public class Bonifico implements Transazioni {
	private ContoBancario da;
	private ContoBancario a;
	private double importo;

	public Bonifico(ContoBancario da, ContoBancario a, double importo) {
		this.da = da;
		this.a = a;
		this.importo = importo;
	}

	@Override
	public void effettuaTransazione()
			throws OperazioneBancariaException {
		if (da.validazionePreleva(importo) && a.validazioneDeposita(importo)) {
			da.preleva(importo);
			a.deposita(importo);
		} else {
			throw new OperazioneBancariaException("L'operazione ha fallito lo step di validazione");
		}
	}
}
