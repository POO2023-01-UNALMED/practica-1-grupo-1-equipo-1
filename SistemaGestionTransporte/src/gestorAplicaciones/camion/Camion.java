package gestorAplicaciones.camion;

import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.util.Pair;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Camion es una clase abstracta que implementa la interfaz Serializable. Sirve como clase base
 * para representar diferentes tipos de camiones.
 * Atributos:
 * placa: Stringque representa la placa del camion.
 * pesoMaximo: double que indica el peso máximo que puede transportar el camion.
 * capacidad: capacidad que indica la capacidad de carga del camion.
 * costo: double que representa el costo de viaje del camion.
 * pais: String que indica el país al que pertenece el camion.
 * disponible: boolean que indica si el camion está disponible o no.
 * ciudadActual: Es una cadena que representa la ciudad actual donde se encuentra el camion.
 * ruta: ArrayList Pair que contiene información sobre la ruta del camion.
 * empleado: Es un objeto de tipo Empleado que representa al empleado asociado con el camion.
 */
public abstract class Camion implements Serializable {
    //nota: capacidad de los camiones:(1 tn, 20 m3), (8 ton, 35 m3), (17 ton, 42 m3) y 24 (24 ton, 48m3);
    //atributos
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

    /**
     * debe ser implementado en las subclases para calcular el costo del camion.
     */
    public abstract void calcularCostoCamion();

    /**
     *
     * @return entero que representa el tiempo estimado que tomar recorrer la ruta del camion
     * en función de su velocidad
     */
    public int calcularTiempo(){
        double km = this.getRuta().get(this.getRuta().size() - 1).getValue();
        return (int) Math.ceil(km/this.valocidad());
    }

    /**
     * debe ser implementado en las subclases para obtener la velocidad del camión.
     * @return retorna la velocidad del camion
     */
    public abstract double valocidad();

    /**
     *
     * @param placa placa de camion a comprobar
     * @return true si la placa pasada como argumento y la del camion coinciden
     * , de lo contrario retorna false
     */
    public boolean comprobarPlaca(String placa){
        return this.placa.equals(placa);
    }

    /**
     *
     * @param tiempo tiempo transcurrido del camion en movimiento
     * @return double que representa la distancia recorrida del camion
     */
    public double distanciaRecorrida(double tiempo){
        return this.valocidad() * tiempo;
    }

    /**
     *
     * @param tiempo tiempo transcurrido del camion en movimiento
     * @return double que representa el tiempo restante que le falta al camion para llegar a su destino.
     */
    public double tiempoRestante(double tiempo){

        return this.calcularTiempo() - tiempo;
    }

    /**
     *
     * @param tiempo tiempo transcurrido del camion en movimiento
     * @return String que indica la ubicacion actual del camion formato: "ciudadA - ciudadB".
     */
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

    /**
     *
     * @param origen ciudad de origen
     * @param peso peso de productos a ser transportados
     * @return Retorna true si el camion es optimo para realizar el viaje, de lo contrario, retorna false
     */
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

    /**
     *
     * @param tipoCarga tipo de carga a transportar
     * @param origen ciudad de origen
     * @param peso peso productos
     * @param volumen volumen productos
     * @return camin adecuado para ula carga específica si es encontrado de lo contarrio retorna null
     */
    public static Camion seleccionarCamion(String tipoCarga, String origen,double peso, double volumen) {

        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for(Camion c: camiones){
            if (c.camionOptimo(origen,peso)) return c;
        }
        return null;
    }

    /**
     *
     * @param tipoCarga tipo de carga a transportar
     * @param placa placa del camion
     * @return Retorna camion que cumpla con los datos pasados como argumentos, de lo contrario
     * retorna false.
     */
    public static Camion buscarCamion(String tipoCarga, String placa){

        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for(Camion c: camiones){
            if (c.comprobarPlaca(placa)) return c;
        }
        return null;
    }

    /**
     *
     * @param placa placa nuevo camion
     * @param nombre nmombre del pais donde operara el camion.
     * @return true si una placa es válida según las reglas establecidas para un país específico,
     * de lo contrario retorna false.
     */
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

    /**
     *
     * @param placa Placa nuevo camionVerifica
     * @return false si la placa se encuentra en uso por otro camion, de lo contarrio retorna
     * true.
     */
    public static boolean isPlacaNueva(String placa) {

        for (Map.Entry<String, ArrayList<? extends Camion>> entry : Camion.camiones.entrySet()){
            ArrayList<? extends Camion> camiones = entry.getValue();
            for(Camion camion : camiones){
                if(camion.placa.equals(placa)) return false;
            }
        }
        return true;
    }

    /**
     * mapo con los datos de los camiones disponibles.
     */
    public static void datosCamiones(){
        Camion.camiones.put("Cisterna", CamionCisterna.getCamiones());
        Camion.camiones.put("Frigorifico", CamionFrigorifico.getCamiones());
        Camion.camiones.put("Lona", CamionLona.getCamiones());
        Camion.camiones.put("PortaCoches", CamionPortaCoches.getCamiones());
    }
}
