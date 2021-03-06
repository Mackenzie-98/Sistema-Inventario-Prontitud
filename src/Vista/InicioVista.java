/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladores.Coordinador;
import static Controladores.Coordinador.inicio;
import Vista.ImagenFondo.ImagenFondo;
import static Vista.LoginVista.cbx_usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Genesis Vargas
 */
public class InicioVista extends javax.swing.JFrame {

    public LoginVista usuario;
    public static Coordinador coordinador = new Coordinador();
    String tipo;

    /**
     * Creates new form Inicio
     */
    public InicioVista() {
        initComponents();
        this.setResizable(false);
        this.setTitle("Droguería Prontitud");
        this.setIconImage(new ImageIcon(getClass().getResource("icons/icon_inicio.png")).getImage());
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(InicioVista.MAXIMIZED_HORIZ);
    }

    public InicioVista(Coordinador coordinador) {

        this.coordinador = coordinador;
        initComponents();
        this.setSize(800, 585);
        this.setResizable(false);
        this.setTitle("Droguería Prontitud");
        this.setIconImage(new ImageIcon(getClass().getResource("icons/icon_inicio.png")).getImage());

        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(InicioVista.MAXIMIZED_HORIZ);

    }

    public void validar() {
        tipo = String.valueOf(cbx_usuario.getSelectedItem());
        if (tipo.equals("Vendedor")) {
            jm_prov.setEnabled(false);
            jmi_registrar_c.setEnabled(false);
            jmi_agg_prod.setEnabled(false);
            jmi_factura_c.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_prod = new javax.swing.JMenu();
        jmi_mostrar_prod = new javax.swing.JMenuItem();
        jmi_mostrar_lotes = new javax.swing.JMenuItem();
        jmi_agg_prod = new javax.swing.JMenuItem();
        jm_prov = new javax.swing.JMenu();
        jmi_mostrar_prov = new javax.swing.JMenuItem();
        jmi_agg_prov = new javax.swing.JMenuItem();
        jm_cliente = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmi_mostrar_clientes = new javax.swing.JMenuItem();
        jmi_agg_cliente = new javax.swing.JMenuItem();
        jm_registrar = new javax.swing.JMenu();
        jmi_mostrar_c = new javax.swing.JMenuItem();
        jmi_factura_c = new javax.swing.JMenuItem();
        jmi_registrar_c = new javax.swing.JMenuItem();
        jm_facturas = new javax.swing.JMenu();
        jmi_mostrar_v = new javax.swing.JMenuItem();
        jmi_facturasV = new javax.swing.JMenuItem();
        jmi_registrar_v = new javax.swing.JMenuItem();
        jm_dev = new javax.swing.JMenu();
        jmi_mostrar_dev = new javax.swing.JMenuItem();
        jmi_reg_dev = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 204)));
        escritorio.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jMenuBar1.setForeground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jMenuBar1.setName(""); // NOI18N

        jm_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/image_prod.png"))); // NOI18N
        jm_prod.setText("Producto");
        jm_prod.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N

        jmi_mostrar_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmi_mostrar_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_mostrar_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_prod.png"))); // NOI18N
        jmi_mostrar_prod.setText("Ver productos");
        jmi_mostrar_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_mostrar_prod);

        jmi_mostrar_lotes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jmi_mostrar_lotes.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_mostrar_lotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_lot.png"))); // NOI18N
        jmi_mostrar_lotes.setText("Ver lotes");
        jmi_mostrar_lotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_lotesActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_mostrar_lotes);

        jmi_agg_prod.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jmi_agg_prod.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_agg_prod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_resg_prod.png"))); // NOI18N
        jmi_agg_prod.setText("Registrar");
        jmi_agg_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_prodActionPerformed(evt);
            }
        });
        jm_prod.add(jmi_agg_prod);

        jMenuBar1.add(jm_prod);

        jm_prov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_prov.png"))); // NOI18N
        jm_prov.setText("Proveedor");
        jm_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jm_prov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jm_prov.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jmi_mostrar_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_mostrar_prov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_prov.png"))); // NOI18N
        jmi_mostrar_prov.setText("Ver proveedores");
        jmi_mostrar_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_mostrar_prov);

        jmi_agg_prov.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_agg_prov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_prov.png"))); // NOI18N
        jmi_agg_prov.setText("Registrar");
        jmi_agg_prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_provActionPerformed(evt);
            }
        });
        jm_prov.add(jmi_agg_prov);

        jMenuBar1.add(jm_prov);

        jm_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_clientes.png"))); // NOI18N
        jm_cliente.setText("Cliente");
        jm_cliente.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jm_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_clienteActionPerformed(evt);
            }
        });
        jm_cliente.add(jSeparator1);

        jmi_mostrar_clientes.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jmi_mostrar_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_cli.png"))); // NOI18N
        jmi_mostrar_clientes.setText("Ver clientes");
        jmi_mostrar_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_clientesActionPerformed(evt);
            }
        });
        jm_cliente.add(jmi_mostrar_clientes);

        jmi_agg_cliente.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_agg_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_cli.png"))); // NOI18N
        jmi_agg_cliente.setText("Registrar");
        jmi_agg_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_agg_clienteActionPerformed(evt);
            }
        });
        jm_cliente.add(jmi_agg_cliente);

        jMenuBar1.add(jm_cliente);

        jm_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_registrar.png"))); // NOI18N
        jm_registrar.setText("Compras");
        jm_registrar.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N

        jmi_mostrar_c.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N
        jmi_mostrar_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_compras.png"))); // NOI18N
        jmi_mostrar_c.setText("Ver compras");
        jmi_mostrar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_cActionPerformed(evt);
            }
        });
        jm_registrar.add(jmi_mostrar_c);

        jmi_factura_c.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jmi_factura_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_fac_comp.png"))); // NOI18N
        jmi_factura_c.setText("Ver Facturas compra");
        jmi_factura_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_factura_cActionPerformed(evt);
            }
        });
        jm_registrar.add(jmi_factura_c);

        jmi_registrar_c.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_registrar_c.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_comp.png"))); // NOI18N
        jmi_registrar_c.setText("Registrar compra");
        jmi_registrar_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_registrar_cActionPerformed(evt);
            }
        });
        jm_registrar.add(jmi_registrar_c);

        jMenuBar1.add(jm_registrar);

        jm_facturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_facturas.png"))); // NOI18N
        jm_facturas.setText("Ventas");
        jm_facturas.setFocusable(false);
        jm_facturas.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N

        jmi_mostrar_v.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_mostrar_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_ventas.png"))); // NOI18N
        jmi_mostrar_v.setText("Ver ventas");
        jmi_mostrar_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_vActionPerformed(evt);
            }
        });
        jm_facturas.add(jmi_mostrar_v);

        jmi_facturasV.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_facturasV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_fac_vent.png"))); // NOI18N
        jmi_facturasV.setText("Ver facturas venta");
        jmi_facturasV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_facturasVActionPerformed(evt);
            }
        });
        jm_facturas.add(jmi_facturasV);

        jmi_registrar_v.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_registrar_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_vent.png"))); // NOI18N
        jmi_registrar_v.setText("Registrar venta");
        jmi_registrar_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_registrar_vActionPerformed(evt);
            }
        });
        jm_facturas.add(jmi_registrar_v);

        jMenuBar1.add(jm_facturas);

        jm_dev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_dev.png"))); // NOI18N
        jm_dev.setText("Devolución");
        jm_dev.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 14)); // NOI18N

        jmi_mostrar_dev.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jmi_mostrar_dev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_ver_dev.png"))); // NOI18N
        jmi_mostrar_dev.setText("Ver devoluciones");
        jmi_mostrar_dev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_mostrar_devActionPerformed(evt);
            }
        });
        jm_dev.add(jmi_mostrar_dev);

        jmi_reg_dev.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 14)); // NOI18N
        jmi_reg_dev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/icons/icon_reg_dev.png"))); // NOI18N
        jmi_reg_dev.setText("Registrar");
        jmi_reg_dev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmi_reg_devActionPerformed(evt);
            }
        });
        jm_dev.add(jmi_reg_dev);

        jMenuBar1.add(jm_dev);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_clienteActionPerformed

    }//GEN-LAST:event_jm_clienteActionPerformed

    private void jmi_agg_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_prodActionPerformed
        coordinador.registrarProductoVista();
    }//GEN-LAST:event_jmi_agg_prodActionPerformed

    public LoginVista getUsuario() {
        return usuario;
    }

    public void setUsuario(LoginVista usuario) {
        this.usuario = usuario;
    }

    public static JDesktopPane getEscritorio() {
        return escritorio;
    }

    public static void setEscritorio(JDesktopPane escritorio) {
        InicioVista.escritorio = escritorio;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JPopupMenu.Separator getjSeparator1() {
        return jSeparator1;
    }

    public void setjSeparator1(JPopupMenu.Separator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    public JMenu getJm_cliente() {
        return jm_cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public void setJm_cliente(JMenu jm_cliente) {
        this.jm_cliente = jm_cliente;
    }

    public JMenu getJm_dev() {
        return jm_dev;
    }

    public void setJm_dev(JMenu jm_dev) {
        this.jm_dev = jm_dev;
    }

    public JMenu getJm_facturas() {
        return jm_facturas;
    }

    public void setJm_facturas(JMenu jm_facturas) {
        this.jm_facturas = jm_facturas;
    }

    public JMenu getJm_prod() {
        return jm_prod;
    }

    public void setJm_prod(JMenu jm_prod) {
        this.jm_prod = jm_prod;
    }

    public JMenu getJm_prov() {
        return jm_prov;
    }

    public void setJm_prov(JMenu jm_prov) {
        this.jm_prov = jm_prov;
    }

    public JMenu getJm_registrar() {
        return jm_registrar;
    }

    public void setJm_registrar(JMenu jm_registrar) {
        this.jm_registrar = jm_registrar;
    }

    public JMenuItem getJmi_agg_cliente() {
        return jmi_agg_cliente;
    }

    public void setJmi_agg_cliente(JMenuItem jmi_agg_cliente) {
        this.jmi_agg_cliente = jmi_agg_cliente;
    }

    public JMenuItem getJmi_agg_prod() {
        return jmi_agg_prod;
    }

    public void setJmi_agg_prod(JMenuItem jmi_agg_prod) {
        this.jmi_agg_prod = jmi_agg_prod;
    }

    public JMenuItem getJmi_agg_prov() {
        return jmi_agg_prov;
    }

    public void setJmi_agg_prov(JMenuItem jmi_agg_prov) {
        this.jmi_agg_prov = jmi_agg_prov;
    }

    public JMenuItem getJmi_facturasC() {
        return jmi_factura_c;
    }

    public void setJmi_facturasC(JMenuItem jmi_facturasC) {
        this.jmi_factura_c = jmi_facturasC;
    }

    public JMenuItem getJmi_facturasV() {
        return jmi_facturasV;
    }

    public void setJmi_facturasV(JMenuItem jmi_facturasV) {
        this.jmi_facturasV = jmi_facturasV;
    }

    public JMenuItem getJmi_mostrar_clientes() {
        return jmi_mostrar_clientes;
    }

    public void setJmi_mostrar_clientes(JMenuItem jmi_mostrar_clientes) {
        this.jmi_mostrar_clientes = jmi_mostrar_clientes;
    }

    public JMenuItem getJmi_mostrar_dev() {
        return jmi_mostrar_dev;
    }

    public void setJmi_mostrar_dev(JMenuItem jmi_mostrar_dev) {
        this.jmi_mostrar_dev = jmi_mostrar_dev;
    }

    public JMenuItem getJmi_mostrar_lotes() {
        return jmi_mostrar_lotes;
    }

    public void setJmi_mostrar_lotes(JMenuItem jmi_mostrar_lotes) {
        this.jmi_mostrar_lotes = jmi_mostrar_lotes;
    }

    public JMenuItem getJmi_mostrar_prod() {
        return jmi_mostrar_prod;
    }

    public void setJmi_mostrar_prod(JMenuItem jmi_mostrar_prod) {
        this.jmi_mostrar_prod = jmi_mostrar_prod;
    }

    public JMenuItem getJmi_mostrar_prov() {
        return jmi_mostrar_prov;
    }

    public void setJmi_mostrar_prov(JMenuItem jmi_mostrar_prov) {
        this.jmi_mostrar_prov = jmi_mostrar_prov;
    }

    public JMenuItem getJmi_reg_dev() {
        return jmi_reg_dev;
    }

    public void setJmi_reg_dev(JMenuItem jmi_reg_dev) {
        this.jmi_reg_dev = jmi_reg_dev;
    }

    public JMenuItem getJmi_registrar_c() {
        return jmi_registrar_c;
    }

    public void setJmi_registrar_c(JMenuItem jmi_registrar_c) {
        this.jmi_registrar_c = jmi_registrar_c;
    }

    public JMenuItem getJmi_registrar_v() {
        return jmi_registrar_v;
    }

    public void setJmi_registrar_v(JMenuItem jmi_registrar_v) {
        this.jmi_registrar_v = jmi_registrar_v;
    }

    private void jmi_buscar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_buscar_prodActionPerformed

    }//GEN-LAST:event_jmi_buscar_prodActionPerformed

    private void jmi_mostrar_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_prodActionPerformed
        coordinador.verProductos();
    }//GEN-LAST:event_jmi_mostrar_prodActionPerformed

    private void jmi_agg_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_provActionPerformed
        coordinador.registrarProveedorVista();
    }//GEN-LAST:event_jmi_agg_provActionPerformed

    private void jmi_mostrar_provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_provActionPerformed
        coordinador.verProveedores();
    }//GEN-LAST:event_jmi_mostrar_provActionPerformed

    private void jmi_buscar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_buscar_clienteActionPerformed

    }//GEN-LAST:event_jmi_buscar_clienteActionPerformed

    private void jmi_agg_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_agg_clienteActionPerformed
        coordinador.registrarCliente();
    }//GEN-LAST:event_jmi_agg_clienteActionPerformed

    private void jmi_mostrar_lotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_lotesActionPerformed
        coordinador.verLotes();
    }//GEN-LAST:event_jmi_mostrar_lotesActionPerformed

    private void jmi_factura_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_factura_cActionPerformed
        FacturaCompraVista ver_ventana = new FacturaCompraVista();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_factura_cActionPerformed

    private void jmi_facturasVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_facturasVActionPerformed
        FacturaVentaVista ver_ventana = new FacturaVentaVista();
        escritorio.add(ver_ventana);
        ver_ventana.show();
    }//GEN-LAST:event_jmi_facturasVActionPerformed

    private void jmi_registrar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_registrar_cActionPerformed
        coordinador.registrarCompraVista();
    }//GEN-LAST:event_jmi_registrar_cActionPerformed

    private void jmi_registrar_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_registrar_vActionPerformed
        coordinador.registrarVentaVista();
    }//GEN-LAST:event_jmi_registrar_vActionPerformed

    private void jmi_mostrar_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_clientesActionPerformed
        coordinador.verClientes();
    }//GEN-LAST:event_jmi_mostrar_clientesActionPerformed

    private void jmi_mostrar_devActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_devActionPerformed
        coordinador.verDevoluciones();
    }//GEN-LAST:event_jmi_mostrar_devActionPerformed

    private void jmi_reg_devActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_reg_devActionPerformed
        coordinador.registrarDevolucionVista();
    }//GEN-LAST:event_jmi_reg_devActionPerformed

    private void jmi_mostrar_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_vActionPerformed
        coordinador.verVentas();
    }//GEN-LAST:event_jmi_mostrar_vActionPerformed

    private void jmi_mostrar_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmi_mostrar_cActionPerformed
        coordinador.verCompras();
    }//GEN-LAST:event_jmi_mostrar_cActionPerformed

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
            java.util.logging.Logger.getLogger(InicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu jm_cliente;
    private javax.swing.JMenu jm_dev;
    private javax.swing.JMenu jm_facturas;
    private javax.swing.JMenu jm_prod;
    private javax.swing.JMenu jm_prov;
    private javax.swing.JMenu jm_registrar;
    private javax.swing.JMenuItem jmi_agg_cliente;
    private javax.swing.JMenuItem jmi_agg_prod;
    private javax.swing.JMenuItem jmi_agg_prov;
    private javax.swing.JMenuItem jmi_factura_c;
    private javax.swing.JMenuItem jmi_facturasV;
    private javax.swing.JMenuItem jmi_mostrar_c;
    private javax.swing.JMenuItem jmi_mostrar_clientes;
    private javax.swing.JMenuItem jmi_mostrar_dev;
    private javax.swing.JMenuItem jmi_mostrar_lotes;
    private javax.swing.JMenuItem jmi_mostrar_prod;
    private javax.swing.JMenuItem jmi_mostrar_prov;
    private javax.swing.JMenuItem jmi_mostrar_v;
    private javax.swing.JMenuItem jmi_reg_dev;
    private javax.swing.JMenuItem jmi_registrar_c;
    private javax.swing.JMenuItem jmi_registrar_v;
    // End of variables declaration//GEN-END:variables

}
