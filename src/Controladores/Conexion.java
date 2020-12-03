package Controladores;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

    private static Conexion conexion;
    private EntityManagerFactory bd;

    private Conexion() {
        this.bd = Persistence.createEntityManagerFactory("MainPU");
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