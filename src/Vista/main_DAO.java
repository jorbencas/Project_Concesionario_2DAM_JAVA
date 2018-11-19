/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DAO.Cargador_XML;
import Controlador.DAO.Conceionario_DAO;
import DAO.ConexionaDB;
import Modelo.Concesionario;
import Modelo.Empleado;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class main_DAO {

    public static void main(String[] args) {
        try {

            Cargador_XML xml = new Cargador_XML();
            ConexionaDB conexion_DB = null;
            Connection con = null;
            Concesionario concesionario = new Concesionario();
            Conceionario_DAO clientedao = null;
            int opcion = 777;
            int opcion2 = 777;
            int opcion1 = 0;
             String tipo = "";
             
             
             
            while (opcion != 0) {
                mostrarmenu();
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        concesionario = xml.cargador("cotxes.xml");
                        conexion_DB = new ConexionaDB();
                        System.out.println("Abrir conexion");
                        con = conexion_DB.abrirconexion();
                        System.out.println("conexion abierta");
                        break;
                    case 2:
                        System.out.println(concesionario.toString());
                        clientedao = new Conceionario_DAO();

                        for (int i = 0; i < concesionario.getEmpleados().size(); i++) {
                            if (clientedao.selecionarempleado(con, concesionario.getEmpleados().get(i)) == false) {
                                Empleado empleado = new Empleado();
                                empleado = concesionario.getEmpleados().get(i);
                                clientedao.crearempleado(con, empleado);
                            } else {
                                System.out.println("No se va ha insertar ningun empleado, ya que ya existe!!!");
                            }
                        }

                        for (int i = 0; i < concesionario.getVentas().size(); i++) {
                            if (clientedao.selecionarvehiculo(con, concesionario.getVentas().get(i)) == false) {
                                Vehiculo vantas = new Vehiculo();
                                vantas = concesionario.getVentas().get(i);
                                clientedao.crearvehiculo(con, vantas);
                            } else {
                                System.out.println("No se va ha insertar ningun vehiculo, ya que ya existe!!");
                            }

                        }
                        break;
                    case 3:
                        mostraropciones();
                        Scanner teclado1 = new Scanner(System.in);
                        opcion1 = teclado1.nextInt();
                        System.out.println("Eligue una opción: ");
                       
                        if (opcion1 == 1) {
                            tipo = "Empleado";
                        } else if (opcion1 == 2) {
                            tipo = "Vehiculo";
                        }

                        while (opcion2 != 5) {
                            mostrarmenucrud(tipo);
                            Scanner teclado2 = new Scanner(System.in);
                            opcion2 = teclado2.nextInt();
                            System.out.println("Eligue una opción: ");
                            switch (opcion2) {
                                case 1:
                                    if ( tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de crear");
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de crear");
                                    }
                                    break;
                                case 2:
                                    if ( tipo == "Empleado") {
                                       System.out.println("Hola " + tipo + " estas realizando la opcion de ");
                                    } else if (tipo == "Vehiculo") {
                                       System.out.println("Hola " + tipo + " estas realizando la opcion de ");
                                    }
                                    break;
                                case 3:
                                    if ( tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de Actualizar");
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de Actualizar");
                                    }
                                    break;
                                case 4:
                                    if ( tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de borrar");
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de borrar");
                                    }
                                    break;
                                default:
                                    System.out.println("Adios");
                                    break;
                            }
                        }

                        /* Cliente_DAO clientedao = new Cliente_DAO();
            
                            Cliente clienteinsert = new Cliente(88,"Alex","Ramiro","gines","Aleragi","4022");
                            //clientedao.crear(con, clienteinsert);
            
                            Cliente clienteupdate = new Cliente(14,"Andres","Ramiro","Pajares","Andrapa","1234");
                            clienteupdate.setMoroso(true);
                            // clientedao.actualitza(con, clienteupdate);
                            // clientedao.findByDNI(con, clienteupdate);
                            clientedao.findByNick(con, clienteupdate);

                            Cliente clientedelete = new Cliente();
                            clientedelete.setDNI(89);
                            clientedao.borrarempleado(con, clientedelete);
                        
                         */
                        break;
                    case 4:
                        System.out.println("cerrar conexión");
                        conexion_DB.cerrarconexion(con);
                        System.out.println("Conexión cerrada");
                        break;
                    default:
                        System.out.println("Adios");
                        System.exit(0);
                        ;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void mostrarmenu() {
        System.out.println("1 - Abriendo la conexión a la base de datos");
        System.out.println("2 - Obtenendo datos de la base de datos y guardado los como objetos en las clases");
        System.out.println("3 - Operaciones CRUD");
        System.out.println("4 - cERRANDO CONEXIÓN A LA BASE DE DATOS");
    }

    static void mostrarmenucrud(String tipo) {
        System.out.println("1 - Crear un " + tipo);
        System.out.println("2 - leer un " + tipo);
        System.out.println("3 - Acturalizar un " + tipo);
        System.out.println("4 - Borrar un " + tipo);
        System.out.println("5 - Salir");
    }

    private static void mostraropciones() {
         System.out.println("1 - Empleado");
         System.out.println("2 - Vehiculo");
    }
}
