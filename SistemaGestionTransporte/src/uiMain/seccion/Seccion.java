package uiMain.seccion;

import java.util.Scanner;

public interface Seccion {
    public void Inicio();
    public  void showMenu();
    public  void guardar();
    public void ingresar();
    public boolean validarInformacion(String usuario, String clave);
}


