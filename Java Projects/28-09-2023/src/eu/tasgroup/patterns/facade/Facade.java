package eu.tasgroup.patterns.facade;

// implementa anche il singleton
public class Facade {
	private Facade() {
	}

	private static Facade istanza;

	public static Facade getInstance() {
		if (istanza == null) {
			istanza = new Facade();
		}
		return istanza;
	}

	public String getInfoBC1() {
		BC1 b = new BC1();
		return b.getInfo();
	}

	public String getInfoBC2() {
		BC2 b = new BC2();
		return b.getInfo();
	}

	public String getInfoBC3() {
		BC3 b = new BC3();
		return b.getInfo();
	}
}
