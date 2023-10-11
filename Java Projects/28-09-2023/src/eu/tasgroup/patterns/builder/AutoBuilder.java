package eu.tasgroup.patterns.builder;

// Abstract Builder
public abstract class AutoBuilder {
	protected Auto auto;

	public void createAutoProduct() {
		this.auto = new Auto();
	}

	public Auto getAuto() {
		return this.auto;
	}

	public abstract void buildCilindrata();

	public abstract void buildModello();
}
