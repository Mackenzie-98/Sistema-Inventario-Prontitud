package Controladores;

import Modelo.*;
import Vista.*;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Coordinador {

    public static LoginVista login;
    public static InicioVista inicio;
    public static ClienteVista clienteVista;
    public static ProductoVista productoVista;
    public static ProveedorVista proveedorVista;
    public static Conexion conexion=Conexion.getConexion();

    public static void main(String[] agrs) throws SQLException {
        login = new LoginVista();
        login.setVisible(true);
    }

    public void iniciarSesion() {
        inicio = new InicioVista();
        inicio.setVisible(true);
        login.setVisible(false);
    }

    public void mostrarClientes() {
        clienteVista = new ClienteVista();
        ClienteJpaController clienteCon = new ClienteJpaController(conexion.getBd());
        List<Cliente> clientes = clienteCon.findClienteEntities();
        DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
        for (Cliente x : clientes) {
            model.addRow(new Object[]{x.getIdentificacion(), x.getNombre(), x.getFechaNacimiento(), x.getCorreo()});
        }
        clienteVista.getTabla_cliente().setModel(model);
        inicio.getEscritorio().add(clienteVista);
        clienteVista.setVisible(true);
    }

    public void mostrarProductos() {
        try {
            productoVista = new ProductoVista();
            Statement st;
            st = conexion.getConexionSQL().createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT p.id_producto, p.nombre, SUM(dl.cantidad), p.precio_unitario FROM Producto p\n"
                    + "INNER JOIN Detalle_Lote dl on dl.id_producto_FK=p.id_producto\n"
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

    public void mostrarProveedores() {
        proveedorVista = new ProveedorVista();
        ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
        List<Proveedor> proveedores = proveedorCon.findProveedorEntities();
        DefaultTableModel model = (DefaultTableModel) proveedorVista.getTabla_proveedor().getModel();
        for (Proveedor x : proveedores) {
            model.addRow(new Object[]{x.getNit(), x.getNombre(), x.getCiudad(), x.getCorreo(), x.getTelefono()});
        }
        proveedorVista.getTabla_proveedor().setModel(model);
        inicio.getEscritorio().add(proveedorVista);
        proveedorVista.setVisible(true);
    }
}
