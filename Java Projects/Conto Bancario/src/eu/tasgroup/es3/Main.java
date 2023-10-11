package eu.tasgroup.es3;

public class Main {

	public static void main(String[] args) {
		ClienteVIP vip1 = new ClienteVIP("Matteo Rampone", 4000);
		ClienteVIP vip2 = new ClienteVIP("Rampeo Mattone", 5500, 100);
		ClienteRegolare reg1 = new ClienteRegolare("GiappoNylon", 300);
		ClienteRegolare reg2 = new ClienteRegolare("GhippoNippon", 1500);
		OffertaCredito[] clienti = { vip1, vip2, reg1, reg2 };

		vip1.setIdoneitàMinima(-1000);
		vip1.riduciIdoneitàCredito(50);

		vip2.riduciIdoneitàCredito(50);

		reg1.aumentaIdoneitàCredito(10);

		reg2.aumentaIdoneitàCredito(10);

		for (OffertaCredito cliente : clienti) {
			System.out.printf("Al cliente %s è stato offerto un credito di %.2f€ con interesse di %.2f%%%n", cliente,
					cliente.getCredito(), cliente.getInteresse());
		}
	}

}
