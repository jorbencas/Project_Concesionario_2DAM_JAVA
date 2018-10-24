package Modelo;

public class Vehiculo {
	private String tipo = "";
	private String matricula = "";
	private int kilometros = 0;
	private int precio = 0;
	private int any = 0;
	private String marca = "";
	private int modelo = 0;
	private int empleado = 0;
	
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(String tipo, String matricula, int kilometros, int precio, int any, String marca, int modelo,
			int empleado) {
		this.tipo = tipo;
		this.matricula = matricula;
		this.kilometros = kilometros;
		this.precio = precio;
		this.any = any;
		this.marca = marca;
		this.modelo = modelo;
		this.empleado = empleado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getAny() {
		return any;
	}

	public void setAny(int any) {
		this.any = any;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getEmpleado() {
		return empleado;
	}

	public void setEmpleado(int empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return " \n Vehiculo [tipo=" + tipo + ", matricula=" + matricula + ", kilometros=" + kilometros + ", precio="
				+ precio + ", any=" + any + ", marca=" + marca + ", modelo=" + modelo + ", empleado=" + empleado + "]";
	}
	
	
	
}
