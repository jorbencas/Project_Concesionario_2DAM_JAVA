/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author jorge
 */
public class DOM {
    
    public Document XMLaDOM() throws SAXException, IOException, ParserConfigurationException{
        Document documento = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        return documento;
    }
    
    public static Document XMLaDOM (File fxmlfile ) throws SAXException, IOException, ParserConfigurationException{ 
        Document doc = (Document) DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fxmlfile);
        doc.getDocumentElement().normalize();
        return doc;
    }
       
       public static void DOMaXML( Document doc, File file) throws TransformerException{
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
       }
       
       
    public static String getValorEtiqueta(String etiqueta, Element empleados) {
    	System.out.println(empleados);
    	Node value = empleados.getElementsByTagName(etiqueta).item(0);
        System.out.println(empleados.getElementsByTagName(etiqueta).item(0));
        //return value.getChildNodes().item(0).getNodeValue();
        return value.getChildNodes().item(0).getTextContent();
    }
    
    public static String getAtributoEtiqueta(String nomAtributo, Element elem) {
		return elem.getAttribute(nomAtributo);
	}
    
    public static Element getElementEtiqueta (String etiqueta, Element empleados) {
        return (Element) empleados.getElementsByTagName(etiqueta).item(0);
    }
    
}
