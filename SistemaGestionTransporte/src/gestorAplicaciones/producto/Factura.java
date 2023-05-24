package gestorAplicaciones.producto;

import gestorAplicaciones.entidades.Usuario;

import java.util.ArrayList;

public class Factura {
    //atributos
    private static final ArrayList<Factura> facturas = new ArrayList<Factura>();
    private static  long IDfactura = 100000000;
    private final double ganancia = 1.25;
    private Pedido pedido;
    private Usuario usuario;
    private String Fecha;
    private long ID;

    //constructor
    public Factura() {
        Factura.IDfactura += 1;
        this.ID = Factura.IDfactura;
    }

    //constrctor
    public Factura(Pedido pedido,Usuario usuario){
        super();
        this.pedido = pedido;
        this.usuario = usuario;
    }

    //metodos getter and setter

    public static long getIDfactura() {
        return IDfactura;
    }

    public static void setIDfactura(long IDfactura) {
        Factura.IDfactura = IDfactura;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getGanancia() {
        return ganancia;
    }

    //metodos

    /*@Override
    public String toString() {
        return "Factura No: " + this.ID
                + ""
    }*/

    public static void historialFacturas(Usuario usuairo){
        /*
            imprime toString() de los objetos de tipo Factura que tieden como atributo al Usuario
            pasado como argumento.
        */

        for (Factura factura : Factura.facturas){
            if(factura.getUsuario() == usuairo){
                System.out.println(factura);
            }
        }
    }
}
