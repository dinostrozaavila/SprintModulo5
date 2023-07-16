package sprintmodulo5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
    private String nombre; // Nombre del usuario
    private String fechaNacimiento; // Fecha de nacimiento del usuario
    private int rut; // RUN del usuario
    private String tipoUsuario; // Tipo de usuario (Cliente, Profesional, Administrativo)
    
	// Lista para almacenar los usuarios
	private static List<Usuario> listaUsuarios = new ArrayList<>();
    
    public Usuario() {
        // Constructor vacío
    }
    
    // Constructor con los parámetros
    public Usuario(String nombre, String fechaNacimiento, int run, String tipoUsuario) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.rut = run;
        this.tipoUsuario=tipoUsuario;
    }
    
    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombre Nombre del usuario.
     * @throws IllegalArgumentException Si el nombre es nulo o tiene una longitud
     *                                  inválida.
     */
    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }

        if (nombre.length() < 10 || nombre.length() > 50) {
            throw new IllegalArgumentException("El nombre debe tener entre 10 y 50 caracteres.");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     *
     * @return Fecha de nacimiento del usuario.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     *
     * @param fechaNacimiento Fecha de nacimiento del usuario.
     * @throws IllegalArgumentException Si la fecha de nacimiento es nula.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser nula.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el RUN del usuario.
     *
     * @return RUN del usuario.
     */
    public int getRut() {
        return rut;
    }

    /**
     * Establece el RUN del usuario.
     *
     * @param run RUN del usuario.
     * @throws IllegalArgumentException Si el RUN es inválido.
     */
    public void setRut(int rut) {
        if (rut >= 99999999) {
            throw new IllegalArgumentException("El RUT debe ser un número menor a 99.999.999.");
        }
        this.rut = rut;
    }
    
    /**
     * Obtiene el tipo de usuario.
     *
     * @return Tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario Tipo de usuario.
     * @throws IllegalArgumentException Si el tipo de usuario no es válido.
     */
    public void setTipoUsuario(String tipoUsuario) {
        if (!tipoUsuario.equals("Cliente") && !tipoUsuario.equals("Profesional") && !tipoUsuario.equals("Administrativo")) {
            throw new IllegalArgumentException("El tipo de usuario no es válido.");
        }
        this.tipoUsuario = tipoUsuario;
    }
    
	// Método para guardar una instancia de Usuario en la lista
	public void guardarUsuario(List<Usuario> listaUsuarios) {
		listaUsuarios.add(this);
	}

	// Método estático para obtener la lista de usuarios
	public static List<Usuario> obtenerListaUsuarios() {
		return listaUsuarios;
	}
    
    /**
     * Devuelve una representación en forma de cadena de la instancia de Usuario.
     *
     * @return Representación en forma de cadena de la instancia de Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", rut=" + rut +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                '}';
    }
}
