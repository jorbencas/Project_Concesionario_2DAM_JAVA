package ejemplo03.dominio;

import com.fpmislata.persistencia.dao.Caption;
import java.io.Serializable;
import javax.persistence.Column;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Vehiculo implements Serializable {

   private String tipo = "";
	private String matricula = "";
	private int kilometros = 0;
	private int precio = 0;
	private int anyo = 0;
	private String marca = "";
	private String modelo = "";
	private Empleado empleado;
	
	
	public Vehiculo() {
		// TODO Auto-generated constructor stub
	}

	public Vehiculo(String tipo, String matricula, int kilometros, int precio, int anyo, String marca, String modelo,
			Empleado empleado) {
		this.tipo = tipo;
		this.matricula = matricula;
		this.kilometros = kilometros;
		this.precio = precio;
		this.anyo = anyo;
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

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String string) {
		this.modelo = string;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return " \n Vehiculo [tipo=" + tipo + ", matricula=" + matricula + ", kilometros=" + kilometros + ", precio="
				+ precio + ", anyo=" + anyo + ", marca=" + marca + ", modelo=" + modelo + ", empleado=" + empleado + "]";
	}
	
	

}
