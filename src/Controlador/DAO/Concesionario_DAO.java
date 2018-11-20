/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Controlador.Parser.Concesionario_CTRL;
import Modelo.Concesionario;
import Modelo.Empleado;
import Modelo.Vehiculo;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author jorge
 */
public class Concesionario_DAO {

    Concesionario_CTRL conce = new Concesionario_CTRL();
    Document doc = null;

    public Concesionario_DAO() {
    }

    public Concesionario cargador(String file) throws SAXException, IOException, ParserConfigurationException {
        doc = conce.recuperar(new File(file));
        return conce.llegir(doc);
    }

    public Connection cargamasiva(Connection con, Concesionario concesionario) throws Exception {

        Empleado empleado = null;
        Empleado_DAO emp = new Empleado_DAO();
        Vehiculo_DAO venta = new Vehiculo_DAO();
        DAO.ConexionaDB conexion_DB = new DAO.ConexionaDB();
        System.out.println("Abrir conexion");
        con = conexion_DB.abrirconexion();
        System.out.println("conexion abierta");

        System.out.println("\n\n////////EMPLEADOS///////////\n\n");
        for (int i = 0; i < concesionario.getEmpleados().size(); i++) {
            empleado = new Empleado();
            empleado = concesionario.getEmpleados().get(i);
            emp.crearempleado(con, empleado);
        }
        
        System.out.println("\n\n////////VEHICULOS///////////\n\n");
        for (int i = 0; i < concesionario.getVentas().size(); i++) {
            Vehiculo vantas = new Vehiculo();
            vantas = concesionario.getVentas().get(i);
            venta.crearvehiculo(con, vantas);
        }

        return con;
    }
}
