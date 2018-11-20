package Controlador.Parser;

import Controlador.Parser.Vehiculos_CTRL;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.Apellido;
import Modelo.Concesionario;
import Modelo.Constants;
import Modelo.Empleado;
import Modelo.Telefono;
import Modelo.Vehiculo;

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

	public Document recuperar() throws SAXException, IOException, ParserConfigurationException{
		Document doc = (Document) DOM.XMLaDOM();
		return doc;
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
		conce.setTelefono(getValorEtiqueta(Constants.ET_TELEFONO,elmconce));
		Element empeados =  getElementEtiqueta(Constants.ET_EMPLEADOS,elmconce);
		NodeList listempleados = empeados.getChildNodes();
		
		for (int i = 0; i < listempleados.getLength(); i++) {
			if(listempleados.item(i).getNodeType() == Node.ELEMENT_NODE){
				conce.setEmpleados(Empleados_CTRL.llegir((Element) listempleados.item(i)));
			}
		}
		
		Element ventas = getElementEtiqueta(Constants.ET_VENTAS,elmconce);
		NodeList listVehiculos = ventas.getChildNodes();
		for (int i = 0; i < listVehiculos.getLength(); i++) {
			if(listVehiculos.item(i).getNodeType() == Node.ELEMENT_NODE){
				//System.out.println("...................................");
				conce.setVentas(Vehiculos_CTRL.llegir((Element) listVehiculos.item(i)));
			}
		}
		
		return conce;
		
	}
	
	public void enmagatzemar(Document doc, File file) throws TransformerException{
		DOM.DOMaXML(doc,file);
	}
	
	public void escriure(Document doc, Concesionario conce){
		
		Element elmconce = doc.createElement(Constants.ET_CONCESIONARIO);
		
		Element elmnombre = doc.createElement(Constants.ET_NOMBRE);
		elmnombre.appendChild(doc.createTextNode(conce.getNom_conc()));
		elmconce.appendChild(elmnombre);
		
		Element	elmciudad = doc.createElement(Constants.ET_CIUDAD);
		elmciudad.appendChild(doc.createTextNode(conce.getCiudad()));
		elmconce.appendChild(elmciudad);
		

		Element elemtel = doc.createElement(Constants.ET_TELEFONO);
		elemtel.appendChild(doc.createTextNode(String.valueOf(conce.getTelefono())));
		elmconce.appendChild(elemtel);
		
		Empleados_CTRL.escribir(doc, elmconce, conce);
		Vehiculos_CTRL.escribir(doc, elmconce, conce);
		
		doc.appendChild(elmconce);
	}
	
	public Concesionario ConcesionariosdeEjemplo(Concesionario conce){
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<Vehiculo> ventas = new ArrayList<Vehiculo>();
		
		Vehiculo vehiculoinstancia = new Vehiculo( "turismo",  "45f9kgp",350, 12500, 2005,  "Wolksvagen","58",2);
		ventas.add(vehiculoinstancia);
		
		Empleado empleadoinstancia = new Empleado("Fijo", 2, "Perico", "48605737", 'P', "Individual");
		empleadoinstancia.setApellido(new Apellido("Ferrer", "Tortosa"));
		empleadoinstancia.setTelefono( new Telefono("962913378","962584963","2365974158"));
		empleados.add(empleadoinstancia);
		
		conce = new Concesionario("Concesiion SL", "Ontinyent", "962913378", empleados,ventas);
		
		return conce;
	}
	
}
