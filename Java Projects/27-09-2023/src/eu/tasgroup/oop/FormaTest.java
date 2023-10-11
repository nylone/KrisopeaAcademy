package eu.tasgroup.oop;

import java.text.DecimalFormat;

public class FormaTest {

	public static void main(String[] args) {
		Forma[] forme = new Forma[3];

		forme[0] = new Punto(0, 1);
		forme[1] = new Cilindro(5, 5, 10, 30);
		forme[2] = new Cerchio(2, 3, 4);

		DecimalFormat formato = new DecimalFormat("0.00");

		for (Forma f : forme) {
			System.out.println(f.getTipo() + "\n" + "Area: " + formato.format(f.area()) + "\n" + "Volume: "
					+ formato.format(f.volume()));
		}
	}

}
