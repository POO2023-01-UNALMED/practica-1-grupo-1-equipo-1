package gestorAplicaciones;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Ciudad {
    private String nombre;
    private String nombrePais;
    private Map<String, Double> conexiones;

    public Ciudad(String nombre, String nombrePais) {
        this.nombre = nombre;
        this.nombrePais = nombrePais;
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
        conexiones.put(nombre,costo);

    }

    public Pair<String,Double> planificarRuta(String destino){

        Map<String, Pair<Boolean,String>> ciudadesVisitadas = new HashMap<>();
        this.inicializarCiudadesVisitadas(ciudadesVisitadas);
        Map<String, Double> costos = new HashMap<>(this.conexiones);
        this.inicializarCostos(costos);
        PriorityQueue<Pair<String, Double>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        queue.offer(new Pair<>(this.nombre,0d));
        String nombre;
        double distancia;
        ciudadesVisitadas.put(this.nombre,new Pair<>(true,"-"));
        Ciudad ciudad;


        while (!queue.isEmpty()){
            nombre = queue.poll().getKey();
            ciudadesVisitadas.put(nombre,new Pair<>(true,ciudadesVisitadas.get(nombre).getValue()));

            if(this.nombrePais.equals("Colombia")) {
                ciudad = Pais.COLOMBIA.getCiudad(nombre);
            }
            else if(this.nombrePais.equals("Ecaudor")){
                ciudad = Pais.ECUADOR.getCiudad(nombre);
            }
            else{
                ciudad = Pais.PANAMA.getCiudad(nombre);
            }

            if (nombre.equals(destino)) break;
            assert ciudad != null;
            for (Map.Entry<String, Double> map : ciudad.conexiones.entrySet()){

                if(map.getValue() != -1 && !ciudadesVisitadas.get(map.getKey()).getKey()){
                    distancia = costos.get(nombre) + ciudad.conexiones.get(map.getKey());
                    System.out.println(costos.get(map.getKey()));
                    if(distancia <= costos.get(map.getKey())){
                        costos.put(map.getKey(), distancia);
                        queue.offer(new Pair<>(map.getKey(), distancia));
                        ciudadesVisitadas.put(map.getKey(),new Pair<>(false,nombre));
                    }
                }
            }
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
            if(map.getValue() == -1){
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

        return procedencia.reverse().toString();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Ciudad: ").append(this.nombre);
        result.append("\nAdyacente\tcosto\n");
        for (Map.Entry<String, Double> map : conexiones.entrySet()){
            result.append(map.getKey()).append("\n").append(map.getValue()).append("\n");
        }
        return result.toString();
    }
}
