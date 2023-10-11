package eu.tasgroup.decoratore;

public class PacchettoSport extends AutoDecorator {

	public PacchettoSport(Auto auto) {
		super(auto);
	}

	@Override
	public void assembla() {
		super.assembla();
		System.out.println("Funzionalità decorata dal pacchetto sport");
	}

}
