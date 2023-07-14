package sprintmodulo5.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instancia;
    private Connection conexion;

    private Conexion() {
        String url = "jdbc:mysql://localhost/prevencion_riesgos?useSSL=false";
        String usuario = "adminp";
        String contraseña = "12345";

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Obtener la conexión a la base de datos
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conexión a la base de datos establecida.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static Conexion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection obtenerConexion() {
        return conexion;
    }
}
