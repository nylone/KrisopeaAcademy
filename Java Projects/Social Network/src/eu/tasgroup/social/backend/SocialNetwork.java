package eu.tasgroup.social.backend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {
	private final Map<String, User> utenti;
	private final int etàMinima;

	public SocialNetwork(int etàMinima) {
		this.etàMinima = etàMinima;
		this.utenti = new HashMap<String, User>();
	}

	public User registrazione(String username, String nome, int età) throws OperationException {
		if (età < this.etàMinima)
			throw new OperationException("età minima non rispettata");
		else if (this.utenti.containsKey(username))
			throw new OperationException("nome utente duplicato");
		else {
			User utente = new User(username, nome, età);
			this.utenti.put(username, utente);
			return utente;
		}
	}

	public User autenticazione(String username) throws OperationException {
		if (!utenti.containsKey(username))
			throw new OperationException("utente non trovato");
		return utenti.get(username);
	}

	public void diventaAmico(String u1, String u2) throws OperationException {
		User utente1 = this.utenti.get(u1);
		User utente2 = this.utenti.get(u2);
		if (utente1 == null || utente2 == null)
			throw new OperationException("utente non trovato");
		else if (utente1.getEtà() < 18 || utente2.getEtà() < 18)
			throw new OperationException("età minima non rispettata per amicizia");
		else if (utente1.getAmici().contains(utente2) && utente2.getAmici().contains(utente1))
			return;
		else {
			utente1.aggiungiAmico(utente2);
			utente2.aggiungiAmico(utente1);
		}
	}

	public void rimuoviAmico(String u1, String u2) throws OperationException {
		User utente1 = this.utenti.get(u1);
		User utente2 = this.utenti.get(u2);
		if (utente1 == null || utente2 == null)
			throw new OperationException("utente non trovato");
		else if (!utente1.getAmici().contains(utente2) || !utente2.getAmici().contains(utente1))
			throw new OperationException("utenti non connessi");
		else {
			utente1.rimuoviAmico(utente2);
			utente2.rimuoviAmico(utente1);
		}
	}

	public Set<User> cercaUtente(String ricerca) {
		HashSet<User> trovati = new HashSet<>();
		for (User user : this.utenti.values()) {
			if (user.getUsername().contains(ricerca) || user.getNome().contains(ricerca))
				trovati.add(user);
		}
		return trovati;
	}

	public User visualizzaUtente(String username) throws OperationException {
		User utente = this.utenti.get(username);
		if (utente == null)
			throw new OperationException("utente non trovato");
		return utente;
	}

	public int getEtàMinima() {
		return etàMinima;
	}

	public Map<String, User> getUtenti() {
		return utenti;
	}

}
