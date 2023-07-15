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

import sprintmodulo5.DAO.ClienteDAO;
import sprintmodulo5.modelo.Cliente;
import sprintmodulo5.modelo.Usuario;

/**
 * Servlet implementation class ListadoDeUsuarios
 */
@WebServlet("/ListadoDeUsuariosServlet")
public class ListadoDeUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListadoDeUsuariosServlet() {
        super();
             
    }
    private ClienteDAO clienteDAO;

    public void init() {
        clienteDAO = new ClienteDAO();
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
		
		// Obtener la lista de usuarios
		List<Usuario> listaUsuarios = Usuario.obtenerListaUsuarios();
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		try {
			listaClientes = clienteDAO.obtenerClientes();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		// Guardar la lista en un atributo de la solicitud
		request.setAttribute("listaUsuarios", listaUsuarios);
		
		request.setAttribute("listaClientes", listaClientes);
		
				
	
		// Llamar al JSP para mostrar la lista de usuarios
		getServletContext().getRequestDispatcher("/views/listadoDeUsuarios.jsp").forward(request, response);
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
