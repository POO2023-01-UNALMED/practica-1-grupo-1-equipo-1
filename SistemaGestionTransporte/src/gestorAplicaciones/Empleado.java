package gestorAplicaciones;

import java.util.ArrayList;

public class Empleado extends Usuario {
	
	//atributos
	private static ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	//private Vehiculo vehiculo;
	//private String nombre;
	//private String clave;
	//private int documento;
	//private static String tipoUsuario = "Empleado";
	//private String carga;
	//private String tipoContrato;
	private boolean estatusActivo;
	
	//constructor
	public Empleado (String nombre, String clave, long id, String correo, boolean statusActivo) {
		super(nombre, clave, id, correo);
		this.estatusActivo = statusActivo;
		Empleado.empleados.add(this);
	}
	
	//metodos get y set
	public static ArrayList<Empleado> getEmpleados() {
		return empleados;
	}

	public static void setEmpleados(ArrayList<Empleado> empleados) {
		Empleado.empleados = empleados;
	}

	public boolean isEstatusActivo() {
		return estatusActivo;
	}

	public void setEstatusActivo(boolean estatusActivo) {
		this.estatusActivo = estatusActivo;
	}

	//metodos
	/*public boolean clausula() {
		
	}*/
	
}
