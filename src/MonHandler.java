import org.xml.sax.*;
import org.xml.sax.helpers.*;


public class MonHandler extends DefaultHandler {
	//	variables locales ("accumulateur")
	
	                    
	//constructeur
	public MonHandler(){
	  super();
	   //initialisation des variables locales
	}
	  
	//d�tection d'ouverture de balise
	@Override
	public void startElement(String uri, String localName, 
	                         String qName, Attributes attributes)
	                         throws SAXException{
		System.out.println("D�but Element :" + qName);
	}

	//d�tection de fin de balise
	@Override
	public void endElement(String uri, String localName, 
	                       String qName) throws SAXException{
		System.out.println("Fin Element :" + qName);
	}

	//	d�tection de caract�res
	@Override
	public void characters(char[] ch, int start, int length) 
	                       throws SAXException{
	   String texte = new String(ch,start,length);
	   System.out.println("TEXTE : " + texte);
	}

	//d�tection d�but document
	@Override
	public void startDocument() throws SAXException {
	   System.out.println("D�but de Document");
	}

	//d�tection fin document
	@Override
	public void endDocument() throws SAXException {
	   System.out.println("Fin de Document");
	}
}
