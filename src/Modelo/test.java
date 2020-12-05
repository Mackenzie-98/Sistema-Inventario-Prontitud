/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controladores.ClienteJpaController;
import java.util.List;

/**
 *
 * @author garun
 */
public class test {
    public static void main(String [] args) throws Exception{
        Conexion con=Conexion.getConexion();
        ClienteJpaController clienteController=new ClienteJpaController(con.getBd());
        List<Cliente> clientes=clienteController.findClienteEntities();
        for(Cliente x:clientes)System.out.println(x.getNombre());
    }
}
