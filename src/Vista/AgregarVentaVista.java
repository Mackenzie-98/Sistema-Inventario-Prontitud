/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.InicioVista.escritorio;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;

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
        txt_fecha = new javax.swing.JTextField();
        cmd_registrar = new javax.swing.JButton();
        lbl_prod = new javax.swing.JLabel();
        txt_id_cliente = new javax.swing.JTextField();
        txt_nombre_prod = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        lbl_cant = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_previo_venta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_lote = new javax.swing.JTextField();
        lbl_lote = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Registrar venta");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_vent.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_dto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_dto.setText("Descuento");
        getContentPane().add(lbl_dto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 73, 22));

        lbl_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_fecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_fecha.setText("Fecha");
        getContentPane().add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 73, 22));

        lbl_cliente.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_cliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cliente.setText("Identificación");
        getContentPane().add(lbl_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 90, 22));
        lbl_cliente.getAccessibleContext().setAccessibleName("Identificación ");
        lbl_cliente.getAccessibleContext().setAccessibleDescription("");

        txt_dto.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_dto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dtoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_dto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 129, 23));

        txt_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha.setText("yyyy-mm-dd");
        txt_fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_fechaMouseClicked(evt);
            }
        });
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 129, 23));

        cmd_registrar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_registrar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        cmd_registrar.setForeground(new java.awt.Color(255, 255, 255));
        cmd_registrar.setText("Registrar");
        cmd_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmd_registrarMouseEntered(evt);
            }
        });
        cmd_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_registrarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 100, 32));

        lbl_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_prod.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_prod.setText("Producto:");
        getContentPane().add(lbl_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 73, 22));
        getContentPane().add(txt_id_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 129, 23));

        txt_nombre_prod.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        getContentPane().add(txt_nombre_prod, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 129, 23));

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 680, 40));

        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Venta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 130, 40));

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Datos de venta:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jLabel3.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/fondo_derecha.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 210, 430));

        txt_cant.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        getContentPane().add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 129, 23));

        lbl_cant.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_cant.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_cant.setText("Cantidad:");
        getContentPane().add(lbl_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 73, 22));

        txt_precio.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 129, 23));

        lbl_previo_venta.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_previo_venta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_previo_venta.setText("Precio:");
        getContentPane().add(lbl_previo_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 73, 22));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_lote.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_lote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loteActionPerformed(evt);
            }
        });
        jPanel1.add(txt_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 130, -1));

        lbl_lote.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_lote.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_lote.setText("Lote:");
        jPanel1.add(lbl_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 60, 22));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 330, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dtoActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void cmd_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_registrarActionPerformed
        VentaVista ver_ventana = new VentaVista();
        escritorio.add(ver_ventana);
        this.setVisible(false);
        ver_ventana.show();
    }//GEN-LAST:event_cmd_registrarActionPerformed

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        cmd_registrar.setBackground(new Color(0, 51, 204));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void cmd_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_registrarMouseEntered
        cmd_registrar.setBackground(new Color(0, 51, 204));
    }//GEN-LAST:event_cmd_registrarMouseEntered

    private void txt_fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_fechaMouseClicked
       this.getTxt_fecha().setText("");
    }//GEN-LAST:event_txt_fechaMouseClicked

    private void txt_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loteActionPerformed
    
    public void limpiar(){
        this.getTxt_cant().setText("");
        this.getTxt_dto().setText("");
        this.getTxt_fecha().setText("");
        this.getTxt_id_cliente().setText("");
        this.getTxt_precio().setText("");
        this.getTxt_nombre_prod().setText("");
        
    }
    
    public JTextField getTxt_cant() {
        return txt_cant;
    }

    public void setTxt_cant(JTextField txt_cant) {
        this.txt_cant = txt_cant;
    }

    public JTextField getTxt_dto() {
        return txt_dto;
    }

    public void setTxt_dto(JTextField txt_dto) {
        this.txt_dto = txt_dto;
    }

    public JTextField getTxt_fecha() {
        return txt_fecha;
    }

    public void setTxt_fecha(JTextField txt_fecha) {
        this.txt_fecha = txt_fecha;
    }

    public JTextField getTxt_id_cliente() {
        return txt_id_cliente;
    }

    public void setTxt_id_cliente(JTextField txt_id_cliente) {
        this.txt_id_cliente = txt_id_cliente;
    }

    public JTextField getTxt_precio() {
        return txt_precio;
    }

    public void setTxt_id_prod2(JTextField txt_id_prod2) {
        this.txt_precio = txt_id_prod2;
    }

    public JTextField getTxt_nombre_prod() {
        return txt_nombre_prod;
    }

    public void setTxt_nombre_prod(JTextField txt_nombre_prod) {
        this.txt_nombre_prod = txt_nombre_prod;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_registrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_cant;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_dto;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_lote;
    private javax.swing.JLabel lbl_previo_venta;
    private javax.swing.JLabel lbl_prod;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_dto;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_id_cliente;
    private javax.swing.JTextField txt_lote;
    private javax.swing.JTextField txt_nombre_prod;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
