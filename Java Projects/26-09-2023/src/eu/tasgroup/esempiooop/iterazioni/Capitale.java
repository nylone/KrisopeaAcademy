package eu.tasgroup.esempiooop.iterazioni;

import java.util.Scanner;

public class Capitale {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Capitale finale?");
		double previsione = in.nextDouble();

		System.out.println("Capitale accumulato durante l'anno?");
		double pagamenti = in.nextDouble();

		System.out.println("Tasso interesse?");
		double tassoInteresse = in.nextDouble();

		in.close();

		double bilancio = 0;
		int anni = 0;
		while (bilancio < previsione) {
			bilancio += pagamenti;
			double interessi = bilancio * tassoInteresse / 100;
			bilancio += interessi;
			anni++;
		}
		System.out.printf("Capitale previsto tra: %d anni.%nCapitale totale: %.2f", anni, bilancio);
	}
}
