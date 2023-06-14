from .camion import Camion
import pickle

class CamionFrigorifico(Camion):
    camiones = []
    
    def __init__(self, placa, pais, CiudadActual, pesoMaximo, capacidad):
        super().__init__(placa, pais, CiudadActual, pesoMaximo, capacidad)
        self.camiones.append(self)
    
    @classmethod
    def getCamiones(cls):
        return cls.camiones
    
    @classmethod
    def setCamiones(cls, camiones):
        cls.camiones = camiones
    
    def calcularCostoCamion(self):
        factor = 0.01
        km = self.getRuta()[-1].getValue()
        self.setCosto(km * self.getCapacidad() * factor)
    
    def valocidad(self):
        velocidadBase = 85.14
        factor = -0.357
        return velocidadBase + self.getCapacidad() * factor
    
    def __str__(self):
        return "\nTipo: Frigorifico" \
               "\nPlaca: " + self.getPlaca() \
               + "\npais: " + self.getPais() \
               + "\nCiudad actual: " + self.getCiudadActual() \
               + "\nPeso Maximo: " + str(self.getPesoMaximo()) \
               + "\nCapacidad: " + str(self.getCapacidad()) \
               + "\nDisponible: " + str(self.isDisponible()) + "\n"