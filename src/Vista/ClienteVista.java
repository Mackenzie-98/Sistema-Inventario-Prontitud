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
public class ClienteVista extends javax.swing.JInternalFrame {

    /** Creates new form Cliente */
    public static Coordinador coordinador;
    
    public ClienteVista() {
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2);  
    }
    
    public ClienteVista(Coordinador coordinador) {
        this.coordinador = coordinador;
        initComponents();
        this.setResizable(false);
        this.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
           (desktopSize.height- jInternalFrameSize.height)/2);  
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_filtrar = new javax.swing.JLabel();
        txt_filtro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new javax.swing.JTable();
        cmd_modificar = new javax.swing.JButton();
        cmd_eliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Tabla de clientes");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_cli.png"))); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_filtrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        lbl_filtrar.setText("Filtrar:");
        getContentPane().add(lbl_filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 80, -1));

        txt_filtro.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        txt_filtro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_filtro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        getContentPane().add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 129, 23));

        tabla_cliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        tabla_cliente.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificación", "Nombre", "Fecha de nacimiento", "Telefono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_cliente.setGridColor(new java.awt.Color(0, 51, 204));
        tabla_cliente.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabla_cliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla_cliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 650, 230));

        cmd_modificar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_modificar.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
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
        getContentPane().add(cmd_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 129, 23));

        cmd_eliminar.setBackground(new java.awt.Color(0, 51, 204));
        cmd_eliminar.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
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
        getContentPane().add(cmd_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 129, 23));

        jLabel7.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Clientes");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 140, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 740, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_abajoLL.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 720, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/ImagenFondo/fondo_largo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    TableRowSorter trs;
    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        this.getTxt_filtro().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+getTxt_filtro().getText(), 0,1,2,3));
            }            
        });
        trs = new TableRowSorter((DefaultTableModel)getTabla_cliente().getModel());
        this.getTabla_cliente().setRowSorter(trs);
    }//GEN-LAST:event_txt_filtroKeyTyped

    private void cmd_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_modificarActionPerformed
        coordinador.verModClienteVista();
    }//GEN-LAST:event_cmd_modificarActionPerformed

    private void cmd_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_eliminarActionPerformed
        coordinador.eliminarCliente(); 
    }//GEN-LAST:event_cmd_eliminarActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd_eliminar;
    private javax.swing.JButton cmd_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_filtrar;
    private javax.swing.JTable tabla_cliente;
    private javax.swing.JTextField txt_filtro;
    // End of variables declaration//GEN-END:variables

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbl_filtrar() {
        return lbl_filtrar;
    }

    public void setLbl_filtrar(JLabel lbl_filtrar) {
        this.lbl_filtrar = lbl_filtrar;
    }

    public JTable getTabla_cliente() {
        return tabla_cliente;
    }

    public void setTabla_cliente(JTable tabla_cliente) {
        this.tabla_cliente = tabla_cliente;
    }

    public JTextField getTxt_filtro() {
        return txt_filtro;
    }

    public void setTxt_id(JTextField txt_filtro) {
        this.txt_filtro = txt_filtro;
    }
}