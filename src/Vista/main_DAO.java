/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.DAO.Concesionario_DAO;
import Controlador.DAO.Empleado_DAO;
import Controlador.DAO.Vehiculo_DAO;
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
            Concesionario_DAO cargaDAO = new Concesionario_DAO();
            ConexionaDB conexion_DB = null;
            Connection con = null;
            Concesionario concesionario = new Concesionario();
            int opcion = 777;
           
            while (opcion != 0) {
                mostrarmenu();
                Scanner teclado = new Scanner(System.in);
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1:
                        concesionario = cargaDAO.cargador("cotxes.xml");
                        break;
                    case 2:
                        con = cargaDAO.cargamasiva(con, concesionario);
                        break;
                    case 3:
                        menuCRUD(con);
                        break;
                    case 4:
                        System.out.println("cerrar conexión");
                        conexion_DB.cerrarconexion(con);
                        System.out.println("Conexión cerrada");
                        break;
                    default:
                        System.out.println("Adios");
                        System.exit(0);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void mostrarmenu() {
        System.out.println("1 - Cargar de xml a objeto y abriendo la conexión a la base de datos");
        System.out.println("2 - Pasar de objeto a Base de datos");
        System.out.println("3 - Operaciones CRUD");
        System.out.println("4 - Cerrando a conexión a la base de datos");
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
    
    static void menuCRUD(Connection con) throws Exception{
         int opcion2 = 777;
            int opcion1 = 0;
            String tipo = "";
            Empleado_DAO emp = new Empleado_DAO();
            Vehiculo_DAO venta = new Vehiculo_DAO();
            Empleado empleado = null;
            Vehiculo vehiculo = null;
            
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
                            String elección = "";
                            mostrarmenucrud(tipo);
                            Scanner teclado2 = new Scanner(System.in);
                            opcion2 = teclado2.nextInt();
                            System.out.println("Eligue una opción: ");
                            switch (opcion2) {
                                case 1:
                                    if (tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de crear");
                                        System.out.println("Escribe el dni del empleado");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        empleado = new Empleado();
                                        empleado.setDni(elección);
                                        emp.crearempleado(con, empleado);
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de crear");
                                        System.out.println("Escribe la matricula del vehiculo");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        vehiculo = new Vehiculo();
                                        vehiculo.setMatricula(elección);
                                        venta.crearvehiculo(con, vehiculo);
                                    }
                                    break;
                                case 2:
                                    if (tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de ");
                                        emp.selecionarempleados(con);
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de ");
                                        venta.selecionarvehiculos(con);
                                    }
                                    break;
                                case 3:
                                    if (tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de Actualizar");
                                        System.out.println("Escribe el dni del empleado");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        if (emp.findByDNI(con, elección) != null) {
                                            empleado = new Empleado();
                                            empleado.setDni(elección);
                                            emp.actualitza(con, empleado);
                                            System.out.println("empleado actualizado");
                                        }
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de Actualizar");
                                        System.out.println("Escribe la matricula del vehiculo");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        if (venta.findbyMatricula(con, elección) != null) {
                                            vehiculo = new Vehiculo();
                                            vehiculo.setMatricula(elección);
                                            venta.actualitza(con, vehiculo);
                                            System.out.println("Vehiculo actualizado");
                                        }
                                    }
                                    break;
                                case 4:
                                    if (tipo == "Empleado") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de borrar");
                                        System.out.println("Escribe el dni del empleado");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        if (emp.findByDNI(con, elección) != null) {
                                            empleado = new Empleado();
                                            empleado.setDni(elección);
                                            emp.borrarempleado(con, empleado);
                                            System.out.println("empleado borrado");
                                        }
                                    } else if (tipo == "Vehiculo") {
                                        System.out.println("Hola " + tipo + " estas realizando la opcion de borrar");
                                        System.out.println("Escribe la matricula del vehiculo");
                                        Scanner tecladoec = new Scanner(System.in);
                                        elección = tecladoec.nextLine();
                                        if (venta.findbyMatricula(con, elección) != null) {
                                            vehiculo = new Vehiculo();
                                            vehiculo.setMatricula(elección);
                                            venta.borrarvehiculo(con, vehiculo);
                                            System.out.println("Vehiculo borrado");
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Adios");
                                    break;
                            }
                        }
    }
}
