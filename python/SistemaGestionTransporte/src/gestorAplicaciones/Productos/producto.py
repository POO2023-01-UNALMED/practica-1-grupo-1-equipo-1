class Producto:
    def __init__(self, nombre, tipo, peso, volumen, cantidad):
        self._nombre = nombre
        self._tipo = tipo
        self._peso = peso
        self._volumen = volumen
        self._cantidad = cantidad

    # metodos getter and setter

    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getTipo(self):
        return self._tipo

    def setTipo(self, tipo):
        self._tipo = tipo

    def getPeso(self):
        return self._peso

    def setPeso(self, peso):
        self._peso = peso

    def getVolumen(self):
        return self._volumen

    def setVolumen(self, volumen):
        self._volumen = volumen

    def getCantidad(self):
        return self._cantidad

    def setCantidad(self, cantidad):
        self._cantidad = cantidad

    @staticmethod
    def crearProducto(nombre, tipo, peso, volumen, cantidad):
        return Producto(nombre, tipo, peso, volumen, cantidad)

    def __str__(self):
        return self._nombre + "\tx" + str(self._cantidad)
