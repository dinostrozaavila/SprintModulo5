package sprintmodulo5.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.modelo.Contacto;

@WebServlet("/ContactoServlet")
public class ContactoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContactoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si el usuario ha iniciado sesión
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // Si no ha iniciado sesión, redireccionar a la página de inicio de sesión
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
        } else {
            // Verificar si se ha guardado correctamente y mostrar ventana emergente en caso afirmativo
            boolean guardadoExitoso = Boolean.parseBoolean((String) request.getAttribute("guardadoExitoso"));
            if (guardadoExitoso) {
                request.setAttribute("mostrarVentanaEmergente", true);
            }
            getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si el usuario ha iniciado sesión
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // Si no ha iniciado sesión, redireccionar a la página de inicio de sesión
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
            return;
        }

        String nombreUsuario = request.getParameter("nombreUsuario");
        String correoElectronico = request.getParameter("correoElectronico");
        String mensaje = request.getParameter("mensaje");

        // Crear una instancia de la clase Contacto y asignar los valores
        Contacto contacto = new Contacto();
        contacto.setNombreUsuario(nombreUsuario);
        contacto.setCorreoElectronico(correoElectronico);
        contacto.setMensaje(mensaje);

        // Simular guardado exitoso
        boolean guardadoExitoso = true;

        // Guardar el resultado en un atributo de la solicitud
        request.setAttribute("mostrarVentanaEmergente", String.valueOf(guardadoExitoso));

        // Redirigir al método doGet para mostrar la ventana emergente
        doGet(request, response);
    }
}


