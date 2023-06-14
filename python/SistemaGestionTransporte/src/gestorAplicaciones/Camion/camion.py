from typing import List, Tuple

class Camion:
    camiones = {}

    def __init__(self, placa: str, pais: str, ciudadActual: str, pesoMaximo: float, capacidad: float):
        self.placa = placa
        self.pesoMaximo = pesoMaximo
        self.capacidad = capacidad
        self.costo = 0.0
        self.pais = pais
        self.disponible = True
        self.ciudadActual = ciudadActual
        self.ruta = []
        self.empleado = None

    def setPesoMaximo(self, pesoMaximo: float):
        self.pesoMaximo = pesoMaximo

    def setCapacidad(self, capacidad: float):
        self.capacidad = capacidad

    def getPlaca(self) -> str:
        return self.placa

    def setPlaca(self, placa: str):
        self.placa = placa

    def getPesoMaximo(self) -> float:
        return self.pesoMaximo

    def getCapacidad(self) -> float:
        return self.capacidad

    def getCosto(self) -> float:
        return self.costo

    def setCosto(self, costo: float):
        self.costo = costo

    def getPais(self) -> str:
        return self.pais

    def setPais(self, pais: str):
        self.pais = pais

    def isDisponible(self) -> bool:
        return self.disponible

    def setDisponible(self, disponible: bool):
        self.disponible = disponible

    def getCiudadActual(self) -> str:
        return self.ciudadActual

    def setCiudadActual(self, ciudadActual: str):
        self.ciudadActual = ciudadActual

    def getRuta(self) -> List[Tuple[str, float]]:
        return self.ruta

    def setRuta(self, ruta: List[Tuple[str, float]]):
        self.ruta = ruta

    def getEmpleado(self):
        return self.empleado

    def setEmpleado(self, empleado):
        self.empleado = empleado

    def calcularCostoCamion(self):
        pass

    def calcularTiempo(self) -> int:
        km = self.ruta[-1][1]
        return int(km / self.velocidad())

    def velocidad(self) -> float:
        pass

    def comprobarPlaca(self, placa: str) -> bool:
        return self.placa == placa

    def distanciaRecorrida(self, tiempo: float) -> float:
        return self.velocidad() * tiempo

    def tiempoRestante(self, tiempo: float) -> float:
        return self.calcularTiempo() - tiempo

    def ubicacionActual(self, tiempo: float) -> str:
        distancia = self.distanciaRecorrida(tiempo)
        aux = 0
        ciudadA = None
        ciudadB = None
        for recorrido in self.ruta:
            aux += recorrido[1]
            ciudadA = ciudadB
            ciudadB = recorrido[0]
            if aux > distancia:
                break
        return f"{ciudadA} - {ciudadB}"

 
    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        if tipoCarga == "Cisterna":
            if self.capacidad == 20 and peso <= self.pesoMaximo:
                return self.ciudadActual == origen
        elif tipoCarga == "Frigorifico":
            if self.capacidad == 35 and peso <= self.pesoMaximo and peso > 1:
                return self.ciudadActual == origen
        elif tipoCarga == "Lona":
            if self.capacidad == 42 and peso <= self.pesoMaximo and peso > 8:
                return self.ciudadActual == origen
        elif tipoCarga == "PortaCoches":
            if self.capacidad == 48 and peso <= self.pesoMaximo and peso > 17:
                return self.ciudadActual == origen
        
 

public class Camion {
    private String placa;
    private String pais;
    private boolean disponible;
    // Otros atributos y métodos de la clase

    public static Camion seleccionarCamion(String tipoCarga, String origen, double peso, double volumen) {
        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for (Camion c : camiones) {
            if (c.camionOptimo(origen, peso)) {
                return c;
            }
        }
        return null;
    }

    public static Camion buscarCamion(String tipoCarga, String placa) {
        ArrayList<? extends Camion> camiones = Camion.camiones.get(tipoCarga);
        for (Camion c : camiones) {
            if (c.comprobarPlaca(placa)) {
                return c;
            }
        }
        return null;
    }

    public static boolean verificarPlaca(String placa, String nombre) {
        String letras, num;
        if (nombre.equals("Colombia") && placa.length() == 6) {
            letras = placa.substring(0, 3);
            num = placa.substring(3);
            return letras.chars().allMatch(Character::isLetter) && num.chars().allMatch(Character::isDigit);
        } else if (nombre.equals("Panama") && placa.length() == 6 && placa.chars().allMatch(Character::isDigit)) {
            return true;
        } else if (nombre.equals("Ecuador") && placa.length() == 7) {
            letras = placa.substring(0, 3);
            num = placa.substring(3);
            return letras.chars().allMatch(Character::isLetter) && num.chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isPlacaNueva(String placa) {
        for (Map.Entry<String, ArrayList<? extends Camion>> entry : Camion.camiones.entrySet()) {
            ArrayList<? extends Camion> camiones = entry.getValue();
            for (Camion camion : camiones) {
                if (camion.placa.equals(placa)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void datosCamiones() {
        Camion.camiones.put("Cisterna", CamionCisterna.getCamiones());
        Camion.camiones.put("Frigorifico", CamionFrigorifico.getCamiones());
        Camion.camiones.put("Lona", CamionLona.getCamiones());
        Camion.camiones.put("PortaCoches", CamionPortaCoches.getCamiones());
    }
}

