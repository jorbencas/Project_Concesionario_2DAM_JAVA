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
import Modelo.Concesionario;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException, TransformerException {
            // TODO Auto-generated method stub
            int opcion = 777;
            String ruta = "";
            File f2 = new File("cotxes_Jorge_Beneyto_Castell�.xml");
            Concesionario_CTRL conce = new Concesionario_CTRL();
            Concesionario concesionario = new Concesionario();
            Concesionario concesionario2 = new Concesionario();
            Document doc = null;
            Document doc2 = null;        
            Scanner teclado = new Scanner(System.in);
            while (opcion != 0) {
                mostrarMenu();
                opcion = teclado.nextInt();
                teclado.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Introduzca ruta del fichero xml o dejalo en blanco en tal caso se utilizara la ruta por defecto");
                        ruta = teclado.nextLine();
                        if (ruta.length() == 0) {
                            ruta = "cotxes.xml";
                        }
                         doc =  conce.recuperar(new File(ruta));
                        break;

                    case 2:
                        concesionario = conce.llegir(doc);
                        break;

                    case 3:
                        System.out.println(concesionario);
                        break;

                    case 4:
                        doc2 = (Document) conce.recuperar();
                        conce.escriure(doc2,conce.ConcesionariosdeEjemplo(concesionario2) );
                        break;

                    case 5:
                        conce.enmagatzemar(doc2, f2);
                        muestraFichero(f2);
                        break;
                }
            }
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

        static void mostrarMenu (){
            System.out.println("1.- Seleccionar un fichero xml a recuperar y crea un document");
            System.out.println("2.- Lee del documento y crea un objeto Resultado");
            System.out.println("3.-Muestra el objeto Resultado");
            System.out.println("4.-Crea un objeto resultado dando de alta un par de locales con sus licencias y escribe en un documento vacio ");
            System.out.println("5.-Guardado en copia.xml");
        }
}
