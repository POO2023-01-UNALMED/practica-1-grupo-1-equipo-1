package gestorAplicaciones.entidades;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.pais.Pais;
import gestorAplicaciones.producto.Factura;

import java.util.ArrayList;

public class Administrador extends Empleado{

	Pais pais;
	Camion camion;

	//constructor
	public Administrador() {
		super("Administrador","Clave",0,"Administrador@egt.com");
	}
	
	//metodos
	public String mostrarEmpleados(String pais) {
		//mostar dotos los objetos de tipo Empleado
		StringBuilder infoEmpleados = new StringBuilder();
		for (Empleado empleado : Empleado.getEmpleados()) {
			if(empleado.getPais().equals(pais)) {
				infoEmpleados.append(empleado);
			}
		}
		return infoEmpleados.toString();
	}

	public String mostarUsuarios() {
		//mostar dotos los objetos de tipo Usuario
		StringBuilder infoUsuarios = new StringBuilder();
		for(Usuario usuario : Usuario.getUsuarios()){
			infoUsuarios.append(usuario.toString());
		}
		return infoUsuarios.toString();
	}

	public String mostarCamiones(String pais, String tipoCamion){
		//mostar informacion de los objetos que heredan de la clase Camion
		StringBuilder infoCamiones = new StringBuilder();
		ArrayList<? extends Camion> camiones;

		camiones = Camion.camiones.get(tipoCamion);
		for(Camion camion : camiones){
			if(camion.getPais().equals(pais)){
				infoCamiones.append(camion);
			}
		}
		return infoCamiones.toString();
	}

	public String mostrarFacturas(String pais) {
		//Retorna un String con las facturas en el pais pasado como argumento
		StringBuilder infoFacturas = new StringBuilder();
		for(Factura factura : Factura.getFacturas()){
			if(factura.getPedido().getPais().getNombre().equals(pais)){
				infoFacturas.append(factura);
			}
		}
		return infoFacturas.toString();
	}

	public void registrarEmpleado(String nombre, String clave, String id, String correo, String pais,String CiudadActual) {

		Empleado.crearEmpleado(nombre, clave, Long.parseLong(id), correo, pais, CiudadActual);
	}

	public void registarCamion(int opcion, String placa, String pais, String ciudadActual, double pesoMaximo, double capacidad) {

		switch (opcion) {
				case 1 -> camion = new CamionCisterna(placa, pais,ciudadActual, pesoMaximo, capacidad);
				case 2 -> camion = new CamionFrigorifico(placa, pais, ciudadActual, pesoMaximo, capacidad);
				case 3 -> camion = new CamionLona(placa, pais, ciudadActual, pesoMaximo, capacidad);
				case 4 -> camion = new CamionPortaCoches(placa, pais, ciudadActual, pesoMaximo, capacidad);
				default -> System.out.println("Opcion no valida");
			}
	}
}