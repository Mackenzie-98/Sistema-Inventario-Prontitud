package Modelo;

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
    private static Connection conexionSQL;

    public Conexion() {
        this.bd = Persistence.createEntityManagerFactory("ProntitudUP");
        try {
            conexionSQL = DriverManager.getConnection("jdbc:mysql://database-prontitud.chjhoyymvqtv.us-east-1.rds.amazonaws.com:3306/Prontitud?zeroDateTimeBehavior=convertToNull", "admin", "3202633111");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getConexion() {

        if (conexion == null) {
            conexion = new Conexion();
        }
        return conexion;
    }

    public static Connection getConexionSQL() {
        return conexionSQL;
    }

    public static void setConexionSQL(Connection conexionSQL) {
        Conexion.conexionSQL = conexionSQL;
    }

  

    public EntityManagerFactory getBd() {
        return bd;
    }

}
