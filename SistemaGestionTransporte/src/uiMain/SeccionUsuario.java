package uiMain;

import java.util.Scanner;

public class SeccionUsuario implements Seccion {
    int opcion = 0;
    @Override
    public void Inicio() {
        //int opcion = 0;
        do {
            System.out.println("Ingrese:\n1.iniciar Seccion.\n2 Registrarse.\n0salir.");
            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0 ->
                    //salir
                        System.out.println("Vuelva pronto");
                case 1 ->
                    //Ingresar
                        this.ingresar();
                case 2 ->
                    //Regidtar usuario
                        this.registrarUSuario();
                default -> System.out.println("Opcion no valida.\n");
            }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        do{
            System.out.println("Ingrese:\nRealizar pedido.\n2 Seguir pedido.\n3. historial de pedido.\n4.PQRS.\n0salir.");
            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada.");
                    break;
                case 1:
                    /*
                    Realizar pedido
                     */
                    break;
                case 2:
                    /*
                    seguimiento de pedido (funcionalidad)
                     */
                    break;
                case 3:
                    /*
                    mostar historial de pedidos
                     */
                    break;
                case 4:
                    /*
                    //funcionalidad PQRS
                     */
                    break;
                default:
                    System.out.println("opcion no valida.");
            }
        }while(this.opcion != 0);

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

    public void registrarUSuario(){
        /*
        1.Pedir datos.
        2.Verificar informacion
        3.Crear usuario
         */
    }
}
