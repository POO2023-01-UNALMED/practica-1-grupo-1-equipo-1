package gestorAplicaciones;

public class Vehiculo {
	
	//Atributos
	
	private String tipo;
	private String placa;
	private Empleado conductor;
	
	//Constructor
	
	public Vehiculo(String tipo, String placa, Empleado conductor) {
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
	

	public void setConductor(Empleado conductor) {
		this.conductor = conductor;
	}
	public Empleado getConductor() {
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
