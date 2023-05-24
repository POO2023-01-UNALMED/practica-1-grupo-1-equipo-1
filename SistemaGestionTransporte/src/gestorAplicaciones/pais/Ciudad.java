package gestorAplicaciones.pais;


import gestorAplicaciones.util.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


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

    public void inicializarCiudadesVisitadas(Map<String, Pair<Boolean, String>> ciudadesVisitadas){
        //iniciar el map CiudadesVisitadas.
        for (Map.Entry<String, Double> map : conexiones.entrySet()) {
            ciudadesVisitadas.put(map.getKey(),new Pair<>(false,"-"));
        }
    }

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
        //sobreescritura del metodo toString
        StringBuilder result = new StringBuilder();
        result.append("Ciudad: ").append(this.nombre);
        result.append("\nAdyacente\tcosto\n");
        for (Map.Entry<String, Double> map : conexiones.entrySet()){
            result.append(map.getKey()).append("\n").append(map.getValue()).append("\n");
        }
        return result.toString();
    }
}
