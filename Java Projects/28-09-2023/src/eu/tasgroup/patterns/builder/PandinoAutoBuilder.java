package eu.tasgroup.patterns.builder;

// Concrete Builder
public class PandinoAutoBuilder extends AutoBuilder {

	@Override
	public void buildCilindrata() {
		super.auto.setCilindrata("4");
	}

	@Override
	public void buildModello() {
		super.auto.setModello("Panda 4x4 usata di fabbrica");
	}

}
