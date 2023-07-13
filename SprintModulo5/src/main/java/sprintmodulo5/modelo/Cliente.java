package sprintmodulo5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private String telefono;
    private String afp;
    private int sistemaSalud;
    private String direccion;
    private String comuna;
    private int edad;
    private int rutCliente;
    private String nombres;
    private String apellidos;

    private static List<Cliente> listaClientes = new ArrayList<>();

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String fechaNacimiento, int run, String tipoUsuario,
                   int rutCliente, String nombres, String apellidos,
                   String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run, tipoUsuario);
        this.rutCliente = rutCliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public String obtenerSistemaSalud() {
        if (sistemaSalud == 1) {
            return "Fonasa";
        } else if (sistemaSalud == 2) {
            return "Isapre";
        } else {
            return "Desconocido";
        }
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

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        if (rutCliente > 0 && rutCliente < 99999999) {
            this.rutCliente = rutCliente;
        } else {
            throw new IllegalArgumentException("El RUT del cliente debe ser un entero mayor a 0 y menor a 99999999");
        }
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        if (nombres != null && !nombres.isEmpty() && nombres.length() >= 5 && nombres.length() <= 30) {
            this.nombres = nombres;
        } else {
            throw new IllegalArgumentException("Los nombres deben tener entre 5 y 30 caracteres");
        }
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        if (apellidos != null && !apellidos.isEmpty() && apellidos.length() >= 5 && apellidos.length() <= 30) {
            this.apellidos = apellidos;
        } else {
            throw new IllegalArgumentException("Los apellidos deben tener entre 5 y 30 caracteres");
        }
    }

    public void guardarCliente(List<Cliente> listaClientes) {
        listaClientes.add(this);
    }

    public static List<Cliente> obtenerListaClientes() {
        return listaClientes;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "nombre='" + getNombre() + '\'' +
                ", fechaNacimiento='" + getFechaNacimiento() + '\'' +
                ", run=" + getRun() +
                ", tipoUsuario='" + getTipoUsuario() + '\'' +
                ", telefono='" + telefono + '\'' +
                ", afp='" + afp + '\'' +
                ", sistemaSalud=" + sistemaSalud +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", edad=" + edad +
                ", rutCliente=" + rutCliente +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}