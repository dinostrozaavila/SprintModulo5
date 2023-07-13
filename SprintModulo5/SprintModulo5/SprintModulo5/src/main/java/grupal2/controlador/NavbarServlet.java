package grupal2.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NavigationServlet")
public class NavbarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NavbarServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String target = request.getParameter("target");

        if (target != null && !target.isEmpty()) {
            if (target.equals("inicio")) {
                response.sendRedirect(request.getContextPath() + "/InicioServlet");
            } else if (target.equals("contacto")) {
                response.sendRedirect(request.getContextPath() + "/ContactoServlet");
            } else if (target.equals("login")) {
                response.sendRedirect(request.getContextPath() + "/LoginServlet");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/InicioServlet");
        }
    }
}

