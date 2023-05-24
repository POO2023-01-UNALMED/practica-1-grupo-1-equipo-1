package gestorAplicaciones;

public class Empleado {
	
	//atributos
	private String nombre;
	private String clave;
	private int documento;
	private static String tipoUsuario = "Empleado";
	private String carga;
	private String tipoContrato;
	private boolean estatusActivo;
	
	//constructor
	public Empleado (String nombre, String clave, int id, String carga, String contrato, boolean estado) {
		this.nombre = nombre;
		this.clave = clave;
		documento = id;
		this.carga = carga;
		tipoContrato = contrato;
		estatusActivo = estado;
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
	public String getCarga() {
		return carga;
	}
	public void setCarga(String carga) {
		this.carga = carga;
	}
	public String getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(String contrato){
		tipoContrato = contrato;
	}
	public boolean isEstatusActivo() {
		return estatusActivo;
	}
	public void setEstatusActivo(boolean estado) {
		estatusActivo = estado;
	}
	
	//metodos
	public boolean clausula() {
		
	}
	
}
