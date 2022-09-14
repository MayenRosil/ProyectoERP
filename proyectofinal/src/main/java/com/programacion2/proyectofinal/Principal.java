/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conexion = new Conexion();
        Connection conectar = conexion.estableceConexion();
        if(conectar != null){
            Inicio inicio = new Inicio();
            //IniciarSesion login = new IniciarSesion();
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, intente mas tarde");
        }
    }
    
}
