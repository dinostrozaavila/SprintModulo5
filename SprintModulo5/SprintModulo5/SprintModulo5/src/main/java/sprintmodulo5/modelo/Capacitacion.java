package sprintmodulo5.modelo;

import java.time.LocalTime;

public class Capacitacion {
	private int identificador; // Identificador de la capacitación
	private int rutCliente; // RUT del cliente
	private String dia; // Día de la capacitación
	private LocalTime hora; // Hora de la capacitación
	private String lugar; // Lugar de la capacitación
	private String duracion; // Duración de la capacitación
	private int cantidad; // Cantidad de asistentes

	// Constructor vacío
	public Capacitacion() {
	}

	// Constructor con los parámetros de la clase
	public Capacitacion(int identificador, int rutCliente, String dia, LocalTime hora, String lugar, String duracion,
			int cantidad) {
		this.identificador = identificador;
		this.rutCliente = rutCliente;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.cantidad = cantidad;
	}

	// Getter y Setter para el identificador de la capacitación
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
		if (identificador <= 0) {
			throw new IllegalArgumentException("El identificador debe ser un número entero positivo.");
		}
	}

	// Getter y Setter para el RUT del cliente
	public int getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(int rutCliente) {
		this.rutCliente = rutCliente;
		if (rutCliente <= 0 || rutCliente >= 99999999) {
			throw new IllegalArgumentException("El RUT del cliente debe ser un entero menor a 99999999.");
		}
	}

	// Getter y Setter para el día de la capacitación
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		if (!isValidDia(dia)) {
			throw new IllegalArgumentException("Día inválido. Debe ser un día entre lunes y domingo.");
		}
		this.dia = dia;
	}

	/**
	 * Verifica si el día ingresado es válido.
	 *
	 * @param dia El día a verificar.
	 * @return true si el día es válido, false de lo contrario.
	 */
	public boolean isValidDia(String dia) {
		String[] diasValidos = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		for (String diaValido : diasValidos) {
			if (diaValido.equalsIgnoreCase(dia)) {
				return true;
			}
		}
		return false;
	}

	// Getter y Setter para la hora de la capacitación
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	// Getter y Setter para el lugar de la capacitación
	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		if (lugar == null || lugar.isEmpty() || lugar.length() < 10 || lugar.length() > 50) {
			throw new IllegalArgumentException("Lugar debe tener, mínimo 10 caracteres, máximo 50.");
		}
		this.lugar = lugar;
	}

	// Getter y Setter para la duración de la capacitación
	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		if (duracion == null || duracion.isEmpty() || duracion.length() > 70) {
			throw new IllegalArgumentException("Duración debe tener un máximo de 70 caracteres.");
		}
		this.duracion = duracion;
	}

	// Getter y Setter para la cantidad de asistentes
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		if (cantidad <= 0 || cantidad > 1000) {
			throw new IllegalArgumentException("Máximo 1000 asistentes.");
		}
		this.cantidad = cantidad;
	}

	// Método toString para representar la información de la capacitación como una cadena de texto
	@Override
	public String toString() {
		return "Capacitacion [identificador=" + identificador + ", rutCliente=" + rutCliente + ", dia=" + dia + ", hora="
				+ hora + ", lugar=" + lugar + ", duracion=" + duracion + ", cantidad=" + cantidad + "]";
	}
}

