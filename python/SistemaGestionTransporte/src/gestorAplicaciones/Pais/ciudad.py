import sys


class Ciudad:

    def __init__(self, nombre, nombrePais):
        self._nombre = nombre
        self._nombrePais = nombrePais
        self._conexiones = {}

    # metodos getter and setter
    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getNombrePais(self):
        return self._nombrePais

    def setNombrePais(self, nombrePais):
        self._nombrePais = nombrePais

    def getConexiones(self):
        return self._conexiones

    def setConexiones(self, conexiones):
        self._conexiones = conexiones

    def inicializarCiudadesVisitidas(self, ciudadesVisitadas):
        tupla_visitas = (False, '-')
        for key in self._conexiones:
            ciudadesVisitadas[key] = tupla_visitas

    def inicializarCostos(self, costos):
        for key, value in costos.items():
            if value == -1:
                costos[key] = sys.float_info.max

    def conectarCiudades(self, nombre, costo):
        self._conexiones[nombre] = costo

    def __str__(self):
        return self._nombre+"\n"
