package uiMain.seccion;

import gestorAplicaciones.entidades.Usuario;
import uiMain.Main;

public class SeccionAdministrador implements Seccion {
    int opcion = 0; //toma el valor de la opcion ingresado por consola
    @Override
    public void Inicio() {
        do{
        //Se tienen las opciones de ingresar como administardor o salir al menu principal en Main
            System.out.println("\nIngrese:\n1. ingresar como administrador.\n0. salir.");

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
            System.out.println("\nIngrese:\n1. Historial de pedidos.\n2. Pedidos en curso.\n3. Trabajadores.\n4. Vehiculos.\n5. Usuarios.\n0salir.");
            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada.");
                    break;
                case 1:
                    /*
                    mostrar historial de pedidos
                     */
                    break;
                case 2:
                    /*
                    Pedidiso en curso
                     */
                    break;
                case 3:
                    /*
                    lista de trabajadores y estado
                     */
                    break;
                case 4:
                    /*
                    lista de vehiculos
                     */
                    break;
                case 5:
                    /*
                    lista de usuarios
                     */
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
