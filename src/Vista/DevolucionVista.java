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
public class DevolucionVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Devolucion
     */
    public DevolucionVista() {
        initComponents();
        this.setSize(605,430);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_compra = new javax.swing.JTable();
        lbl_filtrar = new javax.swing.JLabel();
        txt_id_dev = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tabla de devoluciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_dev.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_compra.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_compra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2", "Prueba de embarazo", "Estado quebrado"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        tabla_compra.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_compra.setName(""); // NOI18N
        tabla_compra.setRequestFocusEnabled(false);
        tabla_compra.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tabla_compra.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_compra);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 704, 180));

        lbl_filtrar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_filtrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_filtrar.setText("Filtrar:");
        getContentPane().add(lbl_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 80, -1));

        txt_id_dev.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_id_dev.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id_dev.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        getContentPane().add(txt_id_dev, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 370, 800, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 790, 30));

        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Datos de devolución:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 73, 190, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_arriba.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 220, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filtrar;
    private javax.swing.JTable tabla_compra;
    private javax.swing.JTextField txt_id_dev;
    // End of variables declaration//GEN-END:variables
}
