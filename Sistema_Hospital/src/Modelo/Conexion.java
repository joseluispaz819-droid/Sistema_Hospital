package Modelo;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
     private static final String URL = "jdbc:mysql://localhost:3306/sistema_hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "toor";

    public static Connection getConexion() {
        Connection con = null;
        try {
            // Cargar el driver (opcional en versiones nuevas, pero no molesta)
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de MySQL");
            e.printStackTrace();
        } catch (SQLException r) {
            System.err.println("❌ Error al conectar a la base de datos");
            r.printStackTrace();
        }
        return con;
    }
}