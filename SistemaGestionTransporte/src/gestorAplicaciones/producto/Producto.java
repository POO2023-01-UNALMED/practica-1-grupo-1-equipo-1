package gestorAplicaciones.producto;

import java.io.Serial;
import java.io.Serializable;

/**
 * es una clase que representa un producto.
 * Atributos:
 *  nombre: String quye representa el nombre del producto.
 *  tipo: String que indica el tipo o categoría del producto.
 *  peso: double que representa el peso del producto.
 *  volumen: double que representa el volumen del producto.
 *  cantidad: int que indica la cantidad de productos. de este producto.
 *
 * @author Julian Salazar, Michael Garcia
 */
public class Producto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //atributos
    private String nombre;
    private String tipo;
    private double peso;
    private double volumen;
    private long cantidad;


    //metodos
    public Producto(String nombre, String tipo, double peso, double volumen,long cantidad){
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.volumen = volumen;
        this.cantidad = cantidad;
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

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @param nombre
     * @param tipo
     * @param peso
     * @param volumen
     * @param cantidad
     * @return instancia de Producto con esos valores.
     */
    public static Producto crearProducto(String nombre,String tipo,double peso,double volumen,long cantidad) {
        //retorna una instacia de Producto con los valores pasados cmo argumentos.
        return new Producto(nombre,tipo,peso,volumen,cantidad);
    }
    public String toString() {
        return this.nombre + "\tx" +
                this.cantidad;
    }
}
