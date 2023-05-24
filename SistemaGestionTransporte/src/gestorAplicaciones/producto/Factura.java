package gestorAplicaciones.producto;

import gestorAplicaciones.entidades.Usuario;
import uiMain.Main;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Representa la factura generada por un usuario al realizar un pedido.
 * Atributos
 * pedido: tipo Pedido que almacena toda la informacion del pedido.
 * usuario: representa el usuario que hizo el pedido.
 * ID: long que es unico para cada instancia de la factura.
 * costo: costo del pedido.
 * horaSalida: LocalDateTime que representa la hora de salida del pedido.
 * Hora llegada: LocalDateTime que representa la hora de llegada del pedido.
 *
 * @author Julian Salazar, Michael Garcia
 */
public class Factura implements Serializable{

    //serializador
    @Serial
    private static final long serialVersionUID = 1L;
    //atributos
    private static ArrayList<Factura> facturas = new ArrayList<Factura>();
    private static  long IDfactura = 100000000;
    private final double ganancia = 1.25;
    private Pedido pedido;
    private Usuario usuario;
    private long ID;
    private double costo;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLLegada;

    //constructor
    public Factura() {
    }

    //constrctor
    public Factura(Pedido pedido,Usuario usuario){
        super();
        this.pedido = pedido;
        this.usuario = usuario;
        this.ID = Factura.IDfactura;
        Factura.IDfactura += 1;
    }

    //metodos getter and setter
    public static long getIDfactura() {
        return IDfactura;
    }

    public static void setIDfactura(long IDfactura) {
        Factura.IDfactura = IDfactura;
    }

    public static ArrayList<Factura> getFacturas(){
        return Factura.facturas;
    }

    public static void setFacturas(ArrayList<Factura> facturas){
        Factura.facturas = facturas;
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

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getGanancia() {
        return ganancia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLLegada() {
        return horaLLegada;
    }

    public void setHoraLLegada(LocalDateTime horaLLegada) {
        this.horaLLegada = horaLLegada;
    }

    //metodos

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "Factura Nro: " + this.getID() + "\n" +
                this.pedido.toString() +
                "Vendido a:" + this.usuario.toString() +
                "Hora Salida: " + this.horaSalida.format(formato) +
                "\nHora llegada: " + this.horaLLegada.format(formato)+
                "\nCosto: $" + this.getCosto();
    }

    /**
     * Calcular costo total del pedido
     *
     * @param costoCamion el costo que trae para el camion realizar el pedido solicitado
     * @param capacidad capacidad del camion
     */
    public void calcularCostoTotal(double costoCamion, double capacidad){
        this.costo = capacidad * 0.05 * costoCamion * this.ganancia;

    }

    /**
     *
     * @param factura agragra instanica de factura al arrayList facturas
     */
    public static void agregarFactura(Factura factura){
        Factura.facturas.add(factura);
    }

    /**
     *
     * @param usuario repesenta un usario
     * @return String con la infromacion de las facturas realizadas por el usuario ingresado.
     */
    public static String historialFacturas(Usuario usuario){
        /*
            imprime toString() de los objetos de tipo Factura que tieden como atributo al Usuario
            pasado como argumento.
        */
        StringBuilder f = new StringBuilder();
        for (Factura factura : Factura.facturas){
            if(factura.getUsuario().getID() == usuario.getID()){
                Main.actualizarInformacion(factura);
                f.append(factura).append('\n');
            }
        }
        return f.toString();
    }

    /**
     *
     * @param ubicacion String con la ubicacion actual del pedido
     * @param tiempo tiempo rstante del pedido
     * @return String con la informacion de la ubicacion actual del pedio y el tiempo restante.
     */
    public String infoViaje(String ubicacion, double tiempo){
        /*
        Este metodo retorna un String Con la ubicacion actual del pedido y el tiempo restante pasados como
        argumentos.
         */
        StringBuilder info = new StringBuilder();
        int horas, minutos;
        horas = (int)  Math.floor(tiempo);
        tiempo = (tiempo - (double)horas) * 60;
        minutos = (int) Math.floor(tiempo);
        info.append("Ubicacion actual: ").append(ubicacion).append("\n");
        info.append("Tiempo restante: ").append(horas).append(" h ").append(minutos).append(" m .");
        return info.toString();
    }

    /**
     *
     * @param id id de la factura
     * @param nombre nombre de usaurio
     * @return true si la factura coincide con el id y el nombre pasdos como parametros, de lo contrario
     * retorna false.
     */
    public boolean isFactura(long id, String nombre){
        return this.ID == id && usuario.getNombre().equals(nombre);
    }

    /**
     *
     * @param id id de la factura
     * @param nombre nombre de usaurio
     * @return retorna una factura que coincidad con el id y nombre ingresados, si no se encuentra retorna null.
     */
    public static Factura buscarFactura(long id, String nombre){
        /*
        Esta funcion retorna una instancia de Factura que coincidad con los atributos id y nombre
        pasados como argumento, de lo contrario retorna null;
        */
        for (Factura factura : Factura.facturas){
            if (factura.isFactura(id,nombre)) return factura;
        }
        return null;
    }
}
