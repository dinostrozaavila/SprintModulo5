package sprintmodulo5.controlador;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.modelo.Usuario;

@WebServlet("/AgregarUsuarioServlet")
public class AgregarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgregarUsuarioServlet() {
		super();
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

		// Verificar si se ha guardado correctamente y mostrar ventana emergente en caso
		// afirmativo
		boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
		if (guardadoExitoso) {
			request.setAttribute("mostrarVentanaEmergente", true);
		}
		getServletContext().getRequestDispatcher("/views/agregarUsuario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Para aceptar caracteres especiales
				request.setCharacterEncoding("UTF-8");
		        response.setCharacterEncoding("UTF-8");
		        
		// Verificar si el usuario ha iniciado sesión
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("username") == null) {
			// Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado sesión
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        int run = Integer.parseInt(request.getParameter("run"));
        String tipoUsuario = request.getParameter("tipoUsuario");

        // Crear una instancia de la clase Usuario y asignar los valores
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setFechaNacimiento(fechaNacimiento);
        usuario.setRun(run);
        usuario.setTipoUsuario(tipoUsuario);

		// Guardar la instancia de Usuario en la lista
		usuario.guardarUsuario(Usuario.obtenerListaUsuarios());

		// Determinar la URL de redirección según el tipo de usuario
		String servletURL;
		if (tipoUsuario.equals("Profesional")) {
		    servletURL = "/AgregarProfesionalServlet";
		} else if (tipoUsuario.equals("Cliente")) {
		    servletURL = "/AgregarClienteServlet";
		} else if (tipoUsuario.equals("Administrativo")) {
		    servletURL = "/AgregarAdministrativoServlet";
		} else {
		    throw new IllegalArgumentException("Tipo de usuario inválido");
		}


		// Redireccionar al servlet correspondiente
		response.sendRedirect(request.getContextPath() + servletURL);
	}
}
