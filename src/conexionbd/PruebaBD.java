/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

/**
 *
 * @author administrador
 */
public class PruebaBD {
   ConexionBD conexion;

    public PruebaBD() {
        conexion=new ConexionBD();
        
    }
    
    
    public static void main(String args[])
    {
      new PruebaBD();
        
    }
    
}
