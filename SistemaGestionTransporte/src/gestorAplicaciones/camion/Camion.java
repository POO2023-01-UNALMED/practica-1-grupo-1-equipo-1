package gestorAplicaciones.camion;

import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public abstract class Camion {
    //atributos
    public static ArrayList<Camion> camiones = new ArrayList<Camion>();
    private String placa;
    private String tamanio;
    private String capacidad;
    private String costo;
    private String pais;
    private boolean disponible;
    private ArrayList <Pair<String, Double>> ruta;

    public Camion(String placa, String tamanio, String capacidad, String costo, String pais){
        this.placa = placa;
        this.tamanio = tamanio;
        this.capacidad = capacidad;
        this.costo = costo;
        this.pais = pais;
        camiones.add(this);
    }

    public static ArrayList<Camion> getCamiones() {
        return camiones;
    }

    public static void setCamiones(ArrayList<Camion> camiones) {
        Camion.camiones = camiones;
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

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
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

    public abstract double calcularCostoCamion();

    public abstract boolean comprobarPlaca(String placa);

    public abstract String ubicacion();
    public abstract String tiempoRestante();
}
