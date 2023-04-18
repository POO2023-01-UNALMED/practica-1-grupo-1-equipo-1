package gestorAplicaciones;

public class Vehiculo {
	
	//Atributos
	
	private String tipo;
	private String placa;
	private Empleados conductor;
	
	//Constructor
	
	public Vehiculo(String tipo, String placa, Empleados conductor) {
		this.tipo = tipo;
		this.placa = placa;
		this.conductor = conductor;
	}
	
	//metodos
	
	public void trayecto() {
	}

	public float costoViaje() {
		
	}
	//metodos set y get
	

	public void setConductor(Empleados conductor) {
		this.conductor = conductor;
	}
	public Empleados getConductor() {
		return conductor;
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
