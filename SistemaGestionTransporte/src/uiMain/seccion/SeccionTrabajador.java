package uiMain.seccion;

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
        usuario = Main.usurio();
        clave = Main.clave();
        if (this.validarInformacion(usuario,clave)){
            System.out.println("correcto");
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }
    }

    @Override
    public boolean validarInformacion(String usuario, String clave) {
        return false;
    }
}
