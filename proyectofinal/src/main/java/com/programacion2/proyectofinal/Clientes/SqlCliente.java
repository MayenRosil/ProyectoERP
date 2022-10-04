
package com.programacion2.proyectofinal.Clientes;

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
public class SqlCliente {
    
    public void listarClientes(JTable tblClientes){
        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel();
        tblClientes.setRowSorter(new TableRowSorter(modelo));
        String sql = "SELECT * FROM Cliente";
        String[] datos = new String[7];
        Statement st;
        
        try{
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("NIT");
            modelo.addColumn("Direccion");
            modelo.addColumn("Correo");
            modelo.addColumn("Telefono");
            tblClientes.setModel(modelo);
            
            st=conexion.estableceConexion().createStatement();
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
            tblClientes.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al listar Clientes\nerror: "+e.toString());
        }
    }
    
    public boolean seleccionarRegistro(JTable tblClientes, JTextField txtId, JTextField txtNombre, JTextField txtApellido,
            JTextField txtNit, JTextField txtDireccion, JTextField txtCorreo, JTextField txtTelefono){
        try{
            int fila = tblClientes.getSelectedRow();
            if(fila >= 0){
                txtId.setText((tblClientes.getValueAt(fila, 0).toString()));
                txtNombre.setText((tblClientes.getValueAt(fila, 1).toString()));
                txtApellido.setText((tblClientes.getValueAt(fila, 2).toString()));
                txtNit.setText((tblClientes.getValueAt(fila, 3).toString()));
                txtDireccion.setText((tblClientes.getValueAt(fila, 4).toString()));
                txtCorreo.setText((tblClientes.getValueAt(fila, 5).toString()));
                txtTelefono.setText((tblClientes.getValueAt(fila, 6).toString()));
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
    
    public boolean crearCliente(Cliente cliente){
        Conexion conexion = new Conexion();
        String consulta = "INSERT INTO Cliente(nombre, apellido, nit, direccion, correo, telefono) VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getNit());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getTelefono());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el Cliente\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean actualizarCliente(Cliente cliente){
        Conexion conexion = new Conexion();
        String consulta = "UPDATE Cliente SET nombre = ?, apellido = ?, nit = ?, direccion = ?, correo = ?, telefono = ? WHERE id = ?";
        PreparedStatement ps = null;
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getNit());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.setString(6, cliente.getTelefono());
            ps.setInt(7, cliente.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar el Cliente\nerror: "+e.toString());
            return false;
        }
    }
    
    public boolean eliminarCliente(Cliente cliente){
        Conexion conexion = new Conexion();
        String consulta = "DELETE FROM Cliente WHERE id = ?";
        PreparedStatement ps = null;
        
        try{
            ps = conexion.estableceConexion().prepareStatement(consulta);
            ps.setInt(1, cliente.getId());
            ps.execute();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el Cliente\nerror: "+e.toString());
            return false;
        }
    }
    
}
