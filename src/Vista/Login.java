/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

/**
 *
 * @author Genesis Vargas
 */
public class Login extends javax.swing.JFrame {

    /** Creates new form Login */
    public Login() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        lbl1 = new java.awt.Label();
        lbl2 = new java.awt.Label();
        lbl_usuario = new java.awt.Label();
        lbl_contrasenia = new java.awt.Label();
        cmd_inicicar = new javax.swing.JButton();
        cbx_usuario = new javax.swing.JComboBox<>();
        jPasswordF_usuario = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl1.setAlignment(java.awt.Label.CENTER);
        lbl1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        lbl1.setName(""); // NOI18N
        lbl1.setText("INICIO DE USUARIO");

        lbl2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        lbl2.setText("Ingrese sus datos:");

        lbl_usuario.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        lbl_usuario.setText("Usuario:");

        lbl_contrasenia.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        lbl_contrasenia.setText("Contraseña:");

        cmd_inicicar.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        cmd_inicicar.setText("Iniciar sesión");
        cmd_inicicar.setActionCommand("cmd_iniciar");
        cmd_inicicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_inicicarActionPerformed(evt);
            }
        });

        cbx_usuario.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        cbx_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "vendedor" }));
        cbx_usuario.setActionCommand("cbx_usuario");
        cbx_usuario.setName(""); // NOI18N
        cbx_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_usuarioActionPerformed(evt);
            }
        });

        jPasswordF_usuario.setText("jPasswordField1");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cmd_inicicar)
                .addGap(139, 139, 139))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordF_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordF_usuario)
                    .addComponent(lbl_contrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(cmd_inicicar)
                .addGap(24, 24, 24))
        );

        lbl1.getAccessibleContext().setAccessibleName("US");
        lbl2.getAccessibleContext().setAccessibleName("Por favor ingrese sus datos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_inicicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_inicicarActionPerformed

        try {
//            String cedula = fieldCedula.getText();
//            char[] pass = fieldPassword.getPassword();
//            Persona persona = negocio.validarSesion(cedula, pass);
//            if(persona!=null){
//                System.out.println("paso");
//                this.setVisible(false);
//                Sesion sesion = new Sesion(persona);
//                sesion.setVisible(true);
//            }
        } catch (Exception ex) {
            System.out.println("Hubo un error");
        }
    }//GEN-LAST:event_cmd_inicicarActionPerformed

    private void cbx_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cbx_usuario;
    private javax.swing.JButton cmd_inicicar;
    private javax.swing.JPasswordField jPasswordF_usuario;
    private java.awt.Label lbl1;
    private java.awt.Label lbl2;
    private java.awt.Label lbl_contrasenia;
    private java.awt.Label lbl_usuario;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

}