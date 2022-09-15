
package com.programacion2.proyectofinal.Usuarios;

import com.programacion2.proyectofinal.Conexiones.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mayen
 */
public class SqlUsuario {
    
        
    public int validarExistenciaUsuario(String usuario){
        Conexion conexion = new Conexion();
        String consulta = "SELECT count(id) FROM Usuario WHERE usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }             
            
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el Usuario\nerror: "+e.toString());
            return 1;
        }
    }
       
    public boolean iniciarSesion(Usuario usuario){               
        Conexion conexion = new Conexion();
        String consulta = "SELECT id, nombre, usuario, clave, correo, rol FROM Usuario WHERE usuario = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){              
                if(usuario.getClave().equals(rs.getString(4))){
                    usuario.setId(rs.getInt(1));
                    usuario.setNombre(rs.getString(2));
                    usuario.setCorreo(rs.getString(5));
                    usuario.setRol(rs.getInt(6));
                    return true;
                }else{
                    return false;
                }
            }
   
            return false;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el Usuario\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean registrarUsuario(Usuario usuario){
        Conexion conexion = new Conexion();
        String consulta = "INSERT INTO Usuario(nombre, usuario, clave, correo, rol) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getCorreo());
            ps.setInt(5, usuario.getRol());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el Usuario\nerror: "+e.toString());
            return false;
        } 
    }
    
}
