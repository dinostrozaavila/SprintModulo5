package sprintmodulo5.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sprintmodulo5.conexion.Conexion;
import sprintmodulo5.modelo.Cliente;

public class ClienteDAO extends UsuarioDAO {

	private static Connection connection;

	public ClienteDAO() {
		connection = Conexion.getConnection();
	}

	// Metodo para guardar Cliente en la base de datos
	public void guardarCliente(Cliente cliente) {

		int usuarioId = guardarUsuario(cliente);
		String SQL = "INSERT INTO clientes (telefono, afp, sistema_salud, direccion, comuna, edad, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = connection.prepareStatement(SQL);

			ps.setString(1, cliente.getTelefono());
			ps.setString(2, cliente.getAfp());
			ps.setInt(3, cliente.getSistemaSalud());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getComuna());
			ps.setInt(6, cliente.getEdad());
			ps.setInt(7, usuarioId);
			ps.execute();

		} catch (SQLException ex) {
			ex.printStackTrace();

		}
	}

	// Obtiene todos los clientes de la base de datos y los devuelve en una lista
	public List<Cliente> obtenerClientes() throws SQLException {
		List<Cliente> clientes = new ArrayList<>();
		String query = "select c.id, u.nombre, u.fecha_nacimiento, u.rut, c.telefono, c.afp, c.sistema_salud, c.direccion, c.comuna, c.edad\r\n"
				+ "from usuarios u\r\n" + "join clientes c\r\n" + "on u.id = c.id_usuario\r\n" + "";
		PreparedStatement statement = ClienteDAO.connection.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(rs.getInt("id"));
			cliente.setTelefono(rs.getString("telefono"));
			cliente.setAfp(rs.getString("afp"));
			cliente.setSistemaSalud(rs.getInt("sistema_salud"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setComuna(rs.getString("comuna"));
			cliente.setEdad(rs.getInt("edad"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
			cliente.setRut(rs.getInt("rut"));

			clientes.add(cliente);

		}
		return clientes;
	}

	// Método para actualizar un cliente en la base de datos
	public void actualizarCliente(Cliente cliente) {
		String SQL = "UPDATE clientes "
				+ "SET telefono = ?, afp = ?, sistema_salud = ?, direccion = ?, comuna = ?, edad = ? " + "WHERE id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setString(1, cliente.getTelefono());
			ps.setString(2, cliente.getAfp());
			ps.setInt(3, cliente.getSistemaSalud());
			ps.setString(4, cliente.getDireccion());
			ps.setString(5, cliente.getComuna());
			ps.setInt(6, cliente.getEdad());
			ps.setInt(7, cliente.getIdCliente());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// Método para obtener un cliente por su Id desde la base de datos
	public static Cliente obtenerClienteId(int id) {
		String query = "SELECT c.id, u.nombre, u.fecha_nacimiento, u.rut, c.telefono, c.afp, c.sistema_salud, c.direccion, c.comuna, c.edad "
				+ "FROM usuarios u " + "JOIN clientes c ON u.id = c.id_usuario " + "WHERE c.id = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setTelefono(rs.getString("telefono"));
					cliente.setAfp(rs.getString("afp"));
					cliente.setSistemaSalud(rs.getInt("sistema_salud"));
					cliente.setDireccion(rs.getString("direccion"));
					cliente.setComuna(rs.getString("comuna"));
					cliente.setEdad(rs.getInt("edad"));
					cliente.setNombre(rs.getString("nombre"));
					cliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
					cliente.setRut(rs.getInt("rut"));
					cliente.setIdCliente(rs.getInt("id"));
					return cliente;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null; // Si no se encuentra el cliente, se devuelve null
	}

}
