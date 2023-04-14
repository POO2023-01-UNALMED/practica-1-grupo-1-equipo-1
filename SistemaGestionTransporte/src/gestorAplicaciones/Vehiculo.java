package gestorAplicaciones;

public class Vehiculo {
	
	//Atributos
	
	private String tipo;
	private String placa;
	private float capacidad_carga;
	private String modelo;
	private Empleados conductor;
	
	//Constructor
	
	public Vehiculo(String tipo, String placa, float capacidad_carga, String modelo, Empleados conductor) {
		super();
		this.tipo = tipo;
		this.placa = placa;
		this.capacidad_carga = capacidad_carga;
		this.modelo = modelo;
		this.conductor = conductor;
	}
	
	//metodos
	
	public void trayecto() {
	}

	public float costoViaje() {
		
	}
}
