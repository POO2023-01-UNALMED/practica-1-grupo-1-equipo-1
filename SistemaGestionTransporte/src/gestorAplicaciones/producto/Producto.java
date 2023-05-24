package gestorAplicaciones.producto;

public class Producto {

    //atributos
    private String nombre;
    private String tipo;
    private double peso;
    private double volumen;


    //metodos
    public Producto(String nombre, String tipo, double peso, double volumen){
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.volumen = volumen;

    }

    //metodos getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    //metodos
    public void Editar(){}

    public void eliminar(){}

    public void agregar(){}

    public void precioFinal(){}
}
