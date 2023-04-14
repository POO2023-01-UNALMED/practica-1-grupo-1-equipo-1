package gestorAplicaciones;

public class Usuario {
	
	//atributos
	private String nombre;
	private String clave;
	private int documento;
	private float saldo;
	private Pedido pedido;
	private String tipoUsuario;
	
	//constructores
	
	public Usuario (String nombreUsuario, String nuevaClave, int id) {
		nombre = nombreUsuario;
		clave = nuevaClave;
		documento = id;
		saldo = 0;
		pedido = null;
		tipoUsuario = "cliente";
	}
	public Usuario (String nombreUsuario, String nuevaClave, int id, float saldo, Pedido pedido, String usuario) {
		nombre = nombreUsuario;
		clave = nuevaClave;
		documento = id;
		this.saldo = saldo;
		this.pedido = pedido;
		tipoUsuario = usuario;
	}
	
	//metodod get y set
	
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
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setUsuario(String usuario) {
		tipoUsuario = usuario;
	}
	
	//metodos
	
	public void crearUsuario(String nombre, String clave, String usuario) {
		new Usuario(nombre, clave, 0, 0, null, usuario);
	}
	public String iniciarSesion(int id, String clave) {
		boolean estado = false;
		estado = comprobarDocumento(id);
		estado = comprobarClave(clave);
	}
	public boolean comprobarDocumento(int documento) {
		
	}
	public boolean comprobarNombre(String nombre) {
		
	}
	public boolean comprobarClave(String clave) {
		
	}
	public String recargarCuenta(float plata) {
		saldo += plata;
		return "Su saldo es" + getSaldo();
	}
	public String mostrarSaldo() {
		return "Su saldo es" + getSaldo();
	}
	public String retirarSaldo(float plata) {
		if (plata <= saldo) {
			saldo -= plata;
			return "Su saldo es" + getSaldo();
		}else {
			return "Saldo insuficiente";
		}
	}
	public Pedido historialPedidos() {
		
	}
}
