package gestorAplicaciones.entidades;

import java.util.ArrayList;

/**
 * clase Empleado es una subclase de la clase Usuario y representa a un empleado.
 * Atributos:
 * empleados: Static ArrayList que almacena todos los empleados creados.
 * estatusActivo: boolean que indica si el empleado está activo o no.
 * disponible: boolean que indica si el empleado está disponible para trabajar o no.
 * pais: almacena el país donde se encuentra el empleado.
 * ciudadActual: almacena la ciudad actual donde se encuentra el empleado.
 *
 * @author Julian Salazar, Michael Garcia
 */
public class Empleado extends Usuario{
	
	//atributos
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();

	private boolean estatusActivo;
	private boolean disponible;
	private String pais;
	private String ciudadActual;
	
	//constructor
	public Empleado (String nombre, String clave, long id, String correo) {
		super(nombre, clave, id, correo);
	}

	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo, String pais, String ciudadActual){
		this(nombre, clave, id, correo);
		this.estatusActivo = statusActivo;
		this.pais = pais;
		this.ciudadActual = ciudadActual;
		this.disponible = true;
		Empleado.empleados.add(this);
	}
	
	//metodos getter and setter
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public static void setEmpleados(ArrayList<Empleado> empleados){
		Empleado.empleados = empleados;
	}


	public boolean isEstatusActivo() {
		return estatusActivo;
	}

	public void setEstatusActivo(boolean estatusActivo) {
		this.estatusActivo = estatusActivo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudadActual() {
		return ciudadActual;
	}

	public void setCiudadActual(String ciudadActual) {
		this.ciudadActual = ciudadActual;
	}

	//metodos

	/**
	 * Verifica si el empleado está disponible, activo y se encuentra en la misma ciudad que la pasada
	 * como argumento.
	 * @param ciudadActual ciudad de donde se realiza el envio
	 * @return true si se cumplen todas las condiciones, de lo contrario, retorna false
	 */
	public boolean elegirConductor(String ciudadActual){
		return this.ciudadActual.equals(ciudadActual) && this.estatusActivo && this.disponible;
	}

	/**
	 * usca y selecciona un empleado disponible que se encuentre en la misma ciudad que la
	 * pasadqa como argumento.
	 * @param origen ciudad de donde se realiza el pedido
	 * @return el empleado seleccionado si se encuentra alguno, de lo contrario, retorna null
	 */
	public static Empleado seleccionarEmpleado(String origen) {

		for(Empleado empleado : Empleado.getEmpleados()){
			if(empleado.elegirConductor(origen)) return empleado;
		}
		return null;
	}

	public String toString(){

		return "\nnombre:\t" + this.getNombre()
				+ "\nid:\t" + this.getID()
				+ "\ncorreo:\t" + this.getCorreo()
				+ "\nPais:" + this.getPais()
				+ "\nCiudad Actual:\t" + this.ciudadActual
				+ "\nActivo:\t" + this.estatusActivo
				+ "\nDisponible:\t" + this.disponible
				+ "\nPais\t" + this.pais
				+ "\n";
	}

	/**
	 *
	 * @param costoPedido costo del camion
	 * @return Calcula y retorna al costop del camion el costo del empleado.
	 */
	public double calcularPago(double costoPedido) {
		return costoPedido + costoPedido*0.2;
	}

	/**
	 *
	 * @param nombre nombre empleado
	 * @param clave clave empleado
	 * @param id id empleado
	 * @param correo correo empleado
	 * @param pais pais donde opera el empleado
	 * @param ciudadActual ciudad actual donde se encuenra el empleado
	 *
	 * crea un objeto Empleado con los datos proporcionados como argumentos.
	 */
	public static void crearEmpleado(String nombre, String clave, long id, String correo, String pais, String ciudadActual) {

		new Empleado(nombre, clave, id, correo, true, pais,ciudadActual);
	}

	/**
	 *
	 * @param nombre nombre3 nuevo empleado
	 * @return false si el nombre contiene espacios o caracteres no alfabéticos, o si ya existe un
	 * empleado con ese nombre. Retorna true en caso contrario.
	 */
	public static boolean isNombreValido(String nombre){

		if(nombre == null || !nombre.chars().allMatch(c -> c == ' ' || Character.isLetter(c))){
			System.out.println("El nombre solo debe tener caracteres alfanumericos.");
			return false;
		}
		for(Empleado empleado : Empleado.empleados) {
			if (empleado.comprobarNombre(nombre)) {
				System.out.println("nombre ya registrado.");
				return false;
			}
		}
		return true;

	}

	/**
	 *
	 * @param id id nuievo empleaqdo
	 * @return false si el ID contiene caracteres no numéricos o si ya existe un empleado con ese ID.
	 * Retorna true en caso contrario.
	 */
	public static boolean isIDValido(String id){

		if(id == null || !id.chars().allMatch(Character::isDigit)){
			System.out.println("la identificacion debe contener solo caracteres numericos.");
			return false;
		}
		for(Empleado empleado : Empleado.empleados) {
			if (empleado.comprobarID(Long.parseLong(id))) {
				System.out.println("numero de identificacion ya registrado.");
				return false;
			}
		}
		return true;
	}

	/**
	 *
	 * @param correo correo nuevo empleado
	 * @return false si el correo no contiene el carácter '@' o si está ubicado al final del correo,
	 * o si ya existe un empleado con ese correo. Retorna true en caso contrario.
	 */
	public static boolean isCorreoValido(String correo){

		if(!correo.contains("@") || correo.charAt(correo.length()-1) == '@'){
			System.out.println("correo no valido.");
			return false;
		}
		for(Empleado empleado : Empleado.empleados) {
			if (empleado.comprobarCorreo(correo)) {
				System.out.println("correo ya registrado.");
				return false;
			}
		}
		return true;
	}
}
