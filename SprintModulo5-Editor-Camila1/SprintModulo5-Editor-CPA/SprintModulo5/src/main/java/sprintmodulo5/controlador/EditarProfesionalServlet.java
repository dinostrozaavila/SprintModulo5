package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.modelo.Profesional;

@WebServlet("/EditarProfesionalServlet")
public class EditarProfesionalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditarProfesionalServlet() {
        super();
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

        int rut = Integer.parseInt(request.getParameter("rut"));
        
        // Obtener el objeto Profesional correspondiente al rut
        Profesional profesional = Profesional.obtenerProfesionalPorRut(rut);
        
        // Agregar el profesional al request para mostrarlo en el formulario de edición
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

        // Obtener los parámetros del formulario
        String rutProfesionalParam = request.getParameter("rutProfesional");
        int rutProfesional = rutProfesionalParam != null ? Integer.parseInt(rutProfesionalParam) : 0;
        String titulo = request.getParameter("titulo");
        String fechaIngreso = request.getParameter("fechaIngreso");

        // Obtener el profesional de la lista de profesionales por su ID
        Profesional profesional = Profesional.obtenerProfesionalPorRut(rutProfesional);

        // Actualizar los valores del profesional
        profesional.setTitulo(titulo);
        profesional.setFechaIngreso(fechaIngreso);

        // Redireccionar al servlet correspondiente según el tipo de usuario
        response.sendRedirect(request.getContextPath() + "/ListadoDeUsuariosServlet");
    }
}
