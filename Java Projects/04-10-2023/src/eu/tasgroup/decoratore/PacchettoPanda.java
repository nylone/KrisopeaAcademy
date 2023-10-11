package eu.tasgroup.decoratore;

public class PacchettoPanda extends AutoDecorator {
	public PacchettoPanda(Auto auto) {
		super(auto);
	}

	@Override
	public void assembla() {
		super.assembla();
		System.out.println("Viva la panda!");
	}
}
