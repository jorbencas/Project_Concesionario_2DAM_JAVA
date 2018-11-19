package Controlador;

import java.util.ArrayList;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Modelo.Concesionario;
import Modelo.Constants;
import Modelo.Empleado;
import Modelo.Vehiculo;

public class Vemtas_CTRL extends DOM {

	public static ArrayList<Vehiculo> llegir(Element elem_vehiculo){
		Vehiculo Vehiculo = new Vehiculo();
		ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
		
		System.out.println("--------------------------------------------------------------------------------");
		Vehiculo.setTipo(getAtributoEtiqueta(Constants.ET_VEHICULO_TIPO, elem_vehiculo));
		System.out.println("Tipo:" + getAtributoEtiqueta(Constants.ET_VEHICULO_TIPO, elem_vehiculo));
		Vehiculo.setMatricula(getValorEtiqueta(Constants.ET_MATRICULA, elem_vehiculo));
		System.out.println("Matricula: " + Vehiculo.getMatricula());
		Vehiculo.setKilometros(Integer.parseInt(getValorEtiqueta(Constants.ET_KILOMETROS, elem_vehiculo)));
		Vehiculo.setPrecio(Integer.parseInt(getValorEtiqueta(Constants.ET_PRECIO, elem_vehiculo)));
		Vehiculo.setAny(Integer.parseInt(getValorEtiqueta(Constants.ET_AnyO, elem_vehiculo)));
		Vehiculo.setMarca(getValorEtiqueta(Constants.ET_MARCA, elem_vehiculo));
		Vehiculo.setModelo(getValorEtiqueta(Constants.ET_MODELO, elem_vehiculo));
		Vehiculo.setEmpleado(Integer.parseInt(getValorEtiqueta(Constants.ET_EMPLEADO, elem_vehiculo)));
		
		vehiculo.add(Vehiculo);
		return vehiculo;
	}
	
	public static void escribir(Document doc, Element elem_concessionario, Concesionario conce){
		Element ventas = doc.createElement(Constants.ET_VENTAS);
		
		for(int i = 0; i < conce.getVentas().size(); i++){
			Element vehiculo = doc.createElement(Constants.ET_VEHICULO);
			vehiculo.appendChild(doc.createTextNode(conce.getEmpleados().get(i).getNombre()));
			ventas.appendChild(vehiculo);
			
			Attr vehiculo_tipo = doc.createAttribute(Constants.ET_EMPLEADO_ID);
			vehiculo_tipo.setValue(conce.getVentas().get(i).getTipo());
			vehiculo.setAttributeNode(vehiculo_tipo);
			
			escriurevehiculo(doc,vehiculo, conce.getVentas().get(i));
			
		}
		elem_concessionario.appendChild(ventas);
	}
	
	public static void escriurevehiculo(Document doc, Element vehiculo, Vehiculo vehiculoinstancia){
		Element matricula = doc.createElement(Constants.ET_MATRICULA);
		matricula.appendChild(doc.createTextNode(vehiculoinstancia.getMatricula()));
		vehiculo.appendChild(matricula);
		
		Element kilometros = doc.createElement(Constants.ET_KILOMETROS);
		kilometros.appendChild(doc.createTextNode(String.valueOf(vehiculoinstancia.getKilometros())));
		vehiculo.appendChild(kilometros);
		
		Element precio = doc.createElement(Constants.ET_PRECIO);
		precio.appendChild(doc.createTextNode(String.valueOf(vehiculoinstancia.getPrecio())));
		vehiculo.appendChild(precio);
		
		Element any = doc.createElement(Constants.ET_AnyO);
		any.appendChild(doc.createTextNode(String.valueOf(vehiculoinstancia.getAny())));
		vehiculo.appendChild(any);
		
		Element marca = doc.createElement(Constants.ET_MARCA);
		marca.appendChild(doc.createTextNode(vehiculoinstancia.getMarca()));
		vehiculo.appendChild(marca);
		
		Element modelo = doc.createElement(Constants.ET_MODELO);
		modelo.appendChild(doc.createTextNode(String.valueOf(vehiculoinstancia.getModelo())));
		vehiculo.appendChild(modelo);
		
		Element empleado = doc.createElement(Constants.ET_EMPLEADO);
		empleado.appendChild(doc.createTextNode(String.valueOf(vehiculoinstancia.getEmpleado())));
		vehiculo.appendChild(empleado);
		
	}
	
}
