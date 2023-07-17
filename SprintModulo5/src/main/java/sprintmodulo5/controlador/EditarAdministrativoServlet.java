package sprintmodulo5.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.DAO.AdministrativoDAO;

import sprintmodulo5.modelo.Administrativo;

@WebServlet("/EditarAdministrativoServlet")
public class EditarAdministrativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdministrativoDAO administrativoDAO;

	public EditarAdministrativoServlet() {
		super();
		administrativoDAO = new AdministrativoDAO();
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

		// Obtener el Id del administrativo a editar desde la URL
		String idParam = request.getParameter("id");
		if (idParam == null || idParam.isEmpty()) {
			// Manejar caso de parámetro nulo o vacío
			// Redireccionar o mostrar mensaje de error según corresponda
			return;
		}

		int id = 0;
		try {
			id = Integer.parseInt(idParam);
		} catch (NumberFormatException e) {
			// Manejar caso de parámetro no numérico
			// Redireccionar o mostrar mensaje de error según corresponda
			return;
		}

		// Obtener el administrativo de la lista de usuarios por su ID
		Administrativo administrativo = AdministrativoDAO.obtenerIdAministrativo(id);
		if (administrativo == null) {
			// Manejar caso de cliente no encontrado
			// Redireccionar o mostrar mensaje de error según corresponda
			return;
		}

		// Agregar el administrativo al request para mostrarlo en el formulario de
		// edición
		request.setAttribute("administrativo", administrativo);

		getServletContext().getRequestDispatcher("/views/editarAdministrativo.jsp").forward(request, response);
	}

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

		/// Para aceptar caracteres especiales
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				 
		// Obtener los parámetros del formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String area = request.getParameter("area");
		String experienciaPrevia = request.getParameter("experienciaPrevia");

		// Obtener el administrativo de la lista de usuarios por su ID
		Administrativo administrativo = new Administrativo();
		try {
			administrativo = AdministrativoDAO.obtenerIdAministrativo(id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (administrativo == null) {
			// Manejar caso de administrativo no encontrado
			// Redireccionar o mostrar mensaje de error según corresponda
			return;
		}

		// Actualizar los valores del administrativo
		administrativo.setArea(area);
		administrativo.setExperienciaPrevia(experienciaPrevia);
		administrativo.setIdAdministrativo(id);

		// Actualizar el administrativo en la base de datos
		administrativoDAO.actualizarAdministrativo(administrativo);

		try {
			// Obtener la lista de administrativo
			List<Administrativo> listaAdministrativos = administrativoDAO.obtenerAdministrativos();

			// Agregar la lista de administrativo al request
			request.setAttribute("listaAdministrativos", listaAdministrativos);

			// Redireccionar al servlet correspondiente según el tipo de usuario
			response.sendRedirect(request.getContextPath() + "/ListarAdministrativosServlet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
