package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.modelo.Administrativo;

@WebServlet("/EditarAdministrativoServlet")
public class EditarAdministrativoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditarAdministrativoServlet() {
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

        // Obtener el ID del administrativo a editar desde la URL
        int rutAdministrativo = Integer.parseInt(request.getParameter("rut"));

        // Obtener el administrativo de la lista de usuarios por su ID
        Administrativo administrativo = Administrativo.obtenerAdministrativoPorRut(rutAdministrativo);

        // Agregar el administrativo al request para mostrarlo en el formulario de edición
        request.setAttribute("administrativo", administrativo);

        getServletContext().getRequestDispatcher("/views/editarAdministrativo.jsp").forward(request, response);
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
        int rutAdministrativo = Integer.parseInt(request.getParameter("rutAdministrativo"));
        String area = request.getParameter("area");
        String experienciaPrevia = request.getParameter("experienciaPrevia");

        // Obtener el administrativo de la lista de usuarios por su ID
        Administrativo administrativo = Administrativo.obtenerAdministrativoPorRut(rutAdministrativo);

        // Actualizar los valores del administrativo
        administrativo.setArea(area);
        administrativo.setExperienciaPrevia(experienciaPrevia);

        // Redireccionar al servlet correspondiente según el tipo de usuario
        response.sendRedirect(request.getContextPath() + "/ListadoDeUsuariosServlet");
    }
}
