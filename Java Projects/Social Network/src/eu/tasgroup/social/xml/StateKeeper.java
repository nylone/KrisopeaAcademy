package eu.tasgroup.social.xml;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eu.tasgroup.social.backend.Commento;
import eu.tasgroup.social.backend.OperationException;
import eu.tasgroup.social.backend.Post;
import eu.tasgroup.social.backend.SocialNetwork;
import eu.tasgroup.social.backend.User;

public class StateKeeper {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");

	public static void saveState(SocialNetwork social) throws ParserConfigurationException, TransformerException {
		new File("C:\\social").mkdir();
		StreamResult output = new StreamResult("C:\\social\\dati.xml");
		Document documento = inizializzaDocument();
		serializza(documento, social);
		finalizzaDocument(documento, output);
	}

	public static SocialNetwork loadState()
			throws ParserConfigurationException, SAXException, IOException, OperationException {
		File percorso = new File("C:\\social\\dati.xml");
		if (!percorso.exists()) {
			return new SocialNetwork(16);
		}
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(percorso);

		int etàMinima = Integer.parseInt(document.getElementsByTagName("età").item(0).getTextContent());
		SocialNetwork network = new SocialNetwork(etàMinima);

		caricaUtenti(document, network);
		caricaAmici(document, network);
		caricaPost(document, network);

		return network;
	}

	private static void caricaUtenti(Document document, SocialNetwork network) throws OperationException {
		NodeList utenti = document.getElementsByTagName("utenti").item(0).getChildNodes();

		for (int i = 0; i < utenti.getLength(); i++) {
			Node nodo = utenti.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element utente = (Element) nodo;
				String username = utente.getElementsByTagName("username").item(0).getTextContent();
				String nome = utente.getElementsByTagName("nome").item(0).getTextContent();
				int età = Integer.parseInt(utente.getElementsByTagName("età").item(0).getTextContent());

				network.registrazione(username, nome, età);
			}
		}
	}

	private static void caricaAmici(Document document, SocialNetwork network) throws OperationException {
		NodeList relazioni = document.getElementsByTagName("relazioni").item(0).getChildNodes();

		for (int i = 0; i < relazioni.getLength(); i++) {
			Node nodo = relazioni.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element relazione = (Element) nodo;
				String username = relazione.getElementsByTagName("username").item(0).getTextContent();
				NodeList amici = relazione.getElementsByTagName("amici").item(0).getChildNodes();
				for (int j = 0; j < amici.getLength(); j++) {
					nodo = amici.item(j);
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						Element amico = (Element) nodo;
						String usernameAmico = amico.getTextContent();

						network.diventaAmico(username, usernameAmico);
					}
				}
			}
		}
	}

	private static void caricaPost(Document document, SocialNetwork network) throws OperationException {
		NodeList utenti = document.getElementsByTagName("posts").item(0).getChildNodes();

		for (int i = 0; i < utenti.getLength(); i++) {
			Node nodo = utenti.item(i);
			if (nodo.getNodeType() == Node.ELEMENT_NODE) {
				Element user = (Element) nodo;
				String username = user.getElementsByTagName("username").item(0).getTextContent();
				NodeList posts = user.getElementsByTagName("posts").item(0).getChildNodes();
				for (int j = 0; j < posts.getLength(); j++) {
					nodo = posts.item(j);
					if (nodo.getNodeType() == Node.ELEMENT_NODE) {
						Element postElement = (Element) nodo;
						String titolo = postElement.getElementsByTagName("titolo").item(0).getTextContent();
						String testo = postElement.getElementsByTagName("testo").item(0).getTextContent();
						LocalDateTime pubblicazione = LocalDateTime
								.parse(postElement.getElementsByTagName("pubblicazione").item(0).getTextContent(), df);
						boolean archiviato = Boolean
								.parseBoolean(postElement.getElementsByTagName("archiviato").item(0).getTextContent());
						Post post = new Post(titolo, testo, pubblicazione);

						NodeList commentiNodeList = postElement.getElementsByTagName("commenti").item(0)
								.getChildNodes();
						for (int k = 0; k < commentiNodeList.getLength(); k++) {
							nodo = commentiNodeList.item(k);
							if (nodo.getNodeType() == Node.ELEMENT_NODE) {
								Element commentoElement = (Element) nodo;
								String utente = commentoElement.getElementsByTagName("utente").item(0).getTextContent();
								String testoCommento = commentoElement.getElementsByTagName("testo").item(0)
										.getTextContent();
								User utenteCommento = network.autenticazione(utente);
								Commento commento = new Commento(utenteCommento, testoCommento);
								post.commenta(commento);
							}
						}
						if (archiviato)
							post.archivia();
						network.autenticazione(username).aggiungiPost(post);
					}
				}
			}
		}
	}

	private static void serializza(Document documento, SocialNetwork social) {
		Element root = documento.getDocumentElement();

		Element età = documento.createElement("età");
		Node etàMinimaNode = documento.createTextNode(Integer.toString(social.getEtàMinima()));
		età.appendChild(etàMinimaNode);

		Element utenti = documento.createElement("utenti");
		for (User user : social.getUtenti().values()) {
			Element userElement = documento.createElement("user");

			Element usernameElement = documento.createElement("username");
			Node usernameNode = documento.createTextNode(user.getUsername());
			usernameElement.appendChild(usernameNode);
			userElement.appendChild(usernameElement);

			Element nomeElement = documento.createElement("nome");
			Node nomeNode = documento.createTextNode(user.getNome());
			nomeElement.appendChild(nomeNode);
			userElement.appendChild(nomeElement);

			Element etàElement = documento.createElement("età");
			Node etàNode = documento.createTextNode(Integer.toString(user.getEtà()));
			etàElement.appendChild(etàNode);
			userElement.appendChild(etàElement);

			utenti.appendChild(userElement);
		}

		Element relazioni = documento.createElement("relazioni");
		for (User user : social.getUtenti().values()) {
			Element userElement = documento.createElement("user");

			Element usernameElement = documento.createElement("username");
			Node usernameNode = documento.createTextNode(user.getUsername());
			usernameElement.appendChild(usernameNode);
			userElement.appendChild(usernameElement);

			Element amiciElement = documento.createElement("amici");
			for (User amico : user.getAmici()) {
				Element amicoElement = documento.createElement("amico");
				Node amicoNode = documento.createTextNode(amico.getUsername());
				amicoElement.appendChild(amicoNode);
				amiciElement.appendChild(amicoElement);
			}
			userElement.appendChild(amiciElement);
			relazioni.appendChild(userElement);
		}

		Element posts = documento.createElement("posts");
		for (User user : social.getUtenti().values()) {
			Element userElement = documento.createElement("user");

			Element usernameElement = documento.createElement("username");
			Node usernameNode = documento.createTextNode(user.getUsername());
			usernameElement.appendChild(usernameNode);
			userElement.appendChild(usernameElement);

			Element postsElement = documento.createElement("posts");
			for (Post post : user.getPost()) {
				Element postElement = documento.createElement("post");

				Element titoloElement = documento.createElement("titolo");
				Node titoloNode = documento.createTextNode(post.getTitolo());
				titoloElement.appendChild(titoloNode);
				postElement.appendChild(titoloElement);

				Element testoElement = documento.createElement("testo");
				Node testoNode = documento.createTextNode(post.getTesto());
				testoElement.appendChild(testoNode);
				postElement.appendChild(testoElement);

				Element pubblicazioneElement = documento.createElement("pubblicazione");
				Node pubblicazioneNode = documento.createTextNode(post.getPubblicazione().format(df));
				pubblicazioneElement.appendChild(pubblicazioneNode);
				postElement.appendChild(pubblicazioneElement);

				Element archiviatoElement = documento.createElement("archiviato");
				Node archiviatoNode = documento.createTextNode(Boolean.toString(post.isArchiviato()));
				archiviatoElement.appendChild(archiviatoNode);
				postElement.appendChild(archiviatoElement);

				Element commentiElement = documento.createElement("commenti");
				for (Commento commento : post.getCommenti()) {
					Element commentoElement = documento.createElement("commento");

					Element utenteElement = documento.createElement("utente");
					Node utenteNode = documento.createTextNode(commento.getUtente().getUsername());
					utenteElement.appendChild(utenteNode);
					commentoElement.appendChild(utenteElement);

					Element testoCommentoElement = documento.createElement("testo");
					Node testoCommentoNode = documento.createTextNode(commento.getTesto());
					testoCommentoElement.appendChild(testoCommentoNode);
					commentoElement.appendChild(testoCommentoElement);
					commentiElement.appendChild(commentoElement);
				}
				postElement.appendChild(commentiElement);

				postsElement.appendChild(postElement);
			}
			userElement.appendChild(postsElement);
			posts.appendChild(userElement);
		}

		root.appendChild(età);
		root.appendChild(utenti);
		root.appendChild(relazioni);
		root.appendChild(posts);
	}

	private static Document inizializzaDocument() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation impl = builder.getDOMImplementation();
		return impl.createDocument(null, "SocialNetwork", null);
	}

	private static void finalizzaDocument(Document document, StreamResult output) throws TransformerException {
		DOMSource sorgente = new DOMSource(document);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "iso-8859-1");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(sorgente, output);
	}
}
