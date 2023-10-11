package eu.tasgroup.es1;

public abstract class ContoBancario {
	private double saldo;
	private int numeroConto;

	public ContoBancario(double saldo, int numeroConto) {
		this.saldo = saldo;
		this.numeroConto = numeroConto;
	}

	public abstract void deposita(double importo) throws OperazioneBancariaException;

	public abstract double preleva(double importo) throws ImpossibilePrelevareException;

	public double getSaldo() {
		return saldo;
	}

	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConto() {
		return numeroConto;
	}
}
