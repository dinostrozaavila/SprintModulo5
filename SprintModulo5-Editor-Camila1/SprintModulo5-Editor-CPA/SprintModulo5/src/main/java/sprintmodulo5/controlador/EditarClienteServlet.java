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

import sprintmodulo5.DAO.ClienteDAO;
import sprintmodulo5.modelo.Cliente;

@WebServlet("/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ClienteDAO clienteDAO;

    public EditarClienteServlet() {
        super();
        clienteDAO = new ClienteDAO();
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

        // Obtener el RUT del cliente a editar desde la URL
        String rutParam = request.getParameter("rut");
        if (rutParam == null || rutParam.isEmpty()) {
            // Manejar caso de parámetro nulo o vacío
            // Redireccionar o mostrar mensaje de error según corresponda
            return;
        }
        
        int rut = 0;
        try {
            rut = Integer.parseInt(rutParam);
        } catch (NumberFormatException e) {
            // Manejar caso de parámetro no numérico
            // Redireccionar o mostrar mensaje de error según corresponda
            return;
        }

        // Obtener el cliente de la base de datos por su rut
        Cliente cliente = clienteDAO.obtenerClientePorRut(rut);

        if (cliente == null) {
            // Manejar caso de cliente no encontrado
            // Redireccionar o mostrar mensaje de error según corresponda
            return;
        }

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
        int rut = Integer.parseInt(request.getParameter("rut"));
        String telefono = request.getParameter("telefono");
        String afp = request.getParameter("afp");
        int sistemaSalud = Integer.parseInt(request.getParameter("sistemaSalud"));
        String direccion = request.getParameter("direccion");
        String comuna = request.getParameter("comuna");
        int edad = Integer.parseInt(request.getParameter("edad"));

        // Obtener el cliente de la base de datos por su rut
        Cliente cliente = Cliente.obtenerClientePorRut(rut);

        if (cliente == null) {
            // Manejar caso de cliente no encontrado
            // Redireccionar o mostrar mensaje de error según corresponda
            return;
        }

        // Actualizar los valores del cliente
        cliente.setTelefono(telefono);
        cliente.setAfp(afp);
        cliente.setSistemaSalud(sistemaSalud);
        cliente.setDireccion(direccion);
        cliente.setComuna(comuna);
        cliente.setEdad(edad);

        // Actualizar el cliente en la base de datos
        clienteDAO.actualizarCliente(cliente);

        try {
            // Obtener la lista de clientes
            List<Cliente> listaClientes = clienteDAO.obtenerClientes();

            // Agregar la lista de clientes al request
            request.setAttribute("listaClientes", listaClientes);

            // Redireccionar al servlet correspondiente según el tipo de usuario
            response.sendRedirect(request.getContextPath() + "/ListarClientesServlet");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



