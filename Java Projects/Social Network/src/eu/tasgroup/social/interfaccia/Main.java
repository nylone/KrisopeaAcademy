package eu.tasgroup.social.interfaccia;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import eu.tasgroup.social.backend.Commento;
import eu.tasgroup.social.backend.OperationException;
import eu.tasgroup.social.backend.Post;
import eu.tasgroup.social.backend.SocialNetwork;
import eu.tasgroup.social.backend.User;
import eu.tasgroup.social.xml.StateKeeper;

public class Main {
	private static SocialNetwork network;
	private static Scanner scan = new Scanner(System.in);
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

	public static void main(String[] args) {
		try {
			network = StateKeeper.loadState();
		} catch (ParserConfigurationException | SAXException | IOException | OperationException e) {
			e.printStackTrace();
			return;
		}
		System.out.println("Benvenuto su un generico social network!\n");
		do {
			User sessione = null;
			while (sessione == null)
				try {
					sessione = autenticazione();
				} catch (OperationException e) {
					System.out.println("Si è verificato un errore:");
					System.out.println(e.getMessage());
				}
			bacheca(sessione, true);
			boolean logout = false;
			while (!logout) {
				separatore();
				System.out.println("Cosa vuoi fare?");
				System.out.println("1 - visualizza amici");
				System.out.println("2 - aggiungi amico");
				System.out.println("3 - rimuovi amico");
				System.out.println("4 - cerca utente");
				System.out.println("5 - crea post");
				System.out.println("6 - archivia post");
				System.out.println("7 - commenta post");
				System.out.println("8 - visualizza bacheca");
				System.out.println("9 - visualizza bacheca amico");
				System.out.println("\n0 - logout");
				System.out.print("\nScegli: ");
				int scelta = scan.nextInt();
				scan.nextLine();
				separatore();
				try {
					switch (scelta) {
					case 1: {
						amici(sessione);
						break;
					}
					case 2: {
						aggiungiAmico(sessione);
						break;
					}
					case 3: {
						rimuoviAmico(sessione);
						break;
					}
					case 4: {
						cerca();
						break;
					}
					case 5: {
						creaPost(sessione);
						break;
					}
					case 6: {
						archiviaPost(sessione);
						break;
					}
					case 7: {
						commentaPost(sessione, sessione);
						break;
					}
					case 8: {
						bacheca(sessione, true);
						break;
					}
					case 9: {
						bachecaAmico(sessione);
						break;
					}
					case 0: {
						logout = true;
						break;
					}
					}
				} catch (OperationException e) {
					System.out.println("Si è verificato un errore:");
					System.out.println(e.getMessage());
				}

			}
			System.out.println("Vuoi uscire?");
			System.out.println("1 - sì");
			System.out.println("2 - no");
		} while (scan.nextInt() != 1);
		scan.close();
		try {
			StateKeeper.saveState(network);
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void separatore() {
		System.out.println("|====================================================================|\n");
	}

	public static User autenticazione() throws OperationException {
		separatore();
		System.out.println("Step di autenticazione");
		System.out.println("1 - Login");
		System.out.println("2 - Registrazione");
		System.out.print("Scegli: ");
		int scelta = scan.nextInt();
		String username;
		User utente = null;
		while (utente == null) {
			switch (scelta) {
			case 1:
				System.out.print("\nInserisci il tuo username: ");
				username = scan.next();
				utente = network.autenticazione(username);
				break;
			case 2:
				System.out.print("\nInserisci il tuo username: ");
				username = scan.next();
				System.out.print("Inserisci il tuo nome: ");
				scan.nextLine();
				String nome = scan.nextLine();
				System.out.print("Inserisci la tua età: ");
				int età = scan.nextInt();
				utente = network.registrazione(username, nome, età);
				break;
			}
		}
		return utente;
	}

	public static void bacheca(User utente, boolean mostraArchiviati) {
		separatore();
		System.out.println("Anagrafica:");
		System.out.printf("\tNome: %s%n", utente.getNome());
		System.out.printf("\tUsername: %s%n", utente.getUsername());
		System.out.printf("\tEtà: %d%n", utente.getEtà());
		System.out.println();
		System.out.println("I tuoi Post:");
		List<Post> posts = utente.getPost();
		if (posts.size() == 0) {
			System.out.println("\n\tNessun post!");
		} else {
			for (int i = 0; i < posts.size(); i++) {
				Post post = posts.get(i);
				System.out.println();
				if (post.isArchiviato()) {
					if (mostraArchiviati)
						System.out.println("\tPost Archiviato");
					else
						continue;
				}
				System.out.printf("\tIdentificativo: %d%n", i);
				System.out.printf("\tData: %s%n", post.getPubblicazione().format(df));
				System.out.printf("\tTitolo: %s%n", post.getTitolo());
				System.out.printf("\tTesto: %s%n", post.getTesto());
				List<Commento> commenti = post.getCommenti();
				if (commenti.size() != 0) {
					System.out.println("\tCommenti:");
					for (Commento commento : commenti) {
						System.out.println();
						System.out.printf("\t\tUtente: %s%n", commento.getUtente().getNome());
						System.out.printf("\t\tTesto: %s%n", commento.getTesto());
					}
				}
			}
		}
		System.out.println();
	}

	public static void bachecaAmico(User sessione) throws OperationException {
		separatore();
		System.out.print("Inserisci il nome utente da visualizzare: ");
		User amico = network.visualizzaUtente(scan.next());
		if (!sessione.getAmici().contains(amico)) {
			System.out.println("Non sei amico di questo utente :/");
			return;
		}
		bacheca(amico, false);
		if (amico.getPost().stream().filter(e -> !e.isArchiviato()).count() == 0) {
			System.out.println("Nessun post da commentare :(");
			return;
		}
		boolean esci = false;
		while (!esci) {
			separatore();
			System.out.println("Interazioni possibili");
			System.out.println("1 - commenta un post");
			System.out.println("2 - ricarica bacheca");
			System.out.println("\n0 - torna alla home");
			System.out.print("\nScegli: ");
			int scelta = scan.nextInt();
			switch (scelta) {
			case 0: {
				esci = true;
				break;
			}
			case 1: {
				commentaPost(amico, sessione);
				break;
			}
			case 2:
				bacheca(amico, false);
				break;
			}
		}
	}

	public static void amici(User utente) {
		separatore();
		System.out.println("I tuoi Amici:");
		Set<User> amici = utente.getAmici();
		if (amici.size() == 0) {
			System.out.println("\n\tMusichetta triste :(");
		} else {
			for (User amico : amici) {
				System.out.println();
				System.out.printf("\tNome: %s%n", amico.getNome());
				System.out.printf("\tUsername: %s%n", amico.getUsername());
			}
		}
		System.out.println();
	}

	public static void cerca() {
		System.out.print("Inserisci la chiave di ricerca: ");
		String ricerca = scan.next();
		Set<User> utenti = network.cercaUtente(ricerca);
		if (utenti.size() == 0) {
			System.out.println("\n\tNessun utente trovato.");
		} else {
			System.out.println("\n\tUtenti trovati:");
			for (User utente : utenti) {
				System.out.println();
				System.out.printf("\tNome: %s%n", utente.getNome());
				System.out.printf("\tUsername: %s%n", utente.getUsername());
			}
		}
		System.out.println();
	}

	public static void aggiungiAmico(User sessione) throws OperationException {
		System.out.print("Inserisci il nome utente da aggiungere: ");
		String amico = scan.next();
		network.diventaAmico(sessione.getUsername(), amico);
		System.out.println("Fatto!\n");
	}

	public static void rimuoviAmico(User sessione) throws OperationException {
		System.out.print("Inserisci il nome utente da rimuovere: ");
		String amico = scan.next();
		network.rimuoviAmico(sessione.getUsername(), amico);
		System.out.println("Fatto :(\n");
	}

	public static void creaPost(User sessione) throws OperationException {
		System.out.print("Inserisci il titolo del post: ");
		String titolo = scan.nextLine();
		System.out.println("Inserisci il testo del post.\nUsa il tasto Enter per terminare.");
		String testo = scan.nextLine();
		Post post = new Post(titolo, testo);
		sessione.aggiungiPost(post);
		System.out.println("\nFatto!\n");
	}

	public static void archiviaPost(User sessione) throws OperationException {
		System.out.print("Inserisci l'identificativo del post: ");
		int id = scan.nextInt();
		List<Post> posts = sessione.getPost();
		if (id >= 0 && id < posts.size()) {
			posts.get(id).archivia();
			System.out.println("\nFatto!\n");
		} else {
			System.out.println("\nIdentificativo inesistente");
		}
	}

	public static void commentaPost(User pagina, User proprietario) throws OperationException {
		System.out.print("Inserisci l'identificativo del post: ");
		int id = scan.nextInt();
		List<Post> posts = pagina.getPost();
		if (id >= 0 && id < posts.size()) {
			scan.nextLine();
			System.out.println("Inserisci il testo del commento.\nUsa il tasto Enter per terminare.");
			String testo = scan.nextLine();
			Commento commento = new Commento(proprietario, testo);
			posts.get(id).commenta(commento);
			;
			System.out.println("\nFatto!\n");
		} else {
			System.out.println("\nIdentificativo inesistente");
		}
	}

}
