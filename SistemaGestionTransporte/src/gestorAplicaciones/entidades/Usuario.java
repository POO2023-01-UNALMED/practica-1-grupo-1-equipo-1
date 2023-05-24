package gestorAplicaciones.entidades;

import java.util.ArrayList;

public class Usuario{
	
	//atributos serializador
	//private static final long serialVersionUID = 1L;
	private final static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private final String nombre;
	private String clave;
	private long ID;
	private String correo;
	
	//constructores
	
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
	
	//metodod get y set

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/*public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}*/

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
		return new Usuario(nombre, clave, id, correo);
	}

	public boolean comprobarUsuario(String nombre, String clave){
		return this.nombre.equals(nombre) && this.clave.equals(clave);
	}
	public boolean comprobarUsuario(long id, String clave){
		return this.ID == id && this.clave.equals(clave);
	}

	public static boolean comprobarNombre(String nombre){
		for (Usuario usuario : Usuario.usuarios){
			if (usuario.getNombre().equals(nombre)) return true;
		}
		return false;
	}
	public static boolean comprobarID(long id){
		for (Usuario usuario : Usuario.usuarios){
			if (usuario.getID() == id) return true;
		}
		return false;
	}

	public static boolean comprobarCorreo(String correo){
		for(Usuario usuario : Usuario.usuarios){
			if(usuario.getCorreo().equals(correo)) return true;
		}
		return false;
	}

	@Override
	public String toString(){
		return "nombre\t" + this.nombre
				+ "\nid\t" + this.ID
				+ "\ncorreo\t" + this.correo
				+ "\n";
	}
}
