import gestorAplicaciones.camion.CamionCisterna;
import gestorAplicaciones.camion.CamionFrigorifico;
import gestorAplicaciones.camion.CamionLona;
import gestorAplicaciones.camion.CamionPortaCoches;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;

public class CargarInformacion {
    //cargar infoirmacion de usuarios, Camiones y empleados
    public static void cargarUsuarios(){
        Usuario usuario1 = new Usuario("Juan", 1001, "juan@example.com");
        Usuario usuario2 = new Usuario("Maria", 1002, "maria@example.com");
        Usuario usuario3 = new Usuario("Pedro", 1003, "pedro@example.com");
        Usuario usuario4 = new Usuario("Laura", 1004, "laura@example.com");
        Usuario usuario5 = new Usuario("Carlos", 1005, "carlos@example.com");
        Usuario usuario6 = new Usuario("Ana", 1006, "ana@example.com");
        Usuario usuario7 = new Usuario("Luis", 1007, "luis@example.com");
        Usuario usuario8 = new Usuario("Marta", 1008, "marta@example.com");
        Usuario usuario9 = new Usuario("Andres", 1009, "andres@example.com");
        Usuario usuario10 = new Usuario("Sofia", 1010, "sofia@example.com");
        Usuario usuario11 = new Usuario("Javier", 1011, "javier@example.com");
    }

    public static void cargarEmpleados(){
        Empleado empleado1 = new Empleado("Juan", "clave1", 1001, "juan@example.com", true, "Colombia","O");
        Empleado empleado2 = new Empleado("Maria", "clave2", 1002, "maria@example.com", true, "Colombia","T");
        Empleado empleado3 = new Empleado("Pedro", "clave3", 1003, "pedro@example.com", true, "Colombia","A");
        Empleado empleado4 = new Empleado("Laura", "clave4", 1004, "laura@example.com", true, "Colombia","B");
        Empleado empleado5 = new Empleado("Carlos", "clave5", 1005, "carlos@example.com", true, "Colombia","C");
        Empleado empleado6 = new Empleado("Ana", "clave6", 1006, "ana@example.com", true, "Colombia","D");
        Empleado empleado7 = new Empleado("Luis", "clave7", 1007, "luis@example.com", true, "Colombia","E");
        Empleado empleado8 = new Empleado("Marta", "clave8", 1008, "marta@example.com", true, "Colombia","F");
        Empleado empleado9 = new Empleado("Andres", "clave9", 1009, "andres@example.com", true, "Colombia","G");
        Empleado empleado10 = new Empleado("Sofia", "clave10", 1010, "sofia@example.com", true, "Colombia","H");
        Empleado empleado11 = new Empleado("Javier", "clave11", 1011, "javier@example.com", true, "Colombia","I");
    }

    public static void cargarCamiones(){
        // Generar instancias de CamionCisterna
        CamionCisterna cisterna1 = new CamionCisterna("ABC123", "Colombia", "A", 1, 20);
        CamionCisterna cisterna2 = new CamionCisterna("DEF456", "Colombia", "B", 8, 35);
        CamionCisterna cisterna3 = new CamionCisterna("GHI789", "Colombia", "C", 17, 42);
        CamionCisterna cisterna4 = new CamionCisterna("JKL012", "Colombia", "D", 24, 48);

        // Generar instancias de CamionFrigorifico
        CamionFrigorifico frigorifico1 = new CamionFrigorifico("MNO345", "Colombia", "E", 1, 20);
        CamionFrigorifico frigorifico2 = new CamionFrigorifico("PQR678", "Colombia", "F", 8, 35);
        CamionFrigorifico frigorifico3 = new CamionFrigorifico("STU901", "Colombia", "G", 17, 42);
        CamionFrigorifico frigorifico4 = new CamionFrigorifico("VWX234", "Colombia", "H", 24, 48);

        // Generar instancias de CamionLona
        CamionLona lona1 = new CamionLona("YZA567", "Colombia", "I", 1, 20);
        CamionLona lona2 = new CamionLona("BCD890", "Colombia", "O", 8, 35);
        CamionLona lona3 = new CamionLona("EFG123", "Colombia", "T", 17, 42);
        CamionLona lona4 = new CamionLona("HIJ456", "Colombia", "A", 24, 48);

        // Generar instancias de CamionPortaCoches
        CamionPortaCoches portaCoches1 = new CamionPortaCoches("KLM789", "Colombia", "B", 1, 20);
        CamionPortaCoches portaCoches2 = new CamionPortaCoches("NOP012", "Colombia", "C", 8, 35);
        CamionPortaCoches portaCoches3 = new CamionPortaCoches("QRS345", "Colombia", "D", 17, 42);
        CamionPortaCoches portaCoches4 = new CamionPortaCoches("TUV678", "Colombia", "E", 24, 48);

    }
}
