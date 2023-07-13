package sprintmodulo5.controlador;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sprintmodulo5.implementacion.CapacitacionImpl;
import sprintmodulo5.interfaces.ICapacitacion;
import sprintmodulo5.modelo.Capacitacion;

@WebServlet("/ProcesarCapacitacionServlet")
public class ProcesarCapacitacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICapacitacion capacitacionImplementacion;

    public ProcesarCapacitacionServlet() {
        super();
        capacitacionImplementacion = new CapacitacionImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int id = Integer.parseInt(request.getParameter("identificador"));
        int rutCliente = Integer.parseInt(request.getParameter("rutCliente"));
        String dia = request.getParameter("dia");
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));
        String lugar = request.getParameter("lugar");
        String duracion = request.getParameter("duracion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        // Crear una instancia de la clase Capacitacion y asignar los valores
        Capacitacion capacitacion = new Capacitacion(id, rutCliente, dia, hora, lugar, duracion, cantidad);

        // Guardar la instancia de Capacitacion en el sistema
        capacitacionImplementacion.guardarCapacitacion(capacitacion);

        // Establecer el atributo para mostrar el mensaje de confirmación
        request.setAttribute("guardadoExitoso", true);

        // Redirigir a la misma página para mostrar el mensaje
        request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
    }
}




