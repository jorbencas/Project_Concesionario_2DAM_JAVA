package Modelo;

public class Empleado {
	private String tipo = "";
	private int id = 0;
	private String nombre = "";
	private Apellido apellido = null;
	private String dni = "";
	private char dni_letra = ' ';
	private Telefono telefono = null;
	private String tarjeta = "";
	
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	public Empleado(String tipo, int id, String nombre, String dni, char dni_letra, String tarjeta) {
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
	public Apellido getApellido() {
		return apellido;
	}
	public void setApellido(Apellido apellido) {
		this.apellido = new Apellido(apellido.getPrimero(), apellido.getSegundo());
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public char getDni_letra() {
		return dni_letra;
	}
	public void setDni_letra(char dni_letra) {
		this.dni_letra = dni_letra;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = new Telefono(telefono.getTelefono(),telefono.getFijo());
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	@Override
	public String toString() {
		return "Empleado [tipo=" + tipo + ", id=" + id + ", nombre=" + nombre + ", apellido=" + apellido.toString() + ", dni="
				+ dni + ", dni_letra=" + dni_letra + ", telefono=" + telefono.toString() + ", tarjeta=" + tarjeta + "]";
	}
	
	
}
