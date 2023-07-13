package sprintmodulo5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Administrativo extends Usuario {
	
	private String area; // Área del administrativo
	private String experienciaPrevia; // Experiencia previa del administrativo
	
	// Lista para almacenar los administrativos
	private static List<Administrativo> listaAdministrativos = new ArrayList<>();
	
	/**
	 * Constructor vacío de la clase Administrativo.
	 */
	public Administrativo() {
		super();
	}
	
	/**
	 * Constructor de la clase Administrativo que recibe todos los atributos.
	 *
	 * @param nombre            Nombre del administrativo.
	 * @param fechaNacimiento   Fecha de nacimiento del administrativo.
	 * @param run               RUN del administrativo.
	 * @param tipoUsuario       Tipo de usuario (Cliente, Profesional, Administrativo).
	 * @param area              Área del administrativo.
	 * @param experienciaPrevia Experiencia previa del administrativo.
	 */
	public Administrativo(String nombre, String fechaNacimiento, int run, String tipoUsuario,
			String area, String experienciaPrevia) {
		super(nombre, fechaNacimiento, run, tipoUsuario);
		this.area = area;
		this.experienciaPrevia = experienciaPrevia;
	}
	
	/**
	 * Obtiene el área del administrativo.
	 *
	 * @return Área del administrativo.
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Establece el área del administrativo.
	 *
	 * @param area Área del administrativo.
	 * @throws IllegalArgumentException Si el área no cumple con los requisitos.
	 */
	public void setArea(String area) {
		if (area != null && !area.isEmpty() && area.length() >= 5 && area.length() <= 20) {
			this.area = area;
		} else {
			throw new IllegalArgumentException("Debe completar con un mínimo de 5 y un máximo de 20 caracteres.");
		}
	}

	/**
	 * Obtiene la experiencia previa del administrativo.
	 *
	 * @return Experiencia previa del administrativo.
	 */
	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	/**
	 * Establece la experiencia previa del administrativo.
	 *
	 * @param experienciaPrevia Experiencia previa del administrativo.
	 * @throws IllegalArgumentException Si la experiencia previa excede el límite de caracteres.
	 */
	public void setExperienciaPrevia(String experienciaPrevia) {
		if (experienciaPrevia != null && experienciaPrevia.length() <= 100) {
			this.experienciaPrevia = experienciaPrevia;
		} else {
			throw new IllegalArgumentException("Solo se puede escribir un máximo de 100 caracteres.");
		}
	}
	
	/**
	 * Agrega un administrativo a la lista de administrativos.
	 *
	 * @param administrativo Administrativo a agregar.
	 */
	public void guardarAdministrativo(List<Administrativo> listaAdministrativos) {
		listaAdministrativos.add(this);
	}
	
	/**
	 * Obtiene la lista de administrativos.
	 *
	 * @return Lista de administrativos.
	 */
	public static List<Administrativo> obtenerListaAdministrativos() {
		return listaAdministrativos;
	}
	
	/**
	 * Obtiene un administrativo de la lista por su RUN.
	 *
	 * @param run RUN del administrativo a buscar.
	 * @return Administrativo correspondiente al RUN especificado, o null si no se encuentra.
	 */
	public static Administrativo obtenerAdministrativoPorRut(int run) {
		for (Administrativo administrativo : listaAdministrativos) {
			if (administrativo.getRun() == run) {
				return administrativo;
			}
		}
		return null; // Retornar null si no se encuentra el administrativo con el RUN especificado
	}
	
	/**
	 * Devuelve una representación en forma de cadena de la instancia de Administrativo.
	 *
	 * @return Representación en forma de cadena de la instancia de Administrativo.
	 */
	@Override
	public String toString() {
		return "Administrativo{" +
				"area='" + area + '\'' +
				", experienciaPrevia='" + experienciaPrevia + '\'' +
				", nombre='" + getNombre() + '\'' +
				", fechaNacimiento='" + getFechaNacimiento() + '\'' +
				", run=" + getRun() +
				", tipoUsuario='" + getTipoUsuario() + '\'' +
				'}';
	}
}
