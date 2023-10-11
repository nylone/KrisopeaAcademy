package eu.tasgroup.patterns.builder;

// Concrete Builder
public class FerrariAutoBuilder extends AutoBuilder {

	@Override
	public void buildCilindrata() {
		super.auto.setCilindrata("4300");
	}

	@Override
	public void buildModello() {
		super.auto.setModello("F430");
	}

}
