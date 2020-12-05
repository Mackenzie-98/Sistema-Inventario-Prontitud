/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.InicioVista.escritorio;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Genesis Vargas
 */
public class ProductoVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Prueba
     */
    public ProductoVista() {
        initComponents();
        this.setSize(784,401);
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
        tabla_producto = new javax.swing.JTable();
        lbl_id = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Tabla de productos");

        tabla_producto.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cantidad", "Precio Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_producto.setEnabled(false);
        tabla_producto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_producto);

        lbl_id.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id.setText("Identificador");

        txt_nombre.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(lbl_id, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbl_id() {
        return lbl_id;
    }

    public void setLbl_id(JLabel lbl_id) {
        this.lbl_id = lbl_id;
    }

    public JTable getTabla_producto() {
        return tabla_producto;
    }

    public void setTabla_producto(JTable tabla_producto) {
        this.tabla_producto = tabla_producto;
    }

    public JTextField getTxt_nombre() {
        return txt_nombre;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_nombre = txt_nombre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTable tabla_producto;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
