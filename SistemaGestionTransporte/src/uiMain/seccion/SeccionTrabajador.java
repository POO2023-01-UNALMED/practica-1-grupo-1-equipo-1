package uiMain.seccion;

import gestorAplicaciones.entidades.Usuario;
import uiMain.Main;

public class SeccionTrabajador implements Seccion{
    int opcion = 0;
    @Override
    public void Inicio() {

    }

    @Override
    public void showMenu() {

    }

    @Override
    public void guardar() {

    }

    @Override
    public void ingresar() {
        String usuario,clave;
        System.out.println("Usuario/ID: ");
        usuario = Main.pedirDato();
        System.out.println("Clave: ");
        clave = Main.pedirDato();
        if (this.validarInformacion(usuario,clave) != null){
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
