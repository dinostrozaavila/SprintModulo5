package sprintmodulo5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintmodulo5.modelo.Cliente;

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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Verificar si se ha guardado correctamente y mostrar ventana emergente en caso
		// afirmativo
		boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
		if (guardadoExitoso) {
			request.setAttribute("mostrarVentanaEmergente", true);
		}
		getServletContext().getRequestDispatcher("/views/agregarCliente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/// Para aceptar caracteres especiales
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

		// Obtener los parámetros del formulario
		int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String telefono = request.getParameter("telefono");
		String afp = request.getParameter("afp");
		int sistemaSalud = Integer.parseInt(request.getParameter("sistemaSalud"));
		String direccion = request.getParameter("direccion");
		String comuna = request.getParameter("comuna");
		int edad = Integer.parseInt(request.getParameter("edad"));

		// Crear una instancia de la clase Cliente y asignar los valores
		Cliente cliente = new Cliente();
		cliente.setRutCliente(rutCliente);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setTelefono(telefono);
		cliente.setAfp(afp);
		cliente.setSistemaSalud(sistemaSalud);
		cliente.setDireccion(direccion);
		cliente.setComuna(comuna);
		cliente.setEdad(edad);

		// Guardar la instancia de Cliente en la lista
		cliente.guardarCliente(Cliente.obtenerListaClientes());

		// Simular guardado exitoso
		boolean guardadoExitoso = true;

		// Guardar el resultado en un atributo de la solicitud
		request.setAttribute("guardadoExitoso", String.valueOf(guardadoExitoso));
		
		// Redirigir al servlet "InicioServlet"
		RequestDispatcher dispatcher = request.getRequestDispatcher("/InicioServlet");
		dispatcher.forward(request, response);

		// Redirigir al método doGet para mostrar la ventana emergente
		doGet(request, response);
	}
}
