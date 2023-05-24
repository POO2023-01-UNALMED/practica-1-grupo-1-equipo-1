package uiMain.seccion;

import gestorAplicaciones.camion.*;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.pais.Pais;
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
                    4. PQRS.
                    0. salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion) {
                case 0:
                    System.out.println("Seccion terminada. Vuelva pronto");
                    break;
                case 1:
                    //realizar pedido
                    this.realizarPedido();
                    this.opcion = -1;
                    
                    break;
                case 2:
                    /*
                    seguimiento de pedido (funcionalidad)
                    this.seguirPedido();
                     */
                    break;
                case 3:
                    //mostar historial de pedidos
                    Factura.historialFacturas(this.usuario);
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

    private void realizarPedido() {
        //funcionalidad 1 gestion de productos y seleccion automatica de camion a utilizar y auto a emplear
        //esta funcion se encarga de gestionnar la realizacion de un pedido
        String tipoCarga;
        pedido = new Pedido();
        //Seleccionar pais
        pedido.setPais(this.selecionarPais());
        if(pedido.getPais() == null){
            System.out.println("Pais no seleccionado.");
            return;
        }

        //Seleccionar ciudad de origen
        pedido.setOrigen(this.elegirCiudad(pedido.getPais(),"Origen"));
        if(pedido.getOrigen() == null){
            System.out.println("Ciudad no valida.");
            return;
        }

        //seleccionar ciuddad de destino
        pedido.setDestino(this.elegirCiudad(pedido.getPais(),"Destino"));
        if(pedido.getDestino() == null){
            System.out.println("Ciudad no valida.");
            return;
        }
        //seleccionar tipos de produccto a transportar
        tipoCarga = this.tipoProductos();
        if(tipoCarga == null){
            System.out.println("Seleccion no validad.");
            return;
        }
        this.seleccionarProductos(tipoCarga);
        if(pedido.getProductos() == null){
            System.out.println("No has ingresado ningun producto.");
            return;
        }
        //Seleccionar camion
        camion = this.seleccionarCamion(tipoCarga);
        if(camion == null){
            System.out.println("Camion no disponible por el momento.");
            return;
        }
        //Seleccionar empleado a conducir coche
        camion.setEmpleado(this.seleccionarEmpleado(pedido.getOrigen()));
        if(camion.getEmpleado() == null){
            System.out.println("No pedemos realizar este pedido, intente mas tarde nuevamente");
            return;
        }
        //funcionalidad 2 tarifa dinamica
        this.calcularTarifa();

        //confirmar pedido
        this.confirmarPedido();
        if(this.opcion == 1){
            //pasar a armar pedido
            camion.setDisponible(false);
            camion.getEmpleado().setDisponible(false);
            Factura.agregarFactura(this.factura);
            /*
            1. Encontar hora de salida y hora de llegada
            2. Buscar camion mismas caracteristicas en ciudad destino y conductor y enviar a origen
             */
        }
        else{
            factura.setID(factura.getID() - 1);

        }

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
        }while(this.opcion != 0);
    }

    private void calcularTarifa() {
        //calcular la tarifa del pedido
        factura = new Factura();
        factura = new Factura(pedido, usuario);
        camion.setRuta(pedido.calcularRuta());
        double costoCamion = camion.calcularCostoCamion();
        factura.calcularCostoTotal(costoCamion,camion.getCapacidad());
    }

    private Empleado seleccionarEmpleado(String origen) {
        //buscar un empleado disponible y que se encuentre en la ciudad de origen
        for(Empleado empleado : Empleado.getEmpleados()){
            if(empleado.elegirConductor(origen)) return empleado;
        }
        return null;
    }

    public Camion seleccionarCamion(String tipoCarga) {
        //selecccionar camion disponible para realizar pedido
        double peso = this.pedido.calcularPeso();
        double volumen = this.pedido.calcularVolumen();
        switch (tipoCarga) {
            case "perecedera" -> {
                for (CamionFrigorifico c : CamionFrigorifico.getCamiones()) {
                    if (c.elegirCamion(pedido.getOrigen(), peso, volumen)) return c;
                }
            }
            case "fragil", "general" -> {
                for (CamionLona c : CamionLona.getCamiones()) {
                    if (c.elegirCamion(pedido.getOrigen(), peso, volumen)) return c;
                }
            }
            case "ADR" -> {
                for (CamionCisterna c : CamionCisterna.getCamiones()) {
                    if (c.elegirCamion(pedido.getOrigen(), peso, volumen)) return c;
                }
            }
            case "coches" -> {
                for (CamionPortaCoches c : CamionPortaCoches.getCamiones()) {
                    if (c.elegirCamion(pedido.getOrigen(), peso, volumen)) return c;
                }
            }
        }
        return null;
    }

    private void seleccionarProductos(String tipo) {
        //ingresar los productos a transportar y caracteristicas
        String nombre;
        double peso, volumen;
        long cantidad;

        do {
            System.out.println("""
    
            Ingrese:
            1. Ingresr producto.
            2. Ver productos ingresados.
            0. Salir.""");

            switch (opcion) {
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

                    //this.pedido.setProductos(this.pedido.getProductos().add(new Producto(nombre,tipo,peso,volumen,cantidad)));
                    ArrayList<Producto> productos = this.pedido.getProductos();
                    Producto producto = new Producto(nombre,tipo,peso,volumen,cantidad);
                    productos.add(producto);
                    this.pedido.setProductos(productos);
                    break;
            }
        }while(this.opcion != 0);
    }

    private String tipoProductos() {
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
            switch (opcion) {
                case 1 -> {
                    return "perecedera";
                }
                case 2 -> {
                    return "fragil";
                }
                case 3 -> {
                    return "ADR";
                }
                case 4 -> {
                    return "coches";
                }
                case 5 -> {
                    return "general";
                }
                default -> System.out.println("Opcion no valida");
            }
        }while(this.opcion != 0);

        return null;
    }

    private String elegirCiudad(Pais pais,String ciudad) {
        //Seleccionar una ciudad
        String str;
        do{
            System.out.println("""
            
            Ingrese:
            1. Ingresar ciudad de "+ciudad+".
            2. ver lista de ciudades.
            0. Salir.""");

            this.opcion = Main.getOption();
            switch (opcion){
                case 0:
                    break;
                case 1:
                    System.out.println("Ingrese ciudad de "+ciudad+": ");
                    str = Main.pedirDato();
                    if (pais.isCiudad(str)) return str;
                    else System.out.println("pais no encontrado.");
                    break;
                case 2:
                    pais.mostarCiudades();
            }
        }while(this.opcion != 0);

        this.opcion = -1;
        return null;
    }

    private Pais selecionarPais() {
        //seleccionar pais donde se realizara el transporte del pedido.
        do{
            System.out.println("""

                    Ingrese:
                    1. Colombia.
                    2. Ecuador.
                    3. Panama.
                    0. Salir.""");

            this.opcion = Main.getOption();
            switch (this.opcion){
                case 0:
                    break;
                case 1:
                    return Pais.COLOMBIA;
                case 2:
                    return Pais.ECUADOR;
                case 3:
                    return Pais.PANAMA;
                default:
                    System.out.println("Opcion no valida.");
            }

        }while (this.opcion != 0);
        this.opcion = -1;
        return null;
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
        if(!this.isNombreValido(nombre)) return;

        //pedir numero de identificacion
        System.out.println("ID: ");
        id = Main.pedirDato();
        if(!this.isIDValido(id)) return;

        //pedir correo
        System.out.println("correo: ");
        correo = Main.pedirDato();
        if(!this.isCorreoValido(correo)) return;

        //pedir clave
        System.out.println("Clave: ");
        clave = Main.pedirDato();
        this.usuario = Usuario.crearUsuario(nombre, clave, Long.parseLong(id), correo);
        this.showMenu();

    }
    private boolean isNombreValido(String nombre){
        /*
        Esta funcion retorna false si el argumento que se ingresa no contione espacio y caracteres
        alfabetiscos o si ya es un atributo de nombre de un objeto de tipo usuario,
        de lo contrario retorna true.
         */
        if(nombre == null || !nombre.chars().allMatch(c -> c == ' ' || Character.isLetter(c))){
            System.out.println("El nombre solo debe tener caracteres alfanumericos.");
            return false;
        }
        if(Usuario.comprobarNombre(nombre)){
            System.out.println("nombre ya registrado.");
            return false;
        }
        return true;

    }

    private boolean isIDValido(String id){
        /*
        Esta funcion retorna false si el argumento que se ingresa no contione solo caracteres
        numericos o si ya es un atributo de ID de un objeto de tipo usuario,
        de lo contrario retorna true.
         */
        if(id == null || !id.chars().allMatch(Character::isDigit)){
            System.out.println("la identificacion debe contener solo caracteres numericos.");
            return false;
        }
        if(Usuario.comprobarID(Long.parseLong(id))){
            System.out.println("numero de identificacion ya registrado.");
            return false;
        }
        return true;
    }

    private boolean isCorreoValido(String correo){
        /*
        Esta funcion retorna false si el argumento que se ingresa contiene el caracter '@' o si
        solo contiene en la ultima posicion, de lo contrario retorna true.
         */
        if(!correo.contains("@") || correo.charAt(correo.length()-1) == '@'){
            System.out.println("correo no valido.");
            return false;
        }
        if(Usuario.comprobarCorreo(correo)){
            System.out.println("correo ya registrado.");
            return false;
        }
        return true;
    }
}
