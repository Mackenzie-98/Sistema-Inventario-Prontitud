/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.InicioVista.escritorio;
import java.awt.Dimension;

/**
 *
 * @author Genes
 */
public class AgregarVentaVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public AgregarVentaVista() {
        initComponents();
        this.setSize(670,310);
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
        lbl_cliente = new javax.swing.JLabel();
        txt_dto = new javax.swing.JTextField();
        cbx_cliente = new javax.swing.JComboBox<>();
        txt_fecha = new javax.swing.JTextField();
        cmd_registrar = new javax.swing.JButton();
        lbl_prod = new javax.swing.JLabel();
        cbx_prod = new javax.swing.JComboBox<>();
        lbl_lote = new javax.swing.JLabel();
        cbx_lote = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Registrar venta");

        lbl_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_dto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dto.setText("Descuento");

        lbl_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha.setText("Fecha");

        lbl_cliente.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cliente.setText("Cliente");

        txt_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_dto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dtoActionPerformed(evt);
            }
        });

        cbx_cliente.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_clienteActionPerformed(evt);
            }
        });

        txt_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setText("YYYY-MM-DD");
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });

        cmd_registrar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        cmd_registrar.setText("Registrar");
        cmd_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_registrarActionPerformed(evt);
            }
        });

        lbl_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_prod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_prod.setText("Producto");

        cbx_prod.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_prod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_prodActionPerformed(evt);
            }
        });

        lbl_lote.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_lote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_lote.setText("Lote");

        cbx_lote.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cbx_lote.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aún no me decido" }));
        cbx_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_loteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 50, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(cbx_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(lbl_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(cbx_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_dto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(txt_dto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)
                            .addComponent(lbl_lote, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(cbx_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(240, 240, 240)
                            .addComponent(cmd_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 50, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 42, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbx_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(14, 14, 14)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(4, 4, 4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_lote, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbx_lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_dto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_dto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(24, 24, 24)
                    .addComponent(cmd_registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 43, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dtoActionPerformed

    private void cbx_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_clienteActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void cmd_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_registrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmd_registrarActionPerformed

    private void cbx_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_prodActionPerformed

    private void cbx_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_loteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_cliente;
    private javax.swing.JComboBox<String> cbx_lote;
    private javax.swing.JComboBox<String> cbx_prod;
    private javax.swing.JButton cmd_registrar;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_dto;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_lote;
    private javax.swing.JLabel lbl_prod;
    private javax.swing.JTextField txt_dto;
    private javax.swing.JTextField txt_fecha;
    // End of variables declaration//GEN-END:variables
}