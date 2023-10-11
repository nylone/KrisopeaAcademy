package eu.tasgroup.collections.code;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class CodaPriorityCustom {

	public static void main(String[] args) {
		Queue<Cliente> coda = new PriorityQueue<>(idComparator);
		Random rand = new Random();
		for (int i = 0; i < 20; i++) {
			coda.offer(new Cliente(rand.nextInt(100), ((Integer) rand.nextInt(100)).toString()));
		}
		Iterator<Cliente> iter = coda.iterator();
		while (iter.hasNext()) {
			if (iter.next().getId() % 2 == 0)
				iter.remove();
		}
		for (int i = 0; i < 20; i++) {
			System.out.print(coda.poll() + " ");
			;
		}
	}

	public static Comparator<Cliente> idComparator = new Comparator<Cliente>() {

		@Override
		public int compare(Cliente o1, Cliente o2) {
			return o1.getId() - o2.getId();
		}

	};
}
