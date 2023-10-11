package eu.tasgroup.esempiooop.collection;

public class ArrayMulti {
	public static void main(String[] args) {
		String[][] test = { { "" }, { "", "" }, { "" } };

		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i].length);
		}

		double[] tassiInteresse = new double[6];
		for (int j = 0; j < tassiInteresse.length; j++) {
			tassiInteresse[j] = (2 + j) / 100.00;
		}

		double[][] bilancio = new double[30][6];
		for (int j = 0; j < bilancio[0].length; j++) {
			bilancio[0][j] = 10_000;
		}

		for (int i = 1; i < bilancio.length; i++) {
			for (int j = 0; j < bilancio[i].length; j++) {
				double bilancioPrecedente = bilancio[i - 1][j];
				double interessi = bilancioPrecedente * tassiInteresse[j];
				bilancio[i][j] = interessi + bilancioPrecedente;
			}
		}

		for (int j = 0; j < tassiInteresse.length; j++) {
			System.out.printf("%9.0f%%", tassiInteresse[j] * 100);
		}

		System.out.println();

		for (double[] riga : bilancio) {
			for (double valore : riga) {
				System.out.printf("%10.3f", valore);
			}
			System.out.println();
		}
	}
}
