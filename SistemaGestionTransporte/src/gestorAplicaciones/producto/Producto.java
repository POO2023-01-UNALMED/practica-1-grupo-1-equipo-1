package gestorAplicaciones.producto;

import uiMain.Main;

import java.util.ArrayList;

public class Producto {

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

    public static String tipoProductos() {
        int opcion = 0;
        //Selecionar el tipo de productos a transportar
        System.out.println("Seleccione el tipo de producto a transportar");
        do{
            System.out.println("""
                    
                    Ingrese:
                    1. Carga perecedera.
                    2. Carga fragil.
                    3. Carga ADR.
                    4. Carga de coches.
                    5. Carga general.
                    0. Salir.""");

            opcion = Main.getOption();
            switch (opcion) {
                case 1 -> {
                    return "Frigorifico";
                }
                case 2, 5 -> {
                    return "Lona";
                }
                case 3 -> {
                    return "Cisterna";
                }
                case 4 -> {
                    return "PortaCoches";
                }
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion != 0);

        return null;
    }

    public static ArrayList<Producto> seleccionarProductos(String tipo) {
        //ingresar los productos a transportar y caracteristicas
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String nombre;
        double peso, volumen;
        long cantidad;
        int opcion;

        do {
            System.out.println("""
    
            Ingrese:
            1. Ingresar producto.
            2. Ver productos ingresados.
            3. Confirmar productos.
            4. Eliminar producto.
            0. Descartar productos.""");
            opcion = Main.getOption();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("nombre del producto: ");
                    nombre = Main.pedirDato();

                    System.out.println("peso del producto: ");
                    peso = Double.parseDouble(Main.pedirDato());

                    System.out.println("volumen del producto: ");
                    volumen = Double.parseDouble(Main.pedirDato());

                    System.out.println("Cantidad de ese producto: ");
                    cantidad = Long.parseLong(Main.pedirDato());

                    productos.add(new Producto(nombre,tipo,peso,volumen,cantidad));
                    break;
                case 2:
                    for(Producto producto : productos){
                        System.out.println(producto);
                    }
                    break;
                case 3:
                    return productos;
                case 4:
                    System.out.println("nombre del producto: ");
                    nombre = Main.pedirDato();
                    for(Producto producto : productos){
                        if(producto.nombre.equals(nombre)){
                            productos.remove(producto);
                            System.out.println("Producto elimindado");
                            break;
                        }
                        System.out.println("producto no encontrado");
                    }
                    break;
            }
        }while(opcion != 0);

        return null;
    }
    public String toString() {
        return this.nombre + "\tx" +
                this.cantidad;
    }
}
