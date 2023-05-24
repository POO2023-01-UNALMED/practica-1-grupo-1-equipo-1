package gestorAplicaciones.entidades;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.producto.Factura;
import uiMain.Main;

import java.util.ArrayList;

/**
 * La clase Administrador es una subclase de la clase Empleado y representa al administrador
 * del sistema.
 *
 *@author Julian Salazar, Michael Garcia
 */

public class Administrador extends Empleado{
	Camion camion;

	//constructor
	public Administrador() {
		super("Administrador","Clave",0,"Administrador@egt.com");
	}
	
	//metodos

	/**
	 *
	 * @param pais pais del que se mostaran los empleados
	 * @return String con la información de todos los objetos de tipo Empleado que se encuentran
	 * en el país con el no,bre pasado como argumento.
	 */
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

	/**
	 *
	 * @return String con la información de todos los objetos de tipo Usuario.
	 */
	public String mostarUsuarios() {
		//mostar dotos los objetos de tipo Usuario
		StringBuilder infoUsuarios = new StringBuilder();
		for(Usuario usuario : Usuario.getUsuarios()){
			infoUsuarios.append(usuario.toString());
		}
		return infoUsuarios.toString();
	}

	/**
	 *
	 * @param pais  pais del que se mostaran los camiones
	 * @param tipoCamion tipo de camion que se mostara
	 * @return String con la información de los objetos que heredan de la clase Camion,
	 * filtrados por país y tipo de camión.
	 */
	public String mostarCamiones(String pais, String tipoCamion){
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

	/**
	 *
	 * @param pais pais del que se mostaran las facturas
	 * @return String con la información de todas las facturas en el país especificado.
	 */
	public String mostrarFacturas(String pais) {

		StringBuilder infoFacturas = new StringBuilder();
		for(Factura factura : Factura.getFacturas()){
			Main.actualizarInformacion(factura);
			if(factura.getPedido().getPais().getNombre().equals(pais)){
				infoFacturas.append(factura);
			}
		}
		return infoFacturas.toString();
	}

	/**
	 *
	 * @param nombre nombre empleado
	 * @param clave clave empleado
	 * @param id id empleado
	 * @param correo correo empleado
	 * @param pais pais donde opera el empleado
	 * @param CiudadActual ciudad actual donde se encuenra el empleado
	 *
	 * Crea una nueva instancia de la clase Empleado con los datos pados como argumentos
	 */
	public void registrarEmpleado(String nombre, String clave, String id, String correo, String pais,String CiudadActual) {

		Empleado.crearEmpleado(nombre, clave, Long.parseLong(id), correo, pais, CiudadActual);
	}

	/**
	 *
	 * @param opcion de que tipo sera el camion
	 * @param placa placa del camion
	 * @param pais pais de operacion del camion
	 * @param ciudadActual ciudad donde se encuentra el camion
	 * @param pesoMaximo peso maxiomo del camion ton
	 * @param capacidad capacidad maxima del camion m3
	 * Crea una nueva instancia de la clase Camion según la opción especificada y los datos pasados
	 * como argumentos.
	 */
	public void registarCamion(int opcion, String placa, String pais, String ciudadActual, double pesoMaximo, double capacidad) {
		//nueva instancia de Camion
		switch (opcion) {
				case 1 -> camion = new CamionCisterna(placa, pais,ciudadActual, pesoMaximo, capacidad);
				case 2 -> camion = new CamionFrigorifico(placa, pais, ciudadActual, pesoMaximo, capacidad);
				case 3 -> camion = new CamionLona(placa, pais, ciudadActual, pesoMaximo, capacidad);
				case 4 -> camion = new CamionPortaCoches(placa, pais, ciudadActual, pesoMaximo, capacidad);
				default -> System.out.println("Opcion no valida");
			}
	}

	/**
	 * Actualiza la información de cada factura llamando al método actualizarInformacion()
	 * de la clase Main para cada objeto Factura
	 */
	public void actualizarFacturas(){

		for(Factura factura : Factura.getFacturas()){
			Main.actualizarInformacion(factura);
		}
	}
}