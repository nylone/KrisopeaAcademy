package eu.tasgroup.decoratore;

public class AutoBase implements Auto {

	private String modello;

	public AutoBase() {
		modello = "modello base";
	}

	@Override
	public void assembla() {
		System.out.println(modello);
	}

}
