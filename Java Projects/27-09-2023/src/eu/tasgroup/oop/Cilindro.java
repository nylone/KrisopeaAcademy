package eu.tasgroup.oop;

public class Cilindro extends Cerchio implements Forma {

	private double altezza;

	public Cilindro(int x, int y, double raggio, double altezza) {
		super(x, y, raggio);
		this.altezza = altezza;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 2 * super.area() + 2 * Math.PI * getRaggio() * altezza;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return super.area() * altezza;
	}

}
