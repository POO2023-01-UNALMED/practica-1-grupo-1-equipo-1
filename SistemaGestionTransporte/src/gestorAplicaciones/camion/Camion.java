package gestorAplicaciones.camion;

import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public abstract class Camion {
    //nota: capacidad de los camiones:(1 tn, 20 m3), (8 ton, 35 m3), (17 ton, 42 m3) y 24 (24 ton, 48m3);
    //atributos
    private String placa;
    private double pesoMaximo;
    private double capacidad;
    private double costo;
    private String pais;
    private boolean disponible;
    private String ciudadActual;
    private ArrayList <Pair<String, Double>> ruta;
    private Empleado empleado;

    //constructor
    public Camion(String placa,String pais, double pesoMaximo,double capacidad){
        this.placa = placa;
        this.pesoMaximo = pesoMaximo;
        this.pais = pais;
        this.capacidad = capacidad;
    }

    //metodos getter and setter
    //public static ArrayList<Camion> getCamiones() {
        //return camiones;
    //}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
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

    public String getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }

    public ArrayList<Pair<String, Double>> getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList<Pair<String, Double>> ruta) {
        this.ruta = ruta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    //metodos
    public abstract double calcularCostoCamion();

    public abstract boolean comprobarPlaca(String placa);

    public abstract String ubicacion();
    public abstract String tiempoRestante();

    public abstract boolean elegirCamion(String origen,double peso, double volumen);

}
