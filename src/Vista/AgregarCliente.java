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
public class AgregarCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cliente
     */
    public AgregarCliente() {
        initComponents();
        this.setSize(520,256);
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

        txt_fecha_nac = new javax.swing.JTextField();
        lbl_id = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        cmd_agregar = new javax.swing.JButton();
        lbl_correo = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registrar cliente");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_fecha_nac.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_fecha_nac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fecha_nac.setText("YYYY-MM-DD");
        getContentPane().add(txt_fecha_nac, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 100, -1));

        lbl_id.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_id.setText("Identificación");
        getContentPane().add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 47, 90, 20));

        lbl_nombre.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_nombre.setText("Nombre:");
        getContentPane().add(lbl_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 102, 23));

        cmd_agregar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cmd_agregar.setText("Agregar");
        cmd_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_agregarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 99, 36));

        lbl_correo.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_correo.setText("Correo:");
        getContentPane().add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 170, 81, 22));

        lbl_fecha.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_fecha.setText("Fecha de nacimiento:");
        getContentPane().add(lbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 23));

        txt_correo.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 100, -1));

        txt_nombre.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 100, -1));

        txt_id.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_agregarActionPerformed
//        String id;
//        String nombre;
//        String fecha_nac;
//        String contacto;

    if ("".equals(this.txt_id.getText())) {
        JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de identificación",
                "ERROR", JOptionPane.WARNING_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Registrar cliente", JOptionPane.INFORMATION_MESSAGE);
        Cliente ver_ventana = new Cliente();
        Inicio.escritorio.add(ver_ventana);
        this.setVisible(false);
        ver_ventana.show();
    }    

    }//GEN-LAST:event_cmd_agregarActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_agregar;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_fecha_nac;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
