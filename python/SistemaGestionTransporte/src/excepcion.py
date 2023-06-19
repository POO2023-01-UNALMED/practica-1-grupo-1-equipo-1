
class ErrorAplicacion(Exception):
    def __init__(self, nombre, mensaje):
        self.nombre = nombre
        self.mensaje = mensaje
        super().__init__(self.mensaje)


# campos faltantes, ciudad repetida, datos no encontrados
class ExepcionLogistica(ErrorAplicacion):
    def __init__(self, nombre, mensaje):
        self.nombre = nombre
        self.mensaje = "Exepcion Logistica: " + mensaje
        super().__init__(self.nombre, self.mensaje)


class CamposVacios(ExepcionLogistica):
    def __init__(self, mensaje):
        super().__init__("Campos Vacios", mensaje)


class CiudadRepetida(ExepcionLogistica):
    def __init__(self, mensaje):
        super().__init__("Coiudad repetida", mensaje)


class DatoNoEncontrado(ExepcionLogistica):
    def __init__(self, mensaje):
        super().__init__("Dato no encontrado", mensaje)


# (usario Existente, Datos No Validos, entrada No validad)
class NoValido(ErrorAplicacion):
    def __init__(self, nombre, mensaje):
        self.nombre = nombre
        self.mensaje = "Opcion no valida: " + mensaje
        super().__init__(self.nombre, self.mensaje)


class ProductosVacios(NoValido):
    def __init__(self):
        super().__init__("Productos Vacios", "No se ha ingresado ningun producto")


class DatoInvalido(NoValido):
    def __init__(self, mensaje):
        super().__init__("Dato de entrada no valido", mensaje)


class CamionNodisponible(NoValido):
    def __init__(self):
        super().__init__("Camion no disponible", "Por el momento no tenemos camiones disponibles")
