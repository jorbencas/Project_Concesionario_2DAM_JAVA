package ejemplo03.dominio;

import com.fpmislata.persistencia.dao.Caption;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.validator.constraints.NotBlank;


public class Empleado implements Serializable  {

    private String tipo = "";
	private int id = 0;
	private String nombre = "";
	private String primero = "";
	private String segundo = "";
	private String dni = "";
	private String dni_letra ="";
	private String telefono1 = "";
        private String telefono2 = "";
	private String fijo = "";
	private String tarjeta = "";
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>(0);
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

    
	public Empleado(String tipo, int id, String nombre, String dni, String dni_letra, String tarjeta) {
		this.tipo = tipo;
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.dni_letra = dni_letra;
		this.tarjeta = tarjeta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primero;
	}
	public void setPrimerApellido(String primero) {
		this.primero = primero;
	}
	public String getSegundoApellido() {
		return segundo;
	}
	public void setSegundoApellido(String segundo) {
		this.segundo = segundo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDni_letra() {
		return dni_letra;
	}
	public void setDni_letra(String dni_letra) {
		this.dni_letra = dni_letra;
	}
	public String getTelefono1() {
		return telefono1;
	}
	
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
        
        public String getTelefono2() {
		return telefono2;
	}
	
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
        
	
	public String getFijo() {
		return fijo;
	}
	
	public void setFijo(String fijo) {
		this.fijo = fijo;
	}
	
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
        
        
	@Override
	public String toString() {
		return "\n Empleado [tipo=" + tipo + ", id=" + id + ", nombre=" + nombre + ", dni="
				+ dni + ", dni_letra=" + dni_letra +  ", tarjeta=" + tarjeta + "]";
	}
    
}
