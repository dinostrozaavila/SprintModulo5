package sprintmodulo5.conexion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

@WebServlet("/TestConnectionServlet")

public class TestConnectionServlet extends HttpServlet {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Connection connection = Conexion.getConnection();
    String message;

    if (connection != null) {
      message = "La conexión a la base de datos se ha realizado con éxito!";
    } else {
      message = "Falló la conexión a la base de datos.";
    }

    request.setAttribute("message", message);
    request.getRequestDispatcher("/views/result.jsp").forward(request, response);
  }
}