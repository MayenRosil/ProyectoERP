

package com.programacion2.proyectofinal.Proveedores;

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
public class SqlProveedor {
    
    public void listarProveedores(JTable tblProveedores){
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        tblProveedores.setRowSorter(new TableRowSorter(modelo));
        String sql = "SELECT * FROM Proveedor";
        String[] datos = new String[6];
        Statement st;
        
        modelo.addColumn("Id");
        modelo.addColumn("Razon Social");
        modelo.addColumn("Direccion");
        modelo.addColumn("Nombre Contacto");
        modelo.addColumn("Telefono Contacto");
        modelo.addColumn("Email Contacto");
        
        tblProveedores.setModel(modelo);
        
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
            tblProveedores.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al listar Proveedores\nerror: "+e.toString());
        }
    }
    
    public boolean selecionarRegistro(JTable tblProveedores, JTextField txtId, JTextField txtRazonSocial,
            JTextField txtDireccion, JTextField txtNombreContacto, JTextField txtTelefonoContacto, JTextField txtEmailContacto){
                try{
            
            int fila = tblProveedores.getSelectedRow();
            if(fila >= 0){
                txtId.setText((tblProveedores.getValueAt(fila, 0).toString()));
                txtRazonSocial.setText((tblProveedores.getValueAt(fila, 1).toString()));
                txtDireccion.setText((tblProveedores.getValueAt(fila, 2).toString()));
                txtNombreContacto.setText((tblProveedores.getValueAt(fila, 3).toString()));
                txtTelefonoContacto.setText((tblProveedores.getValueAt(fila, 4).toString()));
                txtEmailContacto.setText((tblProveedores.getValueAt(fila, 5).toString()));
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
                return false;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar Fila, error: "+e.toString());
            return false;
        }
    }
    
    public boolean crearProveedor(Proveedor proveedor){
        Conexion conexion = new Conexion();
        String consulta = "INSERT INTO Proveedor(razonSocial, direccion, nombreContacto, telefonoContacto, emailContacto) VALUES(?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getNombreContacto());
            ps.setString(4, proveedor.getTelefonoContacto());
            ps.setString(5, proveedor.getEmailContacto());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el Proveedor\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean actualizarProveedor(Proveedor proveedor){
        Conexion conexion = new Conexion();
        String consulta = "UPDATE Proveedor SET razonSocial = ?, direccion = ?, nombreContacto = ?, telefonoContacto = ?, emailContacto = ? WHERE id = ?";
        PreparedStatement ps = null;
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDireccion());
            ps.setString(3, proveedor.getNombreContacto());
            ps.setString(4, proveedor.getTelefonoContacto());
            ps.setString(5, proveedor.getEmailContacto());
            ps.setInt(6, proveedor.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar el Proveedor\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean eliminarProveedor(Proveedor proveedor){
        Conexion conexion = new Conexion();
        String consulta = "DELETE FROM Proveedor WHERE id = ?";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, proveedor.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el Proveedor\nerror: "+e.toString());
            return false;
        }
    }
    
}
