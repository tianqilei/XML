import javax.xml.parsers.*; 
import org.xml.sax.*; 
import org.xml.sax.helpers.*; 
import java.io.*; 

public class SAXTest {

	public static void main(String[] args) {
		System.out.print("Ficher XML: ");
		String fichier = lireString();
		parseSAX(fichier);
	}
	
	private static String lireString(){
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
   	    try {
	    	return in.readLine();
	    } catch (IOException e){
	    	return null;
	    }
	}
	
	/**
	 * @param fichier
	 * @return
	 */
	private static void parseSAX(String fichier){
		try{
			//création d'une fabrique de parseurs SAX
			SAXParserFactory fabrique = SAXParserFactory.newInstance();  
			fabrique.setValidating(true); //si l’on veut vérifier une DTD

			// création d'un parseur SAX
			SAXParser parseur = fabrique.newSAXParser();            
			
			// lecture d'un fichier XML avec un DefaultHandler 
			File xml = new File(fichier);
			DefaultHandler gestionnaire = new MonHandler(); 
			parseur.parse(xml, gestionnaire); 
		} catch(ParserConfigurationException pce){
		     System.out.println("Erreur de configuration du parseur SAX");
		} catch(SAXException se){
		     System.out.println("Erreur lors du parsing du document");
		} catch(IOException ioe){
		     System.out.println("Erreur d'entrée/sortie");
		}
	}
}
