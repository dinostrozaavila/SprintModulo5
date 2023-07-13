package grupal2.interfaces;

import java.util.List;

import grupal2.modelo.Capacitacion;

public interface ICapacitacion {
	
    List<Capacitacion> obtenerListaCapacitaciones();
    
    void guardarCapacitacion(Capacitacion capacitacion);
}
