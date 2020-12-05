/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladores.Coordinador;
import java.awt.Color;
import javax.swing.ImageIcon;


/**
 *
 * @author Genesis Vargas
 */
public class LoginVista extends javax.swing.JFrame {

    Coordinador coordinador=new Coordinador();


    public LoginVista() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("icons/icon_login.png")).getImage());
        this.setTitle("Drogueria prontitud - Inicio de sesión");
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lbl2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        lbl1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbx_usuario = new javax.swing.JComboBox<>();
        lbl_usuario = new java.awt.Label();
        lbl_contrasenia = new java.awt.Label();
        cmd_inicicar = new javax.swing.JButton();
        jPasswordF_usuario = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl2.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        lbl2.setText("Ingrese sus datos:");

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setAlignment(java.awt.Label.CENTER);
        lbl1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setName(""); // NOI18N
        lbl1.setText("INICIO DE USUARIO");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 140, -1));
        lbl1.getAccessibleContext().setAccessibleName("US");

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Drogueria Prontitud");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 380, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbx_usuario.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        cbx_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        cbx_usuario.setActionCommand("cbx_usuario");
        cbx_usuario.setBorder(null);
        cbx_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbx_usuario.setName(""); // NOI18N
        cbx_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cbx_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cbx_usuarioMouseExited(evt);
            }
        });
        cbx_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_usuarioActionPerformed(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        lbl_usuario.setText("Usuario:");

        lbl_contrasenia.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        lbl_contrasenia.setText("Contraseña:");

        cmd_inicicar.setBackground(new java.awt.Color(82, 0, 255));
        cmd_inicicar.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        cmd_inicicar.setForeground(new java.awt.Color(255, 255, 255));
        cmd_inicicar.setText("Iniciar sesión");
        cmd_inicicar.setActionCommand("cmd_iniciar");
        cmd_inicicar.setBorder(null);
        cmd_inicicar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmd_inicicarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmd_inicicarMouseExited(evt);
            }
        });
        cmd_inicicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_inicicarActionPerformed(evt);
            }
        });

        jPasswordF_usuario.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jPasswordF_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordF_usuarioActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_user.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(lbl_contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordF_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_usuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(cmd_inicicar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordF_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(cmd_inicicar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/image_login.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbl2.getAccessibleContext().setAccessibleName("Por favor ingrese sus datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_inicicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_inicicarActionPerformed
            coordinador.iniciarSesion();
    }//GEN-LAST:event_cmd_inicicarActionPerformed

    private void cbx_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_usuarioActionPerformed

    private void jPasswordF_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordF_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordF_usuarioActionPerformed

    private void cmd_inicicarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_inicicarMouseEntered
        cmd_inicicar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_inicicarMouseEntered

    private void cmd_inicicarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_inicicarMouseExited
        cmd_inicicar.setBackground(new Color(82, 0, 255));
    }//GEN-LAST:event_cmd_inicicarMouseExited

    private void cbx_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_usuarioMouseEntered
        cbx_usuario.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cbx_usuarioMouseEntered

    private void cbx_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_usuarioMouseExited
        cbx_usuario.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_cbx_usuarioMouseExited

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
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }
    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cbx_usuario;
    private javax.swing.JButton cmd_inicicar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordF_usuario;
    private java.awt.Label lbl1;
    private java.awt.Label lbl2;
    private java.awt.Label lbl_contrasenia;
    private java.awt.Label lbl_usuario;
    // End of variables declaration//GEN-END:variables

}
