package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private static Conexion conexion;
    private EntityManagerFactory bd;

    public Conexion() {
            this.bd = Persistence.createEntityManagerFactory("ProntitudORMPU");
    }

    public static Conexion getConexion() {
        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }
    public EntityManagerFactory getBd() {
        return bd;
    }

}
