package uiMain;

public class SeccionAdministrador extends Seccion{

    @Override
    public void Inicio() {
        do{
            System.out.println("Ingrese:\n1.ingresar como administrador.\n0salir.");

        this.opcion = Seccion.getOption();
        switch (this.opcion) {
            case 0 ->
                //salir
                    System.out.println("Saliendo...");
            case 1 ->
                //Ingresar
                    this.ingresar();
            default -> System.out.println("Opcion no valida.\n");
        }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        do{
            System.out.println("Ingrese:\n1. Historial de pedidos.\n2 Pedidos en curso.\n3. Trabajadores\n4. Vehiculos\n5. Usuarios.\n0salir.");
            this.opcion = Seccion.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada.");
                    break;
                case 1:
                    /*
                    mostrar historial de pedidos
                     */
                    break;
                case 2:
                    /*
                    Pedidiso en curso
                     */
                    break;
                case 3:
                    /*
                    mlista de trabajadores y estado
                     */
                    break;
                case 4:
                    /*
                    lista de vehiculos
                     */
                    break;
                case 5:
                    /*
                    lista de usuarios
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
    public boolean validarInformacion(String usuario, String clave) {
        return false;
    }
}
