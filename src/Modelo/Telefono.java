package Modelo;

public class Telefono {
	private String telefono = "";
	private String fijo = "";
	
	public Telefono(String telefono, String fijo) {
		super();
		this.telefono = telefono;
		this.fijo = fijo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getFijo() {
		return fijo;
	}
	
	public void setFijo(String fijo) {
		this.fijo = fijo;
	}
	
	@Override
	public String toString() {
		return "Telefono [telefono=" + telefono + ", fijo=" + fijo + "]";
	}
	
	
}
