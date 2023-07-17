package sprintmodulo5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.DAO.ClienteDAO;
import sprintmodulo5.modelo.Cliente;
import sprintmodulo5.modelo.Usuario;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AgregarClienteServlet
 */
@WebServlet("/AgregarClienteServlet")
public class AgregarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AgregarClienteServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recupera el Usuario de la sesión HTTP
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		// Pasa el Usuario al JSP
		request.setAttribute("usuario", usuario);

		// Verificar si se ha guardado correctamente y mostrar ventana emergente en caso
		// afirmativo
		boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
		if (guardadoExitoso) {
			request.setAttribute("mostrarVentanaEmergente", true);
		}
		getServletContext().getRequestDispatcher("/views/agregarCliente.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/// Para aceptar caracteres especiales
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		// Obtener los parámetros del formulario

		String telefono = request.getParameter("telefono");
		String afp = request.getParameter("afp");
		int sistemaSalud = Integer.parseInt(request.getParameter("sistemaSalud"));
		String direccion = request.getParameter("direccion");
		String comuna = request.getParameter("comuna");
		int edad = Integer.parseInt(request.getParameter("edad"));

		// Crear una instancia de la clase Cliente y asignar los valores
		Cliente cliente = new Cliente(usuario.getRut(), usuario.getNombre(), usuario.getFechaNacimiento(),
				usuario.getTipoUsuario(), telefono, afp, sistemaSalud, direccion, comuna, edad);

		// Se guardan los datos de cliente
		ClienteDAO clienteDao = new ClienteDAO();

		try {
			clienteDao.guardarCliente(cliente);
			boolean guardadoExitoso = true;
			request.setAttribute("guardadoExitoso", String.valueOf(guardadoExitoso));
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/InicioServlet");
		dispatcher.forward(request, response);

		doGet(request, response);
	}
}
