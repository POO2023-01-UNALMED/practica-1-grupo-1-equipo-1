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
        

class Camion:
    camiones = {}

    @staticmethod
    def seleccionar_camion(tipo_carga, origen, peso, volumen):
        camiones = Camion.camiones.get(tipo_carga)
        for c in camiones:
            if c.camion_optimo(origen, peso):
                return c
        return None

    @staticmethod
    def buscar_camion(tipo_carga, placa):
        camiones = Camion.camiones.get(tipo_carga)
        for c in camiones:
            if c.comprobar_placa(placa):
                return c
        return None

    @staticmethod
    def verificar_placa(placa, nombre):
        letras, num = '', ''

        if nombre == "Colombia" and len(placa) == 6:
            letras = placa[:3]
            num = placa[3:]
            return all(c.isalpha() for c in letras) and all(c.isdigit() for c in num)

        elif nombre == "Panama" and len(placa) == 6 and placa.isdigit():
            return True

        elif nombre == "Ecuador" and len(placa) == 7:
            letras = placa[:3]
            num = placa[3:]
            return all(c.isalpha() for c in letras) and all(c.isdigit() for c in num)

        return False

    @staticmethod
    def is_placa_nueva(placa):
        for camiones in Camion.camiones.values():
            for camion in camiones:
                if camion.placa == placa:
                    return False
        return True

    @staticmethod
    def datos_camiones():
        Camion.camiones["Cisterna"] = CamionCisterna.get_camiones()
        Camion.camiones["Frigorifico"] = CamionFrigorifico.get_camiones()
        Camion.camiones["Lona"] = CamionLona.get_camiones()
        Camion.camiones["PortaCoches"] = CamionPortaCoches.get_camiones()


class CamionCisterna(Camion):
    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones cisterna en Python
        pass


class CamionFrigorifico(Camion):
    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones frigoríficos en Python
        pass


class CamionLona(Camion):
    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones con lona en Python
        pass


class CamionPortaCoches(Camion):
    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones porta coches en Python
        pass
