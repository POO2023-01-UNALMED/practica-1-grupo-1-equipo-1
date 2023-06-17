from typing import List, Tuple
from abc import ABC, abstractmethod

from src.gestorAplicaciones.Camion.CamionCisterna import CamionCisterna
from src.gestorAplicaciones.Camion.CamionFrigorifico import CamionFrigorifico
from src.gestorAplicaciones.Camion.CamionLona import CamionLona
from src.gestorAplicaciones.Camion.CamionPortaCoches import CamionPortaCoches


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

    def calcularTiempo(self):
        km = self.ruta[-1][1]
        return int(km / self.velocidad())

    @abstractmethod
    def velocidad(self):
        pass

    def comprobarPlaca(self, placa):
        return self.placa == placa

    def distanciaRecorrida(self, tiempo):
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

    def camionOptimo(self, origen, peso):
        if self.capacidad == 20 and peso <= self.getPesoMaximo():
            return self.ciudadActual == origen
        elif self.capacidad == 35 and self.getPesoMaximo() >= peso > 1:
            return self.ciudadActual == origen
        elif self.capacidad == 42 and self.getPesoMaximo() >= peso > 8:
            return self.ciudadActual == origen
        elif self.capacidad == 48 and self.getPesoMaximo() >= peso > 17:
            return self.ciudadActual == origen
        else:
            return False

    @classmethod
    def seleccionarCamion(cls, tipoCarga, origen, peso):
        camiones = cls.camiones[tipoCarga]
        for camion in camiones:
            if camion.camionOptimo(origen, peso):
                return camion
        return None

    @classmethod
    def buscarCamion(cls, tipoCarga, placa):
        camiones = cls.camiones[tipoCarga]
        for camion in camiones:
            if camion.comprobarPlaca(placa):
                return camion
        return None

    @staticmethod
    def verificarPlaca(placa, nombre):
        letras, num = '', ''
        if nombre == "Colombia" and len(placa) == 6:
            letras = placa[:3]
            num = placa[3:]
            return letras.isalpha() and num.isdigit()
        elif nombre == "Panama" and len(placa) == 6 and placa.isdigit():
            return True
        elif nombre == "Ecuador" and len(placa) == 7:
            letras = placa[:3]
            num = placa[3:]
            return letras.isalpha() and num.isdigit()
        return False

    @classmethod
    def isPlacaNueva(cls, placa):
        for camiones in cls.camiones.values():
            for camion in camiones:
                if camion.placa == placa:
                    return False
        return True

    @classmethod
    def datosCamiones(cls):
        cls.camiones["Cisterna"] = CamionCisterna.getCamiones()
        cls.camiones["Frigorifico"] = CamionFrigorifico.getCamiones()
        cls.camiones["Lona"] = CamionLona.getCamiones()
        cls.camiones["PortaCoches"] = CamionPortaCoches.getCamiones()
