package eu.tasgroup.oop;

public class Cerchio extends Punto implements Forma {

	private double raggio;

	public Cerchio(int x, int y, double raggio) {
		super(x, y);
		this.raggio = raggio;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.pow(raggio, 2) * Math.PI;
	}

	public double getRaggio() {
		return raggio;
	}

	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}

}
