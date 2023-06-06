import sys


class Ciudad:

    def __init__(self, nombre, nombre_pais):
        self._nombre = nombre
        self._nombre_pais = nombre_pais
        self._conexiones = {}

    # metodos getter and setter
    def get_nombre(self):
        return self._nombre

    def set_nombre(self, nombre):
        self._nombre = nombre

    def get_nombre_pais(self):
        return self._nombre_pais

    def set_nombre_pais(self, nombre_pais):
        self._nombre_pais = nombre_pais

    def get_conexiones(self):
        return self._conexiones

    def set_conexiones(self, conexiones):
        self._conexiones = conexiones

    def inicializar_ciudades_visitidas(self, ciudades_visitadas):
        tupla_visitas = (False, '-')
        for key in self._conexiones:
            ciudades_visitadas[key] = tupla_visitas

    def inicializar_costos(self, costos):
        for key, value in costos:
            if value == -1:
                costos[key] = sys.float_info.max

    def __str__(self):
        return self._nombre+"\n"
