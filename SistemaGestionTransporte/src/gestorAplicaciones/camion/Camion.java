package gestorAplicaciones.camion;

import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.util.Pair;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Camion implements Serializable {
    //nota: capacidad de los camiones:(1 tn, 20 m3), (8 ton, 35 m3), (17 ton, 42 m3) y 24 (24 ton, 48m3);
    //atributos
    //public final static ArrayList<Camion> camiones = new ArrayList<Camion>();
    public final static Map<String,ArrayList<? extends Camion>> camiones = new HashMap<>();

    @Serial
    private static final long serialVersionUID = 1L;
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
    public Camion(String placa,String pais, String ciudadActual,double pesoMaximo,double capacidad){
        this.placa = placa;
        this.pesoMaximo = pesoMaximo;
        this.pais = pais;
        this.ciudadActual = ciudadActual;
        this.capacidad = capacidad;
        this.disponible = true;
    }

    public Camion() {}

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public void setCapacidad(double capacidad) {
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
        return (int) Math.ceil(km/this.valocidad());
    }
    public abstract double valocidad();

    public boolean comprobarPlaca(String placa){
        return this.placa.equals(placa);
    }

    public double distanciaRecorrida(double tiempo){
        return this.valocidad() * tiempo;
    }

    public double tiempoRestante(double tiempo){
        //double distancia = this.distanciaRecorrida(tiempo);
        //return (double) this.calcularTiempo() - distancia;
        return this.calcularTiempo() - tiempo;
    }

    public String ubicacionActual(double tiempo) {
        double distancia = this.distanciaRecorrida(tiempo);
        double aux = 0;
        String ciudadA = null;
        String ciudadB = null;
        for (Pair<String, Double> recorrido : this.ruta){

            aux += recorrido.getValue();
            ciudadA = ciudadB;
            ciudadB = recorrido.getKey();

            if(aux > distancia) break;

        }
        return ciudadA + " - " + ciudadB;
    }

    public boolean camionOptimo(String origen, double peso) {
        if (this.getCapacidad() == 20 && peso <= this.getPesoMaximo()) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getCapacidad() == 35 && peso <= this.getPesoMaximo() && peso > 1) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getCapacidad() == 42 && peso <= this.getPesoMaximo() && peso > 8) {
            return this.getCiudadActual().equals(origen);
        }
        else if(this.getCapacidad() == 48 && peso <= this.getPesoMaximo() && peso > 17) {
            return this.getCiudadActual().equals(origen);
        }
        return false;
    }

    public static Camion seleccionarCamion(String tipoCarga, String origen,double peso, double volumen) {

        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for(Camion c: camiones){
            if (c.camionOptimo(origen,peso)) return c;
        }
        return null;
    }

    public static Camion buscarCamion(String tipoCarga, String placa){

        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for(Camion c: camiones){
            if (c.comprobarPlaca(placa)) return c;
        }
        return null;
    }

    public static boolean verificarPlaca(String placa, String nombre) {
        String letras, num;

        if(nombre.equals("Colombia") && placa.length() == 6){
            letras = placa.substring(0, 3);
            num = placa.substring(3);
            return letras.chars().allMatch(Character::isLetter) && num.chars().allMatch(Character::isDigit);
        }

        else if(nombre.equals("Panama") && placa.length() == 6 && placa.chars().allMatch(Character::isDigit))
            return true;

        else if(nombre.equals("Ecuador") && placa.length() == 7){
            letras = placa.substring(0,3);
            num = placa.substring(3);
            return letras.chars().allMatch(Character::isLetter) && num.chars().allMatch(Character::isDigit);
        }

        return false;
    }

    public static boolean isPlacaNueva(String placa) {

        for (Map.Entry<String, ArrayList<? extends Camion>> entry : Camion.camiones.entrySet()){
            ArrayList<? extends Camion> camiones = entry.getValue();
            for(Camion camion : camiones){
                if(camion.placa.equals(placa)) return false;
            }
        }
        return true;
    }
    public static void datosCamiones(){
        Camion.camiones.put("Cisterna", CamionCisterna.getCamiones());
        Camion.camiones.put("Frigorifico", CamionFrigorifico.getCamiones());
        Camion.camiones.put("Lona", CamionLona.getCamiones());
        Camion.camiones.put("PortaCoches", CamionPortaCoches.getCamiones());
    }

    public static ArrayList<? extends Camion> listaCamiones(String tipoCarga) {
        return Camion.camiones.get(tipoCarga);
    }
}
