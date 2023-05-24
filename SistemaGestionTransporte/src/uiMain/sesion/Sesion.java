package uiMain.sesion;

import gestorAplicaciones.entidades.Usuario;

/**
 * @author Julian Salazar, Michael Garcia
 */
public interface Sesion {
    /**
     * Método para iniciar la sección.
     */
    public void Inicio();
    /**
     * Método para mostrar el menu de opciones de la sección.
     */
    public  void showMenu();
    /**
     * Método para pedir informacion necesaria para iniciar seccion.
     */
    public void ingresar();
    /**
     * Método para validar la información del usuario.
     *
     * @param usuario El nombre de usuario.
     * @param clave   La contraseña del usuario.
     * @return El objeto Usuario correspondiente si la información es válida, o null en caso contrario.
     */
    public Usuario validarInformacion(String usuario, String clave);
}


