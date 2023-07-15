package sprintmodulo5.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
   
        String URL= System.getenv("URL");
        String USER = System.getenv("DB_USER");
        String PASS = System.getenv("DB_PASS");

     // Singleton instance
        private static Connection connection = null;

        // Private constructor to restrict instantiation
        private Conexion() {
          try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER , PASS);
          } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
          }
        }

        // Getter for the singleton instance
        public static Connection getConnection() {
          if (connection == null) {
            new Conexion();
          }
          return connection;
        }
        
   
}
