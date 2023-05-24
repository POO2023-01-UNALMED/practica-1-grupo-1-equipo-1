package uiMain;

import java.util.Scanner;

public abstract class Seccion {
    public int opcion = 0;
    public abstract void Inicio();
    public abstract void showMenu();
    public abstract void guardar();
    public void ingresar(){
        String usuario;
        String clave;
        System.out.println("USuario: ");
        Scanner scanner = new Scanner(System.in);
        usuario = scanner.nextLine();
        System.out.println("Clave: ");
        scanner = new Scanner(System.in);
        clave = scanner.nextLine();
        if (this.validarInformacion(usuario,clave)){
            System.out.println("correcto");
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }


    }
    public abstract boolean validarInformacion(String usuario, String clave);

    public static int getOption(){
        System.out.println("Eliga una opcion: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}


