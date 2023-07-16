package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.DAO.AdministrativoDAO;
import sprintmodulo5.modelo.Administrativo;
import sprintmodulo5.modelo.Usuario;

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
		getServletContext().getRequestDispatcher("/views/agregarAdministrativo.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/// Para aceptar caracteres especiales
		request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
		// Obtener los parámetros del formulario
        
		String area = request.getParameter("area");
		String experienciaPrevia = request.getParameter("experienciaPrevia");

		// Crear una instancia de la clase Cliente y asignar los valores
		Administrativo administrativo = new Administrativo(usuario.getRut(), usuario.getNombre(), usuario.getFechaNacimiento(), usuario.getTipoUsuario(), area, experienciaPrevia);
		
		// Se guardan los datos de cliente
		AdministrativoDAO administrativoDao = new AdministrativoDAO();

		try {
            administrativoDao.guardarAdministrativo(administrativo);
            boolean guardadoExitoso = true;
            request.setAttribute("guardadoExitoso", String.valueOf(guardadoExitoso));
        } catch(Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/InicioServlet");
        dispatcher.forward(request, response);

	}
}
