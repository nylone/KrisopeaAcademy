package eu.tasgroup.patterns.builder;

public class BuilderTest {
	public static void main(String[] args) {
		FabbricaAuto f = new FabbricaAuto();
		f.setAutoBuilder(new PandinoAutoBuilder());
		f.buildAuto();

		Auto pandino = f.getAuto();
		System.out.println(pandino.getModello());

		FabbricaAuto f2 = new FabbricaAuto();
		f2.setAutoBuilder(new FerrariAutoBuilder());
		f2.buildAuto();

		Auto ferrari = f2.getAuto();
		System.out.println(ferrari.getModello());
	}
}
