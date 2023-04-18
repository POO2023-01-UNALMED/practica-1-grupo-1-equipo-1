package gestorAplicaciones;

public class Avion extends Vehiculo {
	//Atributos
		private int vmax;
		private float capacidad_carga;
		private String modelo;
		private float max_distancia;
	   
	//Constructor

public Avion(String tipo, String placa, float capacidad_carga, String modelo, Empleado conductor,int vmax, float max_distancia) {
	super(String tipo, String placa, Empleado conductor);
	this.vmax=vmax;
	this.capacidad_carga = capacidad_carga;
	this.modelo = modelo;
	this.max_distancia=max_distancia;
	}

	//set y get
public void setCapacidad_carga(float capacidad_carga) {
	this.capacidad_carga = capacidad_carga;
	}
public float getCapacidad_carga() {
	return capacidad_carga;
	}
public void setModelo(String modelo) {
	this.modelo = modelo;
	}
public String getModelo() {
	return modelo;
	}
public void setVmax(int vmax) {
	this.vmax=vmax;
	}
public int getVmax() {
		return vmax;
	}
public void setMax_distancia(float max_distancia) {
	this.max_distancia=max_distancia;
}
public float getMax_distancia() {
	return max_distancia;
}
}
