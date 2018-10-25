package Controlador;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Modelo.Concesionario;
import Modelo.Constants;
import Modelo.Vehiculo;

public class Vemtas_CTRL extends DOM {

	public static ArrayList<Vehiculo> llegir(Element elem_vehiculo){
		Vehiculo Vehiculo = new Vehiculo();
		ArrayList<Vehiculo> vehiculo = new ArrayList<Vehiculo>();
		
		System.out.println("--------------------------------------------------------------------------------");
		Vehiculo.setTipo(getAtributoEtiqueta(Constants.ET_VEHICULO_TIPO, elem_vehiculo));
		System.out.println("Tipo:" + getAtributoEtiqueta(Constants.ET_VEHICULO_TIPO, elem_vehiculo));
		Vehiculo.setMatricula(getValorEtiqueta(Constants.ET_MATRICULA, elem_vehiculo));
		System.out.println("Matricula;" + Vehiculo.getMatricula());
		Vehiculo.setKilometros(Integer.parseInt(getValorEtiqueta(Constants.ET_KILOMETROS, elem_vehiculo)));
		Vehiculo.setPrecio(Integer.parseInt(getValorEtiqueta(Constants.ET_PRECIO, elem_vehiculo)));
		Vehiculo.setAny(Integer.parseInt(getValorEtiqueta(Constants.ET_AÑO, elem_vehiculo)));
		Vehiculo.setMarca(getValorEtiqueta(Constants.ET_MARCA, elem_vehiculo));
		//Vehiculo.setModelo(Integer.parseInt(getValorEtiqueta(Constants.ET_MODELO, elem_vehiculo)));
		Vehiculo.setEmpleado(Integer.parseInt(getValorEtiqueta(Constants.ET_EMPLEADO, elem_vehiculo)));
		
		vehiculo.add(Vehiculo);
		return vehiculo;
	}
	
	public static void escribir(Document doc, Element elem_concessionario, Concesionario conce){
		/*Element empleadonombre = doc.createElement(Constants.ET_EMPLEADO_NOMBRE);
		empleadonombre.appendChild(doc.createTextNode(conce.getEmpleados().get(i).getNombre()));
		empleado.appendChild(empleadonombre);*/
	}
}
