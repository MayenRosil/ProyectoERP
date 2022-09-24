
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
    String bd = "proyectoerpjava";
    String ip = "34.135.159.66";
    String puerto = "3306";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    /*
    String url = "jdbc:mysql://us-east.connect.psdb.cloud/proyectoerpjava?sslMode=VERIFY_IDENTITY";
    String user = "nhy2klvb64ji93tg3oh0";
    String pass = "pscale_pw_neWjyq23TTvSrodS88hVHH0sErXhH1gwZSxQ5MHKnBH";
    */
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
