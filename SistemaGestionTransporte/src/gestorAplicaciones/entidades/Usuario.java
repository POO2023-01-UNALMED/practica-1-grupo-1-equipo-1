package gestorAplicaciones.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {
	
	//serializador
	@Serial
	private static final long serialVersionUID = 1L;

	//atributos
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private final String nombre;
	private String clave;
	private long ID;
	private String correo;
	
	//constructor
	
	public Usuario (String nombre, String clave,long id, String correo) {
		this.nombre = nombre;
		this.clave = clave;
		this.ID = id;
		this.correo = correo;

	}
	public Usuario (String nombre, long id, String correo) {
		this(nombre,"0000", correo, id);
	}
	public Usuario (String nombre, String clave, String correo, long id) {
		this.nombre = nombre;
		this.clave = clave;
		this.correo = correo;
		this.ID = id;
		Usuario.usuarios.add(this);

	}
	
	//metodod gettter and setter

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios){
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
	
	public static Usuario crearUsuario(String nombre, String clave, long id, String correo) {
		/*
		este metodo de clase crea una instacioa de tipo Usuario con los datos pasados
		como argumentos.
		 */
		return new Usuario(nombre, clave, correo, id);
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

	public boolean comprobarNombre(String nombre){
		/*
		este metodo de  clase retorna true si el String pasado como argumento coincide con el
		atributo nombre del objeto de la clase Usuario de lo contrario retorna false.
		 */
		return this.nombre.equals(nombre);
	}
	public  boolean comprobarID(long id){
		/*
		este metodo de clase retorna true si el numero pasado como argumento coincide con el
		atributo ID del objeto de la clase Usuario de lo contrario retorna false.
		 */
		return this.ID == id;
	}

	public  boolean comprobarCorreo(String correo){
		/*
		este metodo de clase retorna true si el String pasado como argumento coincide con el
		atributo correo del objeto de la clase Usuario de lo contrario retorna false.
		 */
			return this.correo.equals(correo);
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
		for(Usuario usuario : Usuario.usuarios) {
			if (usuario.comprobarNombre(nombre)) {
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
		for(Usuario usuario : Usuario.usuarios) {
			if (usuario.comprobarID(Long.parseLong(id))) {
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
		for(Usuario usuario : Usuario.usuarios) {
			if (usuario.comprobarCorreo(correo)) {
				System.out.println("correo ya registrado.");
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString(){
		//sobreescritura del metodo toString para mostar los atributos del objeto.
		return "\nnombre\t" + this.nombre
				+ "\nid\t" + this.ID
				+ "\ncorreo\t" + this.correo
				+ "\n";
	}
}
