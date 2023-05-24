package gestorAplicaciones.camion;

import gestorAplicaciones.producto.Producto;
import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public abstract class Camion {
    //nota: capacidad de los camiones: (8 ton, 35 m3), (17 ton, 42 m3) y 24 (24 ton, 48m3);
    //atributos
    public final static ArrayList<Camion> camiones = new ArrayList<Camion>();
    private String placa;
    private String tamanio;
    private double capacidad;
    private double costo;
    private String pais;
    private boolean disponible;
    private ArrayList <Pair<String, Double>> ruta;

    //constructor
    public Camion(String placa, String tamanio, String pais){
        this.placa = placa;
        this.tamanio = tamanio;
        this.pais = pais;
        camiones.add(this);
    }

    //metodos getter and setter
    public static ArrayList<Camion> getCamiones() {
        return camiones;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public ArrayList<Pair<String, Double>> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Pair<String, Double>> ruta) {
        this.ruta = ruta;
    }

    //metodos
    public abstract double calcularCostoCamion();

    public abstract boolean comprobarPlaca(String placa);

    public abstract String ubicacion();
    public abstract String tiempoRestante();

    public static Camion elegirCamion(String tipoCarga, Producto producto){

        return null;
    }

}
