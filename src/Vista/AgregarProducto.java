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
public class AgregarProducto extends javax.swing.JInternalFrame {

    /**
     * Creates new form Producto
     */
    public AgregarProducto() {
        initComponents();
        this.setSize(520,229);
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

        lbl_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_cant = new javax.swing.JLabel();
        txt_cant = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JTextField();
        lbl_stock = new javax.swing.JLabel();
        cbx_stock = new javax.swing.JComboBox<>();
        cmd_agregar = new javax.swing.JButton();
        lbl_lab = new javax.swing.JLabel();
        txt_lab = new javax.swing.JTextField();
        lbl_lote = new javax.swing.JLabel();
        txt_lote = new javax.swing.JTextField();
        txt_fecha = new javax.swing.JTextField();
        lbl_fecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBorder(null);
        setClosable(true);
        setTitle("Agregar producto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_nombre.setText("Nombre:");
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 28, 81, 23));
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 29, 100, -1));

        lbl_cant.setText("Cantidad:");
        getContentPane().add(lbl_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 69, 81, 23));
        getContentPane().add(txt_cant, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 70, 100, -1));

        lbl_precio.setText("Precio:");
        getContentPane().add(lbl_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 110, 81, 22));

        txt_precio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioActionPerformed(evt);
            }
        });
        getContentPane().add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 111, 100, -1));

        lbl_stock.setText("Stock mínimo:");
        getContentPane().add(lbl_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 160, 81, 22));

        cbx_stock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicamento", "Aseo Personal", "Otro" }));
        getContentPane().add(cbx_stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, -1));

        cmd_agregar.setText("Agregar");
        cmd_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 100, -1));

        lbl_lab.setText("Laboratorio:");
        getContentPane().add(lbl_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 77, 23));
        getContentPane().add(txt_lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 100, -1));

        lbl_lote.setText("No. Lote:");
        getContentPane().add(lbl_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 77, 23));

        txt_lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loteActionPerformed(evt);
            }
        });
        getContentPane().add(txt_lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, -1));

        txt_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });
        getContentPane().add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 100, 20));

        lbl_fecha.setText("Fecha ven:");
        getContentPane().add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 77, 23));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 520, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_precioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioActionPerformed

    private void cmd_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_agregarActionPerformed

        if("".equals(this.txt_nombre.getText()) || "".equals(this.txt_cant.getText()) || "".equals(this.txt_precio.getText()) ||
            "".equals(this.txt_lab.getText()) || "".equals(this.txt_lote.getText()) || "".equals(this.txt_fecha.getText())) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese todos los datos", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Registrar producto", JOptionPane.INFORMATION_MESSAGE);
            Producto ver_ventana = new Producto();
            Inicio.escritorio.add(ver_ventana);
            this.setVisible(false);
            ver_ventana.show();
        }
    
    }//GEN-LAST:event_cmd_agregarActionPerformed

    private void txt_loteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loteActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbx_stock;
    private javax.swing.JButton cmd_agregar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_cant;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_lab;
    private javax.swing.JLabel lbl_lote;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_stock;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_lab;
    private javax.swing.JTextField txt_lote;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}