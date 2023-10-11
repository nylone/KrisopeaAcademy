package com.rampeo.posteggio;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		Posteggio posteggio = new Posteggio(100);

		posteggio.inserisciMacchina(new InfoPosteggio("AB 2013B", LocalDateTime.now(), Duration.ofMinutes(9)));
		posteggio.inserisciMacchina(new InfoPosteggio("SD 5420B", LocalDateTime.now(), Duration.ofHours(48)));
		posteggio.inserisciMacchina(new InfoPosteggio("PF 1648F", LocalDateTime.now(), Duration.ofHours(13)));
		posteggio.inserisciMacchina(new InfoPosteggio("IO 7922F", LocalDateTime.now(), Duration.ofHours(4)));
		posteggio.inserisciMacchina(new InfoPosteggio("AB 4564E", LocalDateTime.now(), Duration.ofHours(2)));
		posteggio.inserisciMacchina(new InfoPosteggio("BE 4897F", LocalDateTime.now(), Duration.ofHours(6)));
		posteggio.inserisciMacchina(new InfoPosteggio("FG 7832G", LocalDateTime.now(), Duration.ofHours(1)));
		posteggio.inserisciMacchina(new InfoPosteggio("AF 8475P", LocalDateTime.now(), Duration.ofHours(24)));

		System.out.println("Posso ritirare \"AF 8475P\"? " + posteggio.ritiraMacchina("AF 8475P"));
		System.out.println("Posso aggiungere \"AF 8475P\"? "
				+ posteggio
						.inserisciMacchina(new InfoPosteggio("AF 8475P", LocalDateTime.now(), Duration.ofHours(24))));
		System.out.println("Posso ritirare \"AB 2013B\"? " + posteggio.ritiraMacchina("AB 2013B"));

		System.out.println("\nOrdine di uscita:");
		for (InfoPosteggio info : posteggio.getOrdineUscita()) {
			System.out.println(info);
		}
	}
}
