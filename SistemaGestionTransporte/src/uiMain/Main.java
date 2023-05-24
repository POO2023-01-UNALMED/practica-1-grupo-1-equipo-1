package uiMain;

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
            opcion = Seccion.getOption();
            switch (opcion) {
                case 0:
                    //cerrar programa
                    System.out.println("Vuelva pronto");
                    break;
                case 1:
                    //Ingrese como usuario

                    seccion = new SeccionUsuario();
                    seccion.Inicio();
                    break;
                case 2:
                    //Igreso como trabajador
                    /*
                    Validar ingreso
                    menu trabajador
                     */
                    break;
                case 3:
                    //Ingreso como administrador
                    /*
                    Validar ingreso
                    menu administrador
                     */
                    break;
                default:
                    System.out.println("Opcion no valida.\n");
            }
        }while (opcion != 0);
    }
}
