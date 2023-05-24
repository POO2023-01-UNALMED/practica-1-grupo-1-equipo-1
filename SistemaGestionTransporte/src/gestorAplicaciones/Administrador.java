package gestorAplicaciones;

public class Administrador extends Empleado{
	
	//atributos
	//constructor
	public Administrador(String clave) {
		super("Administrador","Clave",0,"Administrador@egt.com",true);
	}
	//metodos get y set
	
	//metodos
	public void estadistica() {
		
	}
	public void modificarCosto() {
		
	}
	public String MostrarEmpleados() {
		StringBuilder infoEmpleados = new StringBuilder();
		for (Empleado empleado : Empleado.getEmpleados()) {
			infoEmpleados.append(empleado.toString());
		}
		return infoEmpleados.toString();
	}

	public Empleado mostarEmpleado(String nombre) {
		for (Empleado empleado : Empleado.getEmpleados()) {
			if (empleado.getNombre().equals(nombre)) {
				return empleado;
			}
		}
		return null;
	}

	public String mostarUsuarios() {
		StringBuilder infoUsuarios = new StringBuilder();
		for(Empleado empleado : Empleado.getEmpleados()){
			infoUsuarios.append(empleado);
		}
		return infoUsuarios.toString();
	}

	public Usuario mostarUsuario(String nombre) {
		for (Usuario usuario : Usuario.getUsuarios()){
			if(usuario.getNombre().equals(nombre)){
				return usuario;
			}
		}
		return null;
	}
	/*public void pagarNomina() {
		
	}*/

}