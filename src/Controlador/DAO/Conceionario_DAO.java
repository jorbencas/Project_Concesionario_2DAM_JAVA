/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.DAO;

//import Entity.Cliente;
import Modelo.Concesionario;
import Modelo.Empleado;
import Modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Conceionario_DAO {

    public void crearempleado(Connection con, Empleado empleado) throws Exception {
        PreparedStatement stmt = null;

        //System.out.println(empleado.toString());
        /*
            try {
                stmt = con.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?)");
                stmt.setInt(1, empleado.getId());
                stmt.setString(2, cliente.getNombre());
                System.out.println("nombre cliente" + cliente.getNombre());
                stmt.setString(3, cliente.getApellido1());
                stmt.setString(4, cliente.getApellido2());
                stmt.setString(5, cliente.getNick());
                stmt.setString(6, cliente.getPassword());
                stmt.setFloat(7, cliente.getSaldo());
                System.out.println("Saldo cliente" + cliente.getSaldo());
                if (cliente.isMoroso() == true) {
                    stmt.setInt(8, 1);
                } else {
                    stmt.setInt(8, 0);
                }
                System.out.println("Moroso cliente" + cliente.isMoroso());
                stmt.execute();

            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Problemas al insertar cliente " + ex.getMessage());
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }
*/
    }

    public void crearvehiculo(Connection con, Vehiculo vehiculo) throws Exception {
        PreparedStatement stmt = null;

        //System.out.println(vehiculo.toString());
             /*try {
               
                stmt = con.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?,?,?,?)");
                stmt.setInt(1, cliente.getDNI());
                stmt.setString(2, cliente.getNombre());
                System.out.println("nombre cliente" + cliente.getNombre());
                stmt.setString(3, cliente.getApellido1());
                stmt.setString(4, cliente.getApellido2());
                stmt.setString(5, cliente.getNick());
                stmt.setString(6, cliente.getPassword());
                stmt.setFloat(7, cliente.getSaldo());
                System.out.println("Saldo cliente" + cliente.getSaldo());
                if (cliente.isMoroso() == true) {
                    stmt.setInt(8, 1);
                } else {
                    stmt.setInt(8, 0);
                }
                System.out.println("Moroso cliente" + cliente.isMoroso());
                stmt.execute();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new Exception("Problemas al insertar cliente " + ex.getMessage());
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }*/

    }

    public boolean selecionarempleado(Connection con, Empleado empleado) throws Exception{
        boolean empleadoencontrado = false;
         //Cliente cliente4=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM empleado WHERE id=?");
         stmt.setInt(1, empleado.getId());
         rs = stmt.executeQuery();
            /*
            while(rs.next()){
                cliente4=new Cliente();
                obtenClienteFila(rs, cliente4);
            }
         */
            empleadoencontrado = true;
        }catch (SQLException ex){
           ex.printStackTrace();
           empleadoencontrado = false;
           throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        //cliente4.toString();
        
        return empleadoencontrado;
    }
    
     public boolean selecionarvehiculo(Connection con, Vehiculo vehiculo) throws Exception {
        boolean vehiculoselecionado = false;
        
         //Cliente cliente4=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM vehiculo WHERE matricula=?");
         stmt.setString(1, vehiculo.getMatricula());
         rs = stmt.executeQuery();
            /*
            while(rs.next()){
                cliente4=new Cliente();
                obtenClienteFila(rs, cliente4);
            }
         */
            vehiculoselecionado = true;
        }catch (SQLException ex){
           ex.printStackTrace();
           vehiculoselecionado = false;
           throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        //cliente4.toString();
        
        
        return vehiculoselecionado;
    }
    
    
    
    /*
     private void obtenConcesionarioFila(ResultSet rs, Concesionario concesionario) throws Exception{
        
        cliente.setDNI(rs.getInt("DNI"));
        cliente.setNombre(rs.getString("Nombre"));
        cliente.setApellido1(rs.getString("Ape1"));
        cliente.setApellido2(rs.getString("Ape2"));
        cliente.setNick(rs.getString("Nick"));
        cliente.setPassword(rs.getString("Passwd"));
        cliente.setSaldo(rs.getFloat("Saldo"));        
            if(rs.getInt("Moroso")==0){
                cliente.setMoroso(false);
            }
            else{
                cliente.setMoroso(true);
            }
            
            cliente.toString();
    }
    /*
    public Cliente findByDNI(Connection con, Cliente cliente) throws Exception{
        Cliente cliente4=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM cliente WHERE DNI=?");
         stmt.setInt(1, cliente.getDNI());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                cliente4=new Cliente();
                obtenClienteFila(rs, cliente4);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
         cliente4.toString();
        return cliente4;
    }
    
    public Cliente findByNick(Connection con, Cliente cliente) throws Exception{
        Cliente cliente4=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM cliente WHERE Nick=?");
         stmt.setString(1, cliente.getNick());
         rs = stmt.executeQuery();
            
            while(rs.next()){
                cliente4=new Cliente();
                obtenClienteFila(rs, cliente4);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        cliente4.toString();
        
        return cliente4;
    }
    
    public List<Cliente> findByNumberDNIStart(Connection con, int numero) throws Exception{
        List<Cliente> listaClientes=new ArrayList();
        
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT * FROM Cliente WHERE DNI like ?");
         stmt.setString(1, numero+"%");
         rs = stmt.executeQuery();         
         Cliente cliente=null;
         
            while(rs.next()){
                cliente=new Cliente();
                obtenClienteFila(rs, cliente);
                listaClientes.add(cliente);
            }
         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por Nick "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        return listaClientes;
    }
    
    public Cliente findByMayorGasto(Connection con) throws Exception{
        Cliente cliente=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        
        try{
         stmt = con.prepareStatement("SELECT Cliente_DNI AS DNI, (SUM(Precio*Numero))"
                 + "AS GASTO FROM articulo_factura af, articulo a, factura f"
                 + "WHERE af.Articulo_idArticulo = a.idArticulo "
                 + "AND afFactura_idFactura = f.idFactura "
                 + "GROU BY(Cliente_DNI");
         
         rs = stmt.executeQuery();
         float gatoAnterior=0;;
            
            while(rs.next()){
                float gasto=rs.getFloat("GASTO");
                if(gasto > gatoAnterior){
                    cliente=new Cliente();
                    cliente.setDNI(rs.getInt("DNI"));
                    gatoAnterior=gasto;
                }                
            }         
        }catch (SQLException ex){
           ex.printStackTrace();
           throw new Exception("problema al buscar por DNI "+ex.getMessage());
        }finally
        {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
        }
        if(cliente!=null){
            cliente = findByDNI(con, cliente);
        }
        return cliente;
    }
    
    
    public void actualitza(Connection con, Cliente cliente) throws Exception{
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE cliente SET Nombre=?, Ape1=?, Ape2=?, Nick=?, Passwd=?, Saldo=?, Moroso=? WHERE DNI=?");
            stmt.setString(1, cliente.getNombre());
            System.out.println("nombre cliente"+ cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getNick());
            stmt.setString(5, cliente.getPassword());
            stmt.setFloat(6, cliente.getSaldo());

            if(cliente.isMoroso()){
                stmt.setInt(7, 1);            
            }
            else{
                stmt.setInt(7, 0);
            }     
            stmt.setInt(8, cliente.getDNI());
            stmt.execute();
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            throw  new Exception("Problemas al actualizar cliente "+ex.getMessage());
        } finally{
            if(stmt!=null){
                stmt.close();
            }
        }
    }
    
    */
    public boolean borrarempleado(Connection con, Empleado empleado) throws Exception{
         boolean empleadoencontrado = false;
        PreparedStatement stmt = null;
        String opcion = "";
        try {
            stmt = con.prepareStatement("DELETE FROM empleado WHERE id LIKE ? ");
            stmt.setInt(1, empleado.getId());
            
            System.out.println("Estas completamente seguro que quieres borar al empleado Y/N");
             Scanner teclado2 = new Scanner(System.in);
             opcion = String.valueOf(teclado2.nextInt());
             
            if(opcion.equals("Y")){
                stmt.execute();
                empleadoencontrado = true;
            }else if (opcion.equals("N")){
                System.out.println("Ok de acuerdo otra vez será");
                empleadoencontrado = false;
            }
            
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            throw  new Exception("Problemas al borrar cliente "+ex.getMessage());
        } finally{
            if(stmt!=null){
                stmt.close();
            }
        }
        
        return empleadoencontrado;
    }
    
    
    public boolean borrarvehiculo(Connection con, Vehiculo vehiculo) throws Exception{
         boolean vehiculoselecionado = false;
        PreparedStatement stmt = null;
         String opcion = "";
         
        try {
            stmt = con.prepareStatement("DELETE FROM vehiculo WHERE matricula LIKE ? ");
            stmt.setString(1, vehiculo.getMatricula());
            
             System.out.println("Estas completamente seguro que quieres borar al vehiculo Y/N");
             Scanner teclado2 = new Scanner(System.in);
             opcion = String.valueOf(teclado2.nextInt());
             
            if(opcion.equals("Y")){
                stmt.execute();
                vehiculoselecionado = true;
            }else if (opcion.equals("N")){
                System.out.println("Ok de acuerdo otra vez será");
                vehiculoselecionado = false;
            }

        }catch (SQLException ex) {
            ex.printStackTrace();
            throw  new Exception("Problemas al borrar cliente "+ex.getMessage());
        } finally{
            if(stmt!=null){
                stmt.close();
            }
        }
        return vehiculoselecionado;
    }

   
    
}
