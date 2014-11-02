import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DOM {
	Document document;
	public DOM() {
		DocumentBuilderFactory fabrique = DocumentBuilderFactory.newInstance();
		// fabrique.setValidating(true);
		DocumentBuilder parseur;
		try {
			parseur = fabrique.newDocumentBuilder();
			File xml = new File("flux.xml");
			document = parseur.parse(xml);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double somme(Element racine) {
		double total = 0.0;
		NodeList m = racine.getElementsByTagName("contenu");
		for (int i = 0; i < m.getLength(); i++) {
				Node montant = m.item(i);
				Node parant = montant.getParentNode();
				if(parant.getNodeName().equals("depeche")){
					String val = montant.getTextContent();
					total +=Double.parseDouble(val);
					}
		}
		return total;
	}
	Element getRacine(){
		return document.getDocumentElement();
	}
	public int explorer(Node noeud){
		int resultat = 0;
		if(noeud.getNodeType() == Node.ELEMENT_NODE){
			resultat++;
		}
		if(noeud.hasChildNodes()){
			NodeList enfants = noeud.getChildNodes();
			for(int i=0;i<enfants.getLength();i++){
				int resenf = explorer(enfants.item(i));
				resultat += resenf;
			}	
 		}
		return resultat;
	}
}
