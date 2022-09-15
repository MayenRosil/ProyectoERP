

package com.programacion2.proyectofinal;

import com.programacion2.proyectofinal.Vistas.Inicio;
import com.programacion2.proyectofinal.Conexiones.Conexion;
import java.sql.Connection;
import javax.swing.JOptionPane;
/**
 *
 * @author mayen
 */
public class Principal {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conectar = conexion.estableceConexion();
        if(conectar != null){
            Inicio inicio = new Inicio();
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intente mas tarde");
        }
    }
    
}
