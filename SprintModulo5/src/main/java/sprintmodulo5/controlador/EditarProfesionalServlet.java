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

import sprintmodulo5.DAO.ProfesionalDAO;
import sprintmodulo5.modelo.Profesional;

@WebServlet("/EditarProfesionalServlet")
public class EditarProfesionalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    private ProfesionalDAO profesionalDAO;
    public EditarProfesionalServlet() {
        super();
        profesionalDAO	 = new ProfesionalDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si el usuario ha iniciado sesión
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado sesión
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }

     // Obtener el Id del profesional a editar desde la URL
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
     	// Obtener el profesional de la lista de usuarios por su ID
    		Profesional profesional = ProfesionalDAO.obtenerIdProfesional(id);
    		if (profesional == null) {
    			// Manejar caso de cliente no encontrado
    			// Redireccionar o mostrar mensaje de error según corresponda
    			return;
    		}

    		// Agregar el administrativo al request para mostrarlo en el formulario de
    		// edición
    		request.setAttribute("profesional", profesional);

    		getServletContext().getRequestDispatcher("/views/editarProfesional.jsp").forward(request, response);
    	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si el usuario ha iniciado sesión
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // Redireccionar al formulario de inicio de sesión si el usuario no ha iniciado sesión
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }
      /// Para aceptar caracteres especiales
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		 

        // Obtener los parámetros del formulario
		int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fechaIngreso = request.getParameter("fechaIngreso");

        // Obtener el profesional de la lista de profesionales por su ID
         		Profesional profesional = new Profesional();
     		try {
     			profesional = ProfesionalDAO.obtenerIdProfesional(id);
     		} catch (Exception e) {

     			e.printStackTrace();
     		}

     		if (profesional == null) {
     			// Manejar caso de profesional no encontrado
     			// Redireccionar o mostrar mensaje de error según corresponda
     			return;
     		}

        // Actualizar los valores del profesional
        profesional.setTitulo(titulo);
        profesional.setFechaIngreso(fechaIngreso);
        profesional.setIdProfesional(id);

     // Actualizar el profesional en la base de datos
     		profesionalDAO.actualizarProfesional(profesional);

     		try {
     			// Obtener la lista de profesional
     			List<Profesional> listaProfesionales = profesionalDAO.obtenerProfesionales();

     			// Agregar la lista de profesional al request
     			request.setAttribute("listaProfesionales", listaProfesionales);

     			// Redireccionar al servlet correspondiente según el tipo de usuario
     			response.sendRedirect(request.getContextPath() + "/ListarProfesionalesServlet");
     		} catch (SQLException e) {
     			e.printStackTrace();
     		}
     	}
}
