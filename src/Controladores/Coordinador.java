package Controladores;

import Modelo.*;
import Vista.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Coordinador {

    public static LoginVista login ;
    public static InicioVista inicio;
    public static ClienteVista clienteVista ;
    public static ProductoVista productoVista;
    public static ProveedorVista proveedorVista;
    Conexion conexion = Conexion.getConexion();
    
    
    public static void main(String[] agrs) {
        login=new LoginVista();
        login.setVisible(true);
    }
    public void iniciarSesion(){
        inicio=new InicioVista();
        inicio.setVisible(true);
        login.setVisible(false);
    }
    
    public void mostrarClientes() {
        clienteVista = new ClienteVista();
        ClienteJpaController clienteCon = new ClienteJpaController(conexion.getBd());
        List<Cliente> clientes = clienteCon.findClienteEntities();
        DefaultTableModel model = (DefaultTableModel) clienteVista.getTabla_cliente().getModel();
        for (Cliente x : clientes) {
            model.addRow(new Object[]{x.getIdentificacion(),x.getNombre(),x.getFechaNacimiento(),x.getCorreo()});
        }
        clienteVista.getTabla_cliente().setModel(model);
        inicio.getEscritorio().add(clienteVista);
        clienteVista.setVisible(true);
    }
    
    public void mostrarProductos() {
        productoVista = new ProductoVista();
        ProductoJpaController productoCon = new ProductoJpaController(conexion.getBd());
        List<Producto> productos = productoCon.findProductoEntities();                
        DefaultTableModel model = (DefaultTableModel) productoVista.getTabla_producto().getModel();
        for (Producto x : productos) {
            model.addRow(new Object[]{x.getIdProducto(),x.getNombre(),null,x.getPrecioUnitario()});
        }
        productoVista.getTabla_producto().setModel(model);
        inicio.getEscritorio().add(productoVista);
        productoVista.setVisible(true);
    }   
    
    public void mostrarProveedores() {
        proveedorVista = new ProveedorVista();
        ProveedorJpaController proveedorCon = new ProveedorJpaController(conexion.getBd());
        List<Proveedor> proveedores = proveedorCon.findProveedorEntities();
        DefaultTableModel model = (DefaultTableModel) proveedorVista.getTabla_proveedor().getModel();
        for (Proveedor  x : proveedores) {
            model.addRow(new Object[]{x.getNit(),x.getNombre(),x.getCiudad(),x.getCorreo(), x.getTelefono()});
        }
        proveedorVista.getTabla_proveedor().setModel(model);
        inicio.getEscritorio().add(proveedorVista);
        proveedorVista.setVisible(true);
    }
}
