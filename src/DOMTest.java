import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

public class DOMTest {

	public static void main(String[] args) {
		System.out.print("Ficher XML: ");
		String fichier = lireString();
		Document dom = parseDom(fichier);
		if (dom != null) {
			//get the first child element of the document
			Element racine = dom.getDocumentElement();

			// Calcul r®¶sultat
			// !ADAPTER au type de r®¶sultat et ®§ la liste de param®®tres
			int resultat = explorer(racine);
			double so = somme(racine);
			
			// double somme = somme(racine);
			// Affichage r®¶sultat
			// !ADAPTER ®§ l'affichage souhait®¶
			System.out.println("Le résultat est " + resultat);
			System.out.println("la somme est " + so);
			//titre(racine);
			text(racine);
		} else {
			System.out.println("dom est null");
		}
	}

	private static String lireString() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			return in.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * @param fichier
	 * @return
	 */
	private static Document parseDom(String fichier) {
		try {
			// cr®¶ation d'une fabrique de parseurs
			DocumentBuilderFactory fabrique = DocumentBuilderFactory
					.newInstance();
			// fabrique.setValidating(true); //si l°Øon veut v®¶rifier une DTD

			// cr®¶ation d'un parseur
			DocumentBuilder parseur = fabrique.newDocumentBuilder();

			// transformation d'un fichier XML en DOM
			File xml = new File(fichier);
			Document document = parseur.parse(xml);
			return document;

		} catch (ParserConfigurationException pce) {
			System.out.println("Erreur de configuration du parseur DOM");
		} catch (SAXException se) {
			System.out.println("Erreur lors du parsing du document");
		} catch (IOException ioe) {
			System.out.println("Erreur d'entrée/sortie");
		}
		return null;
	}

	// !ADAPTER au type de résultat et à la liste de paramètres
	private static int explorer(Node noeud) {
		// initialisation
		// !ADAPTER
		int resultat = 0;

		// traitement noeud courant
		// !ADAPTER
		if (noeud.getNodeType() == Node.ELEMENT_NODE) {
			// action pour les noeuds élément
			resultat += 1;
		} else {
			if(noeud.getNodeType() == Node.TEXT_NODE) {
				resultat += 1;
			}
		}
//parce que
		// parcours récursif
		if (noeud.hasChildNodes()) {
			NodeList enfants = noeud.getChildNodes();
			for (int i = 0; i < enfants.getLength(); i++) {
				// appel récursif
				// !ADAPTER
				int resenf = explorer(enfants.item(i));

				// combiner resenf avec resultat
				// !ADAPTER
				resultat += resenf;
			}
		}
		return resultat;
	}

	private static double somme(Element racine) {
		double total = 0.0;
		// NodeList n = racine.getChildNodes();
		NodeList m = racine.getElementsByTagName("montant");
		for (int i = 0; i < m.getLength(); i++) {
			Node noeud = m.item(i);
			Node parent = noeud.getParentNode();
			if (parent.getNodeName().equals("dépense")) {
				String val = noeud.getTextContent();
				total += Double.parseDouble(val);
			}
		}
		return total;
	}

	private static void titre(Element racine){
		NodeList m = racine.getElementsByTagName("titre");
		for(int i= 0 ; i < m.getLength() ; i++){
			Node noeud = m.item(i);
			Node parent = noeud.getParentNode();
			if(parent.getNodeName().equals("depeche")){
				System.out.println(noeud.getTextContent());
			}
		}
	}
	private static void text(Node noeud){
		System.out.println(noeud.getTextContent());
	}
}
