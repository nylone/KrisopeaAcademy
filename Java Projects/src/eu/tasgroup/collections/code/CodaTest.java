package eu.tasgroup.collections.code;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class CodaTest {

	public static void main(String[] args) {
		Queue<Integer> coda = new PriorityQueue<>();

		coda.offer(6);
		System.out.println(coda);
		coda.offer(5);
		System.out.println(coda);
		coda.offer(10);
		System.out.println(coda);
		coda.offer(34);
		System.out.println(coda);
		coda.offer(11);
		System.out.println(coda);
		coda.offer(2);
		System.out.println(coda);
		coda.offer(1);
		Iterator<Integer> i = coda.iterator();
		while (i.hasNext())
			System.out.print(i.next() + " ");
		System.out.println();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();
		System.out.println(coda);
		coda.poll();

		// l'ordinamento degli elementi nella coda è dato dal comparatore naturale sulle
		// stringhe
		System.out.println(coda);

		try {
			coda.remove();
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
	}

}
