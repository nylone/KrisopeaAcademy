package eu.tasgroup.es2;


public abstract class ContoBancario {
	private double saldo;
	private Cliente proprietario;

	public ContoBancario(double saldo, Cliente proprietario) {
		this.saldo = saldo;
		this.proprietario = proprietario;
	}

	public abstract boolean validazioneDeposita(double importo);

	public abstract boolean validazionePreleva(double importo);

	public abstract void deposita(double importo) throws OperazioneBancariaException;

	public abstract void preleva(double importo) throws OperazioneBancariaException;

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getProprietario() {
		return proprietario;
	}
}
