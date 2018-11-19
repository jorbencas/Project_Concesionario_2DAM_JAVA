/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jorge
 */
public class ConexionaDB {
    public Connection abrirconexion() throws ClassNotFoundException {
        Connection con = null;
        try {
             Class.forName("com.mysql.jdbc.Driver");//cargar el driver
            String urljdbc="jdbc:mysql://localhost:3306/concesionario_beneyto";
            con=(java.sql.DriverManager.getConnection(urljdbc,"concesionario_beneyto","concesionario_beneyto"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       return con;
    }
    
    public void cerrarconexion(Connection con) throws Exception{
        try {
            if (con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //Throw new Exception("Ha sido imposible cerrar la conexión" + e.getMessage());
        }
    }
}
