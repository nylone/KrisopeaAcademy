package eu.tasgroup.oop;

public class ImpiegatoTest {
	public static void main(String[] args) {
		Impiegato[] impiegati = new Impiegato[3];

		impiegati[0] = new Responsabile("ACBRD123", "Mario", "Rossi", 1999, 10, 1, 2000, 200);
		impiegati[1] = new Impiegato("ACBHF143", "Giuseppe", "Verdi", 2000, 11, 15, 1200);
		impiegati[2] = new Dirigente("ASDWED745", "Mario", "Rossi", 1959, 3, 2, 4000, 200, "Fiat Panda", 2_000);

		for (Impiegato i : impiegati) {
			System.out.println(i.getNome() + " " + i.getStipendio());
			if (i instanceof Dirigente) {
				System.out.println("Auto: " + ((Dirigente) i).getAuto());
			}
		}
	}
}
