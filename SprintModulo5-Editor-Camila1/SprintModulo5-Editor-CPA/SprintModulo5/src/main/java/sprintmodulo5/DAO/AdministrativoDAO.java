package sprintmodulo5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sprintmodulo5.conexion.Conexion;
import sprintmodulo5.modelo.Administrativo;


public class AdministrativoDAO extends UsuarioDAO {

	
	private Connection connection;

    public AdministrativoDAO() {
        connection = Conexion.getConnection();
    }

    //Metodo para guardar Administrativo en la base de datos
    public void guardarAdministrativo(Administrativo administrativo) {
    	
    	
    	int usuarioId = guardarUsuario(administrativo);
    	String SQL = "INSERT INTO administrativos (area, experiencia_previa, id_usuario) VALUES (?, ?, ?)";
    	
        try {
            PreparedStatement ps = connection.prepareStatement(SQL);
                    
            ps.setString(1, administrativo.getArea());
            ps.setString(2, administrativo.getExperienciaPrevia());
            ps.setInt(3, usuarioId);
            ps.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    }
    
    
    // Obtiene todos los administrativos de la base de datos y los devuelve en una lista
    public List<Administrativo> obtenerAdministrativos() throws SQLException {
        List<Administrativo> administrativos = new ArrayList<>();
        String query = "select u.nombre, u.fecha_nacimiento, u.rut, c.area, c.experiencia_previa\r\n"
        		+ "from usuarios u\r\n"
        		+ "join administrativos c\r\n"
        		+ "on u.id = c.id_usuario\r\n"
        		+ "";
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Administrativo administrativo = new Administrativo();
            administrativo.setArea(rs.getString("area"));
            administrativo.setExperienciaPrevia(rs.getString("experiencia_previa"));
            administrativo.setNombre(rs.getString("nombre"));
            administrativo.setFechaNacimiento(rs.getString("fecha_nacimiento"));
            administrativo.setRut(rs.getInt("rut"));
            administrativos.add(administrativo);
           
        }
        return administrativos;
    }
}