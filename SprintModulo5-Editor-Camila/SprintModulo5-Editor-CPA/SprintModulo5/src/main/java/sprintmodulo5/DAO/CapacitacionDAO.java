package sprintmodulo5.DAO;

import sprintmodulo5.modelo.Capacitacion;
import sprintmodulo5.conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDAO {

    private Connection connection;

    public CapacitacionDAO() {
        connection = Conexion.getConnection();
    }
    // Agrega un registro de capacitacion a la base de datos
    public void agregarCapacitacion(Capacitacion capacitacion) throws SQLException {
        String sql = "INSERT INTO capacitaciones (rutCliente, dia, hora, lugar, duracion, cantidad) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, capacitacion.getRutCliente());
        statement.setString(2, capacitacion.getDia());
        statement.setTime(3, java.sql.Time.valueOf(capacitacion.getHora()));  // Aquí se convierte LocalTime a Time de SQL
        statement.setString(4, capacitacion.getLugar());
        statement.setString(5, capacitacion.getDuracion());
        statement.setInt(6, capacitacion.getCantidad());
        
        statement.executeUpdate();
    }
    
   // Obtiene todas las capacitaciones de la base de datos y las devuelve en una lista

    public List<Capacitacion> obtenerCapacitaciones() throws SQLException {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String query = "SELECT * FROM capacitaciones";
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            Capacitacion capacitacion = new Capacitacion();
            capacitacion.setIdentificador(rs.getInt("Id"));
            capacitacion.setRutCliente(rs.getInt("rutCliente"));
            capacitacion.setDia(rs.getString("dia"));
            capacitacion.setHora(rs.getTime("hora").toLocalTime());
            capacitacion.setLugar(rs.getString("lugar"));
            capacitacion.setDuracion(rs.getString("duracion"));
            capacitacion.setCantidad(rs.getInt("cantidad"));
            capacitaciones.add(capacitacion);
        }
        return capacitaciones;
    }
}