
package com.programacion2.proyectofinal.Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author mayen
 */
public class Conexion {
    Connection conectar = null;
    
    String usuario = "root";
    String password = "123456";
    String bd = "proyectoerp";
    String ip = "127.0.0.1";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, password);
            //JOptionPane.showMessageDialog(null, "Conexion realizada con exito");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error: "+e.toString());
            return null;
        }
        
        return conectar;
    }
}
