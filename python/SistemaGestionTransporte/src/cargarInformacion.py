from src.gestorAplicaciones.Camion.camion import CamionCisterna
from src.gestorAplicaciones.Camion.camion import CamionFrigorifico
from src.gestorAplicaciones.Camion.camion import CamionLona
from src.gestorAplicaciones.Camion.camion import CamionPortaCoches
from src.gestorAplicaciones.entidades.usuario import Usuario
from src.gestorAplicaciones.entidades.empleado import Empleado


class CargarInformacion:
    # cargar información de usuarios, Camiones y empleados
    ciudadesCol = ["Riohacha", "Valledupar", "Barranquilla", "Cucuta", "Monteria", "Bucaramanga",
                   "Irinida", "Medellin", "Boyaca", "Mitu", "Bogota", "Armenia", "Quibdo", "Villavicencio",
                   "Florencia", "Neiva", "Cali", "Pasto"]

    ciudadesEcu = ["Esmeralda", "Ibarra", "PortoViejo", "Quito", "Nueva Loja", "SantoDomingo",
                   "Guayaquil", "Latacunga", "Tena", "Puerto Francisco", "Riobamba", "Cuenca", "Loja", "Puyo",
                   "Macas", "Zamora"]

    ciudadesPan = ["Bocas de Toro", "Bugle", "Chiriqui", "Colon", "Veraguas", "Cocle", "Wargandi",
                   "Herrera", "Ciudad de Panama", "Embera", "Los Santos", "Darien"]

    @staticmethod
    def cargarUsuarios():
        Usuario("Juan", 1001, "juan@example.com", "0000")
        Usuario("Maria", 1002, "maria@example.com", "0000")
        Usuario("Pedro", 1003, "pedro@example.com", "0000")
        Usuario("Laura", 1004, "laura@example.com", "0000")
        Usuario("Carlos", 1005, "carlos@example.com", "0000")
        Usuario("Ana", 1006, "ana@example.com", "0000")
        Usuario("Luis", 1007, "luis@example.com", "0000")
        Usuario("Marta", 1008, "marta@example.com", "0000")
        Usuario("Andres", 1009, "andres@example.com", "0000")
        Usuario("Sofia", 1010, "sofia@example.com", "0000")
        Usuario("Javier", 1011, "javier@example.com", "0000")

    @classmethod
    def cargarEmpleados(cls):
        nombres = ["Juan", "Maria", "Pedro", "Ana", "Luis", "Carolina", "Andres", "Laura", "Carlos",
                   "Sofia", "Javier", "Marcela", "Julian", "Camila", "Camilo"]
        apellidos = ["Garcia", "Rodriguez", "Martinez", "Lopez", "Perez", "Gonzalez", "Hernandez",
                     "Torres", "Rizo", "Medina", "Vargas", "Picon"]

        clave = "xxxx"
        id = 10001
        correo = "@example.com"
        disponible = True
        nombre, apellido = "", ""
        indice = 0

        # Empleados Colombia
        for i in range(6):
            for j in range(6):
                nombre = nombres[i]
                apellido = apellidos[j]
                Empleado(nombre + " " + apellido, clave, str(id), nombre + apellido + correo, disponible,
                         "Colombia", cls.ciudadesCol[indice])
                id += 1
                indice += 1
                if indice == 18:
                    indice = 0

        # Empleados Ecuador
        id = 20001
        for i in range(6, 11):
            for j in range(6, 9):
                nombre = nombres[i]
                apellido = apellidos[j]
                Empleado(nombre + " " + apellido, clave, id, nombre + apellido + correo, disponible,
                         "Ecuador", cls.ciudadesEcu[indice])
                id += 1
                indice += 1
                if indice == 15:
                    indice = 0

        # Empleados Panamá
        id = 30001
        for i in range(11, 15):
            for j in range(9, 12):
                nombre = nombres[i]
                apellido = apellidos[j]
                Empleado(nombre + " " + apellido, clave, id, nombre + apellido + correo, disponible,
                         "Panama", cls.ciudadesPan[indice])
                id += 1
                indice += 1
                if indice == 12:
                    indice = 0

    @classmethod
    def cargarCamiones(cls):
        # Camiones Colombia
        p = "Colombia"
        i = 0

        # Generar instancias de CamionCisterna
        CamionCisterna("ABC123", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionCisterna("DEF456", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionCisterna("GHI789", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionCisterna("JKL012", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionCisterna("ABC321", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionCisterna("DEF457", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionCisterna("GHI784", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionCisterna("JKL312", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionCisterna("ABC223", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionCisterna("DEF656", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionCisterna("GHI889", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionCisterna("JKL112", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionCisterna("ABC323", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionCisterna("DEF556", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionCisterna("GHI189", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionCisterna("JKL912", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionCisterna("ABC233", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionCisterna("DEF446", p, cls.ciudadesCol[i], 8, 35)

        CamionFrigorifico("MNO345", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR678", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU901", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX234", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO145", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR178", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU101", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX234", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO245", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR278", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU201", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX234", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO445", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR378", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU301", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX234", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO545", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR478", p, cls.ciudadesCol[i], 8, 35)
        # Generar instancias de CamionLona
        CamionLona("YZA567", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionLona("BCD890", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionLona("EFG123", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionLona("HIJ456", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionLona("YZA167", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionLona("BCD190", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionLona("EFG523", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionLona("HIJ156", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionLona("YZA267", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionLona("BCD290", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionLona("EFG623", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionLona("HIJ256", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionLona("YZA367", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionLona("BCD390", p, cls.ciudadesCol[i], 8, 35)
        i += 1
        CamionLona("EFG723", p, cls.ciudadesCol[i], 17, 42)
        i += 1
        CamionLona("HIJ356", p, cls.ciudadesCol[i], 24, 48)
        i += 1
        CamionLona("YZA467", p, cls.ciudadesCol[i], 1, 20)
        i += 1
        CamionLona("BCD490", p, cls.ciudadesCol[i], 8, 35)

        # Generar instancias de CamionPortaCoches
        CamionPortaCoches("KLM789", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP012", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS345", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV678", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM189", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP112", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS445", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV178", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM289", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP212", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS545", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV278", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM389", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP312", p, cls.ciudadesCol[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS645", p, cls.ciudadesCol[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV378", p, cls.ciudadesCol[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM489", p, cls.ciudadesCol[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP412", p, cls.ciudadesCol[i], 8, 35)

        # Camiones Ecuador
        p = "Ecuador"
        # Generar instancias de CamionCisterna
        CamionCisterna("ABC1230", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionCisterna("DEF4560", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionCisterna("GHI7890", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionCisterna("JKL0120", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionCisterna("ABC3210", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionCisterna("DEF4570", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionCisterna("GHI7840", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionCisterna("JKL3120", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionCisterna("ABC2230", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionCisterna("DEF6560", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionCisterna("GHI8890", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionCisterna("JKL1120", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionCisterna("ABC3230", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionCisterna("DEF5560", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionCisterna("GHI1890", p, cls.ciudadesEcu[i], 17, 42)

        # Generar instancias de CamionFrigorifico
        CamionFrigorifico("MNO3450", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR6780", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU9010", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX2340", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO1450", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR1780", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU1010", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX2340", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO2450", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR2780", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU2010", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionFrigorifico("VWX2340", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionFrigorifico("MNO4450", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionFrigorifico("PQR3780", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionFrigorifico("STU3010", p, cls.ciudadesEcu[i], 17, 42)

        # Generar instancias de CamionLona
        CamionLona("YZA5670", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionLona("BCD8900", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionLona("EFG1230", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionLona("HIJ4560", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionLona("YZA1670", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionLona("BCD1900", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionLona("EFG5230", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionLona("HIJ1560", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionLona("YZA2670", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionLona("BCD2900", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionLona("EFG6230", p, cls.ciudadesEcu[i], 17, 42)
        i += 1
        CamionLona("HIJ2560", p, cls.ciudadesEcu[i], 24, 48)
        i += 1
        CamionLona("YZA3670", p, cls.ciudadesEcu[i], 1, 20)
        i += 1
        CamionLona("BCD3900", p, cls.ciudadesEcu[i], 8, 35)
        i += 1
        CamionLona("EFG7230", p, cls.ciudadesEcu[i], 17, 42)

        # Generar instancias de CamionPortaCoches
        CamionPortaCoches("KLM7890", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP0120", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS3450", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV6780", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM1890", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP1120", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS4450", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV1780", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM2890", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP2120", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS5450", p, cls.ciudadesEcu[i], 17, 42)
        i -= 1
        CamionPortaCoches("TUV2780", p, cls.ciudadesEcu[i], 24, 48)
        i -= 1
        CamionPortaCoches("KLM3890", p, cls.ciudadesEcu[i], 1, 20)
        i -= 1
        CamionPortaCoches("NOP3120", p, cls.ciudadesEcu[i], 8, 35)
        i -= 1
        CamionPortaCoches("QRS6450", p, cls.ciudadesEcu[i], 17, 42)

        # Camiones Panama
        p = "Panama"
        # Generar instancias de CamionCisterna
        CamionCisterna("001230", p,  cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionCisterna("004560", p,  cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionCisterna("007890", p,  cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionCisterna("000120", p,  cls.ciudadesPan[i], 24, 48)
        i += 1
        CamionCisterna("113210", p,  cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionCisterna("114570", p,  cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionCisterna("117840", p,  cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionCisterna("113120", p,  cls.ciudadesPan[i], 24, 48)
        i += 1
        CamionCisterna("222230", p,  cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionCisterna("226560", p,  cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionCisterna("228890", p,  cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionCisterna("221120", p,  cls.ciudadesPan[i], 24, 48)

        # Generar instancias de CamionFrigorifico
        CamionFrigorifico("333450", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionFrigorifico("336780", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionFrigorifico("339010", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionFrigorifico("332340", p, cls.ciudadesPan[i], 24, 48)
        i -= 1
        CamionFrigorifico("441450", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionFrigorifico("441780", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionFrigorifico("441010", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionFrigorifico("442340", p, cls.ciudadesPan[i], 24, 48)
        i -= 1
        CamionFrigorifico("552450", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionFrigorifico("552780", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionFrigorifico("552010", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionFrigorifico("552340", p, cls.ciudadesPan[i], 24, 48)

        # Generar instancias de CamionLona
        CamionLona("665670", p, cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionLona("668900", p, cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionLona("661230", p, cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionLona("664560", p, cls.ciudadesPan[i], 24, 48)
        i += 1
        CamionLona("771670", p, cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionLona("771900", p, cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionLona("775230", p, cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionLona("771560", p, cls.ciudadesPan[i], 24, 48)
        i += 1
        CamionLona("882670", p, cls.ciudadesPan[i], 1, 20)
        i += 1
        CamionLona("882900", p, cls.ciudadesPan[i], 8, 35)
        i += 1
        CamionLona("886230", p, cls.ciudadesPan[i], 17, 42)
        i += 1
        CamionLona("882560", p, cls.ciudadesPan[i], 24, 48)

        # Generar instancias de CamionPortaCoches
        CamionPortaCoches("997890", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionPortaCoches("990120", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionPortaCoches("993450", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionPortaCoches("996780", p, cls.ciudadesPan[i], 24, 48)
        i -= 1
        CamionPortaCoches("121890", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionPortaCoches("121120", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionPortaCoches("124450", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionPortaCoches("121780", p, cls.ciudadesPan[i], 24, 48)
        i -= 1
        CamionPortaCoches("562890", p, cls.ciudadesPan[i], 1, 20)
        i -= 1
        CamionPortaCoches("562120", p, cls.ciudadesPan[i], 8, 35)
        i -= 1
        CamionPortaCoches("565450", p, cls.ciudadesPan[i], 17, 42)
        i -= 1
        CamionPortaCoches("562780", p, cls.ciudadesPan[i], 24, 48)












