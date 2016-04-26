/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    public ConexionBD()
    {
        
    }
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3307/PracticaBD";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEmpleado(String cedula, String nombre, String direccion, int edad)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO Empleados(Cedula, Nombre, Direccion, Edad) VALUES ("+cedula+","+nombre+","+direccion+","+edad+")");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }
    public void consultarEmpleado(String cedula)
    {
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT Nombre FROM Empleados");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("Nombre");
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: "+nombre); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }
    
}
