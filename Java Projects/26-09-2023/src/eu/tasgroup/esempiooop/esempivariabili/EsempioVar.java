package eu.tasgroup.esempiooop.esempivariabili;

public class EsempioVar {
	
	static int x = 1;
	
	static final int Y = 2;
	
public static void main(String[] args) {
	int x = 5;
	System.out.println("La variabile locale X inizio main vale:\t" + x);
	metodoA();
	metodoB();
	metodoA();
	metodoB();
	System.out.println("La variabile locale X fine main vale:\t" + x);
	System.out.println("La variabile locale X fine main vale:\t" + x);
}

private static void metodoA() {
	int x = 25;
	System.out.println("La variabile locale X inizio A vale:\t" + x);
	x++;
	System.out.println("La variabile locale X fine A vale:\t" + x);
}

private static void metodoB() {
	System.out.println("Il campo di istanza X inizio B vale:\t" + x);
	x *= 10;
	System.out.println("Il campo di istanza X fine B vale:\t" + x);

}
}
