package Vista;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
		Concesionario concesionario = new Concesionario();
		Concesionario concesionario2 = new Concesionario();
		Document doc = (Document) conce.recuperar(f1);
		concesionario = conce.llegir(doc);
		 
		System.out.println(concesionario);
		
		Document doc2 = (Document) conce.recuperar();
	    conce.escriure(doc2,conce.ConcesionariosdeEjemplo(concesionario2) );
	    conce.enmagatzemar(doc2, f2);
	    muestraFichero(f2);
	}
	
	static void muestraFichero(File archivo) {

        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
