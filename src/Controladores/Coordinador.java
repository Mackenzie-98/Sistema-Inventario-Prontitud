package Controladores;

import Modelo.Lote;
import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Modelo.*;
import Vista.*;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Coordinador {

    //Creacion de Vistas
    public static LoginVista login;
    public static InicioVista inicio;
    public static ClienteVista clienteVista;
    public static ProductoVista productoVista;
    public static ProveedorVista proveedorVista;
    public static LoteVista loteVista;
    public static DevolucionVista devolucionVista;

    public static AgregarClienteVista agregarClienteVista;
    public static AgregarProveedorVista agregarProveedorVista;
    public static AgregarProductoVista agregarProductoVista;
    public static AgregarCompraVista agregarCompraVista;
    public static AgregarVentaVista agregarVentaVista;
    public static AgregarDevolucionVista agregarDevolucionVista;

    //Conexion
    public static Conexion conexion = Conexion.getConexion();

    public static void main(String[] agrs) throws SQLException {
        login = new LoginVista();
        login.setVisible(true);
    }

    public void iniciarSesion() {
        inicio = new InicioVista(this);
        inicio.show();
        login.setVisible(false);
    }

    /**
     * METODOS DE REGISTRAR
     */
    public void registrarProductoVista() {
        agregarProductoVista = new AgregarProductoVista(this);
        inicio.getEscritorio().add(agregarProductoVista);
        agregarProductoVista.show();
        agregarProductoVista.toFront();
    }

    public void registrarCliente() {
        agregarClienteVista = new AgregarClienteVista(this);
        inicio.getEscritorio().add(agregarClienteVista);
        agregarClienteVista.show();
        agregarClienteVista.toFront();
    }

    public void registrarProveedorVista() {
        agregarProveedorVista = new AgregarProveedorVista(this);
        inicio.getEscritorio().add(agregarProveedorVista);
        agregarProveedorVista.show();
        agregarProveedorVista.toFront();
    }

    public void registrarCompraVista() {
        agregarCompraVista = new AgregarCompraVista(this);
        inicio.getEscritorio().add(agregarCompraVista);
        agregarCompraVista.show();
        agregarCompraVista.toFront();
    }

    public void registrarDevolucionVista() {
        agregarDevolucionVista = new AgregarDevolucionVista(this);
        inicio.getEscritorio().add(agregarDevolucionVista);
        agregarDevolucionVista.show();
        agregarDevolucionVista.toFront();
    }

    /**
     * METODOS DE AGREGACION
     */
    public void agregarDevolucion() {
        //Atributos
        String idFactura = agregarDevolucionVista.getTxt_id_factura().getText();
        String idProducto = agregarDevolucionVista.getTxt_id_prod().getText();
        String descrip = agregarDevolucionVista.getTxtArea_descrip().getText();

        //Validaciones
        if ("".equals(idFactura) || "".equals(idProducto)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el identificador de Producto y Factura", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                DevolucionJpaController devCon = new DevolucionJpaController(conexion.getBd());
                FacturaVentaJpaController facVenCon = new FacturaVentaJpaController(conexion.getBd());
                ProductoJpaController prodCon = new ProductoJpaController(conexion.getBd());
                Devolucion nuevo = new Devolucion(facVenCon.findFacturaVenta(Integer.parseInt(idFactura)), prodCon.findProducto(Integer.parseInt(idProducto)), descrip);
                devCon.create(nuevo);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Proveedor", JOptionPane.INFORMATION_MESSAGE);
                agregarDevolucionVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregarProducto() {
        //Atributos
        String id = agregarProductoVista.getTxt_id().getText();
        String nombre = agregarProductoVista.getTxt_nombre().getText();
        String cantidad = agregarProductoVista.getTxt_cant().getText();
        String precio = agregarProductoVista.getTxt_precio().getText();
        String stock = agregarProductoVista.getTxt_stock().getText();
        String lab = agregarProductoVista.getTxt_lab().getText();
        String numLote = agregarProductoVista.getTxt_lote().getText();
        String fecha = agregarProductoVista.getTxt_fecha().getText();
        Integer numCategoria = agregarProductoVista.getCbx_categoria().getSelectedIndex() + 1;

        //Validaciones
        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el id del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nombre)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(cantidad)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la cantidad del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(precio)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el precio del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(stock)) {
            stock = String.valueOf(1);
        } else if ("".equals(lab)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el laboratorio del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(numLote)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de lote", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(fecha)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la fecha de vencimiento", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //Controllers
                CategoriaJpaController categoriaCon = new CategoriaJpaController(conexion.getBd());
                ProductoJpaController productoCon = new ProductoJpaController(conexion.getBd());
                LoteJpaController loteCon = new LoteJpaController(conexion.getBd());

                //Entidades
                Categoria categoria = categoriaCon.findCategoria(numCategoria);
                Lote lote = new Lote(Integer.parseInt(numLote), this.obtenerFecha(fecha), lab,Integer.parseInt(cantidad));
                Producto producto = new Producto(Integer.parseInt(id), nombre, Long.parseLong(precio), Integer.parseInt(stock), categoria,loteCon.findLote(Integer.parseInt(numLote)));

                //Creacion
                if (productoCon.findProducto(Integer.parseInt(id)) == null) {
                    productoCon.create(producto);
                }
                loteCon.create(lote);
                //Fin
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Producto", JOptionPane.INFORMATION_MESSAGE);
                agregarProductoVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregarCliente() {
        //Atributos
        String id = agregarClienteVista.getTxt_id().getText();
        String nombre = agregarClienteVista.getTxt_nombre().getText();
        String fecha_nac = agregarClienteVista.getTxt_fecha_nac().getText();
        String telefono = agregarClienteVista.getTxt_telefono().getText();
        String correo = agregarClienteVista.getTxt_correo().getText();

        //Validaciones
        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de identificación", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nombre)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ClienteJpaController controller = new ClienteJpaController(conexion.getBd());
                Cliente nuevo = new Cliente(id, nombre, this.obtenerFecha(fecha_nac), telefono, correo);
                controller.create(nuevo);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Cliente", JOptionPane.INFORMATION_MESSAGE);
                agregarClienteVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agregarProveedor() {
        //Atributos
        String nit = agregarProveedorVista.getTxt_nit().getText();
        String nombre = agregarProveedorVista.getTxt_nombre().getText();
        String ciudad = agregarProveedorVista.getTxt_ciudad().getText();
        String correo = agregarProveedorVista.getTxt_correo().getText();
        String telefono = agregarProveedorVista.getTxt_tel().getText();
        String direccion = agregarProveedorVista.getTxt_direccion().getText();

        //Validaciones
        if ("".equals(nit)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el número de identificación", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(nombre)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el nombre", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                ProveedorJpaController controller = new ProveedorJpaController(conexion.getBd());
                Proveedor nuevo = new Proveedor(nit, nombre, direccion, ciudad, correo, telefono);
                controller.create(nuevo);
                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Proveedor", JOptionPane.INFORMATION_MESSAGE);
                agregarProveedorVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agegarCompra() {
        //Atributos
        String nit = String.valueOf(agregarCompraVista.getTxt_nit());
        String fecha = String.valueOf(agregarCompraVista.getTxt_fecha());
        String descuento = String.valueOf(agregarCompraVista.getTxt_dto());
        String cantidad = String.valueOf(agregarCompraVista.getTxt_cant());
        String precio = String.valueOf(agregarCompraVista.getTxt_precio_c());
        String id = String.valueOf(agregarCompraVista.getTxt_nombre_prod());
        String lote = String.valueOf(agregarCompraVista.getTxt_lote());

        //Validaciones
        if ("".equals(nit)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el NIT", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(fecha)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la fecha", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(descuento)) {
            descuento = String.valueOf(0);
        } else if ("".equals(cantidad)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la cantidad", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(precio)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el precioo", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la identifiacion del Producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(lote)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el lote", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //Controllers
                ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
                ProductoJpaController productoCon = new ProductoJpaController(conexion.getBd());
                DetalleCompraJpaController detalleCompraCon = new DetalleCompraJpaController(conexion.getBd());
                FacturaCompraJpaController facturaCompraCon = new FacturaCompraJpaController(conexion.getBd());

                System.out.println(id);
                Producto producto = productoCon.findProducto(Integer.parseInt(id));
                Proveedor proveedor = proveedorCon.findProveedor(nit);
                FacturaCompra facturaCompra = new FacturaCompra(0, this.obtenerFecha(fecha));
                facturaCompraCon.create(facturaCompra);
                facturaCompra.setNitFk(proveedor);
                DetalleCompraPK detalleCompraPK = new DetalleCompraPK(producto.getIdProducto(), facturaCompra.getIdFactura());

                DetalleCompra detalleCompra = new DetalleCompra(detalleCompraPK, Integer.parseInt(cantidad), Long.parseLong(precio));
                detalleCompra.setProducto(producto);
                detalleCompra.setFacturaCompra(facturaCompra);
                detalleCompraCon.create(detalleCompra);

                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Proveedor", JOptionPane.INFORMATION_MESSAGE);
                agregarCompraVista.limpiar();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * METODOS DE MOSTRAR
     */
    public void verProductos() {
        try {
            productoVista = new ProductoVista(this);
            DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
            Statement st = conexion.getConexionSQL().createStatement();
            ResultSet rs = st.executeQuery("SELECT p.id_producto, p.nombre, SUM(dl.cantidad), p.precio_unitario FROM Producto p\n"
                    + "LEFT JOIN Detalle_Lote dl on dl.id_producto_FK=p.id_producto\n"
                    + "GROUP BY p.id_producto, p.nombre,p.precio_unitario;");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }

            productoVista.getTabla_producto().setModel(model);
            inicio.getEscritorio().add(productoVista);
            productoVista.show();
            productoVista.toFront();
        } catch (SQLException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void verClientes() {
        ClienteJpaController clienteCon = new ClienteJpaController(conexion.getBd());
        clienteVista = new ClienteVista(this);
        DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
        List<Cliente> clientes = clienteCon.findClienteEntities();

        for (Cliente x : clientes) {
            model.addRow(new Object[]{x.getIdentificacion(), x.getNombre(), x.getStringFecha(), x.getTelefono(), x.getCorreo()});
        }

        clienteVista.getTabla_cliente().setModel(model);
        inicio.getEscritorio().add(clienteVista);
        clienteVista.show();
        clienteVista.toFront();
    }

    public void verProveedores() {
        ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
        proveedorVista = new ProveedorVista(this);
        DefaultTableModel model = (DefaultTableModel) proveedorVista.getTabla_proveedor().getModel();
        List<Proveedor> proveedores = proveedorCon.findProveedorEntities();

        for (Proveedor x : proveedores) {
            model.addRow(new String[]{x.getNit(), x.getNombre(), x.getCiudad(), x.getCorreo(), x.getTelefono(), x.getDireccion()});
        }

        proveedorVista.getTabla_proveedor().setModel(model);
        inicio.getEscritorio().add(proveedorVista);
        proveedorVista.show();
        proveedorVista.toFront();
    }

    public void verDevoluciones() {
        DevolucionJpaController devCon = new DevolucionJpaController(conexion.getBd());
        devolucionVista = new DevolucionVista(this);
        DefaultTableModel model = (DefaultTableModel) devolucionVista.getTabla_dev().getModel();
        List<Devolucion> registros = devCon.findDevolucionEntities();

        for (Devolucion x : registros) {
            model.addRow(new Object[]{x.getFacturaVenta().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getDescripcion()});
        }

        devolucionVista.getTabla_dev().setModel(model);
        inicio.getEscritorio().add(devolucionVista);
        devolucionVista.show();
        devolucionVista.toFront();
    }

    public void verLotes() {
        try {
            loteVista = new LoteVista(this);
            DefaultTableModel model = (DefaultTableModel) loteVista.getTabla_lote().getModel();
            Statement st = conexion.getConexionSQL().createStatement();
            ResultSet rs = st.executeQuery("SELECT P.id_producto, L.id_lote, P.nombre, DL.cantidad, L.fecha_vencimiento, L.laboratorio FROM Producto P\n"
                    + "INNER JOIN Detalle_Lote DL on DL.id_producto_FK=P.id_producto\n"
                    + "INNER JOIN Lote L on L.id_lote=DL.id_lote_FK;");

            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }

            loteVista.getTabla_lote().setModel(model);
            inicio.getEscritorio().add(loteVista);
            loteVista.show();
            loteVista.toFront();
        } catch (SQLException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * METODOS DE ELIMINACION
     *
     */
    public void eliminarProducto() {
        ProductoJpaController productoCon = new ProductoJpaController(conexion.getBd());
        int fila = productoVista.getTabla_producto().getSelectedRow();
        Integer id = Integer.parseInt(productoVista.getTabla_producto().getValueAt(fila, 0).toString());

        try {
            productoCon.destroy(id);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Producto", JOptionPane.INFORMATION_MESSAGE);
            productoVista.setVisible(false);
            this.verProductos();
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCliente() {
        ClienteJpaController clienteCon = new ClienteJpaController(conexion.getBd());
        int fila = clienteVista.getTabla_cliente().getSelectedRow();
        String id = clienteVista.getTabla_cliente().getValueAt(fila, 0).toString();

        try {
            clienteCon.destroy(id);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Cliente", JOptionPane.INFORMATION_MESSAGE);
            clienteVista.setVisible(false);
            this.verClientes();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProveedor() {
        ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
        int fila = proveedorVista.getTabla_proveedor().getSelectedRow();
        String nit = proveedorVista.getTabla_proveedor().getValueAt(fila, 0).toString();

        try {
            proveedorCon.destroy(nit);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Proveedor", JOptionPane.INFORMATION_MESSAGE);
            proveedorVista.setVisible(false);
            this.verProveedores();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * METODOS DE ACTUALIZACION
     */
    public void modificarCliente() {

    }

    /**
     * UTILIDADES
     *
     */
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
}
