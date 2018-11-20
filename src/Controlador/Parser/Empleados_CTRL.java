package Controlador.Parser;

import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import Modelo.Apellido;
import Modelo.Concesionario;
import Modelo.Constants;
import Modelo.Empleado;
import Modelo.Telefono;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Empleados_CTRL extends DOM {

    public static ArrayList<Empleado> llegir(Element el_empleado) {
        Empleado empleadoinstancia = new Empleado();
        ArrayList<Empleado> empleado = new ArrayList<Empleado>();

        empleadoinstancia.setTipo(getAtributoEtiqueta(Constants.ET_EMPLEADO_TIPO, el_empleado));

        if (!empleadoinstancia.getTipo().equalsIgnoreCase("director")) {
            System.out.println(getAtributoEtiqueta(Constants.ET_EMPLEADO_ID, el_empleado));
            empleadoinstancia.setId(Integer.parseInt(getAtributoEtiqueta(Constants.ET_EMPLEADO_ID, el_empleado)));
        }

        empleadoinstancia.setNombre(getValorEtiqueta(Constants.ET_EMPLEADO_NOMBRE, el_empleado));
        Element apellidos = getElementEtiqueta(Constants.ET_APELLIDOS, el_empleado);
        empleadoinstancia.setApellido(llegirApellidos(apellidos));
        Element dni = getElementEtiqueta(Constants.ET_DNI, el_empleado);
        empleadoinstancia.setDni(getValorEtiqueta(Constants.ET_DNI, el_empleado));
        String cadena = getAtributoEtiqueta(Constants.ET_LETRA, dni);

        char letra = (char) cadena.charAt(0);//obtenemos la cadena del string obtenido anteriormente.
        //System.out.println(letra);
        empleadoinstancia.setDni_letra(letra);
        Element telefonos = getElementEtiqueta(Constants.ET_TELEFONOS, el_empleado);
        empleadoinstancia.setTelefono(llegirtelefon(telefonos));
        empleadoinstancia.setTarjeta(getValorEtiqueta(Constants.ET_TARJETA, el_empleado));
        empleado.add(empleadoinstancia);
        return empleado;

    }

    public static Apellido llegirApellidos(Element el_apellidos) {
        Apellido apellido = null;

        String Nombre = getValorEtiqueta(Constants.ET_PRIMER_APELLIDO, el_apellidos);
        String Apellido = getValorEtiqueta(Constants.ET_SEGUNDO_APELLIDO, el_apellidos);
        apellido = new Apellido(Nombre, Apellido);
        return apellido;
    }

    public static Telefono llegirtelefon(Element elem_telefonos) {
        Telefono tlf = null;
        //Element Mobil = getElementEtiqueta(Constants.ET_MOVIL, elem_telefonos);
        //Element Fijo = getElementEtiqueta(Constants.ET_FIJO, elem_telefonos);
         String mobil1 = "0";
         String mobil2 = "0";
         String fijo = "0";
          
        if(elem_telefonos.getElementsByTagName(Constants.ET_MOVIL).item(0) != null){
            mobil1 = elem_telefonos.getElementsByTagName(Constants.ET_MOVIL).item(0).getTextContent();
            System.out.println("Movil 1:" + mobil1);
        }
        
        if(elem_telefonos.getElementsByTagName(Constants.ET_MOVIL).item(1) !=null){
            mobil2 = elem_telefonos.getElementsByTagName(Constants.ET_MOVIL).item(1).getTextContent();
            System.out.println("Movil 2: " + mobil2);
        }

        if(elem_telefonos.getElementsByTagName(Constants.ET_FIJO).item(0) != null){
            fijo = elem_telefonos.getElementsByTagName(Constants.ET_FIJO).item(0).getTextContent();
            System.out.println("Fijo :" + fijo);
        }
        tlf = new Telefono(mobil1, mobil2, fijo);
        return tlf;
    }

    public static void escribir(Document doc, Element elem_concessionario, Concesionario conce) {
        Element empeados = doc.createElement(Constants.ET_EMPLEADOS);

        for (int i = 0; i < conce.getEmpleados().size(); i++) {

            Element empleado = doc.createElement(Constants.ET_EMPLEADO);
            Attr empleado_tipo = doc.createAttribute(Constants.ET_EMPLEADO_TIPO);
            Attr empleado_id = doc.createAttribute(Constants.ET_EMPLEADO_ID);

            empleado_tipo.setValue(conce.getEmpleados().get(i).getTipo());
            empleado.setAttributeNode(empleado_tipo);

            empleado.setAttributeNode(empleado_id);
            empleado_id.setValue(String.valueOf(conce.getEmpleados().get(i).getId()));

            Element empleadonombre = doc.createElement(Constants.ET_EMPLEADO_NOMBRE);
            empleadonombre.appendChild(doc.createTextNode(conce.getEmpleados().get(i).getNombre()));
            empleado.appendChild(empleadonombre);

            Element apellido = doc.createElement(Constants.ET_APELLIDOS);
            escriureapellidos(doc, apellido, conce.getEmpleados().get(i));
            empleado.appendChild(apellido);

            Element dni = doc.createElement(Constants.ET_DNI);
            dni.appendChild(doc.createTextNode(conce.getEmpleados().get(i).getDni()));

            Attr letra = doc.createAttribute(Constants.ET_LETRA);
            letra.setValue(String.valueOf(conce.getEmpleados().get(i).getDni_letra()));
            dni.setAttributeNode(letra);
            empleado.appendChild(dni);

            Element telefonos = doc.createElement(Constants.ET_TELEFONOS);
            escriuretelefonos(doc, telefonos, conce.getEmpleados().get(i));
            empleado.appendChild(telefonos);
            Element tarjeta = doc.createElement(Constants.ET_TARJETA);
            tarjeta.appendChild(doc.createTextNode(conce.getEmpleados().get(i).getTarjeta()));
            empleado.appendChild(tarjeta);

            empeados.appendChild(empleado);

        }

        elem_concessionario.appendChild(empeados);
    }

    public static void escriureapellidos(Document doc, Element elem_apellidos, Empleado empleadoinstancia) {

        Element primero = doc.createElement(Constants.ET_PRIMER_APELLIDO);
        primero.appendChild(doc.createTextNode(empleadoinstancia.getApellido().getPrimero()));
        elem_apellidos.appendChild(primero);

        Element segundo = doc.createElement(Constants.ET_SEGUNDO_APELLIDO);
        segundo.appendChild(doc.createTextNode(empleadoinstancia.getApellido().getSegundo()));
        elem_apellidos.appendChild(segundo);
    }

    public static void escriuretelefonos(Document doc, Element elem, Empleado empleadoinstancia) {

        Element telefono1 = doc.createElement(Constants.ET_TELEFONO);
        telefono1.appendChild(doc.createTextNode(empleadoinstancia.getTelefono().getTelefono1()));
        elem.appendChild(telefono1);

        Element telefono2 = doc.createElement(Constants.ET_TELEFONO);
        telefono2.appendChild(doc.createTextNode(empleadoinstancia.getTelefono().getTelefono2()));
        elem.appendChild(telefono2);

        Element fix = doc.createElement(Constants.ET_FIJO);
        fix.appendChild(doc.createTextNode(empleadoinstancia.getTelefono().getFijo()));
        elem.appendChild(fix);

    }
}
