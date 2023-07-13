package sprintmodulo5.interfaces;

import java.util.List;

import sprintmodulo5.modelo.Capacitacion;

public interface ICapacitacion {
	
    List<Capacitacion> obtenerListaCapacitaciones();
    
    void guardarCapacitacion(Capacitacion capacitacion);
}
