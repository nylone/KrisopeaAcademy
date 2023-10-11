package eu.tasgroup.decoratore;

public class AutoDecorator implements Auto {

	private Auto auto;

	public AutoDecorator(Auto auto) {
		this.auto = auto;
	}

	@Override
	public void assembla() {
		this.auto.assembla();
	}

}
