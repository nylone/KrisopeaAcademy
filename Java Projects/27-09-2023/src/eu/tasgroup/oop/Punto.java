package eu.tasgroup.oop;

public class Punto implements Forma {
	int x;
	int y;

	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Punto() {
		this(0, 0);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double volume() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTipo() {
		return DESCRIZIONE + getDescrizione();
	}
}
