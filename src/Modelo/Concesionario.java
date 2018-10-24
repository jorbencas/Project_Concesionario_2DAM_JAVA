package Modelo;

import java.util.ArrayList;

public class Concesionario {
	private String nom_conc = "";
	private String ciudad = "";
	private int telefono = 0;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	private ArrayList<Vehiculo> ventas = new ArrayList<Vehiculo>();
	
	
	public Concesionario() {
		// TODO Auto-generated constructor stub
	}

	public Concesionario(String nom_conc, String ciudad, int telefono, ArrayList<Empleado> empleados,
			ArrayList<Vehiculo> ventas) {
		super();
		this.nom_conc = nom_conc;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.empleados = empleados;
		this.ventas = ventas;
	}

	public String getNom_conc() {
		return nom_conc;
	}

	public void setNom_conc(String nom_conc) {
		this.nom_conc = nom_conc;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ArrayList<Empleado> empleados) {
		this.empleados.addAll(empleados);
	}

	public ArrayList<Vehiculo> getVentas() {
		return ventas;
	}

	public void setVentas(ArrayList<Vehiculo> ventas) {
		this.ventas.addAll(ventas);
	}

	@Override
	public String toString() {
		return "Concesionario [nom_conc=" + nom_conc + ", ciudad=" + ciudad + ", telefono=" + telefono + ", empleados="
				+ empleados.toString() + ventas.toString() + "]";
	}
	
	
}
