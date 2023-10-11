package eu.tasgroup.patterns.builder;

// director
public class FabbricaAuto {

	private AutoBuilder autoBuilder;

	public void setAutoBuilder(AutoBuilder autoBuilder) {
		this.autoBuilder = autoBuilder;
	}

	public Auto getAuto() {
		return autoBuilder.getAuto();
	}

	public void buildAuto() {
		autoBuilder.createAutoProduct();
		autoBuilder.buildCilindrata();
		autoBuilder.buildModello();
	}
}
