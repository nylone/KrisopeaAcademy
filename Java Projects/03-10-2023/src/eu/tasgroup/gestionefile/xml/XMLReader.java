package eu.tasgroup.gestionefile.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReader {
	public static void main(String[] args) {
		try {
			File percorso = new File("C:\\Users\\ramponem\\Desktop\\xml\\output\\dati.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(percorso);

			System.out.println("Root: " + document.getDocumentElement().getNodeName());
			
			NodeList listaNodi = document.getElementsByTagName("prodotto");
			
			for (int i = 0; i < listaNodi.getLength(); i++) {
				Node nodo = listaNodi.item(i);
				System.out.println("\nelemento: " + nodo.getNodeName());
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) nodo;
					System.out.println("Marca " + elemento.getElementsByTagName("marca").item(0).getTextContent());
					System.out.println("Modello " + elemento.getElementsByTagName("modello").item(0).getTextContent());
					System.out.println("Prezzo " + elemento.getElementsByTagName("prezzo").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
