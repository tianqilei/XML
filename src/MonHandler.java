import org.xml.sax.*;
import org.xml.sax.helpers.*;


public class MonHandler extends DefaultHandler {
	//	variables locales ("accumulateur")
	
	                    
	//constructeur
	public MonHandler(){
	  super();
	   //initialisation des variables locales
	}
	  
	//détection d'ouverture de balise
	@Override
	public void startElement(String uri, String localName, 
	                         String qName, Attributes attributes)
	                         throws SAXException{
		System.out.println("DŽbut Element :" + qName);
	}

	//détection de fin de balise
	@Override
	public void endElement(String uri, String localName, 
	                       String qName) throws SAXException{
		System.out.println("Fin Element :" + qName);
	}

	//	détection de caractères
	@Override
	public void characters(char[] ch, int start, int length) 
	                       throws SAXException{
	   String texte = new String(ch,start,length);
	   System.out.println("TEXTE : " + texte);
	}

	//détection début document
	@Override
	public void startDocument() throws SAXException {
	   System.out.println("DŽbut de Document");
	}

	//détection fin document
	@Override
	public void endDocument() throws SAXException {
	   System.out.println("Fin de Document");
	}
}
