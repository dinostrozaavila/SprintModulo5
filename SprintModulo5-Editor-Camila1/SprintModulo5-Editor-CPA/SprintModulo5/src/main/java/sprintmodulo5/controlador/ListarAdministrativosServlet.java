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

import sprintmodulo5.DAO.AdministrativoDAO;
import sprintmodulo5.modelo.Administrativo;

/**
 * Servlet implementation class ListadoDeUsuarios
 */
@WebServlet("/ListarAdministrativosServlet")
public class ListarAdministrativosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAdministrativosServlet() {
        super();
             
    }
    
    private AdministrativoDAO administrativoDAO;

    public void init() {
        administrativoDAO = new AdministrativoDAO();
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
		
		// Obtener la lista de administrativos
		
		
		List<Administrativo> listaAdministrativos = new ArrayList<Administrativo>();
		try {
			listaAdministrativos = administrativoDAO.obtenerAdministrativos();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		// Guardar la lista en un atributo de la solicitud
		
		request.setAttribute("listaAdministrativos", listaAdministrativos);
			
		// Llamar al JSP para mostrar la lista de administrativos
		getServletContext().getRequestDispatcher("/views/listarAdministrativos.jsp").forward(request, response);
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
