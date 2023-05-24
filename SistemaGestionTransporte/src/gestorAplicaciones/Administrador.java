package gestorAplicaciones;

public class Administrador {
	
	//atributos
	private String nombre;
	private String clave;
	private int documento;
	private static String tipoUsuario = "Administrador";
	private int cantidadVehiculos;
		
	//constructor
	public Administrador(String nombre, String clave, int id, int vehiculos) {
		this.nombre = nombre;
		this.clave = clave;
		documento = id;
		cantidadVehiculos = vehiculos;
	}
	
	//metodos get y set
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String Nombre) {
		nombre = Nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String Clave) {
		clave = Clave;
	}
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int id) {
		documento = id;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public int getCantidadVehiculos() {
		return cantidadVehiculos;
	}
	public void setCantidadVehiculos(int cantidad) {
		cantidadVehiculos =cantidad;
	}
	
	//metodos
	public boolean comprobarDocumento(int documento) {
		
	}
	public boolean comprobarNombre(String nombre) {
		
	}
	public boolean comprobarClave(String clave) {
		
	}
	public void estadistica() {
		
	}
	public void modificarCosto() {
		
	}
	public void pagarNomina() {
		
	}

}