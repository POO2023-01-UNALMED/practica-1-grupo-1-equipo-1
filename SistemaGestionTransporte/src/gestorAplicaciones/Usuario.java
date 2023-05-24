package gestorAplicaciones;

import java.util.ArrayList;

public class Usuario{
	
	//atributos serializador
	private static final long serialVersionUID = 1L;
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private final String nombre;
	private String clave;
	private long ID;
	private String correo;

	//private float saldo;
	//private Pedido pedido;
	//private String tipoUsuario;
	
	//constructores
	
	public Usuario (String nombre, String clave,long id, String correo) {
		this(nombre, clave, correo);
		this.ID = id;
		Usuario.usuarios.add(this);
		//saldo = 0;
		//pedido = null;
		//tipoUsuario = "cliente";
	}
	public Usuario (String nombre, String clave, String correo) {
		this.nombre = nombre;
		this.clave = clave;
		this.correo = correo;
	}
	
	//metodod get y set

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

	public String getNombre() {
		return nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public long getID() {
		return ID;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}


	//metodos
	
	public static void crearUsuario(String nombre, String clave,long id, String correo) {
		new Usuario(nombre, clave, id, correo);
	}
	/*public String iniciarSesion(int id, String clave) {
		boolean estado = false;
		estado = comprobarDocumento(id);
		estado = comprobarClave(clave);
	}*/

	public boolean comprobarUsuario(String nombre, String clave){
		return this.nombre.equals(nombre) && this.clave.equals(clave);
	}
	public boolean comprobarUsuario(long id, String clave){
		return this.ID == id && this.clave.equals(clave);
	}
	/*public String recargarCuenta(float plata) {
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
	}*/
	//public Pedido historialPedidos() {}
}
