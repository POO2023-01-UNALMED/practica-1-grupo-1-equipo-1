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
	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo) {
		super(nombre, clave, id, correo);
		this.estatusActivo = statusActivo;
		Empleado.empleados.add(this);
	}

	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo, String pais){
		this(nombre, clave, id, correo, statusActivo);
		this.pais = pais;
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
		return "nombre\t" + this.getNombre()
				+ "\nid\t" + this.getID()
				+ "\ncorreo\t" + this.getCorreo()
				+ "Activo\t" + this.estatusActivo
				+ "Pais\t" + this.pais
				+ "\n";
	}

	public double calcularPago(double costoPedido) {
		return costoPedido;
	}

	public static Empleado crearEmpleado(String nombre, String clave, long id, String correo, String pais) {
		return new Empleado(nombre, clave, id, correo, true, pais);
	}

}
