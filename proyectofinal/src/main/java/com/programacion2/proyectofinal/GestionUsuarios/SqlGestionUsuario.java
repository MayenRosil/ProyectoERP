
package com.programacion2.proyectofinal.GestionUsuarios;

import com.programacion2.proyectofinal.Conexiones.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mayen
 */
public class SqlGestionUsuario {
    
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
    
}
