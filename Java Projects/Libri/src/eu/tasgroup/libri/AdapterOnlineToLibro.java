package eu.tasgroup.libri;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class AdapterOnlineToLibro extends AdapterToLibro {
	private Document document;

	public AdapterOnlineToLibro(DataSourceOnline source)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		String data = source.ottieniDati();
		document = builder.parse(new InputSource(new ByteArrayInputStream(data.getBytes())));
	}

	private Element getElement(String tag) {
		Node node = document.getDocumentElement().getElementsByTagName(tag).item(0);
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			return (Element) node;
		}
		return null;
	}

	@Override
	public void buildTitolo() {
		super.libro.setTitolo(getElement("titolo").getTextContent());
	}

	@Override
	public void buildEditore() {
		super.libro.setEditore(getElement("editore").getTextContent());
	}

	@Override
	public void buildAutore() {
		super.libro.setAutore(getElement("autore").getTextContent());
	}

	@Override
	public void buildPubblicazione() {
		String toParse = getElement("pubblicazione").getTextContent();
		LocalDate date = LocalDate.parse(toParse);
		super.libro.setPubblicazione(date);
	}

}
