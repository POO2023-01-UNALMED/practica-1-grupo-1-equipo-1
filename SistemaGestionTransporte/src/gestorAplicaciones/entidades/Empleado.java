package gestorAplicaciones.entidades;

import java.util.ArrayList;

public class Empleado extends Usuario {
	
	//atributos
	private final static ArrayList<Empleado> empleados = new ArrayList<Empleado>();

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
		Empleado.empleados.add(this);
	}
	
	//metodos getter and setter
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
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

	public boolean elegirConductor(String ciudadActual){
		return this.ciudadActual.equals(ciudadActual) && this.estatusActivo && this.disponible;
	}

	public static Empleado seleccionarEmpleado(String origen) {
		//buscar un empleado disponible y que se encuentre en la ciudad de origen
		for(Empleado empleado : Empleado.getEmpleados()){
			if(empleado.elegirConductor(origen)) return empleado;
		}
		return null;
	}

	public String toString(){
		//sobreescritura del metodo toString para mostar los atributos del objeto.
		return "\nnombre\t" + this.getNombre()
				+ "\nid\t" + this.getID()
				+ "\ncorreo\t" + this.getCorreo()
				+ "\nActivo\t" + this.estatusActivo
				+ "\nPais\t" + this.pais
				+ "\n";
	}

	public double calcularPago(double costoPedido) {
		return costoPedido;
	}

	public static void crearEmpleado(String nombre, String clave, long id, String correo, String pais, String ciudadActual) {
		new Empleado(nombre, clave, id, correo, true, pais,ciudadActual);
	}

	public static boolean isNombreValido(String nombre){
        /*
        Esta funcion retorna false si el argumento que se ingresa no contione espacio y caracteres
        alfabetiscos o si ya es un atributo de nombre de un objeto de tipo usuario,
        de lo contrario retorna true.
         */
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

	public static boolean isIDValido(String id){
        /*
        Esta funcion retorna false si el argumento que se ingresa no contione solo caracteres
        numericos o si ya es un atributo de ID de un objeto de tipo usuario,
        de lo contrario retorna true.
         */
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

	public static boolean isCorreoValido(String correo){
        /*
        Esta funcion retorna false si el argumento que se ingresa contiene el caracter '@' o si
        solo contiene en la ultima posicion, de lo contrario retorna true.
         */
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
