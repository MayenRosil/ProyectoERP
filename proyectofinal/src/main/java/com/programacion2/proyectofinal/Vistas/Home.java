
package com.programacion2.proyectofinal.Vistas;

import com.programacion2.proyectofinal.Usuarios.Usuario;

/**
 *
 * @author mayen
 */
public class Home extends javax.swing.JFrame {
    
    Usuario modelo;

    public static GestionUsuarios frmGestionUsuarios;
    public static Productos frmProductos;
    public static Clientes frmClientes;
    public static Proveedores frmProveedores;
    public static CuentasPagar frmCuentasPagar;
    public static CuentasCobrar frmCuentasCobrar;

    public Home() {
        initComponents();
        this.setVisible(true);
    }
    
    public Home(Usuario modelo){
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
        Inicio.bloquearBotones();
        
        this.modelo = modelo;
        lblNombre.setText(modelo.getNombre());
        lblRol.setText(modelo.getNombreRol());
        
        if(modelo.getRol() == 1){
            btnGestionUsuarios.setVisible(true);
        }else if(modelo.getRol() == 2){
            btnGestionUsuarios.setVisible(true);
        }
        btnUser.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        btnGestionUsuarios = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        lblRol = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnCuentasCobrar = new javax.swing.JButton();
        btnCuentasPagar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNombre.setBorder(new javax.swing.border.MatteBorder(null));

        btnGestionUsuarios.setText("Gestion Usuarios");
        btnGestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionUsuariosActionPerformed(evt);
            }
        });

        btnUser.setText("user");

        lblRol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setText("Proveedores");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnCuentasCobrar.setText("Factura - Cuentas por Cobrar");
        btnCuentasCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasCobrarActionPerformed(evt);
            }
        });

        btnCuentasPagar.setText("Factura - Cuentas por Pagar");
        btnCuentasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentasPagar)
                    .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentasCobrar))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuentasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCuentasCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionUsuariosActionPerformed
        if(frmGestionUsuarios == null){
             frmGestionUsuarios = new GestionUsuarios(this.modelo);
             frmGestionUsuarios.setVisible(true);
         }
    }//GEN-LAST:event_btnGestionUsuariosActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        if(frmProductos == null){
            frmProductos = new Productos(this.modelo);
            frmProductos.setVisible(true);
        }
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        if(frmClientes == null){
            frmClientes = new Clientes(this.modelo);
            frmClientes.setVisible(true);
        }
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        if(frmProveedores == null){
            frmProveedores = new Proveedores(this.modelo);
            frmProveedores.setVisible(true);
        }
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnCuentasCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasCobrarActionPerformed
        if(frmCuentasCobrar == null){
            frmCuentasCobrar = new CuentasCobrar(this.modelo);
            frmCuentasCobrar.setVisible(true);
        }
    }//GEN-LAST:event_btnCuentasCobrarActionPerformed

    private void btnCuentasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasPagarActionPerformed
        if(frmCuentasPagar == null){
            frmCuentasPagar = new CuentasPagar(this.modelo);
            frmCuentasPagar.setVisible(true);
        }
    }//GEN-LAST:event_btnCuentasPagarActionPerformed

  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnCuentasCobrar;
    private javax.swing.JButton btnCuentasPagar;
    private javax.swing.JButton btnGestionUsuarios;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUser;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    // End of variables declaration//GEN-END:variables
}
