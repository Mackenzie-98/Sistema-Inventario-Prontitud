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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Genesis Vargas
 */
public class LoteVista extends javax.swing.JInternalFrame {

    public static Coordinador coordinador;
    public LoteVista() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2); 
    }
        public LoteVista(Coordinador coordinador) {
        this.coordinador=coordinador;
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2); 
    }

    public JTable getTabla_lote() {
        return tabla_lote;
    }

    public void setTabla_lote(JTable tabla_lote) {
        this.tabla_lote = tabla_lote;
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
        tabla_lote = new javax.swing.JTable();
        lbl_filtro = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        cmd_modificar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cmd_eliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Tabla de lotes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_lot.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_lote.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        tabla_lote.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_lote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod. Lote", "Cantidad", "Fecha de vencimiento", "Laboratorio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_lote.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_lote.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabla_lote.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_lote);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 730, 230));

        lbl_filtro.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        lbl_filtro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_filtro.setText("Filtrar");
        getContentPane().add(lbl_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

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
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 120, -1));

        cmd_modificar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_modificar.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
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
        getContentPane().add(cmd_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 130, 23));

        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lotes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 120, 40));

        cmd_eliminar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_eliminar.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 14)); // NOI18N
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
        getContentPane().add(cmd_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 130, 23));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo_dos.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_abajo.png"))); // NOI18N
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 770, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void cmd_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_modificarActionPerformed
        coordinador.verModLoteVista();
    }//GEN-LAST:event_cmd_modificarActionPerformed

    private void cmd_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_eliminarActionPerformed
       coordinador.eliminarLote();
    }//GEN-LAST:event_cmd_eliminarActionPerformed

    private void txt_filtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_filtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_filtroActionPerformed
    
    TableRowSorter trs;
    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        this.getTxt_filtro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+getTxt_filtro().getText(), 0,1,2,3));
            }            
        });
        trs = new TableRowSorter((DefaultTableModel)getTabla_lote().getModel());
        this.getTabla_lote().setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped
    
    public JTextField getTxt_filtro() {
        return txt_filtro;
    }

    public void setTxt_filtrar(JTextField txt_filtrar) {
        this.txt_filtro = txt_filtrar;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_eliminar;
    private javax.swing.JButton cmd_modificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filtro;
    private javax.swing.JTable tabla_lote;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables
}
