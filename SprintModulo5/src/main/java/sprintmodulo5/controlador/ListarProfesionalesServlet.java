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

import sprintmodulo5.DAO.ProfesionalDAO;
import sprintmodulo5.modelo.Profesional;

/**
 * Servlet implementation class ListadoDeUsuarios
 */
@WebServlet("/ListarProfesionalesServlet")
public class ListarProfesionalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProfesionalesServlet() {
        super();
             
    }
    
    private ProfesionalDAO profesionalDAO;

    public void init() {
        profesionalDAO = new ProfesionalDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		
		// Obtener la lista de profesionales
		
		List<Profesional> listaProfesionales = new ArrayList<Profesional>();
		try {
			listaProfesionales = profesionalDAO.obtenerProfesionales();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		// Guardar la lista en un atributo de la solicitud		
		request.setAttribute("listaProfesionales", listaProfesionales);
		
				
	
		// Llamar al JSP para mostrar la lista de usuarios
		getServletContext().getRequestDispatcher("/views/listarProfesionales.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
