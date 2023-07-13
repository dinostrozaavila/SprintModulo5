package grupal2.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    /**
     * Método GET para mostrar la página de inicio de sesión.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redireccionar al formulario de inicio de sesión
        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    /**
     * Método POST para procesar los datos del formulario de inicio de sesión.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificar los valores de usuario y contraseña
        if (username.equals("admin") && password.equals("1234")) {
            // Crear una sesión para el usuario
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redireccionar a la página de contacto
            response.sendRedirect(request.getContextPath() + "/ContactoServlet");
        } else {
            // Redireccionar al formulario de inicio de sesión si las credenciales son incorrectas
            response.sendRedirect(request.getContextPath() + "/LoginServlet");
        }
    }
}




