/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladores.Coordinador;
import static Vista.InicioVista.escritorio;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Genes
 */
public class DevolucionVista extends javax.swing.JInternalFrame {

    

    public JButton getCmd_modificar() {
        return cmd_modificar;
    }

    public void setCmd_modificar(JButton cmd_modificar) {
        this.cmd_modificar = cmd_modificar;
    }

    public JTable getTabla_dev() {
        return tabla_dev;
    }

    public void setTabla_dev(JTable tabla_dev) {
        this.tabla_dev = tabla_dev;
    }

    public JTextField getTxt_filtro() {
        return txt_filtro;
    }

    /**
     * Creates new form Devolucion
     */
    public void setTxt_filtro(JTextField txt_filtro) {
        this.txt_filtro = txt_filtro;
    }

    public static Coordinador coordinador;
    public DevolucionVista(Coordinador coordinador) {
        this.coordinador = coordinador;
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    public DevolucionVista() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_dev = new javax.swing.JTable();
        lbl_filtro = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmd_modificar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tabla de devoluciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_dev.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_dev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        tabla_dev.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_dev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Factura", "Cod. Producto", "Nombre producto", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_dev.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_dev.setName(""); // NOI18N
        tabla_dev.setRequestFocusEnabled(false);
        tabla_dev.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tabla_dev.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_dev);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 650, 190));

        lbl_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_filtro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_filtro.setText("Filtrar:");
        getContentPane().add(lbl_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

        txt_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_filtro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));

        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Devoluciones");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 720, 30));

        cmd_modificar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_modificar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cmd_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_buscar_prov.png"))); // NOI18N
        cmd_modificar.setText("Modificar");
        cmd_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmd_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmd_modificarMouseExited(evt);
            }
        });
        cmd_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 120, 23));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_abajoL.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 730, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseEntered
        cmd_modificar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_modificarMouseEntered

    private void cmd_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseExited
        cmd_modificar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_modificarMouseExited

    private void cmd_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_modificarActionPerformed
        ModificarDevolucionVista ver_ventana = new ModificarDevolucionVista();
        escritorio.add(ver_ventana);
        this.setVisible(false);
        ver_ventana.show();
    }//GEN-LAST:event_cmd_modificarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_modificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filtro;
    private javax.swing.JTable tabla_dev;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
