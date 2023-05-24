package gestorAplicaciones.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Usuario representa un usuario.
 * Atributos:
 * usuarios: ArrayList estátic que almacena todos los usuarios creados.
 * nombre: String final que almacena el nombre del usuario.
 * clave: String que almacena la clave de acceso del usuario.
 * ID: long que almacena el ID del usuario.
 * correo: String que almacena el correo del usuario.
 */
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

	/**
	 *
	 * @param nombre nombre usuario
	 * @param clave clave usuario
	 * @param id id del usuario
	 * @param correo del usuario
	 * @return Nueva instancia de usuario con los datos pasados como argumentos
	 */
	public static Usuario crearUsuario(String nombre, String clave, long id, String correo) {

		return new Usuario(nombre, clave, correo, id);
	}

	/**
	 *
	 * @param nombre nombre de usuario
	 * @param clave clave de usuario
	 * @return true si los argumentos ingresados coinciden con los atributos nombre y
	 * clave, de lo contrario retorna false.
	 */
	public boolean comprobarUsuario(String nombre, String clave){

		return this.nombre.equals(nombre) && this.clave.equals(clave);
	}

	/**
	 *
	 * @param id id de usuario
	 * @param clave clave de usuario
	 * @return true si los argumentos ingresados coinciden con los atributos ID y
	 * clave, de lo contrario retorna false.
	 */
	public boolean comprobarUsuario(long id, String clave){

		return this.ID == id && this.clave.equals(clave);
	}

	/**
	 *
	 * @param nombre nombre de usuario
	 * @return true si el String pasado como argumento coincide con el atributo nombre del objeto
	 * de la clase Usuario de lo contrario retorna false
	 */
	public boolean comprobarNombre(String nombre){

		return this.nombre.equals(nombre);
	}

	/**
	 *
	 * @param id id de usuario
	 * @return true si el numero pasado como argumento coincide con el atributo ID del objeto de
	 * la clase Usuario de lo contrario retorna false.
	 */
	public  boolean comprobarID(long id){

		return this.ID == id;
	}

	/**
	 *
	 * @param correo
	 * @return true si el String pasado como argumento coincide con el atributo correo del objeto,
	 * de la clase Usuario de lo contrario retorna false.
	 */
	public  boolean comprobarCorreo(String correo){

			return this.correo.equals(correo);
	}

	/**
	 *
	 * @param nombre nombre de nuevo usuario
	 * @return false si el nombre contiene espacios o caracteres no alfabéticos,
	 * o si ya existe un usuario con ese nombre. Retorna true en caso contrario.
	 */
	public static boolean isNombreValido(String nombre){

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

	/**
	 *
	 * @param id ide de nuevo usuario
	 * @return false si el ID contiene caracteres no numéricos o si ya existe un usuario con ese ID.
	 * Retorna true en caso contrario.
	 */
	public static boolean isIDValido(String id){

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

	/**
	 *
	 * @param correo correo de nuevo usuario
	 * @return false si el correo no contiene el carácter '@' o si está ubicado al final del correo,
	 * o si ya existe un usuario con ese correo. Retorna true en caso contrario.
	 */
	public static boolean isCorreoValido(String correo){

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

		return "\nnombre:\t" + this.nombre
				+ "\nid:\t" + this.ID
				+ "\ncorreo:\t" + this.correo
				+ "\n";
	}
}
