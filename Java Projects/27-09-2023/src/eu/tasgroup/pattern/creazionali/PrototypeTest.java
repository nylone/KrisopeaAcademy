package eu.tasgroup.pattern.creazionali;

public class PrototypeTest {
	public static void main(String[] args) {
		Account a = new Account();
		a.setNome("rampeo");
		a.setCognome("mattone");
		a.setCredito("tantissimo");

		System.out.println(a);

		Account a2 = a;
		a2.setNome("matteo");
		a2.setCognome("rampone");
		a2.setCredito("poco o niente");

		System.out.println(a);
		System.out.println(a2);

		Account a3 = (Account) a.clone();
		a3.setNome("mario");
		a3.setCognome("rossi");
		a3.setCredito("non lo so");

		System.out.println(a);
		System.out.println(a3);
	}
}
