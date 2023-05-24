package gestorAplicaciones.entidades;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.pais.Pais;
import uiMain.Main;

public class Administrador extends Empleado{

	Pais pais;
	Camion camion;

	//constructor
	public Administrador() {
		super("Administrador","Clave",0,"Administrador@egt.com",true);
	}
	
	//metodos
	public void estadistica() {
		
	}
	public void modificarCosto() {
		
	}
	public String MostrarEmpleados() {
		//mostar dotos los objetos de tipo Empleado
		StringBuilder infoEmpleados = new StringBuilder();
		for (Empleado empleado : Empleado.getEmpleados()) {
			infoEmpleados.append(empleado.toString());
		}
		return infoEmpleados.toString();
	}

	public Empleado mostarEmpleado(String nombre) {
		//retorna la instancia de Empleado que sea igual al atributo de tipo String pasado como argumento
		for (Empleado empleado : Empleado.getEmpleados()) {
			if (empleado.getNombre().equals(nombre)) {
				return empleado;
			}
		}
		return null;
	}

	public String mostarUsuarios() {
		//mostar dotos los objetos de tipo Usuario
		StringBuilder infoUsuarios = new StringBuilder();
		for(Empleado empleado : Empleado.getEmpleados()){
			infoUsuarios.append(empleado);
		}
		return infoUsuarios.toString();
	}

	public Usuario mostarUsuario(String nombre) {
		//retorna la instancia de Usuario que sea igual al atributo de tipo String pasado como argumento
		for (Usuario usuario : Usuario.getUsuarios()){
			if(usuario.getNombre().equals(nombre)){
				return usuario;
			}
		}
		return null;
	}

	public void registrarEmpleado(String nombre, String clave, String id, String correo, String pais) {

		Empleado.crearEmpleado(nombre, clave, Long.parseLong(id), correo,pais);
	}

	public void registarCamion(int opcion, String placa, String pais, double pesoMaximo, double capacidad) {

		switch (opcion) {
				case 1 -> camion = new CamionCisterna(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 2 -> camion = new CamionFrigorifico(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 3 -> camion = new CamionLona(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 4 -> camion = new CamionPortaCoches(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				default -> System.out.println("Opcion no valida");
			}
	}

}