package gestorAplicaciones.entidades;

public class Administrador extends Empleado{

	//constructor
	public Administrador() {
		super("Administrador","Clave",0,"Administrador@egt.com",true);
	}
	
	//metodos
	public void estadistica() {
		
	}
	public void modificarCosto() {
		
	}
	public String MostrarEmpleados() {
		//mostar dotos los objetos de tipo Empleado
		StringBuilder infoEmpleados = new StringBuilder();
		for (Empleado empleado : Empleado.getEmpleados()) {
			infoEmpleados.append(empleado.toString());
		}
		return infoEmpleados.toString();
	}

	public Empleado mostarEmpleado(String nombre) {
		//retorna la instancia de Empleado que sea igual al atributo de tipo String pasado como argumento
		for (Empleado empleado : Empleado.getEmpleados()) {
			if (empleado.getNombre().equals(nombre)) {
				return empleado;
			}
		}
		return null;
	}

	public String mostarUsuarios() {
		//mostar dotos los objetos de tipo Usuario
		StringBuilder infoUsuarios = new StringBuilder();
		for(Empleado empleado : Empleado.getEmpleados()){
			infoUsuarios.append(empleado);
		}
		return infoUsuarios.toString();
	}

	public Usuario mostarUsuario(String nombre) {
		//retorna la instancia de Usuario que sea igual al atributo de tipo String pasado como argumento
		for (Usuario usuario : Usuario.getUsuarios()){
			if(usuario.getNombre().equals(nombre)){
				return usuario;
			}
		}
		return null;
	}

	public void registrarEmpleado() {

	}


	/*public void pagarNomina() {
		
	}*/

}