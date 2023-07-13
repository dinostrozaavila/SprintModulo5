package sprintmodulo5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesional extends Usuario {

    private String titulo; // Título del profesional
    private String fechaIngreso; // Fecha de ingreso del profesional

    // Lista para almacenar los profesionales
    private static List<Profesional> listaProfesionales = new ArrayList<>();

    public Profesional() {
        super();
    }

    /**
     * Constructor de la clase Profesional que recibe todos los atributos.
     *
     * @param nombre          Nombre del profesional.
     * @param fechaNacimiento Fecha de nacimiento del profesional.
     * @param rut             RUN del profesional.
     * @param tipoUsuario     Tipo de usuario (Cliente, Profesional, Administrativo).
     * @param titulo          Título del profesional.
     * @param fechaIngreso    Fecha de ingreso del profesional.
     */
    public Profesional(String nombre, String fechaNacimiento, int rut, String tipoUsuario,
                       String titulo, String fechaIngreso) {
        super(nombre, fechaNacimiento, rut, tipoUsuario);
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
        
    }

    /**
     * Obtiene el título del profesional.
     *
     * @return Título del profesional.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del profesional.
     *
     * @param titulo Título del profesional.
     * @throws IllegalArgumentException Si el título no cumple con los requisitos.
     */
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty() && titulo.length() >= 10 && titulo.length() <= 50) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("El título debe tener entre 10 y 50 caracteres.");
        }
    }

    /**
     * Obtiene la fecha de ingreso del profesional.
     *
     * @return Fecha de ingreso del profesional.
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del profesional.
     *
     * @param fechaIngreso Fecha de ingreso del profesional.
     * @throws IllegalArgumentException Si la fecha de ingreso es nula.
     */
    public void setFechaIngreso(String fechaIngreso) {
        if (fechaIngreso != null && !fechaIngreso.isEmpty()) {
            this.fechaIngreso = fechaIngreso;
        } else {
            throw new IllegalArgumentException("La fecha de ingreso no puede quedar nula.");
        }
    }

    /**
     * Agrega un profesional a la lista de profesionales.
     *
     * @param profesional Profesional a agregar.
     */
    public void guardarProfesional(List<Profesional> listaProfesionales) {
        listaProfesionales.add(this);
    }

    /**
     * Obtiene la lista de profesionales.
     *
     * @return Lista de profesionales.
     */
    public static List<Profesional> obtenerListaProfesionales() {
        return listaProfesionales;
    }

    /**
     * Obtiene un profesional de la lista de profesionales por su RUN.
     *
     * @param rut RUN del profesional a buscar.
     * @return Profesional correspondiente al RUT especificado, o null si no se encuentra.
     */
    public static Profesional obtenerProfesionalPorRut(int rut) {
        for (Profesional profesional : listaProfesionales) {
            if (profesional.getRun() == rut) {
                return profesional;
            }
        }
        return null;
    }

    /**
     * Devuelve una representación en forma de cadena de la instancia de Profesional.
     *
     * @return Representación en forma de cadena de la instancia de Profesional.
     */
    @Override
    public String toString() {
        return "Profesional{" +
                "titulo='" + titulo + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", fechaNacimiento='" + getFechaNacimiento() + '\'' +
                ", run=" + getRun() +
                ", tipoUsuario='" + getTipoUsuario() + '\'' +
                '}';
    }
}
