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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Genesis Vargas
 */
public class VentaVista extends javax.swing.JInternalFrame {

    public static Coordinador coordinador=new Coordinador();
    public VentaVista() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true); 
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2);
    }
        public VentaVista(Coordinador coordinador) {
            this.coordinador=coordinador;
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

        jScrollPane4 = new javax.swing.JScrollPane();
        tabla_venta = new javax.swing.JTable();
        lbl_filtro = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        cmd_modificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Tabla de ventas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_ventas.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_venta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        tabla_venta.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Factura", "Cod. Producto", "Nombre producto", "Nombre de cliente", "Cantidad", "Precio", "Descuento", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_venta.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_venta.setName(""); // NOI18N
        tabla_venta.setRequestFocusEnabled(false);
        tabla_venta.setSelectionBackground(new java.awt.Color(0, 51, 204));
        tabla_venta.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabla_venta);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 750, 200));

        lbl_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_filtro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_filtro.setText("Filtrar");
        getContentPane().add(lbl_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

        txt_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        txt_filtro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));

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
        getContentPane().add(cmd_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 120, 23));

        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ventas");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 770, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 770, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_abajoLL.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 360, 780, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseEntered
        cmd_modificar.setBackground(Color.DARK_GRAY);
    }//GEN-LAST:event_cmd_modificarMouseEntered

    private void cmd_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmd_modificarMouseExited
        cmd_modificar.setBackground(new Color(0,51,204));
    }//GEN-LAST:event_cmd_modificarMouseExited

    TableRowSorter trs;
    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
       this.getTxt_filtro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+getTxt_filtro().getText(), 0,1,2,3,4,5,6,7,8));
            }            
        });
        trs = new TableRowSorter((DefaultTableModel)getTabla_venta().getModel());
        this.getTabla_venta().setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped

    private void cmd_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_modificarActionPerformed
        coordinador.verModVentaVista();
    }//GEN-LAST:event_cmd_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_modificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_filtro;
    private javax.swing.JTable tabla_venta;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables

    public JButton getCmd_modificar() {
        return cmd_modificar;
    }

    public void setCmd_modificar(JButton cmd_modificar) {
        this.cmd_modificar = cmd_modificar;
    }

    public JTable getTabla_venta() {
        return tabla_venta;
    }

    public void setTabla_venta(JTable tabla_venta) {
        this.tabla_venta = tabla_venta;
    }

    public JTextField getTxt_filtro() {
        return txt_filtro;
    }

    public void setTxt_filtro(JTextField txt_filtro) {
        this.txt_filtro = txt_filtro;
    }

}
