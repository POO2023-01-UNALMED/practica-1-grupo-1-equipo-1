package gestorAplicaciones.producto;

import gestorAplicaciones.util.Pair;

import java.util.ArrayList;

public class Pedido {

    public static long numPedido  = 0;
    private String origen;
    private String destino;
    private double peso_carga;
    ArrayList<Producto> productos;
    private double costoPedido;
    private String pais;
    private String estado;
    //private final double ganancia = 1.25;

    public Pedido() {
        Pedido.numPedido += 1;
    }

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
