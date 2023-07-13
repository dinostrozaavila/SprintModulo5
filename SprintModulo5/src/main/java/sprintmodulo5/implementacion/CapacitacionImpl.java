package sprintmodulo5.implementacion;

import java.util.ArrayList;
import java.util.List;

import sprintmodulo5.interfaces.ICapacitacion;
import sprintmodulo5.modelo.Capacitacion;

public class CapacitacionImpl implements ICapacitacion {
    private List<Capacitacion> listaCapacitaciones;

    public CapacitacionImpl() {
        listaCapacitaciones = new ArrayList<>();
    }

    @Override
    public List<Capacitacion> obtenerListaCapacitaciones() {
        return listaCapacitaciones;
    }

    @Override
    public void guardarCapacitacion(Capacitacion capacitacion) {
        listaCapacitaciones.add(capacitacion);
    }
}
