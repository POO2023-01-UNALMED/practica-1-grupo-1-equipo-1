package gestorAplicaciones.pais;


import gestorAplicaciones.util.Pair;

import java.util.HashMap;
import java.util.Map;


/**
 * Representa una ciudad
 *Atributos:
 * nombre: String que representa el nombre de la ciudad
 * nombrePais: String que representa el nombre del país al que pertenece la ciudad.
 * conexiones:  Map que almacena las conexiones de la ciudad con otras ciudades y sus costos (km).
 *
 * @author Julian Salazar, Michael Garcia
 */
public class Ciudad {

    //atributos
    private String nombre;
    private String nombrePais;
    private Map<String, Double> conexiones;

    //constructor
    public Ciudad(String nombre, String nombrePais) {
        this.nombre = nombre;
        this.nombrePais = nombrePais;
        conexiones = new HashMap<>();
        conexiones.put(this.nombre,0d);
    }

    //metodos getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void conectarCiudades(String nombre, double costo){
        conexiones.put(nombre,costo);

    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Map<String, Double> getConexiones() {
        return conexiones;
    }

    public void setConexiones(Map<String, Double> conexiones) {
        this.conexiones = conexiones;
    }

    /**
     * @param ciudadesVisitadas map que almacena el estado de las ciudades visitadas
     *
     * Todas las ciudades se inicializan como no visitadas
     */
    public void inicializarCiudadesVisitadas(Map<String, Pair<Boolean, String>> ciudadesVisitadas){

        for (Map.Entry<String, Double> map : conexiones.entrySet()) {
            ciudadesVisitadas.put(map.getKey(),new Pair<>(false,"-"));
        }
    }

    /**
     *
     * @param costos map que almacena una ciudad y el costo a esta.
     * las ciudades con costo -1 (no conectadas), se inicializan con el valor máximo posible de Double.
     */
    public void inicializarCostos(Map<String, Double> costos){
        //iniciaar el map costos con el valor maximo de Double
        for (Map.Entry<String, Double> map : costos.entrySet()) {
            if(map.getValue() == -1){
                map.setValue(Double.MAX_VALUE);
            }
        }
    }

    @Override
    public String toString(){
        return this.nombre+"\n";
    }
}
