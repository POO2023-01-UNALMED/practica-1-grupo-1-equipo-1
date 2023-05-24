package gestorAplicaciones.entidades;

import java.util.ArrayList;

public class Usuario{
	
	//serializador
	//private static final long serialVersionUID = 1L;

	//atributos
	private final static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private final String nombre;
	private String clave;
	private long ID;
	private String correo;
	
	//constructor
	
	public Usuario (String nombre, String clave,long id, String correo) {
		this(nombre, clave, correo);
		this.ID = id;
		Usuario.usuarios.add(this);

	}
	public Usuario (String nombre, String clave, String correo) {
		this.nombre = nombre;
		this.clave = clave;
		this.correo = correo;
	}
	
	//metodod gettter and setter

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
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
	
	public static Usuario crearUsuario(String nombre, String clave, long id, String correo) {
		/*
		este metodo de clase crea una instacioa de tipo Usuario con los datos pasados
		como argumentos.
		 */
		return new Usuario(nombre, clave, id, correo);
	}

	public boolean comprobarUsuario(String nombre, String clave){
		/*
		este metodo retorna true si los argumentos ingresados coinciden con los atributos nombre y
		clave, de lo contrario retorna false.
		 */
		return this.nombre.equals(nombre) && this.clave.equals(clave);
	}
	public boolean comprobarUsuario(long id, String clave){
		/*
		este metodo retorna true si los argumentos ingresados coinciden con los atributos ID y
		clave, de lo contrario retorna false.
		 */
		return this.ID == id && this.clave.equals(clave);
	}

	public static boolean comprobarNombre(String nombre){
		/*
		este metodo de  clase retorna true si el String pasado como argumento coincide con el
		atributo nombre de un objeto de la clase Usuario lo contrario retorna false.
		 */
		for (Usuario usuario : Usuario.usuarios){
			if (usuario.getNombre().equals(nombre)) return true;
		}
		return false;
	}
	public static boolean comprobarID(long id){
		/*
		este metodo de clase retorna true si el numero pasado como argumento coincide con el
		atributo ID de un objeto de la clase Usuario lo contrario retorna false.
		 */
		for (Usuario usuario : Usuario.usuarios){
			if (usuario.getID() == id) return true;
		}
		return false;
	}

	public static boolean comprobarCorreo(String correo){
		/*
		este metodo de clase retorna true si el String pasado como argumento coincide con el
		atributo correo de un objeto de la clase Usuario lo contrario retorna false.
		 */
		for(Usuario usuario : Usuario.usuarios){
			if(usuario.getCorreo().equals(correo)) return true;
		}
		return false;
	}

	@Override
	public String toString(){
		//sobreescritura del metodo toString para mostar los atributos del objeto.
		return "nombre\t" + this.nombre
				+ "\nid\t" + this.ID
				+ "\ncorreo\t" + this.correo
				+ "\n";
	}
}
