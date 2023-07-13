package grupal2.implementacion;

import java.util.ArrayList;
import java.util.List;

import grupal2.modelo.Capacitacion;
import grupal2.interfaces.ICapacitacion;

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
