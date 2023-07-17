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

	private static Connection connection;

	public ProfesionalDAO() {
		connection = Conexion.getConnection();
	}

	// Metodo para guardar Profesional en la base de datos
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

	// Obtiene todos los profesionales de la base de datos y los devuelve en una
	// lista
	public List<Profesional> obtenerProfesionales() throws SQLException {
		List<Profesional> profesionales = new ArrayList<>();
		String query = "select p.id, u.nombre, u.fecha_nacimiento, u.rut, p.titulo, p.fecha_de_ingreso\r\n"
				+ "from usuarios u\r\n" + "join profesionales p\r\n" + "on u.id = p.id_usuario\r\n" + "";
		PreparedStatement statement = ProfesionalDAO.connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Profesional profesional = new Profesional();
			profesional.setTitulo(rs.getString("titulo"));
			profesional.setFechaIngreso(rs.getString("fecha_de_ingreso"));
			profesional.setNombre(rs.getString("nombre"));
			profesional.setFechaNacimiento(rs.getString("fecha_nacimiento"));
			profesional.setRut(rs.getInt("rut"));
			profesional.setIdProfesional(rs.getInt("id"));
			profesionales.add(profesional);

		}
		return profesionales;
	}
	// Método para actualizar un profesional en la base de datos
		public void actualizarProfesional(Profesional profesional) {
			String SQL = "UPDATE profesionales " + "SET titulo = ?, fecha_de_ingreso = ? " + "WHERE id = ?";
			try {
				PreparedStatement ps = connection.prepareStatement(SQL);
				ps.setString(1, profesional.getTitulo());
				ps.setString(2, profesional.getFechaIngreso());
				ps.setInt(3, profesional.getIdProfesional());
				ps.executeUpdate();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		// Método para obtener un profesional por su Id desde la base de datos
		public static Profesional obtenerIdProfesional(int id) {
			String query = "SELECT p.id, p.titulo, p.fecha_de_ingreso " + "FROM usuarios u "
					+ "JOIN profesionales p ON u.id = p.id_usuario " + "WHERE p.id = ?";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, id);
				try (ResultSet rs = statement.executeQuery()) {
					if (rs.next()) {
						Profesional profesional = new Profesional();
						profesional.setTitulo(rs.getString("titulo"));
						profesional.setFechaIngreso(rs.getString("fecha_de_ingreso"));
						profesional.setIdProfesional(rs.getInt("id"));
						return profesional;
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			return null; // Si no se encuentra el Administrativo, se devuelve null
		}
}