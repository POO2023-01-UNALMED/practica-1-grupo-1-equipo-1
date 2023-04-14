package gestorAplicaciones;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ciudad {
    private String nombre;
    private Map<String, Double> conexiones;

    public Ciudad(String nombre) {
        this.nombre = nombre;
        conexiones = new HashMap<>();
        conexiones.put(this.nombre,0d);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void conectarCiudades(String nombre, double costo){
        conexiones.put(this.nombre,costo);

    }

    public Pair<String,Double> planificarRuta(String destino){

        Map<String, Pair<Boolean,String>> ciudadesVisitadas = new HashMap<>();
        this.inicializarCiudadesVisitadas(ciudadesVisitadas);
        Map<String, Double> costos = new HashMap<>(this.conexiones);
        PriorityQueue<Pair<String, Double>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        queue.offer(new Pair<>(this.nombre,0d));
        String ciudad, procedencia = "-";
        double distancia;

        while (!queue.isEmpty()){
            ciudad = queue.poll().getKey();
            ciudadesVisitadas.put(ciudad,new Pair<>(true,procedencia));

            if (ciudad.equals(destino)) break;
            for (Map.Entry<String, Double> map : conexiones.entrySet()){

                if(map.getValue() != -1 && ciudadesVisitadas.get(map.getKey()).getKey()){
                    distancia = costos.get(ciudad) + conexiones.get(map.getKey());
                    if(distancia < costos.get(map.getKey())){
                        costos.put(map.getKey(), distancia);
                        queue.offer(new Pair<>(map.getKey(), distancia));
                    }
                }
            }
            procedencia = ciudad;
        }
        distancia = costos.get(destino);

        return new Pair<>(this.getRuta(destino,ciudadesVisitadas), distancia);

    }

    private void inicializarCiudadesVisitadas(Map<String, Pair<Boolean,String>> ciudadesVisitadas){
        for (Map.Entry<String, Double> map : conexiones.entrySet()) {
            ciudadesVisitadas.put(map.getKey(),new Pair<>(false,"-"));
        }
    }

    private void inicializarCostos(Map<String, Double> costos){
        for (Map.Entry<String, Double> map : costos.entrySet()) {
            if(map.getKey().equals(this.nombre)){
                map.setValue(0d);
            }
            else{
                map.setValue(Double.MAX_VALUE);
            }
        }
    }

    private String getRuta(String destino, Map<String, Pair<Boolean,String>> ciudadesVisitadas){
        StringBuilder procedencia = new StringBuilder(destino);
        destino = ciudadesVisitadas.get(destino).getValue();
        while (!destino.equals("-")){
            procedencia.append(" - ").append(destino);
            destino = ciudadesVisitadas.get(destino).getValue();
        }

        return procedencia.toString();
    }
}
