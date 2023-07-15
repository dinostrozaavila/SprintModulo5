package sprintmodulo5.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sprintmodulo5.modelo.Cliente;

@WebServlet("/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditarClienteServlet() {
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

        // Obtener el ID del cliente a editar desde la URL
        int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));

        // Obtener el cliente de la lista de usuarios por su ID
        Cliente cliente = Cliente.obtenerClientePorRut(rutCliente);

        // Agregar el cliente al request para mostrarlo en el formulario de edición
        request.setAttribute("cliente", cliente);

        getServletContext().getRequestDispatcher("/views/editarCliente.jsp").forward(request, response);
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
        int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
        String nombre = request.getParameter("nombres");
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        int sistemaSalud = Integer.parseInt(request.getParameter("sistemaSalud"));
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        int edad = Integer.parseInt(request.getParameter("edad"));
        
        // Obtener el cliente de la lista de usuarios por su ID
        Cliente cliente = Cliente.obtenerClientePorRut(rutCliente);

        // Actualizar los valores del cliente
        cliente.setNombre(nombre);
        cliente.setFechaNacimiento(fechaNacimiento);

           
     // Actualizar los valores del cliente
        cliente.actualizarCliente(telefono, afp, sistemaSalud, direccion, comuna, edad);

    
        // Redireccionar al servlet correspondiente según el tipo de usuario
        response.sendRedirect(request.getContextPath() + "/ListadoDeUsuariosServlet");
    }

}
