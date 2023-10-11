package eu.tasgroup.es2;

import java.util.ArrayList;
import java.util.List;

public class Banca {

	private List<Cliente> clienti;
	private List<ContoBancario> contiBancari;

	public Banca() {
		this.clienti = new ArrayList<Cliente>();
		this.contiBancari = new ArrayList<ContoBancario>();
	}

	public ContoBancario getConto(String nome, String cognome, String indirizzo, int contoID)
			throws OperazioneBancariaException {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);
		boolean found = false;
		for (Cliente c : this.clienti) {
			if (c.equals(cliente))
				found = true;
		}
		if (!found)
			throw new OperazioneBancariaException("Il cliente non esiste");

		ContoBancario conto;
		try {
			conto = this.contiBancari.get(contoID);
			if (!conto.getProprietario().equals(cliente))
				throw new OperazioneBancariaException("Il conto non è tuo");
		} catch (IndexOutOfBoundsException e) {
			throw new OperazioneBancariaException("Il conto non esiste");
		}
		return conto;
	}

	public int apriConto(String nome, String cognome, String indirizzo, String tipo)
			throws OperazioneBancariaException {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);

		for (Cliente c : this.clienti) {
			if (c.equals(cliente))
				throw new OperazioneBancariaException("Il cliente esiste già");
		}

		ContoBancario conto;
		switch (tipo) {
		case "corrente":
			conto = new ContoCorrente(cliente);
			break;
		case "savings":
			conto = new ContoSavings(0, cliente);
			break;
		default:
			throw new OperazioneBancariaException("Il tipo di conto non è supportato");
		}

		int contoID = this.contiBancari.size();
		this.contiBancari.add(contoID, conto);
		this.clienti.add(cliente);

		return contoID;
	}

	public void depositaSulConto(String nome, String cognome, String indirizzo, int contoID, double importo)
			throws OperazioneBancariaException {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);
		boolean found = false;
		for (Cliente c : this.clienti) {
			if (c.equals(cliente))
				found = true;
		}
		if (!found)
			throw new OperazioneBancariaException("Il cliente non esiste");

		ContoBancario conto;
		try {
			conto = this.contiBancari.get(contoID);
			if (!conto.getProprietario().equals(cliente))
				throw new OperazioneBancariaException("Il conto non è tuo");
		} catch (IndexOutOfBoundsException e) {
			throw new OperazioneBancariaException("Il conto non esiste");
		}
		conto.deposita(importo);
	}

	public void prelevaDalConto(String nome, String cognome, String indirizzo, int contoID, double importo)
			throws OperazioneBancariaException {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);
		boolean found = false;
		for (Cliente c : this.clienti) {
			if (c.equals(cliente))
				found = true;
		}
		if (!found)
			throw new OperazioneBancariaException("Il cliente non esiste");

		ContoBancario conto;
		try {
			conto = this.contiBancari.get(contoID);
			if (!conto.getProprietario().equals(cliente))
				throw new OperazioneBancariaException("Il conto non è tuo");
		} catch (IndexOutOfBoundsException e) {
			throw new OperazioneBancariaException("Il conto non esiste");
		}

		conto.preleva(importo);

		return;
	}

	public double saldoSulConto(String nome, String cognome, String indirizzo, int contoID)
			throws OperazioneBancariaException {
		Cliente cliente = new Cliente(nome, cognome, indirizzo);
		boolean found = false;
		for (Cliente c : this.clienti) {
			if (c.equals(cliente))
				found = true;
		}
		if (!found)
			throw new OperazioneBancariaException("Il cliente non esiste");

		ContoBancario conto;
		try {
			conto = this.contiBancari.get(contoID);
		} catch (IndexOutOfBoundsException e) {
			throw new OperazioneBancariaException("Il conto non esiste");
		}

		if (!conto.getProprietario().equals(cliente))
			throw new OperazioneBancariaException("Il conto non è tuo");

		return conto.getSaldo();
	}

	public void bonifico(ContoBancario da, ContoBancario a, double importo) throws OperazioneBancariaException {
		da.preleva(importo);
		a.deposita(importo);
	}

	public void bilanciaFondi(ContoBancario c1, ContoBancario c2) throws OperazioneBancariaException {
		double c1Saldo = c1.getSaldo();
		double c2Saldo = c2.getSaldo();
		if (c1Saldo > c2Saldo) {
			c2.deposita(c1Saldo - c2Saldo);
			c1.preleva(c1Saldo - c2Saldo);
		} else {
			c1.deposita(c2Saldo - c1Saldo);
			c2.preleva(c2Saldo - c1Saldo);
		}
	}

	public void svuotaConto(ContoBancario da, ContoBancario a) throws OperazioneBancariaException {
		da.preleva(da.getSaldo());
		a.deposita(da.getSaldo());
	}
}
