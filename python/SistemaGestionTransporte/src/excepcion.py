class ErrorAplicacion(Exception):
    pass


# campos faltantes, ciudad repetida, ciudad no encontrada
class ExepcionLogistica(ErrorAplicacion):
    pass


class CamposVacios(ExepcionLogistica):
    pass


class CiudadRepetida(ExepcionLogistica):
    pass


class CiudadNoEncontrada(ExepcionLogistica):
    pass


class CiudadRepetidas(ErrorAplicacion):
    pass


# (usario Existente, Datos No Validos, entrada No validad)
class NoValido(ErrorAplicacion):
    pass


class UsuarioExistente(NoValido):
    pass


class DatoInvalido(NoValido):
    pass


class EntradaInvalida(NoValido):
    pass
