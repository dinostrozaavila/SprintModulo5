package grupal2.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import grupal2.modelo.Profesional;

/**
 * Servlet implementation class AgregarProfesionalServlet
 */
@WebServlet("/AgregarProfesionalServlet")
public class AgregarProfesionalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarProfesionalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Verificar si se ha guardado correctamente y mostrar ventana emergente en caso
		// afirmativo
		boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
		if (guardadoExitoso) {
			request.setAttribute("mostrarVentanaEmergente", true);
		}
		getServletContext().getRequestDispatcher("/views/agregarProfesional.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtener los parámetros del formulario
		String titulo = request.getParameter("titulo");
		String fechaIngreso = request.getParameter("fechaIngreso");

		// Crear una instancia de la clase Profesional y asignar los valores
		Profesional profesional = new Profesional();
		profesional.setTitulo(titulo);
		profesional.setFechaIngreso(fechaIngreso);


		// Guardar la instancia de Profesional en la lista
		profesional.guardarProfesional(Profesional.obtenerListaProfesionales());

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
