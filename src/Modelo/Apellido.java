package Modelo;

public class Apellido {
	private String primero = "";
	private String segundo = "";
	public Apellido(String primero, String segundo) {
		super();
		this.primero = primero;
		this.segundo = segundo;
	}
	public String getPrimero() {
		return primero;
	}
	public void setPrimero(String primero) {
		this.primero = primero;
	}
	public String getSegundo() {
		return segundo;
	}
	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}
	@Override
	public String toString() {
		return "Apellido [primero=" + primero + ", segundo=" + segundo + "]";
	}
	
	
}
