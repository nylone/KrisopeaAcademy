package eu.tasgroup.memento;

public class MementoTest {
	public static void main(String[] args) {
		Originator origin = new Originator();
		CareTaker caretaker = new CareTaker();

		origin.setStato("Primo Stato");
		origin.setStato("Secondo Stato");
		caretaker.add(origin.salvaStatoMemento());

		origin.setStato("Terzo Stato");
		caretaker.add(origin.salvaStatoMemento());

		origin.setStato("Quarto Stato");
		System.out.println("Il quarto stato è: " + origin.getStato());

		origin.getStatoMemento(caretaker.get(0));
		System.out.println("Il primo stato salvato è: " + origin.getStato());
	}
}
