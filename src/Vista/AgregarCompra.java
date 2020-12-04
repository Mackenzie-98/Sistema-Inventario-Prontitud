/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.Inicio.escritorio;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author Genesis Vargas
 */
public class AgregarCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarCompra
     */
    public AgregarCompra() {
        initComponents();
        this.setSize(605,310);
        this.setResizable(false);
        this.setVisible(true); 
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2);
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_dto = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        lbl_prov = new javax.swing.JLabel();
        txt_dto = new javax.swing.JTextField();
        cbx_proveedor = new javax.swing.JComboBox<>();
        txt_fecha = new javax.swing.JTextField();
        cmd_registrar = new javax.swing.JButton();
        lbl_prod = new javax.swing.JLabel();
        cbx_prod = new javax.swing.JComboBox<>();
        lbl_lote = new javax.swing.JLabel();
        cbx_lote = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Registrar compra");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_dto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dto.setText("Descuento");
        getContentPane().add(lbl_dto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 73, 22));

        lbl_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha.setText("Fecha");
        getContentPane().add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 73, 22));

        lbl_prov.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_prov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_prov.setText("Proveedor");
        getContentPane().add(lbl_prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 73, 22));

        txt_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_dto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dtoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_dto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 150, -1));

        cbx_proveedor.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_proveedorActionPerformed(evt);
            }
        });
        getContentPane().add(cbx_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        txt_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setText("YYYY-MM-DD");
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 149, -1));

        cmd_registrar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        cmd_registrar.setText("Registrar");
        cmd_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 100, 32));

        lbl_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_prod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_prod.setText("Producto");
        getContentPane().add(lbl_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 73, 22));

        cbx_prod.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_prod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_prodActionPerformed(evt);
            }
        });
        getContentPane().add(cbx_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        lbl_lote.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_lote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_lote.setText("Lote");
        getContentPane().add(lbl_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 73, 22));

        cbx_lote.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_lote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_loteActionPerformed(evt);
            }
        });
        getContentPane().add(cbx_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dtoActionPerformed

    private void cbx_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_proveedorActionPerformed

    private void cmd_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmd_registrarActionPerformed

    private void cbx_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_prodActionPerformed

    private void cbx_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_loteActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_lote;
    private javax.swing.JComboBox<String> cbx_prod;
    private javax.swing.JComboBox<String> cbx_proveedor;
    private javax.swing.JButton cmd_registrar;
    private javax.swing.JLabel lbl_dto;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_lote;
    private javax.swing.JLabel lbl_prod;
    private javax.swing.JLabel lbl_prov;
    private javax.swing.JTextField txt_dto;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}
