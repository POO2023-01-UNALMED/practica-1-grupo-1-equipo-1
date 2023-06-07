from src.gestorAplicaciones.Pais.pais import Pais, Ciudad
from producto import Producto
import heapq
from datetime import datetime, timedelta


class Pedido:

    def __init__(self):
        self._origen = None
        self._destino = None
        self._productos = []
        self._pais = None
        self._estado = None
        self._vehiculo = None
        self._tipoProductos = None

    # metodos getter and setter

    def getOrigen(self):
        return self._origen

    def setOrigen(self, origen):
        self._origen = origen

    def getDestino(self):
        return self._destino

    def setDestino(self, destino):
        self._destino = destino

    def getProductos(self):
        return self._productos

    def setProductos(self, productos):
        self._productos = productos

    def getPais(self):
        return self._pais

    def setPais(self, pais):
        self._pais = pais

    def getEstado(self):
        return self._estado

    def setEstado(self, estado):
        self._estado = estado

    def getVehiculo(self):
        return self._vehiculo

    def setVehiculo(self, vehiculo):
        self._vehiculo = vehiculo

    def getTipoProdutos(self):
        return self._tipoProductos

    def setTipoProdutos(self, tipoProductos):
        self._tipoProductos = tipoProductos

    def calcularRuta(self):
        ciudadPartida = self._pais.getCiudad(self._origen)  # ciudad de origen

        # diccionario para referenciar las ciudades ya visitadas en el algoritmo
        ciudadesVisitadas = {}
        ciudadPartida.inicializarCiudadesVisitadas(ciudadesVisitadas)

        costos = ciudadPartida.getConexiones().copy()
        ciudadPartida.inicializarCostos(costos)

        queue = []
        heapq.heappush(queue, (0, ciudadPartida.getNombre()))

        nombre = None
        distancia = None
        ciudad = None
        ciudadesVisitadas[ciudadPartida.getNombre()] = (True, '-')

        while len(queue) > 0:
            nombre = heapq.heappop(queue)[1]
            ciudadesVisitadas[nombre] = (True, ciudadesVisitadas[nombre][1])

            ciudad = self._pais.getCiudad(nombre)

            if nombre == self._destino:
                break

            for key, value in ciudad.getConexiones().items():
                if value != -1 and not (ciudadesVisitadas[key][0]):
                    distancia = costos[nombre] + value

                    if distancia <= costos[key]:
                        costos[key] = distancia
                        heapq.heappush(queue, (distancia, key))
                        ciudadesVisitadas[key] = (False, nombre)

        return self._getRuta(self._getCamino(self._destino, ciudadesVisitadas), costos)

    def _getCamino(self, destino, ciudadesVistadas):
        procedencia = [destino]
        destino = ciudadesVistadas[destino][1]
        while destino != '-':
            procedencia.append(destino)
            destino = ciudadesVistadas[destino][1]

        return procedencia[::-1]

    def _getRuta(self, camino, costos):
        ruta = []
        for ciudad in camino:
            ruta.append((ciudad, costos[ciudad]))
        return ruta

    def calcularpeso(self):
        peso = 0
        for producto in self._productos:
            peso += producto.getPeso() * producto.getCantidad()
        return peso / 1000

    def calcularVolumen(self):
        volumen = 0
        for producto in self._productos:
            volumen += producto.getVolumen() * producto.getCantidad()
        return volumen

    def calcularHoraSalida(self):

        salida = datetime.now()
        hora = salida.hour
        formato = "%Y-%m-%d"
        if 14 > hora > 5:
            strFecha = salida.strftime(formato) + " 15:00:00"
        elif hora > 14:
            salida = salida + timedelta(days=1)
            strFecha = salida.strftime(formato) + " 06:00:00"
        else:
            strFecha = salida.strftime(formato) + " 06:00:00"

        formato = "%Y-%m-%d %H:%M:%S"
        return datetime.strptime(strFecha, formato)

    def calcularHoraLlegada(self, horas, horaSalida):
        return horaSalida + timedelta(hours=horas)

    def verificarEstado(self, salida, llegada):
        actual = datetime.now()
        duracion = salida.hour - llegada.hour
        factor = actual.timetuple().tm_mday - salida.timetuple().tm_yday
        diffHora = 24 * factor + actual.hour - salida.hour

        if diffHora < 0:
            self._estado = "Confirmado"
        elif diffHora < duracion:
            self._estado = "Enviado"
        else:
            self._estado = "Entregado"

    def tiempoTranscurrido(self, salida):
        actual = datetime.now()
        return actual.hour - salida.hour + actual.minute / 60


pedido = Pedido()
pedido.setOrigen("Valledupar")
pedido.setDestino("Cali")
pedido.setPais(Pais.COLOMBIA)
print(pedido.calcularRuta())
