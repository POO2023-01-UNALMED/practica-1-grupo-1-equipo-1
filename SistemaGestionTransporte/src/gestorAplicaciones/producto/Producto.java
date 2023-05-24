package gestorAplicaciones.producto;

public class Producto {
    private String tipo;
    private double peso;

    private double volumen;

    //metodos
    public Producto(String tipo, double peso, double volumen){

    }

    public Producto(double peso, double volumen){
        this("otros", peso, volumen);
    }
}
