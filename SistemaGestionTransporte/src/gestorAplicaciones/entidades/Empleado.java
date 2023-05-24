package gestorAplicaciones.entidades;

import java.util.ArrayList;

public class Empleado extends Usuario {
	
	//atributos
	private final static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	//private Vehiculo vehiculo;
	//private String nombre;
	//private String clave;
	//private int documento;
	//private static String tipoUsuario = "Empleado";
	//private String carga;
	//private String tipoContrato;
	private boolean estatusActivo;
	private String pais;
	
	//constructor
	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo) {
		super(nombre, clave, id, correo);
		this.estatusActivo = statusActivo;
		Empleado.empleados.add(this);
	}

	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo, String pais){
		this(nombre, clave, id, correo, statusActivo);
		this.pais = pais;
		//Empleado.empleados.add(this);

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

	//metodos
	public static boolean comprobarMombre(String nombre){
		/*
		este metodo de  clase retorna true si el String pasado como argumento coincide con el
		atributo nombre de un objeto de la clase Empleado lo contrario retorna false.
		 */
		for (Empleado empleado : Empleado.empleados){
			if (empleado.getNombre().equals(nombre)) return true;
		}
		return false;
	}
	public static boolean comprobarID(long id){
		/*
		este metodo de  clase retorna true si el numero pasado como argumento coincide con el
		atributo ID de un objeto de la clase Empleado lo contrario retorna false.
		 */
		for (Empleado empleado: Empleado.empleados){
			if (empleado.getID() == id) return true;
		}
		return false;
	}

	public String toString(){
		//sobreescritura del metodo toString para mostar los atributos del objeto.
		return "nombre\t" + this.getNombre()
				+ "\nid\t" + this.getID()
				+ "\ncorreo\t" + this.getCorreo()
				+ "Activo\t" + this.estatusActivo
				+ "Pais\t" + this.pais
				+ "\n";
	}
	/*public boolean clausula() {
		
	}*/
	
}
