package gestorAplicaciones.camion;

import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.pais.Ciudad;
import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public abstract class Camion {
    //nota: capacidad de los camiones:(1 tn, 20 m3), (8 ton, 35 m3), (17 ton, 42 m3) y 24 (24 ton, 48m3);
    //atributos
    private String placa;
    private final double pesoMaximo;
    private final double capacidad;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }


    public double getCapacidad() {
        return capacidad;
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
    public abstract void calcularCostoCamion();

    public int calcularTiempo(){
        double km = this.getRuta().get(this.getRuta().size() - 1).getValue();
        return Integer.parseInt(String.valueOf(km/this.valocidad()));
    }
    public abstract double valocidad();

    public boolean comprobarPlaca(String placa){
        return this.placa.equals(placa);
    }

    public double distanciaRecorrida(double tiempo){
        return this.valocidad() * tiempo;
    }

    public double tiempoRestante(double tiempo){
        double distancia = this.distanciaRecorrida(tiempo);
        return (double) this.calcularTiempo() - distancia;
    }

    public String ubicacionActual(double tiempo) {
        double distancia = this.distanciaRecorrida(tiempo);
        double aux = 0;
        String ciudadA = null;
        String ciudadB = null;
        for (Pair<String, Double> recorrido : this.ruta){
            aux += recorrido.getValue();
            ciudadB = ciudadA;
            if(aux > tiempo){
                break;
            }
            ciudadA = recorrido.getKey();
        }
        return ciudadA + " - " + ciudadB;
    }

    public boolean elegirCamion(String origen, double peso) {
        if (this.getPesoMaximo() == 20 && peso <= this.getPesoMaximo()) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getPesoMaximo() == 35 && peso <= this.getPesoMaximo() && peso > 20) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getPesoMaximo() == 42 && peso <= this.getPesoMaximo() && peso > 35) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getPesoMaximo() == 48 && peso <= this.getPesoMaximo() && peso > 48) {
            return this.getCiudadActual().equals(origen);
        }
        return false;
    }

    public static Camion seleccionarCamion(String tipoCarga, String origen,double peso, double volumen) {
        //selecccionar camion disponible para realizar pedido
        //double peso = this.pedido.calcularPeso();
        //double volumen = this.pedido.calcularVolumen();
        switch (tipoCarga) {
            case "perecedera" -> {
                for (CamionFrigorifico c : CamionFrigorifico.getCamiones()) {
                    if (c.elegirCamion(origen, peso)) return c;
                }
            }
            case "fragil", "general" -> {
                for (CamionLona c : CamionLona.getCamiones()) {
                    if (c.elegirCamion(origen, peso)) return c;
                }
            }
            case "ADR" -> {
                for (CamionCisterna c : CamionCisterna.getCamiones()) {
                    if (c.elegirCamion(origen, peso)) return c;
                }
            }
            case "coches" -> {
                for (CamionPortaCoches c : CamionPortaCoches.getCamiones()) {
                    if (c.elegirCamion(origen, peso)) return c;
                }
            }
        }
        return null;
    }

    public static Camion buscarCamion(String tipoCarga, String placa){
        switch (tipoCarga) {
            case "perecedera" -> {
                for (CamionFrigorifico c : CamionFrigorifico.getCamiones()) {
                    if (c.comprobarPlaca(placa)) return c;
                }
            }
            case "fragil", "general" -> {
                for (CamionLona c : CamionLona.getCamiones()) {
                    if (c.comprobarPlaca(placa)) return c;
                }
            }
            case "ADR" -> {
                for (CamionCisterna c : CamionCisterna.getCamiones()) {
                    if (c.comprobarPlaca(placa)) return c;
                }
            }
            case "coches" -> {
                for (CamionPortaCoches c : CamionPortaCoches.getCamiones()) {
                    if (c.comprobarPlaca(placa)) return c;
                }
            }
        }
        return null;
    }
}
