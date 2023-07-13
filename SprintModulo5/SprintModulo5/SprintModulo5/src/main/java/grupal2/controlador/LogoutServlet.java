package grupal2.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet de implementación de cierre de sesión
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LogoutServlet()	{
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// cierre de sesión
		
			request.getSession().invalidate();
		// Redireccionar al formulario de inicio de sesión
			
		response.sendRedirect(request.getContextPath() + "/LoginServlet");

	

	}
}