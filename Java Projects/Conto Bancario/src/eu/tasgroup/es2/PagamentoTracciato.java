package eu.tasgroup.es2;

public class PagamentoTracciato implements Transazioni {
	private ContoBancario da;
	private ContoBancario a;
	private double importo;

	public PagamentoTracciato(ContoBancario da, ContoBancario a, double importo) {
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
			RegistroPagamenti.getInstance().aggiungiEntry(String.format("Transazione da %s a %s con importo di %.2f",
					da.getProprietario(), da.getProprietario(), importo));
		} else {
			throw new OperazioneBancariaException("L'operazione ha fallito lo step di validazione");
		}
	}
}
