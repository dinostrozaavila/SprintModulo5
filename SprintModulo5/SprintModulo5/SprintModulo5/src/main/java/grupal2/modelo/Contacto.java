package grupal2.modelo;

public class Contacto {
	private String nombreUsuario; // Nombre del usuario
	private String correoElectronico; // Correo electrónico del usuario
	private String mensaje; // Mensaje del usuario

	/**
	 * Constructor vacío de la clase Contacto.
	 */
	public Contacto() {
		// Constructor vacío
	}

	/**
	 * Constructor de la clase Contacto con los parámetros.
	 *
	 * @param nombreUsuario     Nombre del usuario
	 * @param correoElectronico Correo electrónico del usuario
	 * @param mensaje           Mensaje del usuario
	 */
	public Contacto(String nombreUsuario, String correoElectronico, String mensaje) {
		this.nombreUsuario = nombreUsuario;
		this.correoElectronico = correoElectronico;
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene el nombre del usuario.
	 *
	 * @return Nombre del usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el nombre del usuario.
	 *
	 * @param nombreUsuario Nombre del usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
		if (nombreUsuario != null && !nombreUsuario.isEmpty() && nombreUsuario.length() >= 5
				&& nombreUsuario.length() <= 30) {
			this.nombreUsuario = nombreUsuario;
		} else {
			throw new IllegalArgumentException("El nombre de usuario debe tener entre 5 y 30 caracteres");
		}
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 *
	 * @return Correo electrónico del usuario
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 *
	 * @param correoElectronico Correo electrónico del usuario
	 */
	public void setCorreoElectronico(String correoElectronico) {
		if (correoElectronico == null || !correoElectronico.contains("@")) {
			throw new IllegalArgumentException("El correo electrónico no puede ser nulo y debe incluir el símbolo @.");
		}
		this.correoElectronico = correoElectronico;
	}

	/**
	 * Obtiene el mensaje del usuario.
	 *
	 * @return Mensaje del usuario
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece el mensaje del usuario.
	 *
	 * @param mensaje Mensaje del usuario
	 */
	public void setMensaje(String mensaje) {
		if (mensaje == null) {
			throw new IllegalArgumentException("El mensaje no puede ser nulo.");
		}

		if (mensaje.length() > 100) {
			throw new IllegalArgumentException("El mensaje no puede tener más de 100 caracteres.");
		}

		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Contacto [nombreUsuario=" + nombreUsuario + ", correoElectronico=" + correoElectronico + ", mensaje="
				+ mensaje + "]";
	}
}
