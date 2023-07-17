package sprintmodulo5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

	private int idCliente;
	private String telefono;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private int edad;

	private static List<Cliente> listaClientes = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(int rut, String nombre, String fechaNacimiento, String tipoUsuario, String telefono, String afp,
			int sistemaSalud, String direccion, String comuna, int edad) {
		super(nombre, fechaNacimiento, rut, tipoUsuario);
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;

	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono != null && !telefono.isEmpty()) {
			this.telefono = telefono;
		} else {
			throw new IllegalArgumentException("El teléfono es obligatorio");
		}
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		if (afp != null && !afp.isEmpty() && afp.length() >= 4 && afp.length() <= 30) {
			this.afp = afp;
		} else {
			throw new IllegalArgumentException("La AFP es obligatoria y debe tener entre 4 y 30 caracteres");
		}
	}

	public int getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(int sistemaSalud) {
		if (sistemaSalud == 1 || sistemaSalud == 2) {
			this.sistemaSalud = sistemaSalud;
		} else {
			throw new IllegalArgumentException("El sistema de salud debe ser 1 (Fonasa) o 2 (Isapre)");
		}
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		if (direccion != null && !direccion.isEmpty() && direccion.length() <= 70) {
			this.direccion = direccion;
		} else {
			throw new IllegalArgumentException("La dirección es obligatoria y debe tener un máximo de 70 caracteres");
		}
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		if (comuna != null && !comuna.isEmpty() && comuna.length() <= 50) {
			this.comuna = comuna;
		} else {
			throw new IllegalArgumentException("La comuna es obligatoria y debe tener un máximo de 50 caracteres");
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad >= 0 && edad < 150) {
			this.edad = edad;
		} else {
			throw new IllegalArgumentException("La edad debe ser un número entero mayor o igual a 0 y menor a 150");
		}
	}

	public void guardarCliente(List<Cliente> listaClientes) {
		listaClientes.add(this);
	}

	public static List<Cliente> obtenerListaClientes() {
		return listaClientes;
	}

	public static Cliente obtenerClientePorRut(int rut) {
		List<Cliente> listaClientes = obtenerListaClientes();

		for (Cliente cliente : listaClientes) {
			if (cliente.getRut() == rut) {
				return cliente;
			}
		}

		return null; // Retornar null si no se encuentra el cliente con el rut especificado
	}

	@Override
	public String toString() {
		return "Cliente {" + "nombre='" + getNombre() + '\'' + ", fechaNacimiento='" + getFechaNacimiento() + '\''
				+ ", rut=" + getRut() + ", tipoUsuario='" + getTipoUsuario() + '\'' + ", telefono='" + telefono + '\''
				+ ", afp='" + afp + '\'' + ", sistemaSalud=" + sistemaSalud + ", direccion='" + direccion + '\''
				+ ", comuna='" + comuna + '\'' + ", edad=" + edad + '}';
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String obtenerSistemaSalud() {
		if (sistemaSalud == 1) {
			return "Fonasa";
		} else if (sistemaSalud == 2) {
			return "Isapre";
		} else {
			throw new IllegalStateException("El valor del sistema de salud no es válido");
		}
	}

}
