package eu.tasgroup.es1;

public class Main {
	public static void main(String[] args) {
		ContoBancario[] conti = {
				new ContoCorrente(1), new ContoSavings(100000, 2), new ContoSavings(50, 3),
		};
		double[] daDepositare = { 100, 1, 20, -1, 10000, 50.02 };
		double[] daPrelevare = { 1000, 1, 20, -1, 20000, 301 };

		for (ContoBancario conto : conti) {
			System.out.println("Conto #" + conto.getNumeroConto() + " di tipo " + conto.getClass().getSimpleName());
			for (double deposito : daDepositare) {
				try {
					conto.deposita(deposito);
					System.out.println("depositati " + deposito);
				} catch (OperazioneBancariaException e) {
					System.out.println("impossibile depositare " + deposito + " perchè:\n\t" + e.getMessage());
				}
			}

			for (double prelievo : daPrelevare) {
				try {
					conto.preleva(prelievo);
					System.out.println("prelevati " + prelievo);
				} catch (ImpossibilePrelevareException e) {
					System.out.println("impossibile prelevare " + prelievo + " perchè:\n\t" + e.getMessage());
				}
			}
			
			if (conto instanceof Interessi) {
				double interessi = ((Interessi) conto).calcolaInteressi();
				System.out.println("gli interessi per il conto #" + conto.getNumeroConto() + " sono: " + interessi);
			}

			System.out.println();

		}
}
}
