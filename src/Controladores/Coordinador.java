package Controladores;

import Modelo.*;
import Vista.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Coordinador {

    public static LoginVista login;
    public static InicioVista inicio;
    public static ClienteVista clienteVista;
    public static ProductoVista productoVista;
    public static ProveedorVista proveedorVista;
    public static AgregarClienteVista agregarClienteVista;
    public static LoteVista loteVista;
    public static AgregarProveedorVista agregarProveedorVista;
    public static AgregarProductoVista agregarProductoVista;
    public static Conexion conexion = Conexion.getConexion();

    public static void main(String[] agrs) throws SQLException {
        login = new LoginVista();
        login.setVisible(true);
    }

    public void iniciarSesion() {
        inicio = new InicioVista(this);
        inicio.setVisible(true);
        login.setVisible(false);
    }
    public void registrarProveedorVista() {
        agregarProveedorVista = new AgregarProveedorVista(this);
        inicio.getEscritorio().add(agregarProveedorVista);
        agregarProveedorVista.show();
    }
    
     public void agregarProveedor() {
        String nit = agregarProveedorVista.getTxt_nit().getText();
        String nombre = agregarProveedorVista.getTxt_nombre().getText();
        String ciudad = agregarProveedorVista.getTxt_ciudad().getText();
        String correo=agregarProveedorVista.getTxt_correo().getText();
        String telefono=agregarProveedorVista.getTxt_tel().getText();
        String direccion=agregarProveedorVista.getTxt_direccion().getText();
        if ("".equals(nit)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de identificación", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nombre)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Proveedor nuevo = new Proveedor(nit, nombre, direccion, ciudad,correo, telefono);
                ProveedorJpaController controller = new ProveedorJpaController(conexion.getBd());
                controller.create(nuevo);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar proveedor", JOptionPane.INFORMATION_MESSAGE);
                agregarProveedorVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void registrarProductoVista() {
        agregarProductoVista = new AgregarProductoVista(this);
        inicio.getEscritorio().add(agregarProductoVista);
        agregarProductoVista.show();
    }
       
    public void agregarProducto() {        
        String id = agregarProductoVista.getTxt_id().getText();
        String nombre = agregarProductoVista.getTxt_nombre().getText();
        String cantidad = agregarProductoVista.getTxt_cant().getText();
        String precio = agregarProductoVista.getTxt_precio().getText();
        String stock = agregarProductoVista.getTxt_stock().getText();
        String lab = agregarProductoVista.getTxt_lab().getText();
        String numLote = agregarProductoVista.getTxt_lote().getText();
        String fecha = agregarProductoVista.getTxt_fecha().getText();
        Integer numCategoria = agregarProductoVista.getCbx_categoria().getSelectedIndex() + 1;
        
        if ("".equals(id)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el id del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if("".equals(nombre)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if ("".equals(cantidad)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la cantidad del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if ("".equals(precio)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el precio del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if ("".equals(lab)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el laboratorio del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if ("".equals(numLote)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de lote", "ERROR", JOptionPane.WARNING_MESSAGE);
        else if ("".equals(fecha)) JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la fecha de vencimiento", "ERROR", JOptionPane.WARNING_MESSAGE);
        else{
            try { 
                //Controllers
                CategoriaJpaController categoriaCon = new CategoriaJpaController(conexion.getBd());
                ProductoJpaController productoCon = new ProductoJpaController(conexion.getBd());    
                LoteJpaController loteCon = new LoteJpaController(conexion.getBd());
                DetalleLoteJpaController detalleLoteCon = new DetalleLoteJpaController(conexion.getBd());
                
                //Entidades
                Categoria categoria = categoriaCon.findCategoria(numCategoria);
                Producto producto = new Producto(Integer.parseInt(id), nombre, Long.parseLong(precio), Integer.parseInt(stock), categoria);
                if(productoCon.findProducto(Integer.parseInt(id)) == null) productoCon.create(producto);
                Lote lote = new Lote(Integer.parseInt(numLote), this.obtenerFecha(fecha), lab);
                DetalleLote detalleLote = new DetalleLote(new DetalleLotePK(), cantidad);
                
                loteCon.create(lote); detalleLote.setProducto(producto); detalleLote.setLote(lote);
                detalleLoteCon.create(detalleLote);                
                
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar producto", JOptionPane.INFORMATION_MESSAGE);
                agregarProductoVista.limpiar();
            } catch (Exception ex) { 
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void verClientes() {
        clienteVista = new ClienteVista();
        ClienteJpaController clienteCon = new ClienteJpaController(conexion.getBd());
        List<Cliente> clientes = clienteCon.findClienteEntities();
        DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
        for (Cliente x : clientes) {
            model.addRow(new Object[]{x.getIdentificacion(), x.getNombre(), x.getStringFecha(), x.getCorreo()});
        }
        clienteVista.getTabla_cliente().setModel(model);
        inicio.getEscritorio().add(clienteVista);
        clienteVista.setVisible(true);
    }

    public void verProductos() {
        try {
            productoVista = new ProductoVista();
            Statement st;
            st = conexion.getConexionSQL().createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT p.id_producto, p.nombre, SUM(dl.cantidad), p.precio_unitario FROM Producto p\n"
                    + "LEFT JOIN Detalle_Lote dl on dl.id_producto_FK=p.id_producto\n"
                    + "GROUP BY p.id_producto, p.nombre,p.precio_unitario;");
            Object datos[] = new String[4];
            DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                model.addRow(datos);
            }
            productoVista.getTabla_producto().setModel(model);
            inicio.getEscritorio().add(productoVista);
            productoVista.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void verProveedores() {
        proveedorVista = new ProveedorVista();
        ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
        List<Proveedor> proveedores = proveedorCon.findProveedorEntities();
        DefaultTableModel model = (DefaultTableModel) proveedorVista.getTabla_proveedor().getModel();
        for (Proveedor x : proveedores) {
            model.addRow(new String[]{x.getNit(), x.getNombre(), x.getCiudad(), x.getCorreo(), x.getTelefono(),x.getDireccion()});
        }
        proveedorVista.getTabla_proveedor().setModel(model);
        inicio.getEscritorio().add(proveedorVista);
        proveedorVista.setVisible(true);
    }

    public void agregarCliente() {
        String id = agregarClienteVista.getTxt_id().getText();
        String nombre = agregarClienteVista.getTxt_nombre().getText();
        String fecha_nac = agregarClienteVista.getTxt_fecha_nac().getText();
        String telefono = agregarClienteVista.getTxt_telefono().getText();
        String correo = agregarClienteVista.getTxt_correo().getText();

        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de identificación", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nombre)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                Cliente nuevo = new Cliente(id, nombre, this.obtenerFecha(fecha_nac), telefono, correo);
                ClienteJpaController controller = new ClienteJpaController(conexion.getBd());
                controller.create(nuevo);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar cliente", JOptionPane.INFORMATION_MESSAGE);
                agregarClienteVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void registrarCliente() {
        agregarClienteVista = new AgregarClienteVista(this);
        inicio.getEscritorio().add(agregarClienteVista);
        agregarClienteVista.show();
    }

    public java.util.Date obtenerFecha(String fecha) {
        java.util.Date now = null;
        try {
            now = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            //System.out.println(now.getDate()+"-"+(now.getMonth()+1)+"-"+(now.getYear()+1900));
        } catch (ParseException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return now;
    }

    public void verLotes() {
        try {
            loteVista=new LoteVista(this);
            Statement st;
            st = conexion.getConexionSQL().createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT P.id_producto, L.id_lote, P.nombre, DL.cantidad, L.fecha_vencimiento, L.laboratorio FROM Producto P\n"
                    + "INNER JOIN Detalle_Lote DL on DL.id_producto_FK=P.id_producto\n"
                    + "INNER JOIN Lote L on L.id_lote=DL.id_lote_FK;");
            Object datos[] = new String[6];
            DefaultTableModel model = (DefaultTableModel) loteVista.getTabla_lote().getModel();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
            loteVista.getTabla_lote().setModel(model);
            inicio.getEscritorio().add(loteVista);
            loteVista.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}