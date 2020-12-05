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
        clienteVista=new ClienteVista();
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
    
}
