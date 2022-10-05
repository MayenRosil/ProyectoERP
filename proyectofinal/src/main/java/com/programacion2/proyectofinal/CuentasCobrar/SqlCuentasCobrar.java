

package com.programacion2.proyectofinal.CuentasCobrar;

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
}
