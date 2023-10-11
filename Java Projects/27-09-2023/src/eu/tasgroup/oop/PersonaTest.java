package eu.tasgroup.oop;

public class PersonaTest {

	public static void main(String[] args) {
		Persona persone[] = new Persona[2];
		// Persona nonCompilerebbe = new Persona("ciao", "pippo");
		persone[0] = new Studente("massimo", "rossi", "filosofia");
		persone[1] = new Dipendente("massimo", "rossi", 1500);

		for (Persona p : persone) {
			System.out.println(p.getNome() + " dice:\n" + p.getSaluto());
		}
	}

}
