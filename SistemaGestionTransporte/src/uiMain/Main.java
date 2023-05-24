package uiMain;

import uiMain.seccion.Seccion;
import uiMain.seccion.SeccionAdministrador;
import uiMain.seccion.SeccionTrabajador;
import uiMain.seccion.SeccionUsuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //inicio
        System.out.println("--------------------Bienvenidos a transportes ltda.--------------------");
        int opcion;
        Seccion seccion;

        //inicio de seccion
        do {
            System.out.println("Presione:\n1. Ingresar como usuario\n2. Ingresar como trabajador\n3. Ingresar como administrador\n0. Salir");
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
        System.out.println("Eliga una opcion: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String pedirDato(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

   /* public static String clave(){
        System.out.println("Clave: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }*/
}
