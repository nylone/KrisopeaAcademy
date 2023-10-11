package eu.tasgroup.patterns.facade;

public class FacadeTest {
	public static void main(String[] args) {
		Facade f = Facade.getInstance();
		System.out.println(f.getInfoBC1());
		System.out.println(f.getInfoBC2());
		System.out.println(f.getInfoBC3());

		BC3 bc3 = new BC3();
		System.out.println(bc3.getInfo());

	}
}
