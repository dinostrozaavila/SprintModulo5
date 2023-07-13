package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CrearCapacitacionServlet")
public class CrearCapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCapacitacionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Verificar si el usuario ha iniciado sesión
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado sesión
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}

		// Redireccionar al formulario de creación de capacitación
		request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Verificar si el usuario ha iniciado sesión
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado sesión
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}

		// Redirigir la solicitud a ProcesarCapacitacionServlet
		request.getRequestDispatcher("/ProcesarCapacitacionServlet").forward(request, response);
	}
}

