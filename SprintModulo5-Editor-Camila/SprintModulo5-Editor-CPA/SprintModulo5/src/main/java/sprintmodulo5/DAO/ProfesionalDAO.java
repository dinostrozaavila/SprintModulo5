package sprintmodulo5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sprintmodulo5.conexion.Conexion;
import sprintmodulo5.modelo.Profesional;


public class ProfesionalDAO extends UsuarioDAO {

	
	private Connection connection;

    public ProfesionalDAO() {
        connection = Conexion.getConnection();
    }

    //Metodo para guardar Profesional en la base de datos
    public void guardarProfesional(Profesional profesional) {
    	
    	
    	int usuarioId = guardarUsuario(profesional);
    	String SQL = "INSERT INTO profesionales (titulo, fecha_de_ingreso, id_usuario) VALUES (?, ?, ?)";
    	
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
                    
            ps.setString(1, profesional.getTitulo());
            ps.setString(2, profesional.getFechaIngreso());
            ps.setInt(3, usuarioId);
            ps.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    }
    
    
    // Obtiene todos los profesionales de la base de datos y los devuelve en una lista
    public List<Profesional> obtenerProfesionales() throws SQLException {
        List<Profesional> profesionales = new ArrayList<>();
        String query = "select u.nombre, u.fecha_nacimiento, u.rut, c.titulo, c.fecha_de_ingreso\r\n"
        		+ "from usuarios u\r\n"
        		+ "join profesionales c\r\n"
        		+ "on u.id = c.id_usuario\r\n"
        		+ "";
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Profesional profesional = new Profesional();
            profesional.setTitulo(rs.getString("titulo"));
            profesional.setFechaIngreso("fecha_de_ingreso");
            profesional.setNombre(rs.getString("nombre"));
            profesional.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            profesional.setRut(rs.getInt("rut"));
            profesionales.add(profesional);
           
        }
        return profesionales;
    }
}