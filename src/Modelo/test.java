/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controladores.ClienteJpaController;
import Controladores.Conexion;
import Controladores.ProductoJpaController;
import java.util.Date;
import javax.persistence.EntityManager;

/**
 *
 * @author garun
 */
public class test {
    public static void main(String [] args) throws Exception{
        Conexion con=Conexion.getConexion();
        ClienteJpaController clienteController=new ClienteJpaController(con.getBd());
        Date f=new Date(2000, 12, 12);
        Cliente cli=new Cliente("123456", "Alberto",f , "3214567892", "correo@gmail.com");
        clienteController.create(cli);
        System.out.println(clienteController.getClienteCount());
    }
}
