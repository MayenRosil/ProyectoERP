
package com.programacion2.proyectofinal.GestionUsuarios;

import com.programacion2.proyectofinal.Conexiones.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mayen
 */
public class SqlGestionUsuario {
    
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
    
    public void listarUsuarios(JTable tblUsuarios){
        
        Conexion conexion = new Conexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        tblUsuarios.setRowSorter(new TableRowSorter(modelo));
        
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Usuario");
        modelo.addColumn("Clave");
        modelo.addColumn("Correo");
        modelo.addColumn("Rol");
        
        tblUsuarios.setModel(modelo);
        
        sql = "SELECT * FROM Usuario;";
        
        String[] datos = new String[6];
        
        Statement st;
        
        try{
            
            st = conexion.estableceConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                
                modelo.addRow(datos);
            }
            
            tblUsuarios.setModel(modelo);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al listar Usuarios\nerror: "+e.toString());
        }
        
    }
    
    public void seleccionarRegistro(JTable tblUsuarios, JTextField txtId, JTextField txtNombre, 
            JTextField txtUsuario, JTextField txtClave, JTextField txtCorreo){
        try{
            
            int fila = tblUsuarios.getSelectedRow();
            if(fila >= 0){
                txtId.setText((tblUsuarios.getValueAt(fila, 0).toString()));
                txtNombre.setText((tblUsuarios.getValueAt(fila, 1).toString()));
                txtUsuario.setText((tblUsuarios.getValueAt(fila, 2).toString()));
                txtClave.setText((tblUsuarios.getValueAt(fila, 3).toString()));
                txtCorreo.setText((tblUsuarios.getValueAt(fila, 4).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar Fila, error: "+e.toString());
        }
    }
    
     public boolean crearUsuario(GestionUsuario usuario){
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
            JOptionPane.showMessageDialog(null, "Error al crear el Usuario\nerror: "+e.toString());
            return false;
        } 
    }
     
    public boolean actualizarUsuario(GestionUsuario usuario){
        Conexion conexion = new Conexion();
        String consulta = "UPDATE Usuario SET nombre = ?, usuario = ?, clave = ?, correo = ? WHERE id = ?;";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getClave());
            ps.setString(4, usuario.getCorreo());
            ps.setInt(5, usuario.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar el Usuario\nerror: "+e.toString());
            return false;
        } 
    }
    
        public boolean eliminarUsuario(GestionUsuario usuario){
        Conexion conexion = new Conexion();
        String consulta = "DELETE FROM Usuario WHERE id = ?;";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, usuario.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el Usuario\nerror: "+e.toString());
            return false;
        } 
    }
    
}
