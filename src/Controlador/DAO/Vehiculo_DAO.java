/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

import Modelo.Empleado;
import Modelo.Vehiculo;
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
public class Vehiculo_DAO {

    public void crearvehiculo(Connection con, Vehiculo vehiculo) throws Exception {
        PreparedStatement stmt = null;
        Empleado_DAO emp = new Empleado_DAO();
        //System.out.println(vehiculo.toString());
        try {
            stmt = con.prepareStatement("INSERT INTO vehiculo VALUES (?,?,?,?,?,?,?,?)");
            stmt.setString(1, vehiculo.getMatricula());
            stmt.setString(2, vehiculo.getTipo());
            System.out.println("Matricula vehiculo" + vehiculo.getMatricula());
            stmt.setInt(3, vehiculo.getKilometros());
            stmt.setInt(4, vehiculo.getPrecio());
            stmt.setInt(5, vehiculo.getAny());
            stmt.setString(6, vehiculo.getMarca());
            stmt.setString(7, vehiculo.getModelo());
            
            ArrayList<Empleado> empleados = emp.selecionarempleados(con);
            for(int i = 0; i < empleados.size(); i++){
                Empleado empleado2 = new Empleado();
                System.out.println("Tipo de empleado: " + empleado2.getTipo());
                empleado2 = empleados.get(i);
                System.out.println("empleado id : " + empleado2.getId());
                
                //if ( empleado2.getId() == vehiculo.getEmpleado()) {
                    vehiculo.setEmpleado(empleado2.getId());
                    stmt.setInt(8, vehiculo.getEmpleado());
               // }
            }
            
            stmt.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al insertar cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

    }

    public Vehiculo selecionarvehiculo(Connection con, Vehiculo vehiculo) throws Exception {
        Vehiculo vehiculo1 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM vehiculo WHERE matricula=?");
            stmt.setString(1, vehiculo.getMatricula());
            rs = stmt.executeQuery();

            while (rs.next()) {
                vehiculo1 = new Vehiculo();
                obtenVehiculoFila(rs, vehiculo1);
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
        return vehiculo1;
    }

    public ArrayList<Vehiculo> selecionarvehiculos(Connection con) throws Exception {
        ArrayList<Vehiculo> vehiculo1 = new ArrayList<Vehiculo>();
        Vehiculo vehiculonuevo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM vehiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                vehiculonuevo = new Vehiculo();
                obtenVehiculoFila(rs, vehiculonuevo);
                vehiculo1.add(vehiculonuevo);
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

        return vehiculo1;
    }

    private void obtenVehiculoFila(ResultSet rs, Vehiculo vehiculo) throws Exception {
        vehiculo.setMatricula(rs.getString("matricula"));
        vehiculo.setTipo(rs.getString("tipo"));
        vehiculo.setKilometros(Integer.parseInt(rs.getString("kilometros")));
        vehiculo.setPrecio(Integer.parseInt(rs.getString("precio")));
        vehiculo.setAny(Integer.parseInt(rs.getString("anyo")));
        vehiculo.setModelo(rs.getString("marca"));
        vehiculo.setMarca(rs.getString("modelo"));
        vehiculo.setEmpleado(Integer.parseInt(rs.getString("id_empleado")));
    }

    public Vehiculo findbyMatricula(Connection con, String matricula) throws Exception {
        Vehiculo vehiculonuevo = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM vehiculo WHERE matricula=?");
            stmt.setString(1, matricula);
            rs = stmt.executeQuery();

            while (rs.next()) {
                vehiculonuevo = new Vehiculo();
                obtenVehiculoFila(rs, vehiculonuevo);
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
        System.out.println("El nuevo vehiculo: " + vehiculonuevo.toString());
        return vehiculonuevo;
    }

    public void actualitza(Connection con, Vehiculo vehiculo) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE empleado SET tipo=?, kilometros=?, precio=?, anyo=?, marca=?, modelo=? WHERE matricula=?");

            stmt.setString(1, vehiculo.getTipo());
            System.out.println("Matricula vehiculo" + vehiculo.getMatricula());
            stmt.setInt(2, vehiculo.getKilometros());
            stmt.setInt(3, vehiculo.getPrecio());
            stmt.setInt(4, vehiculo.getAny());
            stmt.setString(5, vehiculo.getMarca());
            stmt.setString(6, vehiculo.getModelo());
            stmt.setString(7, vehiculo.getMatricula());
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

    public boolean borrarvehiculo(Connection con, Vehiculo vehiculo) throws Exception {
        boolean vehiculoselecionado = false;
        PreparedStatement stmt = null;
        String opcion = "";

        try {
            stmt = con.prepareStatement("DELETE FROM vehiculo WHERE matricula LIKE ? ");
            stmt.setString(1, vehiculo.getMatricula());

            System.out.println("Estas completamente seguro que quieres borar al vehiculo Y/N");
            Scanner teclado2 = new Scanner(System.in);
            opcion = String.valueOf(teclado2.nextInt());

            if (opcion.equals("Y")) {
                stmt.execute();
                vehiculoselecionado = true;
            } else if (opcion.equals("N")) {
                System.out.println("Ok de acuerdo otra vez será");
                vehiculoselecionado = false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Problemas al borrar cliente " + ex.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return vehiculoselecionado;
    }

}
