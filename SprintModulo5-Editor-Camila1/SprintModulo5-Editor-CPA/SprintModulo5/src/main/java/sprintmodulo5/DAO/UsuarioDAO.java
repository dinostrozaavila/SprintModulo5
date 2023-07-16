package sprintmodulo5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sprintmodulo5.conexion.Conexion;
import sprintmodulo5.modelo.Usuario;

public class UsuarioDAO {

	private Connection connection;

    public UsuarioDAO() {
        connection = Conexion.getConnection();
    }

    //Metodo para guardar usuario en la base de datos
    public int guardarUsuario(Usuario usuario) {
        try {
            String ps = "INSERT INTO usuarios (nombre, fecha_nacimiento, rut, tipo_usuario ) VALUES (?, ?, ?, ?)";
            
            //obtiene el registro del id del usuario autogenerado incrementalmente
            int id = 0;
            try (
                PreparedStatement pstmt = connection.prepareStatement(ps, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, usuario.getNombre());
                pstmt.setString(2, usuario.getFechaNacimiento());
                pstmt.setInt(3, usuario.getRut());
                pstmt.setString(4, usuario.getTipoUsuario());
                pstmt.executeUpdate();

                // Recuperar el ID del usuario recién insertado
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return id; // Devolver el ID del usuario recién insertado
        
        } finally{
        	
        }
        
    }
}
