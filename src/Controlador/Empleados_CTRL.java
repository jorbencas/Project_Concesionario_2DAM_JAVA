package Controlador;

import java.util.ArrayList;

import org.w3c.dom.Element;

import Modelo.Apellido;
import Modelo.Constants;
import Modelo.Empleado;
import Modelo.Telefono;

public class Empleados_CTRL extends DOM {

	public static ArrayList<Empleado> llegir(Element el_empleado){
		Empleado empleadoinstancia = new Empleado();
		ArrayList<Empleado> empleado = new ArrayList<Empleado>();
		
		empleadoinstancia.setTipo(getAtributoEtiqueta(Constants.ET_EMPLEADO_TIPO,el_empleado));
		//empleadoinstancia.setId(Integer.parseInt(getAtributoEtiqueta(Constants.ET_EMPLEADO_ID,el_empleado)));
		empleadoinstancia.setNombre(getValorEtiqueta(Constants.ET_EMPLEADO_NOMBRE, el_empleado));
		Element apellidos = getElementEtiqueta(Constants.ET_APELLIDOS, el_empleado);
		empleadoinstancia.setApellido(llegirApellidos(apellidos));
		Element dni = getElementEtiqueta(Constants.ET_DNI, el_empleado);
		empleadoinstancia.setDni(getValorEtiqueta(Constants.ET_DNI, el_empleado));
		String cadena = getAtributoEtiqueta(Constants.ET_LETRA,dni);

		char letra = (char) cadena.charAt(0);//obtenemos la cadena del string obtenido anteriormente.
		System.out.println(letra);
		empleadoinstancia.setDni_letra(letra);
		Element telefonos = getElementEtiqueta(Constants.ET_TELEFONOS, el_empleado);
		empleadoinstancia.setTelefono(llegirtelefon(telefonos));
		empleadoinstancia.setTarjeta(getValorEtiqueta(Constants.ET_TARJETA, el_empleado));
		empleado.add(empleadoinstancia);
		return empleado;
		
	}
	
	public static Apellido llegirApellidos(Element el_apellidos){
		Apellido apellido = null;
		
		String Nombre = getValorEtiqueta(Constants.ET_PRIMER_APELLIDO,el_apellidos);
		String Apellido = getValorEtiqueta(Constants.ET_SEGUNDO_APELLIDO,el_apellidos);
		apellido = new Apellido(Nombre, Apellido);
		return apellido;
	}
	
	public static Telefono llegirtelefon(Element elem_telefonos){
		Telefono tlf = null;
		Element Mobil = getElementEtiqueta(Constants.ET_MOVIL, elem_telefonos); 
		Element Fijo = 	getElementEtiqueta(Constants.ET_FIX, elem_telefonos);
		String mobil = "";
		String fijo = "";
		
		if(Mobil != null){
			mobil = getValorEtiqueta(Constants.ET_MOVIL,elem_telefonos);
		}
		
		if(Fijo != null){
			fijo =  getValorEtiqueta(Constants.ET_FIX,elem_telefonos);
		}
		
		tlf = new Telefono(mobil,fijo);
		return tlf;
	}
}
