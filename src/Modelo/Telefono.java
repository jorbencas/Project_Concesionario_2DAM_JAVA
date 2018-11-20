package Modelo;

public class Telefono {
	private String telefono1 = "";
        private String telefono2 = "";
	private String fijo = "";
	
	public Telefono(String telefono1,String  telefono2, String fijo) {
		super();
		this.telefono1 = telefono1;
                this.telefono2 = telefono2;
		this.fijo = fijo;
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
	
	@Override
	public String toString() {
		return "Telefono [telefono1=" + telefono1 + "telefono2=" + telefono2 + ", fijo=" + fijo + "]";
	}
	
	
}
