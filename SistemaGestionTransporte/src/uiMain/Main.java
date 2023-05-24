package uiMain;

import baseDatos.Serial.Deserializador;
import baseDatos.Serial.Serializador;
import gestorAplicaciones.camion.Camion;
import gestorAplicaciones.pais.Pais;
import gestorAplicaciones.producto.Factura;
import gestorAplicaciones.producto.Pedido;
import uiMain.seccion.Seccion;
import uiMain.seccion.SeccionAdministrador;
import uiMain.seccion.SeccionTrabajador;
import uiMain.seccion.SeccionUsuario;

import java.util.Scanner;



/**
 *Iniciar programa y funciones globales usadas en todos los metodos
 *
 * @author Julian Salazar, Michael Garcia
 *
 */
public class Main {
    public static void main(String[] args) {

        /*
        menu para ingresar:
        como usario si se ingresa 1 por consola.
        como empleado si se ingresa 2 por consola.
        como administaror ssi se ingresa 3 por consola.
        si se ingresa 0 se cieera el programa.
         */

        /*CargarInformacion.cargarUsuarios();
        CargarInformacion.cargarCamiones();
        CargarInformacion.cargarEmpleados();*/

        try {
            Deserializador.deserializar();
            Camion.datosCamiones();

            System.out.println("--------------------Bienvenidos a Transportes ltda.--------------------");
            int opcion;
            Seccion seccion;

            //inicio de seccion
            do {
                System.out.println("""
                                        
                        Presione:
                        1. Ingresar como usuario
                        2. Ingresar como empleado
                        3. Ingresar como administrador
                        0. Salir""");
                opcion = Main.getOption();
                switch (opcion) {
                    case 0 -> {
                        //cerrar programa
                        System.out.println("Vuelva pronto!");
                        Serializador.serializar();
                    }
                    case 1 -> {
                        //Ingrese como usuario
                        seccion = new SeccionUsuario();
                        seccion.Inicio();
                    }
                    case 2 -> {
                        //Igreso como trabajador
                        seccion = new SeccionTrabajador();
                        seccion.Inicio();
                    }
                    case 3 -> {
                        //Ingreso como administrador
                        seccion = new SeccionAdministrador();
                        seccion.Inicio();
                    }
                    default -> System.out.println("Opcion no valida.\n");
                }
            } while (opcion != 0);
        }catch (Exception e){
            System.out.println("\n---------------Error de ejecucion.--------------");
            Serializador.serializar();
        }
    }

    /**
     * Pide por consola un numero y lo retorna el valor ingresado como un int
     *
     * @return int de la informacion ingresada por consola
     */
    public static int getOption() {

        System.out.println("Eliga una opcion: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Pide por consola un numero y retorna el valor como String
     * @return String de la informacion ingresada por consola.
     */
    public static String pedirDato(){
        //Esta funcion pide un dato por conosla y lo retorna comp un String
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     *
     * @param factura parametro una instancia de Factura que va a ser modificado
     *
     *actualiza el atributo estado de la instancia Pedido, atribtu de factura.
     */
    public static void actualizarInformacion(Factura factura){

        //funcionalidad 5: actualizar informacionede envio

        String estadoAnterior;

        if(!factura.getPedido().getEstado().equals("Entregado")) {
            Pedido pedido = factura.getPedido();
            estadoAnterior = pedido.getEstado();
            pedido.verificarEstado(factura.getHoraSalida(), factura.getHoraLLegada());
            if (!pedido.getEstado().equals(estadoAnterior) && pedido.getEstado().equals("Entregado")) {
                Camion camion = Camion.buscarCamion(pedido.getTipoProductos(), pedido.getVehiculo());
                camion.setDisponible(true);
                camion.setCiudadActual(pedido.getDestino());
                camion.getEmpleado().setDisponible(true);
                camion.getEmpleado().setCiudadActual(pedido.getDestino());
            }
        }
    }

    /**
     * Permite al usuario seleccionar el país donde se realizará el transporte del pedido.
     *
     * @return El país seleccionado (Pais.COLOMBIA, Pais.ECUADOR o Pais.PANAMA) o null si se elige salir.
     */
    public  static Pais selecionarPais() {
        //seleccionar pais donde se realizara el transporte del pedido.
        int opcion;
        do{
            System.out.println("""

                    Ingrese:
                    1. Colombia.
                    2. Ecuador.
                    3. Panama.
                    0. Salir.""");

            opcion = Main.getOption();
            switch (opcion){
                case 0:
                    break;
                case 1:
                    return Pais.COLOMBIA;
                case 2:
                    return Pais.ECUADOR;
                case 3:
                    return Pais.PANAMA;
                default:
                    System.out.println("Opcion no valida.");
            }

        }while (opcion != 0);
        return null;
    }
}
