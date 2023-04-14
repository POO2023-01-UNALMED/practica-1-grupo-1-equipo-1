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
	//metodos set y get
	
	public void setCapacidad_carga(float capacidad_carga) {
		this.capacidad_carga = capacidad_carga;
	}
	public float getCapacidad_carga() {
		return capacidad_carga;
	}
	public void setConductor(Empleados conductor) {
		this.conductor = conductor;
	}
	public Empleados getConductor() {
		return conductor;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getModelo() {
		return modelo;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getPlaca() {
		return placa;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTipo() {
		return tipo;
	}
}
