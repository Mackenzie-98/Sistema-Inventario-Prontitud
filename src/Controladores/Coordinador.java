package Controladores;

import Modelo.DetalleVenta;
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

    //Creacion de Vistas para mostrar
    public static LoginVista login;
    public static InicioVista inicio;
    public static ClienteVista clienteVista;
    public static CompraVista compraVista;
    public static DevolucionVista devolucionVista;
    public static FacturaCompraVista facturaCompraVista;
    public static FacturaVentaVista facturaVentaVista;
    public static LoteVista loteVista;
    public static ProductoVista productoVista;
    public static ProveedorVista proveedorVista;
    public static VentaVista ventaVista;

    //Creacion de Vistas para agregar
    public static AgregarClienteVista agregarClienteVista;
    public static AgregarCompraVista agregarCompraVista;
    public static AgregarDevolucionVista agregarDevolucionVista;
    public static AgregarProductoVista agregarProductoVista;
    public static AgregarProveedorVista agregarProveedorVista;
    public static AgregarVentaVista agregarVentaVista;

    //Conexion
    public static Conexion conexion = Conexion.getConexion();

    //Controllers
    public static CategoriaJpaController categoriaCon;
    public static ClienteJpaController clienteCon;
    public static DetalleCompraJpaController detalleCompraCon;
    public static DetalleVentaJpaController detalleVentaCon;
    public static DevolucionJpaController devolucionCon;
    public static FacturaCompraJpaController facturaCompraCon;
    public static FacturaVentaJpaController facturaVentaCon;
    public static LoteJpaController loteCon;
    public static ProductoJpaController productoCon;
    public static ProveedorJpaController proveedorCon;

    public static void main(String[] agrs) throws SQLException {
        Coordinador control = new Coordinador();

        //Creacion de Vistas para mostrar
        login = new LoginVista(control);
        inicio = new InicioVista(control);
        clienteVista = new ClienteVista(control);
        compraVista = new CompraVista(control);
        devolucionVista = new DevolucionVista(control);
        facturaCompraVista = new FacturaCompraVista(control);
        facturaVentaVista = new FacturaVentaVista(control);
        loteVista = new LoteVista(control);
        productoVista = new ProductoVista(control);
        proveedorVista = new ProveedorVista(control);
        ventaVista = new VentaVista(control);

        //Creacion de Vistas para agregar
        agregarClienteVista = new AgregarClienteVista(control);
        agregarCompraVista = new AgregarCompraVista(control);
        agregarDevolucionVista = new AgregarDevolucionVista(control);
        agregarProductoVista = new AgregarProductoVista(control);
        agregarProveedorVista = new AgregarProveedorVista(control);
        agregarVentaVista = new AgregarVentaVista(control);

        //Conexion
        conexion = Conexion.getConexion();

        //Controllers
        categoriaCon = new CategoriaJpaController(conexion.getBd());
        clienteCon = new ClienteJpaController(conexion.getBd());
        detalleCompraCon = new DetalleCompraJpaController(conexion.getBd());
        detalleVentaCon = new DetalleVentaJpaController(conexion.getBd());
        devolucionCon = new DevolucionJpaController(conexion.getBd());
        facturaCompraCon = new FacturaCompraJpaController(conexion.getBd());
        facturaVentaCon = new FacturaVentaJpaController(conexion.getBd());
        loteCon = new LoteJpaController(conexion.getBd());
        productoCon = new ProductoJpaController(conexion.getBd());
        proveedorCon = new ProveedorJpaController(conexion.getBd());
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
        inicio.getEscritorio().add(agregarProductoVista);
        agregarProductoVista.show();
        agregarProductoVista.toFront();
    }

    public void registrarCliente() {
        inicio.getEscritorio().add(agregarClienteVista);
        agregarClienteVista.show();
        agregarClienteVista.toFront();
    }

    public void registrarProveedorVista() {
        inicio.getEscritorio().add(agregarProveedorVista);
        agregarProveedorVista.show();
        agregarProveedorVista.toFront();
    }

    public void registrarCompraVista() {
        inicio.getEscritorio().add(agregarCompraVista);
        agregarCompraVista.show();
        agregarCompraVista.toFront();
    }

    public void registrarDevolucionVista() {
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
                Devolucion devolucion = new Devolucion(facturaVentaCon.findFacturaVenta(Integer.parseInt(idFactura)), productoCon.findProducto(Integer.parseInt(idProducto)), descrip);
                devolucionCon.create(devolucion);
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
                //Entidades
                Categoria categoria = categoriaCon.findCategoria(numCategoria);
                Lote lote = new Lote(Integer.parseInt(numLote), this.obtenerFecha(fecha), lab, Integer.parseInt(cantidad));
                loteCon.create(lote);
                Producto producto = new Producto(Integer.parseInt(id), nombre, Long.parseLong(precio), Integer.parseInt(stock), categoria, loteCon.findLote(Integer.parseInt(numLote)));

                //Creacion
                if (productoCon.findProducto(Integer.parseInt(id)) == null) {
                    productoCon.create(producto);
                }

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
                Cliente nuevo = new Cliente(id, nombre, this.obtenerFecha(fecha_nac), telefono, correo);
                clienteCon.create(nuevo);
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
                Proveedor nuevo = new Proveedor(nit, nombre, direccion, ciudad, correo, telefono);
                proveedorCon.create(nuevo);
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
                //Creacion
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
        DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
        List<Producto> productos = productoCon.findProductoEntities();

        for (Producto x : productos) {
            model.addRow(new Object[]{x.getIdProducto(), x.getIdloteFK().getIdLote(), x.getNombre(), x.getPrecioUnitario()});
        }

        productoVista.getTabla_producto().setModel(model);
        inicio.getEscritorio().add(productoVista);
        productoVista.show();
        productoVista.toFront();

    }

    public void verClientes() {
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
        DefaultTableModel model = (DefaultTableModel) devolucionVista.getTabla_dev().getModel();
        List<Devolucion> registros = devolucionCon.findDevolucionEntities();

        for (Devolucion x : registros) {
            model.addRow(new Object[]{x.getFacturaVenta().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getDescripcion()});
        }

        devolucionVista.getTabla_dev().setModel(model);
        inicio.getEscritorio().add(devolucionVista);
        devolucionVista.show();
        devolucionVista.toFront();
    }

    public void verLotes() {
        DefaultTableModel model = (DefaultTableModel) loteVista.getTabla_lote().getModel();
        List<Lote> lotes=loteCon.findLoteEntities();

        for (Lote x : lotes) {
            model.addRow(new Object[]{x.getIdLote(),x.getCantidad(),x.getStringFecha(),x.getLaboratorio()});
        }

        loteVista.getTabla_lote().setModel(model);
        inicio.getEscritorio().add(loteVista);
        loteVista.show();
        loteVista.toFront();

    }

    public void verCompras() {
        DefaultTableModel model = (DefaultTableModel) compraVista.getTabla_compra().getModel();
        List<DetalleCompra> compras = detalleCompraCon.findDetalleCompraEntities();
        long descuento = 0;
        for (DetalleCompra x : compras) {
            if (x.getDescuento() != null) {
                descuento = x.getDescuento() * x.getPrecioUnitario();
            }
            model.addRow(new Object[]{x.getFacturaCompra().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getFacturaCompra().getNitFk().getNombre(), x.getCantidad(), x.getPrecioUnitario(), x.getDescuento(), x.getPrecioUnitario() - descuento});
        }

        compraVista.getTabla_compra().setModel(model);
        inicio.getEscritorio().add(compraVista);
        compraVista.show();
        compraVista.toFront();
    }

    public void verVentas() {
        DefaultTableModel model = (DefaultTableModel) ventaVista.getTabla_venta().getModel();
        List<DetalleVenta> ventas = detalleVentaCon.findDetalleVentaEntities();
        long descuento = 0;
        for (DetalleVenta x : ventas) {

            if (x.getDescuento() != null) {
                descuento = x.getDescuento() * x.getPrecioUnitario();
            }
            model.addRow(new Object[]{x.getFacturaVenta().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getFacturaVenta().getIdentificacionFK().getNombre(), x.getCantidad(), x.getPrecioUnitario(), x.getDescuento(), x.getPrecioUnitario() - descuento});
        }

        ventaVista.getTabla_venta().setModel(model);
        inicio.getEscritorio().add(ventaVista);
        ventaVista.show();
        ventaVista.toFront();
    }

    /**
     * METODOS DE ELIMINACION
     *
     */
    public void eliminarProducto() {
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
        } catch (ParseException ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return now;
    }
}
