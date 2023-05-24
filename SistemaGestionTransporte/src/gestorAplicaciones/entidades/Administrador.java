package gestorAplicaciones.entidades;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.pais.Pais;
import uiMain.Main;

public class Administrador extends Empleado{

	Pais pais;
	Camion camion;
	int opcion = 0;

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
		String nombre, clave, id, correo;

		pais = Pais.selecionarPais();

		//pedir nombre
		System.out.println("nombre: ");
		nombre = Main.pedirDato();
		if(!Empleado.isNombreValido(nombre)) return;

		//pedir numero de identificacion
		System.out.println("ID: ");
		id = Main.pedirDato();
		if(!Empleado.isIDValido(id)) return;

		//pedir correo
		System.out.println("correo: ");
		correo = Main.pedirDato();
		if(!Empleado.isCorreoValido(correo)) return;

		//pedir clave
		System.out.println("Clave: ");
		clave = Main.pedirDato();
		Empleado.crearEmpleado(nombre, clave, Long.parseLong(id), correo,pais.getNombre());
	}

	public void registarCamion() {
		String placa;
		double pesoMaximo = 0, capacidad = 0;

		pais = Pais.selecionarPais();

		if (pais == null) return;

		System.out.println("Placa: ");
		placa = Main.pedirDato();
		placa = placa.toUpperCase();
		if(!Camion.verificarPlaca(placa, pais.getNombre())){
			System.out.println("""
            
            Placa no valida
            Colombia: XXX000
            Panama: 000000
            Ecuador: XXX0000
            """);
			return;
		}
		if(!Camion.isPlacaNueva(placa)){
			System.out.println("Placa ya existente");
			return;
		}

		do {
			System.out.println("""
                
                Vehiculo tipo:
                1. Liviano 1tn.
                2. Mediano 8tn.
                3. Semipesado 17tn.
                4. Pesado 24tn.
                0. cancelar.
                """);
			this.opcion = Main.getOption();
			switch (this.opcion) {
				case 1 -> {
					pesoMaximo = 1;
					capacidad = 20;
				}
				case 2 -> {
					pesoMaximo = 8;
					capacidad = 35;
				}
				case 3 -> {
					pesoMaximo = 17;
					capacidad = 42;
				}
				case 4 -> {
					pesoMaximo = 24;
					capacidad = 48;
				}
				default -> System.out.println("Opcion no valida");
			}
		}while(this.opcion != 0);


		do {
			System.out.println("""
                
                Tipo de vehiculo:
                1. Cisterna.
                2. Frigorifico.
                3. Lona.
                4. PortaCoches.
                0. Cancelar.
                """);

			switch (this.opcion) {
				case 1 -> camion = new CamionCisterna(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 2 -> camion = new CamionFrigorifico(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 3 -> camion = new CamionLona(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				case 4 -> camion = new CamionPortaCoches(placa, this.pais.getNombre(), pesoMaximo, capacidad);
				default -> System.out.println("Opcion no valida");
			}
		}while (this.opcion != 0);
	}
}