package uiMain.seccion;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.entidades.Administrador;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.pais.Pais;
import uiMain.Main;

import javax.sound.midi.Soundbank;

public class SeccionAdministrador implements Seccion {
    int opcion = 0; //toma el valor de la opcion ingresado por consola
    Camion camion;
    Empleado empleado;
    Pais pais;

    Administrador admin = new Administrador();
    @Override
    public void Inicio() {
        do{
        //Se tienen las opciones de ingresar como administardor o salir al menu principal en Main
            System.out.println("""

                    Ingrese:
                    1. ingresar como administrador.
                    0. salir.""");

        this.opcion = Main.getOption();
        switch (this.opcion) {
            case 0 ->
                //salir
                    System.out.println("Saliendo...");
            case 1 ->
                //Ingresar como administrador
                    this.ingresar();
            default -> System.out.println("Opcion no valida.\n");
        }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        //mostar el tipo de acciones que puede realizar el administrador.
        do{
            System.out.println("""

                    Ingrese:
                    1. Registrar nuevo empleado.
                    2. Registar nuevo vehiculo.
                    3. Estadisticas.
                    4. Vehiculos.
                    5. Usuarios.
                    6. Empleados.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada.");
                    break;
                case 1:
                    //Registrar  nuevo empleado
                    this.nuevoEmpleado();
                    break;
                case 2:
                    //Registar nuevo camion
                    this.nuevoCamion();
                    break;
                case 3:
                    admin.estadistica();
                    break;
                case 4:
                    //lista de vehiculos
                    this.Camiones();

                    break;
                case 5:
                    //lista de usuarios
                    this.Usuarios();
                    break;
                case 6:
                    //lista de mepleados
                    this.Empleados();
                default:
                    System.out.println("opcion no valida.");
            }
        }while(this.opcion != 0);

    }

    private void Empleados() {
        System.out.println(admin.mostrarEmpleados());
    }

    private void Usuarios() {
        System.out.println(admin.mostarUsuarios());
    }

    private void Camiones() {
        System.out.println(admin.mostarCamiones());
    }

    @Override
    public void ingresar() {
             /*
        Esta funcion pide  la clave de dministardor ycomprueba que los datos ingresador correspondan
         a los datos del administrador..
         */
        String usuario,clave;
        usuario = "Administrador";
        System.out.println("Clave: ");
        clave = Main.pedirDato();
        if (admin.getClave().equals(clave)) {
            System.out.println("Ingresando como administrador...");
            this.showMenu();
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }
    }

    @Override
    public Usuario validarInformacion(String usuario, String clave) {
        return null;
    }
    public void nuevoEmpleado() {
        String nombre, clave, id, correo, ciudadActual;

        pais = Main.selecionarPais();

        //pedir nombre
        System.out.println("nombre: ");
        nombre = Main.pedirDato();
        if(!Empleado.isNombreValido(nombre)) return;

        //pedir numero de identificacion
        System.out.println("ID: ");
        id = Main.pedirDato();
        if(!Empleado.isIDValido(id)) return;

        //pedir correo
        System.out.println("correo: ");
        correo = Main.pedirDato();
        if(!Empleado.isCorreoValido(correo)) return;

        //pedir clave
        System.out.println("Clave: ");
        clave = Main.pedirDato();

        System.out.println("ciudad actual del empleado: ");
        do{
            ciudadActual = Main.pedirDato();
            if(pais.isCiudad(ciudadActual)) break;
            System.out.println("Ciudad no encontrada.");
            System.out.println("\n\"ciudad actual del empleado: \"");
        }while(ciudadActual!=null);

        if(ciudadActual==null) return;

        admin.registrarEmpleado(nombre, clave, id, correo,pais.getNombre(), ciudadActual);
    }

    public void nuevoCamion() {
        String placa, ciudadActual;
        double pesoMaximo = 0, capacidad = 0;

        pais = Main.selecionarPais();

        if (pais == null) return;

        System.out.println("Placa: ");
        placa = Main.pedirDato();
        placa = placa.toUpperCase();
        if(!Camion.verificarPlaca(placa, pais.getNombre())){
            System.out.println("""
            
            Placa no valida
            Colombia: XXX000
            Panama: 000000
            Ecuador: XXX0000
            """);
            return;
        }
        if(!Camion.isPlacaNueva(placa)){
            System.out.println("Placa ya existente");
            return;
        }

        do {
            System.out.println("""
                
                Vehiculo tipo:
                1. Liviano 1tn.
                2. Mediano 8tn.
                3. Semipesado 17tn.
                4. Pesado 24tn.
                0. cancelar.
                """);
            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 1 -> {
                    pesoMaximo = 1;
                    capacidad = 20;
                }
                case 2 -> {
                    pesoMaximo = 8;
                    capacidad = 35;
                }
                case 3 -> {
                    pesoMaximo = 17;
                    capacidad = 42;
                }
                case 4 -> {
                    pesoMaximo = 24;
                    capacidad = 48;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opcion no valida");
            }
        }while(this.opcion != 0);


        do {
            System.out.println("""
                
                Tipo de vehiculo:
                1. Cisterna.
                2. Frigorifico.
                3. Lona.
                4. PortaCoches.
                0. Cancelar.
                """);

            System.out.println("ciudad actual del Camion: ");
            do{
                ciudadActual = Main.pedirDato();
                if(pais.isCiudad(ciudadActual)) break;
                System.out.println("Ciudad no encontrada.");
                System.out.println("\n\"ciudad actual del empleado: \"");
            }while(ciudadActual!=null);

            if(ciudadActual==null) return;

            switch (this.opcion) {
                case 1,2,3,4 -> {
                    admin.registarCamion(this.opcion, placa,pais.getNombre(), ciudadActual,pesoMaximo,capacidad);
                    return;
                }
                default -> System.out.println("Opcion no valida");
                case 0 -> {
                    return;
                }
            }
        }while (this.opcion != 0);
    }
}
