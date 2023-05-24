package uiMain.seccion;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.producto.Factura;
import gestorAplicaciones.producto.Pedido;
import gestorAplicaciones.producto.Producto;
import uiMain.Main;

import java.util.ArrayList;

public class SeccionUsuario implements Seccion {
    int opcion = 0;
    Usuario usuario;
    Pedido pedido;
    Camion camion;
    Factura factura;
    @Override
    public void Inicio() {
        /*
        Se tienen las opciones de salir al menu pricipal, iniciar seccion de usuario,
        registar un nuevo usuario o salir al menu principal en Main
         */
        do {
            System.out.println("""
                    
                    Ingrese:
                    1. iniciar Seccion.
                    2. Registrarse.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0 ->
                    //salir
                        System.out.println("Vuelva pronto");
                case 1 ->
                    //Ingresar
                        this.ingresar();
                case 2 ->
                    //Registar usuario
                        this.registrarUsuario();
                default -> System.out.println("Opcion no valida.\n");
            }
        }while(this.opcion != 0);
    }

    @Override
    public void showMenu() {
        //mostar el tipo de acciones que puede realizar el usuario.
        do{
            System.out.println("""

                    Ingrese:
                    1. Realizar pedido.
                    2. Seguir pedido.
                    3. historial de pedido.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0 -> System.out.println("Seccion terminada. Vuelva pronto");
                case 1 -> {
                    //realizar pedido
                    this.realizarPedido();
                    this.opcion = -1;
                }
                case 2 ->
                    //seguimiento de pedido (funcionalidad)
                        this.seguirPedido();
                case 3 ->
                    //mostar historial de pedidos
                        Factura.historialFacturas(this.usuario);
                default -> System.out.println("opcion no valida.");
            }
        }while(this.opcion != 0);

    }

    private void seguirPedido() {
        //funcionalidad 4 seguir estado pedido
        long id;
        System.out.println("Ingrese ID factura: ");
        id = Long.parseLong(Main.pedirDato());
        factura = Factura.buscarFactura(id, usuario.getNombre());
        if(factura != null){
            pedido = factura.getPedido();
            camion = Camion.buscarCamion(pedido.getTipoProductos(), pedido.getVehiculo());
            pedido.verificarEstado(factura.getHoraSalida(),factura.getHoraLLegada());
            System.out.println(factura);

            if(pedido.getEstado().equals("Enviado")){
               double tiempo = pedido.tiempoTranscurrido(factura.getHoraSalida());
               String ubicacion = camion.ubicacionActual(tiempo);
               tiempo = camion.tiempoRestante(tiempo);
                System.out.println(factura.infoViaje(ubicacion, tiempo));
            }
        }
    }

    private void realizarPedido() {
        //esta funcion se encarga de gestionar la realizacion de un pedido

        //funcionalidad 1 gestion de pedido
        if(!this.gestionarPedido()) return;

        //funcionalidad 2 tarifa dinamica
        this.calcularTarifa();

        //funcionalidad 3 Calcular hora de salida y llegada
        this.calcularTiempo();

        //confirmar pedido
        this.confirmarPedido();
        if(this.opcion == 1){
            //pasar a armar pedido
            camion.setDisponible(false);
            camion.getEmpleado().setDisponible(false);
            pedido.setVehiculo(camion.getPlaca());
            pedido.setEstado("Confirmado");
            Factura.agregarFactura(this.factura);
        }
        else{
            factura.setID(factura.getID() - 1);
        }

    }

    private void calcularTiempo() {
        factura.setHoraSalida(pedido.calcularHoraSalida());
        factura.setHoraLLegada(pedido.calcularHoraLLegada(camion.calcularTiempo(),factura.getHoraSalida()));
    }

    private boolean gestionarPedido() {
        //gestion de productos y seleccion automatica de camion a utilizar y empleado a conducir
        String tipoCarga;
        pedido = new Pedido();
        //Seleccionar pais
        pedido.setPais(Main.selecionarPais());
        if(pedido.getPais() == null){
            System.out.println("Pais no seleccionado.");
            return false;
        }

        //Seleccionar ciudad de origen
        pedido.setOrigen(this.elegirCiudad("Origen"));
        if(pedido.getOrigen() == null){
            System.out.println("Ciudad no valida.");
            return false;
        }

        //seleccionar ciuddad de destino
        pedido.setDestino(this.elegirCiudad("Destino"));
        if(pedido.getDestino() == null){
            System.out.println("Ciudad no valida.");
            return false;
        }
        //seleccionar tipos de produccto a transportar
        tipoCarga = this.tipoProductos();
        if(tipoCarga == null){
            System.out.println("Seleccion no validad.");
            return false;
        }
        pedido.setTipoProductos(tipoCarga);

        pedido.setProductos(this.seleccionarProductos(tipoCarga));
        if(pedido.getProductos() == null){
            System.out.println("No has ingresado ningun producto.");
            return false;
        }
        //Seleccionar camion
        camion = Camion.seleccionarCamion(tipoCarga, pedido.getOrigen(),pedido.calcularPeso(), pedido.calcularVolumen());
        if(camion == null){
            System.out.println("Camion no disponible en el momento.");
            return false;
        }
        pedido.setVehiculo(camion.getPlaca());

        //Seleccionar empleado a conducir coche
        camion.setEmpleado(Empleado.seleccionarEmpleado(pedido.getOrigen()));
        if(camion.getEmpleado() == null){
            System.out.println("No pedemos realizar este pedido, intente mas tarde nuevamente");
            return false;
        }
        return true;
    }

    private void confirmarPedido() {
        System.out.println(factura);
        do{
            System.out.println("""
                    
                    Seleccione.
                    1. Confirmar pedido.
                    2. Cancelar pedido.
                    """);
            this.opcion = Main.getOption();
        }while(this.opcion != 1 && this.opcion != 2);
    }

    private void calcularTarifa() {
        //calcular la tarifa del pedido
        factura = new Factura();
        factura = new Factura(pedido, usuario);
        camion.setRuta(pedido.calcularRuta());
        camion.calcularCostoCamion();
        double costoPedido = camion.getCosto();
        costoPedido = camion.getEmpleado().calcularPago(costoPedido);
        factura.calcularCostoTotal(costoPedido,camion.getCapacidad());
    }

    @Override
    public void guardar() {

    }

    @Override
    public void ingresar() {
        /*
        Esta funcion pide dos datos, usuario y clave, usario puede ser el nombre o id del usario,
         y clave es la clave del usuario y comprueba que los datos ingresador correspondan
         a un usuario ya existente.
         */
        String usuario,clave;

        //pedir usuario o numero de identificacion
        System.out.println("USuario/ID: ");
        usuario = Main.pedirDato();

        //pedir clave
        System.out.println("clave: ");
        clave = Main.pedirDato();

        //si los datos son validos llama a la funcion showMenu() si no sale de la funcion

        this.usuario = this.validarInformacion(usuario,clave);
        if (this.usuario != null) {
            this.showMenu();
        }
        else{
            System.out.println("Usuario y/o clave no validas");
        }
    }

    @Override
    public  Usuario validarInformacion(String usuario, String clave) {
        /*
        Esta funcion recibe dos String y retorna un objeto de tipo Usuario
        que coincida con los datos ingresados, de lo contrario retorna null.
         */

        if(usuario != null && usuario.chars().allMatch(c -> c == ' ' || Character.isLetter(c))){
            for (Usuario u : Usuario.getUsuarios()){
                if(u.comprobarUsuario(usuario,clave)) return u;
            }
        }
        else if(usuario != null && usuario.chars().allMatch(Character::isDigit)){
            for (Usuario u : Usuario.getUsuarios()){
                if(u.comprobarUsuario(Long.parseLong(usuario),clave)) return u;
            }
        }
        return null;
    }

    public void registrarUsuario(){
        /*
        Esta funcion registra un nuervo usuario en caso de que se cumplan
        todas las condiciones
        */
        String nombre, clave, id, correo;

        //pedir nombre
        System.out.println("nombre: ");
        nombre = Main.pedirDato();
        if(!Usuario.isNombreValido(nombre)) return;

        //pedir numero de identificacion
        System.out.println("ID: ");
        id = Main.pedirDato();
        if(!Usuario.isIDValido(id)) return;

        //pedir correo
        System.out.println("correo: ");
        correo = Main.pedirDato();
        if(!Usuario.isCorreoValido(correo)) return;

        //pedir clave
        System.out.println("Clave: ");
        clave = Main.pedirDato();
        this.usuario = Usuario.crearUsuario(nombre, clave, Long.parseLong(id), correo);
        this.showMenu();
    }
    public String elegirCiudad(String ciudad) {
        //Seleccionar una ciudad
        int opcion;
        String str;
        do{
            System.out.println("""
            
            Ingrese:
            1. Ingresar ciudad de\s""" +ciudad+
                    """
                    
                    2. ver lista de ciudades.
                    0. Salir.""");

            opcion = Main.getOption();
            switch (opcion){
                case 0:
                    break;
                case 1:
                    System.out.println("Ingrese ciudad de "+ciudad+": ");
                    str = Main.pedirDato();
                    if (pedido.getPais().isCiudad(str)) return str;
                    else System.out.println("pais no encontrado.");
                    break;
                case 2:
                    pedido.getPais().mostarCiudades();
            }
        }while(opcion != 0);
        return null;
    }

    public  String tipoProductos() {
        //Selecionar el tipo de productos a transportar
        System.out.println("Seleccione el tipo de producto a transportar");
        do{
            System.out.println("""
                    
                    Ingrese:
                    1. Carga perecedera.
                    2. Carga fragil.
                    3. Carga ADR.
                    4. Carga de coches.
                    5. Carga general.
                    0. Salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 1 -> {
                    return "Frigorifico";
                }
                case 2, 5 -> {
                    return "Lona";
                }
                case 3 -> {
                    return "Cisterna";
                }
                case 4 -> {
                    return "PortaCoches";
                }
                default -> System.out.println("Opcion no valida");
            }
        }while(this.opcion != 0);

        return null;
    }
    public  ArrayList<Producto> seleccionarProductos(String tipo) {
        //ingresar los productos a transportar y caracteristicas
        ArrayList<Producto> productos = new ArrayList<Producto>();
        String nombre;
        double peso, volumen;
        long cantidad;

        do {
            System.out.println("""
    
            Ingrese:
            1. Ingresar producto.
            2. Ver productos ingresados.
            3. Confirmar productos.
            4. Eliminar producto.
            0. Descartar productos.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("nombre del producto: ");
                    nombre = Main.pedirDato();

                    System.out.println("peso del producto: ");
                    peso = Double.parseDouble(Main.pedirDato());

                    System.out.println("volumen del producto: ");
                    volumen = Double.parseDouble(Main.pedirDato());

                    System.out.println("Cantidad de ese producto: ");
                    cantidad = Long.parseLong(Main.pedirDato());

                    productos.add(Producto.crearProducto(nombre, tipo, peso, volumen, cantidad));
                    break;
                case 2:
                    for(Producto producto : productos){
                        System.out.println(producto);
                    }
                    break;
                case 3:
                    return productos;
                case 4:
                    System.out.println("nombre del producto: ");
                    nombre = Main.pedirDato();
                    for(Producto producto : productos){
                        if(producto.getNombre().equals(nombre)){
                            productos.remove(producto);
                            System.out.println("Producto elimindado");
                            break;
                        }
                        System.out.println("producto no encontrado");
                    }
                    break;
            }
        }while(this.opcion != 0);

        return null;
    }
}
