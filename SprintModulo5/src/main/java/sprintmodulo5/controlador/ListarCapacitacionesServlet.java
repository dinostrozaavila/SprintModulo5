package sprintmodulo5.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.DAO.CapacitacionDAO;
import sprintmodulo5.modelo.Capacitacion;

@WebServlet("/ListarCapacitacionesServlet")
public class ListarCapacitacionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListarCapacitacionesServlet() {
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

		// Obtener la lista de capacitaciones
		List<Capacitacion> listaCapacitaciones = new ArrayList<Capacitacion>();
		try {
			listaCapacitaciones = capacitacionDAO.obtenerCapacitaciones();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		// Guardar la lista en un atributo de la solicitud
		request.setAttribute("listaCapacitaciones", listaCapacitaciones);

		// Llamar al JSP para mostrar la lista de capacitaciones
		getServletContext().getRequestDispatcher("/views/listarCapacitaciones.jsp").forward(request, response);
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

		// Permitir solo el acceso a través del método GET
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}
}

