from typing import List, Tuple
from abc import ABC, abstractmethod

class Camion(ABC):
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

    @abstractmethod
    def calcularCostoCamion(self):
        pass

    def calcularTiempo(self) -> int:
        km = self.ruta[-1][1]
        return int(km / self.velocidad())

    @abstractmethod
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

    @abstractmethod
    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        pass


class CamionCisterna(Camion):
    def calcularCostoCamion(self):
        pass

    def velocidad(self) -> float:
        pass

    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        if tipoCarga == "Cisterna":
            if self.capacidad == 20 and peso <= self.pesoMaximo:
                return self.ciudadActual == origen
        return False

    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones cisterna en Python
        pass


class CamionFrigorifico(Camion):
    def calcularCostoCamion(self):
        pass

    def velocidad(self) -> float:
        pass

    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        if tipoCarga == "Frigorifico":
            if self.capacidad == 35 and peso <= self.pesoMaximo and peso > 1:
                return self.ciudadActual == origen
        return False

    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones frigoríficos en Python
        pass


class CamionLona(Camion):
    def calcularCostoCamion(self):
        pass

    def velocidad(self) -> float:
        pass

    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        if tipoCarga == "Lona":
            if self.capacidad == 42 and peso <= self.pesoMaximo and peso > 8:
                return self.ciudadActual == origen
        return False

    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones con lona en Python
        pass


class CamionPortaCoches(Camion):
    def calcularCostoCamion(self):
        pass

    def velocidad(self) -> float:
        pass

    def camionOptimo(self, tipoCarga: str, origen: str, peso: float) -> bool:
        if tipoCarga == "PortaCoches":
            if self.capacidad == 48 and peso <= self.pesoMaximo and peso > 17:
                return self.ciudadActual == origen
        return False

    @staticmethod
    def get_camiones():
        # Implementación para obtener los camiones porta coches en Python
        pass

class CamionFactory:
    @staticmethod
    def crear_camion(tipo: str, placa: str, pais: str, ciudad_actual: str, peso_maximo: float, capacidad: float):
        if tipo == "Cisterna":
            return CamionCisterna(placa, pais, ciudad_actual, peso_maximo, capacidad)
        elif tipo == "Frigorifico":
            return CamionFrigorifico(placa, pais, ciudad_actual, peso_maximo, capacidad)
        elif tipo == "Lona":
            return CamionLona(placa, pais, ciudad_actual, peso_maximo, capacidad)
        elif tipo == "PortaCoches":
            return CamionPortaCoches(placa, pais, ciudad_actual, peso_maximo, capacidad)
        else:
            return None

