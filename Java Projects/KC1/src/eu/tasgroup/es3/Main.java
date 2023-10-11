package eu.tasgroup.es3;

// Utilizzando gli operatori bitwise stampare un valore intero unsigned come sequenza di 32 bit.
public class Main {
	public static void main(String[] args) {
		int unsigned = 0b00101101;
		do {
			int resto = unsigned % 2;
			unsigned = unsigned / 2;
			System.out.print(resto);
		} while (unsigned != 0);
	}
}
