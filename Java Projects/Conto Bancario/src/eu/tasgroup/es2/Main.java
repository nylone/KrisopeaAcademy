package eu.tasgroup.es2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Banca banca = new Banca();

		try (Scanner in = new Scanner(System.in)) {
			boolean vuoleContinuare = true;
			while (vuoleContinuare) {
				System.out.print("Che tipo di conto vuoi creare? (corrente/savings) ");
				String tipo = in.next();
				System.out.print("Inserisci il tuo nome: ");
				String nome = in.next();
				System.out.print("Inserisci il tuo cognome: ");
				String cognome = in.next();
				System.out.print("Inserisci il tuo indirizzo: ");
				String indirizzo = in.next();
				try {
					int contoID = banca.apriConto(nome, cognome, indirizzo, tipo);
					System.out.println("Il tuo conto è il #" + contoID);
				} catch (OperazioneBancariaException e) {
					System.out.println("L'operazione è fallita. Mesaggio di errore:");
					System.out.println(e.getMessage());
				}
				System.out.print("continuare? (S/n)");
				String continuare = in.next();
				if (continuare.equalsIgnoreCase("n")) {
					vuoleContinuare = false;
				}
			}
			vuoleContinuare = true;
			while (vuoleContinuare) {
				System.out.println("Seleziona l'account su cui depositare i soldi");
				System.out.print("Inserisci il tuo nome: ");
				String nome = in.next();
				System.out.print("Inserisci il tuo cognome: ");
				String cognome = in.next();
				System.out.print("Inserisci il tuo indirizzo: ");
				String indirizzo = in.next();
				System.out.print("Inserisci il tuo conto: ");
				int contoID = in.nextInt();
				System.out.print("Inserisci l'importo: ");
				int importo = in.nextInt();
				try {
					banca.depositaSulConto(nome, cognome, indirizzo, contoID, importo);
					double saldo = banca.saldoSulConto(nome, cognome, indirizzo, contoID);
					System.out.println("Il tuo saldo è " + saldo);

				} catch (OperazioneBancariaException e) {
					System.out.println("L'operazione è fallita. Mesaggio di errore:");
					System.out.println(e.getMessage());
				}
				System.out.print("continuare? (S/n)");
				String continuare = in.next();
				if (continuare.equalsIgnoreCase("n")) {
					vuoleContinuare = false;
				}
			}
			vuoleContinuare = true;
			while (vuoleContinuare) {
				System.out.println("Seleziona l'account da cui prelevare i soldi");
				System.out.print("Inserisci il tuo nome: ");
				String nome = in.next();
				System.out.print("Inserisci il tuo cognome: ");
				String cognome = in.next();
				System.out.print("Inserisci il tuo indirizzo: ");
				String indirizzo = in.next();
				System.out.print("Inserisci il tuo conto: ");
				int contoID = in.nextInt();
				System.out.print("Inserisci l'importo: ");
				int importo = in.nextInt();
				try {
					banca.prelevaDalConto(nome, cognome, indirizzo, contoID, importo);
					double saldo = banca.saldoSulConto(nome, cognome, indirizzo, contoID);
					System.out.println("Il tuo saldo è " + saldo);
				} catch (OperazioneBancariaException e) {
					System.out.println("L'operazione è fallita. Mesaggio di errore:");
					System.out.println(e.getMessage());
				}
				System.out.print("continuare? (S/n)");
				String continuare = in.next();
				if (continuare.equalsIgnoreCase("n")) {
					vuoleContinuare = false;
				}
			}
			vuoleContinuare = true;
			while (vuoleContinuare) {
				System.out.println("Seleziona l'account da cui iniziare la transazione");
				System.out.print("Inserisci il nome: ");
				String nome = in.next();
				System.out.print("Inserisci il cognome: ");
				String cognome = in.next();
				System.out.print("Inserisci l' indirizzo: ");
				String indirizzo = in.next();
				System.out.print("Inserisci il conto: ");
				int contoID = in.nextInt();
				System.out.println("Seleziona l'account con cui completare la transazione");
				System.out.print("Inserisci il nome: ");
				String nome2 = in.next();
				System.out.print("Inserisci il cognome: ");
				String cognome2 = in.next();
				System.out.print("Inserisci l' indirizzo: ");
				String indirizzo2 = in.next();
				System.out.print("Inserisci il conto: ");
				int contoID2 = in.nextInt();
				System.out.print("Inserisci l'importo della transazione: ");
				int importo = in.nextInt();
				System.out.print("Inserisci il tipo della transazione: (BONIFICO/pagamento)");
				String tipo = in.next();
				try {
					ContoBancario conto = banca.getConto(nome, cognome, indirizzo, contoID);
					ContoBancario conto2 = banca.getConto(nome2, cognome2, indirizzo2, contoID2);
					Transazioni transazione;
					if (tipo.equalsIgnoreCase("pagamento")) {
						transazione = new PagamentoTracciato(conto, conto2, importo);
					} else {
						transazione = new Bonifico(conto, conto2, importo);
					}
					transazione.effettuaTransazione();
					double saldo = conto.getSaldo();
					double saldo2 = conto2.getSaldo();

					System.out.println("Il saldo di partenza è " + saldo);
					System.out.println("Il saldo di arrivo è " + saldo2);
				} catch (OperazioneBancariaException e) {
					System.out.println("L'operazione è fallita. Mesaggio di errore:");
					System.out.println(e.getMessage());
				}
				System.out.print("continuare? (S/n)");
				String continuare = in.next();
				if (continuare.equalsIgnoreCase("n")) {
					vuoleContinuare = false;
				}
			}
			for (String entry : RegistroPagamenti.getInstance().getRegistro()) {
				System.out.println(entry);
			}
		}
	}
}
