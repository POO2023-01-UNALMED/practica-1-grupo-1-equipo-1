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
    public void ingresar() {
        /*
        Esta funcion pide dos datos, usuario y clave, usario puede ser el nombre o id del empleado,
         y clave es la clave del empleado y comprueba que los datos ingresador correspondan
         a un empleado ya existente.
         */
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
