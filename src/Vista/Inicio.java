/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.Login.cbx_usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Genesis Vargas
 */
public class Inicio extends javax.swing.JFrame {
    
    public Login usuario;
    String tipo = String.valueOf(cbx_usuario.getSelectedItem());
 
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        
        initComponents();
        this.setSize(810,564);
        this.setResizable(false);
        this.setVisible(true);

    }
    public void validar(){
        if(tipo.equals("Vendedor")){
            jm_prov.setEnabled(false);
            jmi_registrar_c.setEnabled(false);
            jmi_eliminar_prod.setEnabled(false);
            jmi_agg_prod.setEnabled(false);
            jmi_facturasC.setEnabled(false);
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_prod = new javax.swing.JMenu();
        jmi_mostrar_prod = new javax.swing.JMenuItem();
        jmi_agg_prod = new javax.swing.JMenuItem();
        jmi_buscar_prod = new javax.swing.JMenuItem();
        jmi_eliminar_prod = new javax.swing.JMenuItem();
        jmi_mostrar_lotes = new javax.swing.JMenuItem();
        jm_prov = new javax.swing.JMenu();
        jmi_agg_prov = new javax.swing.JMenuItem();
        jmi_buscar_prov = new javax.swing.JMenuItem();
        jmi_eliminar_prov = new javax.swing.JMenuItem();
        jmi_mostrar_prov = new javax.swing.JMenuItem();
        jm_cliente = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_agg_cliente = new javax.swing.JMenuItem();
        jmi_buscar_cliente = new javax.swing.JMenuItem();
        jm_registrar = new javax.swing.JMenu();
        jmi_registrar_c = new javax.swing.JMenuItem();
        jmi_registrar_v = new javax.swing.JMenuItem();
        jm_facturas = new javax.swing.JMenu();
        jmi_facturasC = new javax.swing.JMenuItem();
        jmi_facturasV = new javax.swing.JMenuItem();
        jm_dev = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        escritorio.setPreferredSize(new java.awt.Dimension(810, 543));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jMenuBar1.setName(""); // NOI18N

        jm_prod.setText("Producto");
        jm_prod.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N

        jmi_mostrar_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jmi_mostrar_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_mostrar_prod.setText("Ver productos");
        jmi_mostrar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_mostrar_prod);

        jmi_agg_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmi_agg_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_agg_prod.setText("Agregar ");
        jmi_agg_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_agg_prod);

        jmi_buscar_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jmi_buscar_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_buscar_prod.setText("Buscar ");
        jmi_buscar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_buscar_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_buscar_prod);

        jmi_eliminar_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmi_eliminar_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_eliminar_prod.setText("Eliminar");
        jmi_eliminar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_eliminar_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_eliminar_prod);

        jmi_mostrar_lotes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jmi_mostrar_lotes.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_mostrar_lotes.setText("Ver lotes");
        jmi_mostrar_lotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_lotesActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_mostrar_lotes);

        jMenuBar1.add(jm_prod);

        jm_prov.setText("Proveedor");
        jm_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N

        jmi_agg_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_agg_prov.setText("Agregar");
        jmi_agg_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_agg_prov);

        jmi_buscar_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_buscar_prov.setText("Buscar");
        jmi_buscar_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_buscar_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_buscar_prov);

        jmi_eliminar_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_eliminar_prov.setText("Eliminar");
        jmi_eliminar_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_eliminar_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_eliminar_prov);

        jmi_mostrar_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_mostrar_prov.setText("Mostrar");
        jmi_mostrar_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_mostrar_prov);

        jMenuBar1.add(jm_prov);

        jm_cliente.setText("Cliente");
        jm_cliente.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jm_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_clienteActionPerformed(evt);
            }
        });
        jm_cliente.add(jSeparator1);

        jmi_agg_cliente.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_agg_cliente.setText("Agregar");
        jmi_agg_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_clienteActionPerformed(evt);
            }
        });
        jm_cliente.add(jmi_agg_cliente);

        jmi_buscar_cliente.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_buscar_cliente.setText("Buscar");
        jmi_buscar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_buscar_clienteActionPerformed(evt);
            }
        });
        jm_cliente.add(jmi_buscar_cliente);

        jMenuBar1.add(jm_cliente);

        jm_registrar.setText("Registrar");
        jm_registrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N

        jmi_registrar_c.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_registrar_c.setText("Registrar compra");
        jmi_registrar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_registrar_cActionPerformed(evt);
            }
        });
        jm_registrar.add(jmi_registrar_c);

        jmi_registrar_v.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_registrar_v.setText("Registrar venta");
        jmi_registrar_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_registrar_vActionPerformed(evt);
            }
        });
        jm_registrar.add(jmi_registrar_v);

        jMenuBar1.add(jm_registrar);

        jm_facturas.setText("Facturas");
        jm_facturas.setFocusable(false);
        jm_facturas.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N

        jmi_facturasC.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jmi_facturasC.setText("Facturas compra");
        jmi_facturasC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_facturasCActionPerformed(evt);
            }
        });
        jm_facturas.add(jmi_facturasC);

        jmi_facturasV.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_facturasV.setText("Facturas venta");
        jmi_facturasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_facturasVActionPerformed(evt);
            }
        });
        jm_facturas.add(jmi_facturasV);

        jMenuBar1.add(jm_facturas);

        jm_dev.setText("Devolución");
        jm_dev.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jMenuBar1.add(jm_dev);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_clienteActionPerformed

    private void jmi_agg_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_prodActionPerformed
//        escritorio.removeAll();
        AgregarProducto ver_ventana = new AgregarProducto();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_agg_prodActionPerformed

    private void jmi_buscar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_buscar_prodActionPerformed
//        escritorio.removeAll();
        String nombre;
        nombre = JOptionPane.showInputDialog("Digita el nombre del producto:  ");     
        Producto ver_ventana = new Producto();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_buscar_prodActionPerformed

    private void jmi_eliminar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_eliminar_prodActionPerformed
//        escritorio.removeAll();
        String nombre;
        nombre = JOptionPane.showInputDialog("Digita el nombre del producto:  ");     
        Producto ver_ventana = new Producto();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_eliminar_prodActionPerformed

    private void jmi_mostrar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_prodActionPerformed
//        escritorio.removeAll();
        Producto ver_ventana = new Producto();
        escritorio.add(ver_ventana);
        ver_ventana.show();        
    }//GEN-LAST:event_jmi_mostrar_prodActionPerformed

    private void jmi_agg_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_provActionPerformed
        // TODO add your handling code here:
//        escritorio.removeAll();
        AgregarProveedor ver_ventana = new AgregarProveedor();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_agg_provActionPerformed

    private void jmi_mostrar_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_provActionPerformed
//        escritorio.removeAll();
        Proveedor ver_ventana = new Proveedor();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_mostrar_provActionPerformed

    private void jmi_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_buscar_clienteActionPerformed
//        escritorio.removeAll();
        String id;
        id = JOptionPane.showInputDialog("Digita número de documento:  "); 
        Cliente ver_ventana = new Cliente();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_buscar_clienteActionPerformed

    private void jmi_eliminar_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_eliminar_provActionPerformed
//        escritorio.removeAll();
        String nombre;
        nombre = JOptionPane.showInputDialog("Digita el número de NIT:  "); 
        Proveedor ver_ventana = new Proveedor();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_eliminar_provActionPerformed

    private void jmi_buscar_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_buscar_provActionPerformed
//        escritorio.removeAll();
        String nombre;
        nombre = JOptionPane.showInputDialog("Digita el número de NIT:  "); 
        Proveedor ver_ventana = new Proveedor();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_buscar_provActionPerformed

    private void jmi_agg_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_clienteActionPerformed
//        escritorio.removeAll();
        AgregarCliente ver_ventana = new AgregarCliente();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_agg_clienteActionPerformed

    private void jmi_mostrar_lotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_lotesActionPerformed
        Lote ver_ventana = new Lote();
        escritorio.add(ver_ventana);
        ver_ventana.show();        
    }//GEN-LAST:event_jmi_mostrar_lotesActionPerformed

    private void jmi_facturasCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_facturasCActionPerformed
        Compra ver_ventana = new Compra();
        escritorio.add(ver_ventana);
        ver_ventana.show();          
    }//GEN-LAST:event_jmi_facturasCActionPerformed

    private void jmi_facturasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_facturasVActionPerformed
        Venta ver_ventana = new Venta();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_facturasVActionPerformed

    private void jmi_registrar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_registrar_cActionPerformed
        Compra ver_ventana = new Compra();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_registrar_cActionPerformed

    private void jmi_registrar_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_registrar_vActionPerformed
        Venta ver_ventana = new Venta();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_registrar_vActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jm_cliente;
    private javax.swing.JMenu jm_dev;
    private javax.swing.JMenu jm_facturas;
    private javax.swing.JMenu jm_prod;
    private javax.swing.JMenu jm_prov;
    private javax.swing.JMenu jm_registrar;
    private javax.swing.JMenuItem jmi_agg_cliente;
    private javax.swing.JMenuItem jmi_agg_prod;
    private javax.swing.JMenuItem jmi_agg_prov;
    private javax.swing.JMenuItem jmi_buscar_cliente;
    private javax.swing.JMenuItem jmi_buscar_prod;
    private javax.swing.JMenuItem jmi_buscar_prov;
    private javax.swing.JMenuItem jmi_eliminar_prod;
    private javax.swing.JMenuItem jmi_eliminar_prov;
    private javax.swing.JMenuItem jmi_facturasC;
    private javax.swing.JMenuItem jmi_facturasV;
    private javax.swing.JMenuItem jmi_mostrar_lotes;
    private javax.swing.JMenuItem jmi_mostrar_prod;
    private javax.swing.JMenuItem jmi_mostrar_prov;
    private javax.swing.JMenuItem jmi_registrar_c;
    private javax.swing.JMenuItem jmi_registrar_v;
    // End of variables declaration//GEN-END:variables
}
