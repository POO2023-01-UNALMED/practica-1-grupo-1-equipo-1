from enum import Enum
from ciudad import Ciudad


class Pais(Enum):
    COLOMBIA = "Colombia"
    ECUADOR = "Ecuador"
    PANAMA = "panama"

    def __init__(self, nombre):
        self._nombre = nombre
        self._ciudades = []
        self._generar_conexiones()

    # metodos getter and setter

    def get_nombre(self):
        return self._nombre

    def set_nombre(self, nombre):
        self._nombre = nombre

    def get_ciudades(self):
        return self._ciudades

    def set_ciudades(self, ciudades):
        self._ciudades = ciudades

    def get_ciudad(self, nombre_ciudad):
        for ciudad in self._ciudades:
            if ciudad.get_nombre() == nombre_ciudad:
                return ciudad
        return None

    def mostrar_ciudades(self):
        ciudades = "Ciudades de " + self._nombre + "\n"
        for ciudad in self._ciudades:
            ciudades += ciudad.get_nombre() + "\n"
        return ciudades

    def _generar_conexiones(self):
        ruta = "src/baseDatos/temp/paises/" + self._nombre + ".txt"
        mapa = self.leer_archivo(ruta)
        lineas = mapa.split("\n")
        for linea in lineas:
            conexion = linea.split(":")
            if not self.isCiudad(conexion[0]): self._agregarCiudad(conexion[0])
            if not self.isCiudad(conexion[0]): self._agregarCiudad(conexion[0])
            self._costoCiudades(conexion[0], conexion[1], float(conexion[2]))

    def isCiudad(self, nombre_ciudad):
        return nombre_ciudad in self._ciudades

    def _agregarCiudad(self, nombre_ciudad):
        self._ciudades.append(Ciudad(nombre_ciudad, self._nombre))
        self._conexiones_iniciales()

    def _conexiones_iniciales(self):
        ciudad = self._ciudades[len(self._ciudades) - 1]
        for ciudad_adyacente in self._ciudades:
            if not (ciudad.get_nombre() == ciudad_adyacente.get_nombre()):
                ciudad.conectar_ciudades(ciudad_adyacente, -1)
                ciudad_adyacente.conectar_ciudades(ciudad, -1)

    def _costoCiudades(self, nombre_ciudad1, nombre_ciudad2, costo):
        for ciudad1 in self._ciudades:
            if ciudad1.get_nombre() == nombre_ciudad1:
                for ciudad2 in self._ciudades:
                    if ciudad2.get_nombre() == nombre_ciudad2:
                        ciudad1.conectar_ciudades(ciudad2.get_nombre(), costo)
                        ciudad2.conectar_ciudades(ciudad1.get_nombre(), costo)
                        return

    def leer_archivo(self, ruta):
        archivo = open(ruta, 'r')
        texto = archivo.read()
        archivo.close()
        return texto
