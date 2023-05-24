package gestorAplicaciones.producto;

import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public class Pedido {

    //atributos
    public static long numPedido  = 0;
    private String origen;
    private String destino;
    private double peso_carga;
    ArrayList<Producto> productos;
    private double costoPedido;
    private String pais;
    private String estado;

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //metodos
    public ArrayList<Pair<String,Double>> calcularRuta(){
        return null;
    }

    public double CalcularPeso(){
        return 0d;
    }

    public void asignarVehiculo(){

    }
    public void asignarConductor(){

    }
}
