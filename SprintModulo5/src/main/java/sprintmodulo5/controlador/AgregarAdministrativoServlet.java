package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintmodulo5.modelo.Administrativo;

/**
 * Servlet implementation class AgregarAdministrativoServlet
 */
@WebServlet("/AgregarAdministrativoServlet")
public class AgregarAdministrativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarAdministrativoServlet() {
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
		getServletContext().getRequestDispatcher("/views/agregarAdministrativo.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Obtener los parámetros del formulario
		String area = request.getParameter("area");
		String experienciaPrevia = request.getParameter("experienciaPrevia");

		// Crear una instancia de la clase Administrativo y asignar los valores
		Administrativo administrativo = new Administrativo();
		administrativo.setArea(area);
		administrativo.setExperienciaPrevia(experienciaPrevia);


		// Guardar la instancia de Administrativo en la lista
		administrativo.guardarAdministrativo(Administrativo.obtenerListaAdministrativos());

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
