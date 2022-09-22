
package com.programacion2.proyectofinal.Productos;

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
public class SqlProducto {
    
    public int validarExistenciaProducto(String nombre){
        Conexion conexion = new Conexion();
        String consulta = "SELECT count(id) FROM Producto WHERE nombre = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            
            return 1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar el Producto\nerror: "+e.toString());
            return 1;
        }
    }
    
    public void listarProductos(JTable tblProductos){
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        tblProductos.setRowSorter(new TableRowSorter(modelo));
        String sql = "";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Marca");
        modelo.addColumn("Stock");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Precio Venta");
        modelo.addColumn("Fecha Ultimo Ingreso");
        modelo.addColumn("Fecha Ultima Salida");
        
        tblProductos.setModel(modelo);
        sql = "SELECT * FROM Producto";
        
        String[] datos = new String[8];
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
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                
                modelo.addRow(datos);
            }
            tblProductos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al listar Productos\nerror: "+e.toString());
        }
    }
    
    public void seleccionarRegistro(JTable tblProductos, JTextField txtId, JTextField txtNombre, 
            JTextField txtMarca, JTextField txtStock, JTextField txtPrecioCompra, JTextField txtPrecioVenta){
        try{
            
            int fila = tblProductos.getSelectedRow();
            if(fila >= 0){
                txtId.setText((tblProductos.getValueAt(fila, 0).toString()));
                txtNombre.setText((tblProductos.getValueAt(fila, 1).toString()));
                txtMarca.setText((tblProductos.getValueAt(fila, 2).toString()));
                txtStock.setText((tblProductos.getValueAt(fila, 3).toString()));
                txtPrecioCompra.setText((tblProductos.getValueAt(fila, 4).toString()));
                txtPrecioVenta.setText((tblProductos.getValueAt(fila, 5).toString()));
            }else{
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al seleccionar Fila, error: "+e.toString());
        }
    }
    
}
