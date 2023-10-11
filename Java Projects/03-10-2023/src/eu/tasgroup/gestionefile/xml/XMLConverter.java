package eu.tasgroup.gestionefile.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLConverter {
	private static Document documentoXML;
	private static Element root;
	private static BufferedReader txtInput;
	private static StreamResult output;

	public static void main(String[] args) {
		new XMLConverter().convert();
	}

	private void convert() {
		try {
			String directory = "output";
			new File("C:\\Users\\ramponem\\Desktop\\xml\\" + directory).mkdir();
		
			txtInput = new BufferedReader(new FileReader("C:\\Users\\ramponem\\Desktop\\xml\\dati.txt"));
			output = new StreamResult("C:\\Users\\ramponem\\Desktop\\xml\\" + directory + "\\dati.xml");
			inizializzaDocument();
			String linea;
			while ((linea = txtInput.readLine()) != null) {
				elabora(linea);
			}
			txtInput.close();
			scriviFileXML();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	private void scriviFileXML() throws TransformerException {
		DOMSource sorgente = new DOMSource(documentoXML);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(sorgente, output);
		System.out.println("documento trasformato");
	}

	private void inizializzaDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation impl = builder.getDOMImplementation();
		documentoXML = impl.createDocument(null, "prodotti", null);
		root = documentoXML.getDocumentElement();
	}

	private void elabora(String linea) {
		String[] elementi = linea.split("\\;");
		Element e0 = documentoXML.createElement("prodotto");

		Element e1 = documentoXML.createElement("marca");
		Node n1 = documentoXML.createTextNode(elementi[0]);
		e1.appendChild(n1);

		Element e2 = documentoXML.createElement("modello");
		Node n2 = documentoXML.createTextNode(elementi[1]);
		e2.appendChild(n2);

		Element e3 = documentoXML.createElement("prezzo");
		Node n3 = documentoXML.createTextNode(elementi[2]);
		e3.appendChild(n3);

		e0.appendChild(e1);
		e0.appendChild(e2);
		e0.appendChild(e3);

		root.appendChild(e0);
	}
}
