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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
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

    //Creacion de Vistas para modificar
    public static ModificarClienteVista modClienteVista;
    public static ModificarCompraVista modCompraVista;
    public static ModificarDevolucionVista modDevolucionVista;
    public static ModificarLoteVista modLoteVista;
    public static ModificarProductoVista modProductoVista;
    public static ModificarProveedorVista modProveedorVista;
    public static ModificarVentaVista modVentaVista;

    //Conexion
    public static Conexion conexion =Conexion.getConexion();

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

        //Creacion de Vistas para modificar
        modClienteVista = new ModificarClienteVista(control);
        modCompraVista = new ModificarCompraVista(control);
        modDevolucionVista = new ModificarDevolucionVista(control);
        modLoteVista = new ModificarLoteVista(control);
        modProductoVista = new ModificarProductoVista(control);
        modProveedorVista = new ModificarProveedorVista(control);
        modVentaVista = new ModificarVentaVista(control);

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

        login.setVisible(true);
    }

    public void iniciarSesion() {
        inicio.validar();
        inicio.setVisible(true);
        login.setVisible(false);
    }

    /**
     * METODOS DE REGISTRAR
     */
    public void registrarProductoVista() {
        inicio.getEscritorio().add(agregarProductoVista,0);
        agregarProductoVista.show();
        agregarProductoVista.toFront();
    }

    public void registrarCliente() {
        inicio.getEscritorio().add(agregarClienteVista,0);
        agregarClienteVista.show();
        agregarClienteVista.toFront();
    }

    public void registrarProveedorVista() {
        inicio.getEscritorio().add(agregarProveedorVista,0);
        agregarProveedorVista.show();
        agregarProveedorVista.toFront();
    }

    public void registrarCompraVista() {
        inicio.getEscritorio().add(agregarCompraVista,0);
        agregarCompraVista.show();
        agregarCompraVista.toFront();
    }

    public void registrarVentaVista() {
        inicio.getEscritorio().add(agregarVentaVista,0);
        agregarVentaVista.show();
        agregarVentaVista.toFront();
    }

    public void registrarDevolucionVista() {
        inicio.getEscritorio().add(agregarDevolucionVista,0);
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
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                verProductos();
            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agegarCompra() {
        //Atributos
        String nit = agregarCompraVista.getTxt_nit().getText();
        String fecha = agregarCompraVista.getTxt_fecha().getText();
        String descuento = agregarCompraVista.getTxt_dto().getText();
        String cantidad = agregarCompraVista.getTxt_cant().getText();
        String precio = agregarCompraVista.getTxt_precio_c().getText();
        String id = agregarCompraVista.getTxt_nombre_prod().getText();
        String lote = agregarCompraVista.getTxt_lote().getText();

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
                FacturaCompra facturaCompra = new FacturaCompra(0, this.obtenerFecha(fecha), 19l, proveedor);
                facturaCompraCon.create(facturaCompra);

                DetalleCompraPK detalleCompraPK = new DetalleCompraPK(producto.getIdProducto(), facturaCompra.getIdFactura());
                DetalleCompra detalleCompra = new DetalleCompra(detalleCompraPK, Integer.parseInt(cantidad), Long.parseLong(precio));
                detalleCompra.setProducto(producto);
                detalleCompra.setFacturaCompra(facturaCompra);
                detalleCompraCon.create(detalleCompra);

                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Compra", JOptionPane.INFORMATION_MESSAGE);
                agregarCompraVista.limpiar();

            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void agegarVenta() {
        //Atributos
        String id_cliente = agregarVentaVista.getTxt_id_cliente().getText();
        String id_producto = agregarVentaVista.getTxt_nombre_prod().getText();
        String cantidad = agregarVentaVista.getTxt_cant().getText();
        String fecha = agregarVentaVista.getTxt_fecha().getText();
        String descuento = agregarVentaVista.getTxt_dto().getText();
        String lote = agregarVentaVista.getTxt_lote().getText();

        //Validaciones
        if ("".equals(id_cliente)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la identificaicon del Cliente", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(id_producto)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el id del producto", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(cantidad)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la cantidad", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(fecha)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese la fecha", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(descuento)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el descuento", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if ("".equals(lote)) {
            JOptionPane.showMessageDialog(null, "ERROR: Es necesario que ingrese el lote", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //Creacion
                Producto producto = productoCon.findProducto(Integer.parseInt(id_producto));
                Cliente cliente = clienteCon.findCliente(id_cliente);
                FacturaVenta facturaVenta = new FacturaVenta(0, this.obtenerFecha(fecha));
                facturaVenta.setIdentificacionFK(cliente);
                facturaVentaCon.create(facturaVenta);

                DetalleVentaPK detalleVentaPK = new DetalleVentaPK(facturaVenta.getIdFactura(), producto.getIdProducto());
                DetalleVenta detalleVenta = new DetalleVenta(detalleVentaPK, Integer.parseInt(cantidad), producto.getPrecioUnitario());
                detalleVenta.setProducto(producto);
                detalleVenta.setFacturaVenta(facturaVenta);
                detalleVentaCon.create(detalleVenta);

                JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Agregar Venta", JOptionPane.INFORMATION_MESSAGE);
                agregarVentaVista.limpiar();

            } catch (Exception ex) {
                Logger.getLogger(Coordinador.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * METODOS DE MOSTRAR
     */
    public void verProductos() {
        DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
        try {
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }
            List<Producto> productos = productoCon.findProductoEntities();
            for (Producto x : productos) {
                System.out.println(x.getIdloteFK());
                model.addRow(new Object[]{x.getIdProducto(), x.getIdloteFK().getIdLote(), x.getNombre(), x.getPrecioUnitario()});
            }
            productoVista.getTabla_producto().setModel(model);
            inicio.getEscritorio().add(productoVista, 0);
            productoVista.setVisible(true);
            productoVista.toFront();

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void verClientes() {
        try {
            DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
            List<Cliente> clientes = clienteCon.findClienteEntities();
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }

            for (Cliente x : clientes) {
                model.addRow(new Object[]{x.getIdentificacion(), x.getNombre(), x.getStringFecha(), x.getTelefono(), x.getCorreo()});
            }

            clienteVista.getTabla_cliente().setModel(model);
            inicio.getEscritorio().add(clienteVista, 0);
            clienteVista.setVisible(true);
            clienteVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void verProveedores() {
        try {
            DefaultTableModel model = (DefaultTableModel) proveedorVista.getTabla_proveedor().getModel();
            List<Proveedor> proveedores = proveedorCon.findProveedorEntities();
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }

            for (Proveedor x : proveedores) {
                model.addRow(new String[]{x.getNit(), x.getNombre(), x.getCiudad(), x.getCorreo(), x.getTelefono(), x.getDireccion()});
            }

            proveedorVista.getTabla_proveedor().setModel(model);
            inicio.getEscritorio().add(proveedorVista, 0);
            proveedorVista.setVisible(true);
            proveedorVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void verDevoluciones() {
        try {
            DefaultTableModel model = (DefaultTableModel) devolucionVista.getTabla_dev().getModel();
            List<Devolucion> registros = devolucionCon.findDevolucionEntities();
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }
            for (Devolucion x : registros) {
                model.addRow(new Object[]{x.getFacturaVenta().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getDescripcion()});
            }

            devolucionVista.getTabla_dev().setModel(model);
            inicio.getEscritorio().add(devolucionVista, 0);
            devolucionVista.setVisible(true);
            devolucionVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void verLotes() {
        try {
            DefaultTableModel model = (DefaultTableModel) loteVista.getTabla_lote().getModel();
            List<Lote> lotes = loteCon.findLoteEntities();
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }
            for (Lote x : lotes) {
                model.addRow(new Object[]{x.getIdLote(), x.getCantidad(), x.getStringFecha(), x.getLaboratorio()});
            }

            loteVista.getTabla_lote().setModel(model);
            inicio.getEscritorio().add(loteVista, 0);
            loteVista.setVisible(true);
            loteVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void verCompras() {
        try {
            DefaultTableModel model = (DefaultTableModel) compraVista.getTabla_compra().getModel();
            List<DetalleCompra> compras = detalleCompraCon.findDetalleCompraEntities();
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }
            long descuento = 0;
            for (DetalleCompra x : compras) {
                if (x.getDescuento() != null) {
                    descuento = x.getDescuento() * x.getPrecioUnitario();
                } else {
                    x.setDescuento(0l);
                }
                model.addRow(new Object[]{x.getFacturaCompra().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getFacturaCompra().getNitFk().getNombre(), x.getCantidad(), x.getPrecioUnitario(), x.getDescuento(), x.getPrecioUnitario() - descuento});

                model.addRow(new String[]{x.getFacturaCompra().getIdFactura().toString(), x.getProducto().getIdProducto().toString(), x.getProducto().getNombre(), x.getFacturaCompra().getNitFk().getNombre(), String.valueOf(x.getCantidad()), String.valueOf(x.getPrecioUnitario()), String.valueOf(x.getDescuento()), String.valueOf(x.getPrecioUnitario() - descuento)});
            }

            compraVista.getTabla_compra().setModel(model);
            inicio.getEscritorio().add(compraVista, 0);
            compraVista.setVisible(true);
            compraVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void verVentas() {
        try {
            DefaultTableModel model = (DefaultTableModel) ventaVista.getTabla_venta().getModel();
            List<DetalleVenta> ventas = detalleVentaCon.findDetalleVentaEntities();
            long descuento = 0;
            int numDatos = model.getRowCount();
            for (int i = 0; i < numDatos; i++) {
                model.removeRow(0);
            }
            for (DetalleVenta x : ventas) {
                if (x.getDescuento() != null) {
                    descuento = x.getDescuento() * x.getPrecioUnitario();
                } else {
                    x.setDescuento(0l);
                }
                model.addRow(new Object[]{x.getFacturaVenta().getIdFactura(), x.getProducto().getIdProducto(), x.getProducto().getNombre(), x.getFacturaVenta().getIdentificacionFK().getNombre(), x.getCantidad(), x.getPrecioUnitario(), x.getDescuento(), x.getPrecioUnitario() - descuento});
            }

            ventaVista.getTabla_venta().setModel(model);
            inicio.getEscritorio().add(ventaVista, 0);
            ventaVista.setVisible(true);
            ventaVista.toFront();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * METODOS DE ELIMINACION
     *
     */
    public void eliminarProducto() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int fila = productoVista.getTabla_producto().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Integer id = Integer.parseInt(productoVista.getTabla_producto().getValueAt(fila, 0).toString());
            Producto producto = productoCon.findProducto(id);

            productoCon.destroy(id);
            loteCon.destroy(producto.getIdloteFK().getIdLote());

            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Producto", JOptionPane.INFORMATION_MESSAGE);
            this.verProductos();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarCliente() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int fila = clienteVista.getTabla_cliente().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String id = clienteVista.getTabla_cliente().getValueAt(fila, 0).toString();
            clienteCon.destroy(id);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Cliente", JOptionPane.INFORMATION_MESSAGE);
            this.verClientes();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProveedor() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int fila = proveedorVista.getTabla_proveedor().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            String nit = proveedorVista.getTabla_proveedor().getValueAt(fila, 0).toString();

            proveedorCon.destroy(nit);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Proveedor", JOptionPane.INFORMATION_MESSAGE);
            this.verProveedores();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarLote() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            int fila = loteVista.getTabla_lote().getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Integer id = Integer.parseInt(loteVista.getTabla_lote().getValueAt(fila, 0).toString());
            List<Producto> productos = productoCon.findProductoEntities();

            for (Producto x : productos) {
                if (Objects.equals(x.getIdloteFK().getIdLote(), id)) {
                    productoCon.destroy(x.getIdProducto());
                }
            }

            loteCon.destroy(id);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Elimnar Lote", JOptionPane.INFORMATION_MESSAGE);
            this.verLotes();

        } catch (IllegalOrphanException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * METODOS DE ACTUALIZACION
     */
    public void verModClienteVista() {
        int fila = clienteVista.getTabla_cliente().getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Obtener Datos
        String id = clienteVista.getTabla_cliente().getValueAt(fila, 0).toString();
        String nombre = clienteVista.getTabla_cliente().getValueAt(fila, 1).toString();
        String fecha = clienteVista.getTabla_cliente().getValueAt(fila, 2).toString();
        String telefono = clienteVista.getTabla_cliente().getValueAt(fila, 3).toString();
        String correo = clienteVista.getTabla_cliente().getValueAt(fila, 4).toString();

        //Precargar datos  
        modClienteVista.getTxt_id().setText(id);
        modClienteVista.getTxt_nombre().setText(nombre);
        modClienteVista.getTxt_fecha_nac().setText(fecha);
        modClienteVista.getTxt_telefono().setText(telefono);
        modClienteVista.getTxt_correo().setText(correo);

        //Mostrar
        inicio.getEscritorio().add(modClienteVista, 0);
        modClienteVista.setVisible(true);
        modClienteVista.toFront();
    }

    public void verModCompraVista() {
        int fila = compraVista.getTabla_compra().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Obtener Datos
        String nit = compraVista.getTabla_compra().getValueAt(fila, 0).toString();
        String fecha = compraVista.getTabla_compra().getValueAt(fila, 1).toString();
        String descuento = compraVista.getTabla_compra().getValueAt(fila, 2).toString();
        String cantidad = compraVista.getTabla_compra().getValueAt(fila, 3).toString();
        String precio = compraVista.getTabla_compra().getValueAt(fila, 4).toString();
        String id = compraVista.getTabla_compra().getValueAt(fila, 5).toString();
        String lote = compraVista.getTabla_compra().getValueAt(fila, 6).toString();

        //Precargar Datos
        modCompraVista.getTxt_nit().setText(nit);
        modCompraVista.getTxt_fecha().setText(fecha);
        modCompraVista.getTxt_dto().setText(descuento);
        modCompraVista.getTxt_cant().setText(cantidad);
        modCompraVista.getTxt_precio_c().setText(precio);
        modCompraVista.getTxt_nombre_prod().setText(id);
        modCompraVista.getTxt_lote().setText(lote);

        //Mostrar
        inicio.getEscritorio().add(modCompraVista, 0);
        modCompraVista.setVisible(true);
        modCompraVista.toFront();
    }

    public void verModDevolucionVista() {
        int fila = devolucionVista.getTabla_dev().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Obtener Datos
        String id_factura = devolucionVista.getTabla_dev().getValueAt(fila, 0).toString();
        String id_producto = devolucionVista.getTabla_dev().getValueAt(fila, 1).toString();
        String cantidad = devolucionVista.getTabla_dev().getValueAt(fila, 2).toString();
        String des = devolucionVista.getTabla_dev().getValueAt(fila, 3).toString();

        //Precargar datos  
        modDevolucionVista.getTxt_id_factura().setText(id_factura);
        modDevolucionVista.getTxt_id_prod().setText(id_producto);
        modDevolucionVista.getTxt_cant().setText(cantidad);
        modDevolucionVista.getTxtArea_descrip().setText(des);

        //Mostrar
        inicio.getEscritorio().add(modDevolucionVista, 0);
        modDevolucionVista.setVisible(true);
        modDevolucionVista.toFront();

    }

    public void verModLoteVista() {
        int fila = loteVista.getTabla_lote().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String lote = loteVista.getTabla_lote().getValueAt(fila, 0).toString();
        String cantidad = loteVista.getTabla_lote().getValueAt(fila, 1).toString();
        String fecha = loteVista.getTabla_lote().getValueAt(fila, 2).toString();
        String laboratorio = loteVista.getTabla_lote().getValueAt(fila, 3).toString();

        //Precargar datos  
        modLoteVista.getTxt_lote().setText(lote);
        modLoteVista.getTxt_cant().setText(cantidad);
        modLoteVista.getTxt_fecha().setText(fecha);
        modLoteVista.getTxt_lab().setText(laboratorio);

        //Mostrar
        inicio.getEscritorio().add(modLoteVista, 0);
        modLoteVista.setVisible(true);
        modLoteVista.toFront();
    }

    public void verModProductoVista() {
        try{
        int fila = productoVista.getTabla_producto().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Obtener Datos
        String id = productoVista.getTabla_producto().getValueAt(fila, 0).toString();
        String id_lote = productoVista.getTabla_producto().getValueAt(fila, 1).toString();
        String nombre = productoVista.getTabla_producto().getValueAt(fila, 2).toString();
        String precio = productoVista.getTabla_producto().getValueAt(fila, 3).toString();

        Producto producto = productoCon.findProducto(Integer.parseInt(id));
        Lote lote = loteCon.findLote(Integer.parseInt(id_lote));

        //Precargar datos  
        modProductoVista.getTxt_id().setText(id);
        modProductoVista.getTxt_nombre().setText(producto.getNombre());
        modProductoVista.getTxt_cant().setText(String.valueOf(lote.getCantidad()));
        modProductoVista.getTxt_precio().setText(String.valueOf(producto.getPrecioUnitario()));
        modProductoVista.getTxt_stock().setText(String.valueOf(producto.getStockMinimo()));
        modProductoVista.getCbx_categoria().setSelectedIndex(producto.getIdcategoriaFK().getIdCategoria() - 1);
        modProductoVista.getTxt_lab().setText(lote.getLaboratorio());
        modProductoVista.getTxt_lote().setText(id_lote);
        modProductoVista.getTxt_fecha().setText(lote.getStringFecha());

        //Mostrar
        inicio.getEscritorio().add(modProductoVista, 0);
        modProductoVista.show();
        modProductoVista.toFront();
        }catch(Exception e){
            System.err.println(e);
                    
        }
    }

    public void verModProveedorVista() {
        int fila = proveedorVista.getTabla_proveedor().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Obtener Datos
        String nit = proveedorVista.getTabla_proveedor().getValueAt(fila, 0).toString();
        String nombre = proveedorVista.getTabla_proveedor().getValueAt(fila, 1).toString();
        String ciudad = proveedorVista.getTabla_proveedor().getValueAt(fila, 2).toString();
        String correo = proveedorVista.getTabla_proveedor().getValueAt(fila, 3).toString();
        String telefono = proveedorVista.getTabla_proveedor().getValueAt(fila, 4).toString();
        String direccion = proveedorVista.getTabla_proveedor().getValueAt(fila, 5).toString();

        //Precargar datos  
        modProveedorVista.getTxt_nit().setText(nit);
        modProveedorVista.getTxt_nombre().setText(nombre);
        modProveedorVista.getTxt_ciudad().setText(ciudad);
        modProveedorVista.getTxt_correo().setText(correo);
        modProveedorVista.getTxt_tel().setText(telefono);
        modProveedorVista.getTxt_direccion().setText(direccion);

        //Mostrar
        inicio.getEscritorio().add(modProveedorVista, 0);
        modProveedorVista.setVisible(true);
        modProveedorVista.toFront();
    }

    public void verModVentaVista() {
        int fila = ventaVista.getTabla_venta().getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "ERROR: Debe seleccionar un registro", "ERROR", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Obtener Datos
        String id_factura = ventaVista.getTabla_venta().getValueAt(fila, 0).toString();
        String id_producto = ventaVista.getTabla_venta().getValueAt(fila, 1).toString();
        String cantidad = ventaVista.getTabla_venta().getValueAt(fila, 4).toString();
        String precio = ventaVista.getTabla_venta().getValueAt(fila, 5).toString();
        String dto = ventaVista.getTabla_venta().getValueAt(fila, 6).toString();

        FacturaVenta facturaVenta = facturaVentaCon.findFacturaVenta(Integer.parseInt(id_factura));

        //Precargar datos  
        modVentaVista.getTxt_id_cliente().setText(String.valueOf(facturaVenta.getIdentificacionFK()));
        modVentaVista.getTxt_nombre_prod().setText(id_producto);
        modVentaVista.getTxt_cant().setText(cantidad);
        modVentaVista.getTxt_fecha().setText(facturaVenta.getStringFecha());
        modVentaVista.getTxt_precio().setText(precio);
        modVentaVista.getTxt_dto().setText(dto);

        //Mostrar
        inicio.getEscritorio().add(modVentaVista, 0);
        modVentaVista.setVisible(true);
        modVentaVista.toFront();
    }

    public void modificarProductos() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
            int index = productoVista.getTabla_producto().getSelectedRow();

            String oldIdLote = model.getValueAt(index, 1).toString();
            String p7 = modProductoVista.getTxt_cant().getText();
            String p8 = modProductoVista.getTxt_lab().getText();
            String p9 = modProductoVista.getTxt_fecha().getText();

            //Info Prod
            String oldIdProd = model.getValueAt(index, 0).toString();
            int oldIdCat = productoCon.findProducto(Integer.parseInt(oldIdProd)).getIdcategoriaFK().getIdCategoria();
            String p1 = modProductoVista.getTxt_id().getText();
            String p2 = modProductoVista.getTxt_nombre().getText();
            String p3 = modProductoVista.getTxt_precio().getText();
            String p4 = modProductoVista.getTxt_stock().getText();
            String p5 = String.valueOf(modProductoVista.getCbx_categoria().getSelectedIndex() + 1);
            String p6 = modProductoVista.getTxt_lote().getText();
            String query0 = "UPDATE `Prontitud`.`Producto` SET `id_categoria_FK` = '" + p5 + "' WHERE (`id_lote_FK` = '" + oldIdCat + "');";
            String query1 = "UPDATE `Prontitud`.`Producto` SET `id_lote_FK` = '" + p6 + "' WHERE (`id_lote_FK` = '" + oldIdLote + "');";
            String query2 = "UPDATE `Prontitud`.`Producto` SET `id_producto` = '" + p1 + "', `nombre` = '" + p2 + "', `precio_unitario` = '" + p3 + "', `stock_minimo` = '" + p4 + "', `id_categoria_FK` = '" + p5 + "', `id_lote_FK` = '" + p6 + "' WHERE (`id_producto` = '" + oldIdProd + "');";
            if (loteCon.findLote(Integer.parseInt(p6)) == null) {
                loteCon.create(new Lote(Integer.parseInt(p6), this.obtenerFecha(p9), p8, Integer.parseInt(p7)));
            }
            Statement st;
            st = conexion.getConexionSQL().createStatement();
            st.execute(query0);
            st.execute(query1);
            st.execute(query2);
            if (!oldIdLote.equals(p6)) {
                loteCon.destroy(Integer.parseInt(oldIdLote));
            }
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Actualizar Producto", JOptionPane.INFORMATION_MESSAGE);
            modProductoVista.setVisible(false);
            verProductos();
        } catch (Exception ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void modificarClientes() {
        if (inicio.getTipo().equals("Vendedor")) {
            JOptionPane.showMessageDialog(null, "Error, el usuario: Vendedor NO puede eliminar productos. "
                    + "", "Acceso denegado ", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        try {
            DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
            int index = clienteVista.getTabla_cliente().getSelectedRow();

            String oldIdCliente = model.getValueAt(index, 0).toString();
            String p1 = modClienteVista.getTxt_id().getText();
            String p2 = modClienteVista.getTxt_nombre().getText();
            String p3 = modClienteVista.getTxt_fecha_nac().getText();
            String p4 = modClienteVista.getTxt_telefono().getText();
            String p5 = modClienteVista.getTxt_correo().getText();
            //String newFecha=clienteCon.findCliente(oldIdCliente).getStringFecha();
            //if(!p3.equals(""))newFecha=p3.split("-")[2]+"-"+p3.split("-")[1]+"-"+p3.split("-")[0];
            String query0 = "UPDATE `Prontitud`.`Cliente` SET `identificacion` = '"+p1+"', `nombre` = '"+p2+"', `fecha_nacimiento` = '"+p3+"', `telefono` = '"+p4+"', `correo` = '"+p5+"' WHERE (`identificacion` = '"+oldIdCliente+"');";
            Statement st;
            st = conexion.getConexionSQL().createStatement();
            st.execute(query0);
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente", "Actualizar Cliente", JOptionPane.INFORMATION_MESSAGE);
            modClienteVista.setVisible(false);
            verClientes();
        } catch (Exception ex) {
            Logger.getLogger(Coordinador.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(Coordinador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return now;
    }
}
