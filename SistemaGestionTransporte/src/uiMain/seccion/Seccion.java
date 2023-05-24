package uiMain.seccion;

import gestorAplicaciones.entidades.Usuario;

import java.util.Scanner;

public interface Seccion {
    public void Inicio();
    public  void showMenu();
    public  void guardar();
    public void ingresar();
    public Usuario validarInformacion(String usuario, String clave);
}


