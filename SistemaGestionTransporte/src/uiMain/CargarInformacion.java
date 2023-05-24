package uiMain;

import gestorAplicaciones.camion.CamionCisterna;
import gestorAplicaciones.camion.CamionFrigorifico;
import gestorAplicaciones.camion.CamionLona;
import gestorAplicaciones.camion.CamionPortaCoches;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;

public class CargarInformacion {
    //cargar infoirmacion de usuarios, Camiones y empleados
    public static String[] ciudadesCol = {"Riohacha",	"Valledupar", "Barranquilla","Cucuta", "Monteria", "Bucaramanga",
            "Irinida", "Medellin", "Boyaca", "Mitu", "Bogota", "Armenia", "Quibdo", "Villavicencio",
            "Florencia","Neiva", "Cali", "Pasto"};

    public static String[] ciudadesEcu = {"Esmeralda", "Ibarra", "PortoViejo", "Quito", "Nueva Loja", "SantoDomingo",
            "Guayaquil", "Latacunga", "Tena", "Puerto Francisco", "Riobamba", "Cuenca", "Loja", "Puyo",
            "Macas", "Zamora"};

    public static String[] ciudadesPan = {"Bocas de Toro", "Bugle", "Chiriqui", "Colon", "Veraguas", "Cocle", "Wargandi",
            "Herrera", "Ciudad de Panama",	"Embera", "Los Santos", "Darien"};
    public static void cargarUsuarios(){
        new Usuario("Juan", 1001, "juan@example.com");
        new Usuario("Maria", 1002, "maria@example.com");
        new Usuario("Pedro", 1003, "pedro@example.com");
        new Usuario("Laura", 1004, "laura@example.com");
        new Usuario("Carlos", 1005, "carlos@example.com");
        new Usuario("Ana", 1006, "ana@example.com");
        new Usuario("Luis", 1007, "luis@example.com");
        new Usuario("Marta", 1008, "marta@example.com");
        new Usuario("Andres", 1009, "andres@example.com");
        new Usuario("Sofia", 1010, "sofia@example.com");
        new Usuario("Javier", 1011, "javier@example.com");
    }

    public static void cargarEmpleados(){
        //Colombia
        String[] nombres = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Carolina","Andres", "Laura", "Carlos",
                "Sofia", "Javier", "Marcela", "Julian", "Camila", "Camilo"};
        String[] apellidos = {"Garcia", "Rodriguez", "Martinez", "Lopez", "Perez", "Gonzalez", "Hernandez",
                "Torres", "Rizo", "Medina", "Vargas", "Picon"};

        String clave = "xxxx";
        long id = 10001;
        String correo= "@example.com";
        boolean disponible = true;
        String nombre, apellido;
        int indice = 0;
        //Empleados Colombia
        for (int i = 0; i < 6; i++){

            for (int j = 0; j < 6; j ++){
                nombre = nombres[i];
                apellido = apellidos[j];
                new Empleado(nombre+" "+apellido,clave,id,nombre+apellido+correo,disponible,
                        "Colombia",ciudadesCol[indice]);
                id++;
                indice++;
                if (indice == 18) indice = 0;
            }
        }

        //Empleados Ecuador
        id = 20001;
        for (int i = 6; i < 11; i++){

            for (int j = 6; j < 9; j ++){
                nombre = nombres[i];
                apellido = apellidos[j];
                new Empleado(nombre+" "+apellido,clave,id,nombre+apellido+correo,disponible,
                        "Ecuador",ciudadesEcu[indice]);
                id++;
                indice++;
                if (indice == 15) indice = 0;
            }
        }

        //Empleados Ecuador
        id = 30001;
        for (int i = 11; i < 15; i++){

            for (int j = 9; j < 12; j ++){
                nombre = nombres[i];
                apellido = apellidos[j];
                new Empleado(nombre+" "+apellido,clave,id,nombre+apellido+correo,disponible,
                        "Panama",ciudadesPan[indice]);
                id++;
                indice++;
                if (indice == 12) indice = 0;
            }
        }
    }

    public static void cargarCamiones(){

        //Camiones Colombia
        String p = "Colombia";
        int i = 0;
        // Generar instancias de CamionCisterna
        new CamionCisterna("ABC123", p, ciudadesCol[i++], 1, 20);
        new CamionCisterna("DEF456", p, ciudadesCol[i++], 8, 35);
        new CamionCisterna("GHI789", p, ciudadesCol[i++], 17, 42);
        new CamionCisterna("JKL012", p, ciudadesCol[i++], 24, 48);

        new CamionCisterna("ABC321", p, ciudadesCol[i++], 1, 20);
        new CamionCisterna("DEF457", p, ciudadesCol[i++], 8, 35);
        new CamionCisterna("GHI784", p, ciudadesCol[i++], 17, 42);
        new CamionCisterna("JKL312", p, ciudadesCol[i++], 24, 48);

        new CamionCisterna("ABC223", p, ciudadesCol[i++], 1, 20);
        new CamionCisterna("DEF656", p, ciudadesCol[i++], 8, 35);
        new CamionCisterna("GHI889", p, ciudadesCol[i++], 17, 42);
        new CamionCisterna("JKL112", p, ciudadesCol[i++], 24, 48);

        new CamionCisterna("ABC323", p, ciudadesCol[i++], 1, 20);
        new CamionCisterna("DEF556", p, ciudadesCol[i++], 8, 35);
        new CamionCisterna("GHI189", p, ciudadesCol[i++], 17, 42);
        new CamionCisterna("JKL912", p, ciudadesCol[i++], 24, 48);

        new CamionCisterna("ABC233", p, ciudadesCol[i++], 1, 20);
        new CamionCisterna("DEF446", p, ciudadesCol[i++], 8, 35);


        // Generar instancias de CamionFrigorifico
        i --;
        new CamionFrigorifico("MNO345", p, ciudadesCol[i--], 1, 20);
        new CamionFrigorifico("PQR678", p, ciudadesCol[i--], 8, 35);
        new CamionFrigorifico("STU901", p, ciudadesCol[i--], 17, 42);
        new CamionFrigorifico("VWX234", p, ciudadesCol[i--], 24, 48);

        new CamionFrigorifico("MNO145", p, ciudadesCol[i--], 1, 20);
        new CamionFrigorifico("PQR178", p, ciudadesCol[i--], 8, 35);
        new CamionFrigorifico("STU101", p, ciudadesCol[i--], 17, 42);
        new CamionFrigorifico("VWX234", p, ciudadesCol[i--], 24, 48);

        new CamionFrigorifico("MNO245", p, ciudadesCol[i--], 1, 20);
        new CamionFrigorifico("PQR278", p, ciudadesCol[i--], 8, 35);
        new CamionFrigorifico("STU201", p, ciudadesCol[i--], 17, 42);
        new CamionFrigorifico("VWX234", p, ciudadesCol[i--], 24, 48);

        new CamionFrigorifico("MNO445", p, ciudadesCol[i--], 1, 20);
        new CamionFrigorifico("PQR378", p, ciudadesCol[i--], 8, 35);
        new CamionFrigorifico("STU301", p, ciudadesCol[i--], 17, 42);
        new CamionFrigorifico("VWX234", p, ciudadesCol[i--], 24, 48);

        new CamionFrigorifico("MNO545", p, ciudadesCol[i--], 1, 20);
        new CamionFrigorifico("PQR478", p, ciudadesCol[i--], 8, 35);


        // Generar instancias de CamionLona
        i++;
        new CamionLona("YZA567", p, ciudadesCol[i++], 1, 20);
        new CamionLona("BCD890", p, ciudadesCol[i++], 8, 35);
        new CamionLona("EFG123", p, ciudadesCol[i++], 17, 42);
        new CamionLona("HIJ456", p, ciudadesCol[i++], 24, 48);

        new CamionLona("YZA167", p, ciudadesCol[i++], 1, 20);
        new CamionLona("BCD190", p, ciudadesCol[i++], 8, 35);
        new CamionLona("EFG523", p, ciudadesCol[i++], 17, 42);
        new CamionLona("HIJ156", p, ciudadesCol[i++], 24, 48);

        new CamionLona("YZA267", p, ciudadesCol[i++], 1, 20);
        new CamionLona("BCD290", p, ciudadesCol[i++], 8, 35);
        new CamionLona("EFG623", p, ciudadesCol[i++], 17, 42);
        new CamionLona("HIJ256", p, ciudadesCol[i++], 24, 48);

        new CamionLona("YZA367", p, ciudadesCol[i++], 1, 20);
        new CamionLona("BCD390", p, ciudadesCol[i++], 8, 35);
        new CamionLona("EFG723", p, ciudadesCol[i++], 17, 42);
        new CamionLona("HIJ356", p, ciudadesCol[i++], 24, 48);

        new CamionLona("YZA467", p, ciudadesCol[i++], 1, 20);
        new CamionLona("BCD490", p, ciudadesCol[i++], 8, 35);


        // Generar instancias de CamionPortaCoches
        i --;
        new CamionPortaCoches("KLM789", p, ciudadesCol[i--], 1, 20);
        new CamionPortaCoches("NOP012", p, ciudadesCol[i--], 8, 35);
        new CamionPortaCoches("QRS345", p, ciudadesCol[i--], 17, 42);
        new CamionPortaCoches("TUV678", p, ciudadesCol[i--], 24, 48);

        new CamionPortaCoches("KLM189", p, ciudadesCol[i--], 1, 20);
        new CamionPortaCoches("NOP112", p, ciudadesCol[i--], 8, 35);
        new CamionPortaCoches("QRS445", p, ciudadesCol[i--], 17, 42);
        new CamionPortaCoches("TUV178", p, ciudadesCol[i--], 24, 48);

        new CamionPortaCoches("KLM289", p, ciudadesCol[i--], 1, 20);
        new CamionPortaCoches("NOP212", p, ciudadesCol[i--], 8, 35);
        new CamionPortaCoches("QRS545", p, ciudadesCol[i--], 17, 42);
        new CamionPortaCoches("TUV278", p, ciudadesCol[i--], 24, 48);

        new CamionPortaCoches("KLM389", p, ciudadesCol[i--], 1, 20);
        new CamionPortaCoches("NOP312", p, ciudadesCol[i--], 8, 35);
        new CamionPortaCoches("QRS645", p, ciudadesCol[i--], 17, 42);
        new CamionPortaCoches("TUV378", p, ciudadesCol[i--], 24, 48);

        new CamionPortaCoches("KLM489", p, ciudadesCol[i--], 1, 20);
        new CamionPortaCoches("NOP412", p, ciudadesCol[i--], 8, 35);

        //Camiones Ecuador
        p = "Ecuador";
        // Generar instancias de CamionCisterna
        i ++;
        new CamionCisterna("ABC1230", p, ciudadesEcu[i++], 1, 20);
        new CamionCisterna("DEF4560", p, ciudadesEcu[i++], 8, 35);
        new CamionCisterna("GHI7890", p, ciudadesEcu[i++], 17, 42);
        new CamionCisterna("JKL0120", p, ciudadesEcu[i++], 24, 48);

        new CamionCisterna("ABC3210", p, ciudadesEcu[i++], 1, 20);
        new CamionCisterna("DEF4570", p, ciudadesEcu[i++], 8, 35);
        new CamionCisterna("GHI7840", p, ciudadesEcu[i++], 17, 42);
        new CamionCisterna("JKL3120", p, ciudadesEcu[i++], 24, 48);

        new CamionCisterna("ABC2230", p, ciudadesEcu[i++], 1, 20);
        new CamionCisterna("DEF6560", p, ciudadesEcu[i++], 8, 35);
        new CamionCisterna("GHI8890", p, ciudadesEcu[i++], 17, 42);
        new CamionCisterna("JKL1120", p, ciudadesEcu[i++], 24, 48);

        new CamionCisterna("ABC3230", p, ciudadesEcu[i++], 1, 20);
        new CamionCisterna("DEF5560", p, ciudadesEcu[i++], 8, 35);
        new CamionCisterna("GHI1890", p, ciudadesEcu[i++], 17, 42);

        // Generar instancias de CamionFrigorifico
        i --;
        new CamionFrigorifico("MNO3450", p, ciudadesEcu[i--], 1, 20);
        new CamionFrigorifico("PQR6780", p, ciudadesEcu[i--], 8, 35);
        new CamionFrigorifico("STU9010", p, ciudadesEcu[i--], 17, 42);
        new CamionFrigorifico("VWX2340", p, ciudadesEcu[i--], 24, 48);

        new CamionFrigorifico("MNO1450", p, ciudadesEcu[i--], 1, 20);
        new CamionFrigorifico("PQR1780", p, ciudadesEcu[i--], 8, 35);
        new CamionFrigorifico("STU1010", p, ciudadesEcu[i--], 17, 42);
        new CamionFrigorifico("VWX2340", p, ciudadesEcu[i--], 24, 48);

        new CamionFrigorifico("MNO2450", p, ciudadesEcu[i--], 1, 20);
        new CamionFrigorifico("PQR2780", p, ciudadesEcu[i--], 8, 35);
        new CamionFrigorifico("STU2010", p, ciudadesEcu[i--], 17, 42);
        new CamionFrigorifico("VWX2340", p, ciudadesEcu[i--], 24, 48);

        new CamionFrigorifico("MNO4450", p, ciudadesEcu[i--], 1, 20);
        new CamionFrigorifico("PQR3780", p, ciudadesEcu[i--], 8, 35);
        new CamionFrigorifico("STU3010", p, ciudadesEcu[i--], 17, 42);


        // Generar instancias de CamionLona
        i++;
        new CamionLona("YZA5670", p, ciudadesEcu[i++], 1, 20);
        new CamionLona("BCD8900", p, ciudadesEcu[i++], 8, 35);
        new CamionLona("EFG1230", p, ciudadesEcu[i++], 17, 42);
        new CamionLona("HIJ4560", p, ciudadesEcu[i++], 24, 48);

        new CamionLona("YZA1670", p, ciudadesEcu[i++], 1, 20);
        new CamionLona("BCD1900", p, ciudadesEcu[i++], 8, 35);
        new CamionLona("EFG5230", p, ciudadesEcu[i++], 17, 42);
        new CamionLona("HIJ1560", p, ciudadesEcu[i++], 24, 48);

        new CamionLona("YZA2670", p, ciudadesEcu[i++], 1, 20);
        new CamionLona("BCD2900", p, ciudadesEcu[i++], 8, 35);
        new CamionLona("EFG6230", p, ciudadesEcu[i++], 17, 42);
        new CamionLona("HIJ2560", p, ciudadesEcu[i++], 24, 48);

        new CamionLona("YZA3670", p, ciudadesEcu[i++], 1, 20);
        new CamionLona("BCD3900", p, ciudadesEcu[i++], 8, 35);
        new CamionLona("EFG7230", p, ciudadesEcu[i++], 17, 42);


        // Generar instancias de CamionPortaCoches
        i --;
        new CamionPortaCoches("KLM7890", p, ciudadesEcu[i--], 1, 20);
        new CamionPortaCoches("NOP0120", p, ciudadesEcu[i--], 8, 35);
        new CamionPortaCoches("QRS3450", p, ciudadesEcu[i--], 17, 42);
        new CamionPortaCoches("TUV6780", p, ciudadesEcu[i--], 24, 48);

        new CamionPortaCoches("KLM1890", p, ciudadesEcu[i--], 1, 20);
        new CamionPortaCoches("NOP1120", p, ciudadesEcu[i--], 8, 35);
        new CamionPortaCoches("QRS4450", p, ciudadesEcu[i--], 17, 42);
        new CamionPortaCoches("TUV1780", p, ciudadesEcu[i--], 24, 48);

        new CamionPortaCoches("KLM2890", p, ciudadesEcu[i--], 1, 20);
        new CamionPortaCoches("NOP2120", p, ciudadesEcu[i--], 8, 35);
        new CamionPortaCoches("QRS5450", p, ciudadesEcu[i--], 17, 42);
        new CamionPortaCoches("TUV2780", p, ciudadesEcu[i--], 24, 48);

        new CamionPortaCoches("KLM3890", p, ciudadesEcu[i--], 1, 20);
        new CamionPortaCoches("NOP3120", p, ciudadesEcu[i--], 8, 35);
        new CamionPortaCoches("QRS6450", p, ciudadesEcu[i--], 17, 42);

        //Camiones Ecuador
        p = "Panama";
        // Generar instancias de CamionCisterna
        i ++;
        new CamionCisterna("001230", p, ciudadesPan[i++], 1, 20);
        new CamionCisterna("004560", p, ciudadesPan[i++], 8, 35);
        new CamionCisterna("007890", p, ciudadesPan[i++], 17, 42);
        new CamionCisterna("000120", p, ciudadesPan[i++], 24, 48);

        new CamionCisterna("113210", p, ciudadesPan[i++], 1, 20);
        new CamionCisterna("114570", p, ciudadesPan[i++], 8, 35);
        new CamionCisterna("117840", p, ciudadesPan[i++], 17, 42);
        new CamionCisterna("113120", p, ciudadesPan[i++], 24, 48);

        new CamionCisterna("222230", p, ciudadesPan[i++], 1, 20);
        new CamionCisterna("226560", p, ciudadesPan[i++], 8, 35);
        new CamionCisterna("228890", p, ciudadesPan[i++], 17, 42);
        new CamionCisterna("221120", p, ciudadesPan[i++], 24, 48);

        // Generar instancias de CamionFrigorifico
        i --;
        new CamionFrigorifico("333450", p, ciudadesPan[i--], 1, 20);
        new CamionFrigorifico("336780", p, ciudadesPan[i--], 8, 35);
        new CamionFrigorifico("339010", p, ciudadesPan[i--], 17, 42);
        new CamionFrigorifico("332340", p, ciudadesPan[i--], 24, 48);

        new CamionFrigorifico("441450", p, ciudadesPan[i--], 1, 20);
        new CamionFrigorifico("441780", p, ciudadesPan[i--], 8, 35);
        new CamionFrigorifico("441010", p, ciudadesPan[i--], 17, 42);
        new CamionFrigorifico("442340", p, ciudadesPan[i--], 24, 48);

        new CamionFrigorifico("552450", p, ciudadesPan[i--], 1, 20);
        new CamionFrigorifico("552780", p, ciudadesPan[i--], 8, 35);
        new CamionFrigorifico("552010", p, ciudadesPan[i--], 17, 42);
        new CamionFrigorifico("552340", p, ciudadesPan[i--], 24, 48);


        // Generar instancias de CamionLona
        i++;
        new CamionLona("665670", p, ciudadesPan[i++], 1, 20);
        new CamionLona("668900", p, ciudadesPan[i++], 8, 35);
        new CamionLona("661230", p, ciudadesPan[i++], 17, 42);
        new CamionLona("664560", p, ciudadesPan[i++], 24, 48);

        new CamionLona("771670", p, ciudadesPan[i++], 1, 20);
        new CamionLona("771900", p, ciudadesPan[i++], 8, 35);
        new CamionLona("775230", p, ciudadesPan[i++], 17, 42);
        new CamionLona("771560", p, ciudadesPan[i++], 24, 48);

        new CamionLona("882670", p, ciudadesPan[i++], 1, 20);
        new CamionLona("882900", p, ciudadesPan[i++], 8, 35);
        new CamionLona("886230", p, ciudadesPan[i++], 17, 42);
        new CamionLona("882560", p, ciudadesPan[i++], 24, 48);


        // Generar instancias de CamionPortaCoches
        i --;
        new CamionPortaCoches("997890", p, ciudadesPan[i--], 1, 20);
        new CamionPortaCoches("990120", p, ciudadesPan[i--], 8, 35);
        new CamionPortaCoches("993450", p, ciudadesPan[i--], 17, 42);
        new CamionPortaCoches("996780", p, ciudadesPan[i--], 24, 48);

        new CamionPortaCoches("121890", p, ciudadesPan[i--], 1, 20);
        new CamionPortaCoches("121120", p, ciudadesPan[i--], 8, 35);
        new CamionPortaCoches("124450", p, ciudadesPan[i--], 17, 42);
        new CamionPortaCoches("121780", p, ciudadesPan[i--], 24, 48);

        new CamionPortaCoches("562890", p, ciudadesPan[i--], 1, 20);
        new CamionPortaCoches("562120", p, ciudadesPan[i--], 8, 35);
        new CamionPortaCoches("565450", p, ciudadesPan[i--], 17, 42);
        new CamionPortaCoches("562780", p, ciudadesPan[i--], 24, 48);
    }
}
