package uiMain.seccion;

import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;

import uiMain.Main;

public class SeccionTrabajador implements Seccion{
    int opcion = 0;

    Empleado empleado;
    @Override
    public void Inicio() {

        //Se tienen las opciones de salir al menu pricipal e iniciar seccion de empleado,

        do {
            System.out.println("""
                    
                    Ingrese:
                    1. iniciar Seccion.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0 ->
                    //salir
                        System.out.println("Vuelva pronto");
                case 1 ->
                    //Ingresar
                        this.ingresar();
                default -> System.out.println("Opcion no valida.\n");
            }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        //mostar el tipo de acciones que puede realizar el usuario.
        try {
            System.out.println("\nBienvenido/a " + empleado.getNombre());
            do {
                System.out.println("""

                        Ingrese:
                        1. Mostar estado en la empresa.
                        2. Cambiar estado en la empresa.
                        0. salir.""");

                this.opcion = Main.getOption();
                switch (this.opcion) {
                    case 0 -> System.out.println("Seccion terminada. Vuelva pronto");
                    case 1 -> {
                        //realizar pedido
                        this.mostarEstado();
                        this.opcion = -1;
                    }
                    case 2 ->
                        //seguimiento de pedido (funcionalidad)
                            this.cambiarEstado();
                    default -> System.out.println("opcion no valida.");
                }
            } while (this.opcion != 0);
        }catch (Exception e){
            System.out.println("\n----------Error de ejecion. Intente nuevamente----------");
        }
    }

    private void cambiarEstado() {
        //Cambia el estatusAcivo de  la instancia de la clase empleado.
        this.empleado.setEstatusActivo(!this.empleado.isEstatusActivo());
        this.mostarEstado();
        System.out.println("Tu estado en la empresa ha cambiado.");
    }

    private void mostarEstado() {
        //imprime el estado del empleado de acuerdo a el atributo statusActivo
        if(this.empleado.isEstatusActivo()) System.out.println("Estado: Activo");
        else System.out.println("Estado: Inantivo");
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

        this.empleado = (Empleado) this.validarInformacion(usuario,clave);

        if (this.empleado != null){
            this.showMenu();
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }
    }

    @Override
    public Usuario validarInformacion(String empleado, String clave) {
        /*
        Esta funcion recibe dos String y retorna un objeto de tipo Usuario
        que coincida con los datos ingresados, de lo contrario retorna null.
         */

        if(empleado != null && empleado.chars().allMatch(c -> c == ' ' || Character.isLetter(c))){
            for (Empleado u : Empleado.getEmpleados()){
                if(u.comprobarUsuario(empleado,clave)) return u;
            }
        }
        else if(empleado != null && empleado.chars().allMatch(Character::isDigit)){
            for (Empleado u : Empleado.getEmpleados()){
                if(u.comprobarUsuario(Long.parseLong(empleado),clave)) return u;
            }
        }
        return null;
    }
}
