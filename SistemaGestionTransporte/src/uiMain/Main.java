package uiMain;

import uiMain.seccion.Seccion;
import uiMain.seccion.SeccionAdministrador;
import uiMain.seccion.SeccionTrabajador;
import uiMain.seccion.SeccionUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        menu para ingresar:
        como usario si se ingresa 1 por consola.
        como empleado si se ingresa 2 por consola.
        como administaror ssi se ingresa 3 por consola.
        si se ingresa 0 se cieera el programa.
         */
        System.out.println("--------------------Bienvenidos a transportes ltda.--------------------");
        int opcion;
        Seccion seccion;

        //inicio de seccion
        do {
            System.out.println("\nPresione:\n1. Ingresar como usuario\n2. Ingresar como empleado\n3. Ingresar como administrador\n0. Salir");
            opcion = Main.getOption();
            switch (opcion) {
                case 0 ->
                    //cerrar programa
                        System.out.println("Vuelva pronto");
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
        }while (opcion != 0);
    }

    public static int getOption() {
        //esta funcion dide que se ingrese un numero por consola y retorna el dato tipo int.
        System.out.println("Eliga una opcion: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String pedirDato(){
        //Esta funcion pide un dato por conosla y lo retorna comp un String
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
