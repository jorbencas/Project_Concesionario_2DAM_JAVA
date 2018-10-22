package Controlador;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Concesionario;
import Modelo.Constants;

public class Concesionario_CTRL extends DOM {

	private File file;
	private Concesionario conce;
	
	public Concesionario_CTRL() {
		// TODO Auto-generated constructor stub
		conce = new Concesionario();
	}
	
	public Concesionario_CTRL(File file, Concesionario conce) {
		this.file = file;
		this.conce = conce;
	}

	public Concesionario_CTRL(Concesionario conce) {
		this.conce = conce;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Document recuperar(File file) throws SAXException, IOException, ParserConfigurationException{
		Document doc = null;
		 doc = (Document) DOM.XMLaDOM(file);
		return doc;
	}
	
	public static Concesionario llegir(Document doc){
		Concesionario conce = new Concesionario();
		Element elmconce = doc.getDocumentElement();
		conce.setNom_conc(getValorEtiqueta(Constants.ET_NOMBRE,elmconce));
		conce.setCiudad(getValorEtiqueta(Constants.ET_CIUDAD,elmconce));
		conce.setTelefono(Integer.parseInt(getValorEtiqueta(Constants.ET_TELEFONO,elmconce)));
		Element empeados =  getElementEtiqueta(Constants.ET_EMPLEADOS,elmconce);
		NodeList listempleados = empeados.getChildNodes();
		
		for (int i = 0; i < listempleados.getLength(); i++) {
			if(listempleados.item(i).getNodeType() == Node.ELEMENT_NODE){
				conce.setEmpleados(Empleados_CTRL.llegir((Element) listempleados.item(i)));
			}
		}
		return conce;
		
	}
	
	public void enmagatzemar(Document doc, File file) throws TransformerException{
		DOM.DOMaXML(doc,file);
	}
	/*
	public static escriure(){
		
	}*/
}
