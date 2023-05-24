package uiMain.seccion;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.entidades.Administrador;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.pais.Pais;
import uiMain.Main;

public class SeccionAdministrador implements Seccion {
    int opcion = 0; //toma el valor de la opcion ingresado por consola
    Camion camion;
    Empleado empleado;
    Pais pais;

    Administrador admin = new Administrador();
    @Override
    public void Inicio() {
        do{
        //Se tienen las opciones de ingresar como administardor o salir al menu principal en Main
            System.out.println("""

                    Ingrese:
                    1. ingresar como administrador.
                    0. salir.""");

        this.opcion = Main.getOption();
        switch (this.opcion) {
            case 0 ->
                //salir
                    System.out.println("Saliendo...");
            case 1 ->
                //Ingresar como administrador
                    this.ingresar();
            default -> System.out.println("Opcion no valida.\n");
        }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        //mostar el tipo de acciones que puede realizar el administrador.
        do{
            System.out.println("""

                    Ingrese:
                    1. Registrar nuevo empleado.
                    2. Registar nuevo vehiculo.
                    3. Historial de pedidos.
                    4. Pedidos en curso.
                    5. Trabajadores.
                    6. Vehiculos.
                    7. Usuarios.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada.");
                    break;
                case 1:
                    //Registrar  nuevo empleado
                    admin.registrarEmpleado();
                    break;
                case 2:
                    //Registar nuevo camion
                    admin.registarCamion();
                    break;
                case 3:
                    admin.estadistica();
                    break;
                case 4:
                    /*
                    lista de vehiculos
                     */
                    break;
                case 5:
                    //lista de usuarios

                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        }while(this.opcion != 0);

    }

    @Override
    public void guardar() {

    }

    @Override
    public void ingresar() {
             /*
        Esta funcion pide  la clave de dministardor ycomprueba que los datos ingresador correspondan
         a los datos del administrador..
         */
        String usuario,clave;
        usuario = "Administrador";
        System.out.println("Clave: ");
        clave = Main.pedirDato();
        if (this.validarInformacion(usuario,clave )!= null){
            System.out.println("correcto");
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }
    }

    @Override
    public Usuario validarInformacion(String usuario, String clave) {
        return null;
    }
}
