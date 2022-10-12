

package com.programacion2.proyectofinal.CuentasCobrar;

import com.programacion2.proyectofinal.Conexiones.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author mayen
 */
public class SqlCuentasCobrar {
    
    public void listarFacturas(JTable tblFacturas){
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        tblFacturas.setRowSorter(new TableRowSorter(modelo));
        String sql = "SELECT * FROM Factura_CxC";
        
        try{
            modelo.addColumn("Id");
            modelo.addColumn("Id Cliente");
            modelo.addColumn("Id Producto");
            modelo.addColumn("Fecha");
            modelo.addColumn("Total");
            modelo.addColumn("Precio Unitario");
            modelo.addColumn("Cantidad Articulo");
            tblFacturas.setModel(modelo);
            
            String[] datos = new String[7];
            Statement st;
            
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
                
                modelo.addRow(datos);
            }
            tblFacturas.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al listar Facturas\nerror: "+e.toString());
        }
    }
    
    public boolean seleccionarRegistro(JTable tblFacturas, JTextField txtId, JTextField txtIdCliente, JTextField txtIdProducto,
            JTextField txtTotal, JTextField txtPrecioUnitario, JTextField txtCantidad){
        try{
            int fila = tblFacturas.getSelectedRow();
            if(fila >= 0){
                txtId.setText((tblFacturas.getValueAt(fila, 0).toString()));
                txtIdCliente.setText((tblFacturas.getValueAt(fila, 1).toString()));
                txtIdProducto.setText((tblFacturas.getValueAt(fila, 2).toString()));
                txtTotal.setText((tblFacturas.getValueAt(fila, 4).toString()));
                txtPrecioUnitario.setText((tblFacturas.getValueAt(fila, 5).toString()));
                txtCantidad.setText((tblFacturas.getValueAt(fila, 6).toString()));
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
    
    public boolean crearFactura(CuentaCobrar cuentaCobrar){
        Conexion conexion = new Conexion();
        String consulta = "INSERT INTO Factura_CxC(idCliente, idProducto, fecha, total, precioUnitario, cantidadArticulos) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        
        try{
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat dateOnly = new SimpleDateFormat("yyyy-MM-dd");
            
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, Integer.toString(cuentaCobrar.getIdCliente()));
            ps.setString(2, Integer.toString(cuentaCobrar.getIdProducto()));
            ps.setString(3, dateOnly.format(cal.getTime()));
            ps.setString(4, Double.toString(cuentaCobrar.getTotal()));
            ps.setString(5, Double.toString(cuentaCobrar.getPrecioUnitario()));
            ps.setString(6, Integer.toString(cuentaCobrar.getCantidadArticulos()));
            ps.execute();
            
            Statement st = conexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery("CALL actualizarStockProducto_Venta("+Integer.toString(cuentaCobrar.getIdProducto())+", "+Integer.toString(cuentaCobrar.getCantidadArticulos())+");");
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear la Factura\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean actualizarFactura(CuentaCobrar cuentaCobrar){
        Conexion conexion = new Conexion();
        String consulta = "UPDATE Factura_CxC SET idCliente = ?, idProducto = ?, total = ?, precioUnitario = ?, cantidadArticulos = ? WHERE id = ?;";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, Integer.toString(cuentaCobrar.getIdCliente()));
            ps.setString(2, Integer.toString(cuentaCobrar.getIdProducto()));
            ps.setString(3, Double.toString(cuentaCobrar.getTotal()));
            ps.setString(4, Double.toString(cuentaCobrar.getPrecioUnitario()));
            ps.setString(5, Integer.toString(cuentaCobrar.getCantidadArticulos()));
            ps.setInt(6, cuentaCobrar.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar la Factura\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean eliminarFactura(CuentaCobrar cuentaCobrar){
        Conexion conexion = new Conexion();
        String consulta = "DELETE FROM Factura_CxC WHERE id = ?";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, cuentaCobrar.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar la Factura\nerror: "+e.toString());
            return false;
        }
    }
}
