/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Apellido;
import Modelo.Empleado;
import Modelo.Telefono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Empleado_DAO {

    public void crearempleado(Connection con, Empleado empleado) throws Exception {
        PreparedStatement stmt = null;
        Empleado_DAO emp = new Empleado_DAO();
        //System.out.println(empleado.toString());

        try {
            stmt = con.prepareStatement("INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, empleado.getTipo());
            System.out.println("empleado tipo" + empleado.getTipo());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido().getPrimero());
            stmt.setString(4, empleado.getApellido().getSegundo());
            if(emp.findByDNI(con, empleado.getDni()) == null){
                stmt.setString(5, empleado.getDni());
            }
            stmt.setString(6, String.valueOf(empleado.getDni_letra()));
            stmt.setString(7, empleado.getTelefono().getTelefono1());
            stmt.setString(8, empleado.getTelefono().getTelefono2());
            stmt.setString(9, empleado.getTelefono().getFijo());
            stmt.setString(10, empleado.getTarjeta());

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al insertar empleado " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public Empleado selecionarempleado(Connection con, Empleado empleado) throws Exception {
        Empleado empleado1 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM empleado WHERE id=?");
            stmt.setInt(1, empleado.getId());
            rs = stmt.executeQuery();
            while (rs.next()) {
                empleado1 = new Empleado();
                obtenEmpleadoFila(rs, empleado1);
                System.out.println("Emp: " + empleado1.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por Nick " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return empleado1;
    }

    public ArrayList<Empleado> selecionarempleados(Connection con) throws Exception {
        ArrayList<Empleado> empleado1 = new ArrayList<Empleado>();
        Empleado empleadonuevo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM empleado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                empleadonuevo = new Empleado();
                obtenEmpleadoFila(rs, empleadonuevo);
                System.out.println("Emp: " + empleadonuevo.toString());
                empleado1.add(empleadonuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por Nick " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return empleado1;
    }

    private void obtenEmpleadoFila(ResultSet rs, Empleado empleado) throws Exception {
        empleado.setTipo(rs.getString("tipo"));
        empleado.setNombre(rs.getString("nombre"));
        Apellido apellido = new Apellido(rs.getString("primer_apellido"), rs.getString("segundo_apellido"));
        empleado.setApellido(apellido);
        empleado.setDni(rs.getString("dni"));
        char letra = (char) rs.getString("letra").charAt(0);
        System.out.println("letra dni: " + letra);
        empleado.setDni_letra(letra);
        Telefono telefono = new Telefono(rs.getString("movil_1"), rs.getString("movil_2"), rs.getString("fijo"));
        empleado.setTelefono(telefono);
        empleado.setTarjeta(rs.getString("tarjeta"));
    }

    public Empleado findByDNI(Connection con, String dni) throws Exception {
        Empleado empleadoencontrado = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM empleado WHERE dni=?");
            stmt.setString(1, dni);
            rs = stmt.executeQuery();

            while (rs.next()) {
                empleadoencontrado = new Empleado();
                obtenEmpleadoFila(rs, empleadoencontrado);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("problema al buscar por DNI " + ex.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        System.out.println("El nuevo empleado: " + empleadoencontrado.toString());
        return empleadoencontrado;
    }

    public void actualitza(Connection con, Empleado empleado) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE empleado SET tipo=?, nombre=?, primer_apellido=?, segundo_apellido=?, movil_1=?, movil_2=?,fijo=?,tarjeta=? WHERE dni=?");
            stmt.setString(1, empleado.getTipo());
            System.out.println("empleado tipo" + empleado.getTipo());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido().getPrimero());
            stmt.setString(4, empleado.getApellido().getSegundo());
            stmt.setString(7, empleado.getTelefono().getTelefono1());
            stmt.setString(8, empleado.getTelefono().getTelefono2());
            stmt.setString(9, empleado.getTelefono().getFijo());
            stmt.setString(10, empleado.getTarjeta());
            stmt.setString(8, empleado.getDni());
            stmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al actualizar cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public boolean borrarempleado(Connection con, Empleado empleado) throws Exception {
        boolean empleadoencontrado = false;
        PreparedStatement stmt = null;
        String opcion = "";
        try {
            stmt = con.prepareStatement("DELETE FROM empleado WHERE dni LIKE ? ");
            stmt.setString(1, empleado.getDni());
            System.out.println("Estas completamente seguro que quieres borar al empleado Y/N");
            Scanner teclado2 = new Scanner(System.in);
            opcion = String.valueOf(teclado2.nextInt());

            if (opcion.equals("Y")) {
                stmt.execute();
                empleadoencontrado = true;
            } else if (opcion.equals("N")) {
                System.out.println("Ok de acuerdo otra vez será");
                empleadoencontrado = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al borrar cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        return empleadoencontrado;
    }

}
