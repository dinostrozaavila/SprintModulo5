package sprintmodulo5.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.DAO.CapacitacionDAO;
import sprintmodulo5.modelo.Capacitacion;

@WebServlet("/CrearCapacitacionServlet")
public class CrearCapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCapacitacionServlet() {
		super();
	}
    private CapacitacionDAO capacitacionDAO;

    public void init() {
        capacitacionDAO = new CapacitacionDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Verificar si el usuario ha iniciado sesión
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado
			// sesión
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}

		// Verificar si se ha guardado correctamente y mostrar ventana emergente en caso
		// afirmativo
		boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
		if (guardadoExitoso) {
			request.setAttribute("mostrarVentanaEmergente", true);
		}
		getServletContext().getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Verificar si el usuario ha iniciado sesión
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado
			// sesión
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}

		// Obtener los parámetros del formulario
		int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
		String dia = request.getParameter("dia");
		LocalTime hora = LocalTime.parse(request.getParameter("hora"));
		String lugar = request.getParameter("lugar");
		String duracion = request.getParameter("duracion");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		// Crear una instancia de la clase Capacitacion y asignar los valores
		Capacitacion capacitacion = new Capacitacion();
		capacitacion.setRutCliente(rutCliente);
		capacitacion.setDia(dia);
		capacitacion.setHora(hora);
		capacitacion.setLugar(lugar);
		capacitacion.setDuracion(duracion);
		capacitacion.setCantidad(cantidad);

		// Guardar la instancia de Capacitacion en la lista
		try {
            capacitacionDAO.agregarCapacitacion(capacitacion);
            request.setAttribute("guardadoExitoso", "true");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("guardadoExitoso", "false");
        }
		// Simular guardado exitoso
		boolean guardadoExitoso = true;

		// Guardar el resultado en un atributo de la solicitud
		request.setAttribute("guardadoExitoso", String.valueOf(guardadoExitoso));

		// Redirigir al método doGet para mostrar la ventana emergente
		doGet(request, response);
	}
}

