package Vista;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import Controlador.Concesionario_CTRL;
import Controlador.DOM;
import Modelo.Concesionario;

public class main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		File f1 = new File("cotxes.xml");
		File f2 = new File("cotxes_Jorge_Beneyto_Castelló.xml");
		Concesionario_CTRL conce = new Concesionario_CTRL();
		Concesionario concesionario = null;
		Concesionario concesionario2 = null;
		Document doc = (Document) conce.recuperar(f1);
		concesionario = conce.llegir(doc);
		 
		System.out.println(concesionario);
		
		 DOM xtdom = new DOM();
	     Document doc2 = (Document) xtdom.XMLaDOM();
	     /*concesionario2.librosdeEjemplo(concesionario2);
	     conce.escriure(doc2, concesionario2);*/
	     conce.enmagatzemar(doc2, f2);
	}

}
