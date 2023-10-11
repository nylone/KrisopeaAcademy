package com.rampeo.posteggio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Posteggio {
	private HashSet<String> targhePresenti;
	private PriorityQueue<InfoPosteggio> codaUscita;
	private int maxPosti;

	public Posteggio(int maxPosti) {
		this.targhePresenti = new HashSet<>();
		this.maxPosti = maxPosti;
		this.codaUscita = new PriorityQueue<InfoPosteggio>();
	}

	public int getMaxPosti() {
		return maxPosti;
	}

	public int getPostiLiberi() {
		return this.maxPosti - this.targhePresenti.size();
	}

	public boolean inserisciMacchina(InfoPosteggio prenotazione) {
		if (this.targhePresenti.size() > this.maxPosti || this.targhePresenti.contains(prenotazione.getTarga()))
			return false;
		this.targhePresenti.add(prenotazione.getTarga());
		this.codaUscita.add(prenotazione);
		return true;
	}

	public boolean ritiraMacchina(String targa) {
		if (this.targhePresenti.contains(targa)) {
			InfoPosteggio macchina = this.codaUscita.peek();
			if (macchina.getTarga().equals(targa)) {
				this.targhePresenti.remove(targa);
				this.codaUscita.poll();
				return true;
			}
		}
		return false;
	}
	
	public List<InfoPosteggio> getOrdineUscita() {
		ArrayList<InfoPosteggio> ordinati = new ArrayList<>(this.codaUscita.size());
		while (this.codaUscita.size() > 0) {
			ordinati.add(codaUscita.poll());
		}
		for (InfoPosteggio info : ordinati)
			this.codaUscita.add(info);
		return ordinati;
	}

}
