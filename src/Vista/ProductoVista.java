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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Genesis Vargas
 */
    

public class ProductoVista extends javax.swing.JInternalFrame {

    /**
     * Creates new form Prueba
     */
    public static Coordinador coordinador;
    
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
    
    public ProductoVista(Coordinador coordinador) {
        this.coordinador = coordinador;
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
        cmd_modificar = new javax.swing.JButton();
        txt_filtro = new javax.swing.JTextField();
        cmd_eliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Tabla de productos");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_prod.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_producto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        tabla_producto.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Producto", "Cod. Lote", "Nombre", "Precio Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_producto.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_producto.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabla_producto.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_producto);
        if (tabla_producto.getColumnModel().getColumnCount() > 0) {
            tabla_producto.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 732, 207));

        lbl_id.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_id.setText("Filtro:");
        getContentPane().add(lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 80, -1));

        cmd_modificar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_modificar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cmd_modificar.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(cmd_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 120, 23));

        txt_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_filtro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        txt_filtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_filtroActionPerformed(evt);
            }
        });
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 129, 23));

        cmd_eliminar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_eliminar.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        cmd_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        cmd_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_eliminar.png"))); // NOI18N
        cmd_eliminar.setText("Eliminar");
        cmd_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmd_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmd_eliminarMouseExited(evt);
            }
        });
        cmd_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(cmd_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 120, 23));

        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Productos");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 170, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo_dos.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_abajoLL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 770, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    TableRowSorter trs;
    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        this.getTxt_filtro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+getTxt_filtro().getText(), 0,1,2,3,4));
            }            
        });
        trs = new TableRowSorter((DefaultTableModel)getTabla_producto().getModel());
        this.getTabla_producto().setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped

    private void txt_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroActionPerformed

    private void cmd_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseEntered
        cmd_modificar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_modificarMouseEntered

    private void cmd_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseExited
        cmd_modificar.setBackground(new Color(0,51,204));
    }//GEN-LAST:event_cmd_modificarMouseExited

    private void cmd_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_eliminarMouseEntered
        cmd_eliminar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_eliminarMouseEntered

    private void cmd_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_eliminarMouseExited
        cmd_eliminar.setBackground(new Color(0,51,204));
    }//GEN-LAST:event_cmd_eliminarMouseExited

    private void cmd_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_eliminarActionPerformed
        coordinador.eliminarProducto();
    }//GEN-LAST:event_cmd_eliminarActionPerformed

    private void cmd_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_modificarActionPerformed
        coordinador.modificarProductos();
    }//GEN-LAST:event_cmd_modificarActionPerformed

    public JTextField getTxt_filtro() {
        return txt_filtro;
    }

    public void setTxt_filtro(JTextField txt_filtro) {
        this.txt_filtro = txt_filtro;
    }
                                             
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
        return txt_filtro;
    }

    public void setTxt_nombre(JTextField txt_nombre) {
        this.txt_filtro = txt_nombre;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_eliminar;
    private javax.swing.JButton cmd_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JTable tabla_producto;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
