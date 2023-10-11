package eu.tasgroup.libri;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) {
		{
			DataSourceOnline source = new DataSourceOnline("libro1");
			AdapterOnlineToLibro adapter;
			try {
				adapter = new AdapterOnlineToLibro(source);
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
				return;
			}
			FabbricaLibro fabbrica = new FabbricaLibro(adapter);
			fabbrica.buildLibro();
			Libro libro = fabbrica.getLibro();
			System.out.println(libro);
		}
		{
			DataSourceOffline source = new DataSourceOffline("libro2");
			AdapterOfflineToLibro adapter = new AdapterOfflineToLibro(source);
			FabbricaLibro fabbrica = new FabbricaLibro(adapter);
			fabbrica.buildLibro();
			Libro libro = fabbrica.getLibro();
			System.out.println(libro);
		}
	}
}
