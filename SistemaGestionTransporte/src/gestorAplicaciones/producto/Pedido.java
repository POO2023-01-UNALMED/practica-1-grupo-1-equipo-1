package gestorAplicaciones.producto;

import gestorAplicaciones.pais.Ciudad;
import gestorAplicaciones.pais.Pais;
import gestorAplicaciones.util.Pair;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pedido implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //atributos
    public static long numPedido  = 0;
    private String origen;
    private String destino;
    private double peso_carga;
    ArrayList<Producto> productos;
    private double costoPedido;
    private Pais pais;
    private String estado;
    private String vehiculo;
    private String tipoProductos;

    //constructor
    public Pedido() {
        Pedido.numPedido += 1;
    }

    //metodos getter and setter
    public static long getNumPedido() {
        return numPedido;
    }

    public static void setNumPedido(long numPedido) {
        Pedido.numPedido = numPedido;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPeso_carga() {
        return peso_carga;
    }

    public void setPeso_carga(double peso_carga) {
        this.peso_carga = peso_carga;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public double getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(double costoPedido) {
        this.costoPedido = costoPedido;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getTipoProductos() {
        return tipoProductos;
    }

    public void setTipoProductos(String tipoProductos) {
        this.tipoProductos = tipoProductos;
    }

    //metodos
    public ArrayList<Pair<String,Double>> calcularRuta(){
        /*
        este metodo implementa el algoritmo de dijkstra para encontrar el camino mas corto entre dos
        las ciudades origen y destino.
         */

        //obtener el objeto de la ciudad destino
        Ciudad ciudadPartida = this.pais.getCiudad(this.origen);

        Map<String, Pair<Boolean,String>> ciudadesVisitadas = new HashMap<>();
        assert ciudadPartida != null;
        ciudadPartida.inicializarCiudadesVisitadas(ciudadesVisitadas);

        Map<String, Double> costos = new HashMap<>(ciudadPartida.getConexiones());
        ciudadPartida.inicializarCostos(costos);

        PriorityQueue<Pair<String, Double>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        queue.offer(new Pair<>(ciudadPartida.getNombre(),0d));

        String nombre;
        double distancia;
        ciudadesVisitadas.put(ciudadPartida.getNombre(),new Pair<>(true,"-"));
        Ciudad ciudad;

        while (!queue.isEmpty()){
            nombre = queue.poll().getKey();
            ciudadesVisitadas.put(nombre,new Pair<>(true,ciudadesVisitadas.get(nombre).getValue()));

            ciudad = this.pais.getCiudad(nombre);

            if (nombre.equals(this.destino)) break;
            assert ciudad != null;
            for (Map.Entry<String, Double> map : ciudad.getConexiones().entrySet()){

                if(map.getValue() != -1 && !ciudadesVisitadas.get(map.getKey()).getKey()){
                    distancia = costos.get(nombre) + ciudad.getConexiones().get(map.getKey());

                    if(distancia <= costos.get(map.getKey())){
                        costos.put(map.getKey(), distancia);
                        queue.offer(new Pair<>(map.getKey(), distancia));
                        ciudadesVisitadas.put(map.getKey(),new Pair<>(false,nombre));
                    }
                }
            }
        }
        return  this.getRuta(this.getCamino(this.destino,ciudadesVisitadas),costos);
    }

    private ArrayList<String> getCamino(String destino, Map<String, Pair<Boolean, String>> ciudadesVisitadas){
        //obtener la ruta de una ciudad A a una ciudad B con el el mapa de ciudades visitadas
        ArrayList<String> procedencia = new ArrayList<String>();
        procedencia.add(destino);
        destino = ciudadesVisitadas.get(destino).getValue();
        while (!destino.equals("-")){
            procedencia.add(destino);
            destino = ciudadesVisitadas.get(destino).getValue();
        }

        Collections.reverse(procedencia);
        return procedencia;
    }

    private ArrayList<Pair<String,Double>> getRuta(ArrayList<String> camino, Map<String, Double> costos){
        ArrayList<Pair<String,Double>> ruta = new ArrayList<Pair<String,Double>>();
        for(String ciudad : camino){
            ruta.add(new Pair<>(ciudad,costos.get(ciudad)));
        }
        return ruta;
    }

    public double calcularPeso(){
        //calcular y retornar el peso total de todos los productos
        double peso = 0d;
        for(Producto producto : this.productos){
            peso += (producto.getPeso()*producto.getCantidad());
        }

        //convertir kg a toneladas
        return peso/1000;
    }

    public double calcularVolumen(){
        //Calcular y retornar el volumen total de todos los productos
        double volumen = 0d;
        for(Producto producto : this.productos){
            volumen += (producto.getVolumen()*producto.getCantidad());
        }

        return volumen;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Desde: ").append(this.origen).append("\nhasta: ").append(this.destino).append("\n");
        for(Producto producto : this.productos){
            sb.append(producto.toString()).append("\n");
        }
        if(this.estado != null) sb.append("Estado: ").append(this.estado).append("\n");
        else sb.append("Estado: Por confirmar\n");
        return sb.toString();
    }

    public LocalDateTime calcularHoraSalida() {
        LocalDateTime salida = LocalDateTime.now();
        String strFecha;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int hora  = salida.getHour();
        if(hora < 14 && hora > 5){
            strFecha = (salida.format(formato)) + (" 15:00:00");
        }
        else if(hora > 14){
            salida = salida.plusDays(1);
            strFecha = (salida.format(formato)) + (" 06:00:00");
        }
        else {
            strFecha = (salida.format(formato)) + (" 06:00:00");
        }
        formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(strFecha, formato);
    }

    public LocalDateTime calcularHoraLLegada(int horas, LocalDateTime horaSalida) {
        return horaSalida.plusHours(horas);
    }

    public void verificarEstado(LocalDateTime salida, LocalDateTime llegada){

        LocalDateTime actual = LocalDateTime.now();

        int diffHora, duracion, factor;
        duracion = llegada.getHour() - salida.getHour();
        factor = actual.getDayOfYear() - salida.getDayOfYear();
        diffHora = factor*24 + actual.getHour() - salida.getHour();

        if(diffHora < 0) this.estado = "Confirmado";
        else if(diffHora < duracion) this.estado = "Enviado";
        else this.estado = "Entregado";
    }

    public double tiempoTranscurrido(LocalDateTime salida){
        LocalDateTime actual = LocalDateTime.now();
        return actual.getHour() - salida.getHour() + (double)actual.getMinute()/60;
    }

    public static void main(String[] args) {
        LocalDateTime actual = LocalDateTime.now();
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        System.out.println(actual.format(fecha));
        System.out.println(actual.getSecond());
    }
}
