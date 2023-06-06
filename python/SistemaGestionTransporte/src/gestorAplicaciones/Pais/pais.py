import sys
from enum import Enum


class Pais(Enum):
    COLOMBIA = "Colombia"
    ECUADOR = "Ecuador"
    PANAMA = "panama"

    def __init__(self, nombre):
        self._nombre = nombre
        self._ciudades = []
        # self._generarConexiones()

    # metodos getter and setter

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getCiudades(self):
        return self._ciudades

    def setCiudades(self, ciudades):
        self._ciudades = ciudades

    def getCiudad(self, nombreCiudad):
        for ciudad in self._ciudades:
            if ciudad.getNombre() == nombreCiudad:
                return ciudad
        return None

    def mostrarCiudades(self):
        ciudades = "Ciudades de " + self._nombre + "\n"
        for ciudad in self._ciudades:
            ciudades += ciudad.getNombre() + "\n"
        return ciudades

    def _generarConexiones(self):
        ruta = "src/baseDatos/temp/paises/" + self._nombre + ".txt"
        mapa = self.leerArchivo(ruta)
        lineas = mapa.split("\n")
        for linea in lineas:
            conexion = linea.split(":")
            if not self.isCiudad(conexion[0]): self._agregarCiudad(conexion[0])
            if not self.isCiudad(conexion[0]): self._agregarCiudad(conexion[0])
            self._costoCiudades(conexion[0], conexion[1], float(conexion[2]))

    def isCiudad(self, nombreCiudad):
        return nombreCiudad in self._ciudades

    def _agregarCiudad(self, nombreCiudad):
        self._ciudades.append(Ciudad(nombreCiudad, self._nombre))
        self._conexionesIniciales()

    def _conexionesIniciales(self):
        ciudad = self._ciudades[len(self._ciudades) - 1]
        for ciudadAdyacente in self._ciudades:
            if not (ciudad.getNombre() == ciudadAdyacente.getNombre()):
                ciudad.conectar_ciudades(ciudadAdyacente, -1)
                ciudadAdyacente.conectar_ciudades(ciudad, -1)

    def _costoCiudades(self, nombreCiudad1, nombreCiudad2, costo):
        for ciudad1 in self._ciudades:
            if ciudad1.getNombre() == nombreCiudad1:
                for ciudad2 in self._ciudades:
                    if ciudad2.getNombre() == nombreCiudad2:
                        ciudad1.conectarCiudades(ciudad2.getNombre(), costo)
                        ciudad2.conectarCiudades(ciudad1.getNombre(), costo)
                        return

    def leerArchivo(self, ruta):
        archivo = open(ruta, 'r')
        texto = archivo.read()
        archivo.close()
        return texto


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
        return self._nombre + "\n"
