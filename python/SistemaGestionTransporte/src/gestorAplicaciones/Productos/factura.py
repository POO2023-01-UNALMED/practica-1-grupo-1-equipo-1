from src.gestorAplicaciones.Camion.camion import Camion


class Factura:
    _facturas = []
    _IDfactura = 100000000

    def __init__(self, pedido, usuario):
        self._pedido = pedido
        self._usuario = usuario
        self._ID = Factura._IDfactura
        self._ganancia = 1.25
        self._pedido = None
        self._costo = None
        self._horaSalida = None
        self._horaLLegada = None

        Factura._IDfactura += 1

    @classmethod
    def getIDfactura(cls):
        return cls._IDfactura

    @classmethod
    def setIDfactura(cls, IDfactura):
        cls._IDfactura = IDfactura

    @classmethod
    def getFacturas(cls):
        return cls._facturas

    @classmethod
    def setFacturas(cls, facturas):
        cls._facturas = facturas

    def getPedido(self):
        return self._pedido

    def setPedido(self, pedido):
        self._pedido = pedido

    def getUsuario(self):
        return self._usuario

    def setUsuario(self, usuario):
        self._usuario = usuario

    def getID(self):
        return self._ID

    def setID(self, ID):
        self._ID = ID

    def getGanancia(self):
        return self._ganancia

    def getHoraSalida(self):
        return self._horaSalida

    def setHoraSalida(self, horaSalida):
        self._horaSalida = horaSalida

    def getHoraLLegada(self):
        return self._horaLLegada

    def setHoraLLegada(self, horaLLegada):
        self._horaLLegada = horaLLegada

    def calcularCostoTotal(self, costoCamion, capacidad):
        self._costo = capacidad * 0.05 + costoCamion * self._ganancia

    @classmethod
    def agregarFactura(cls, factura):
        cls._facturas.append(factura)

    @classmethod
    def historialFacturas(cls, usuario):
        for factura in cls._facturas:
            if factura.getUsuario().getID() == usuario.getID():
                Factura.actualizarInformacion(factura)

    def infoViaje(self, ubicacion, tiempo):
        horas = int(tiempo)
        minutos = int(tiempo - horas) * 60
        return ubicacion + ":" + horas + minutos

    def isFactura(self, id, nombre):
        return self._ID == id and self._usuario.getNombre() == nombre

    @classmethod
    def buscarFactura(cls, id, nombre):
        for factura in cls._facturas:
            if factura.isFactura(id, nombre):
                return factura
        return None

    @staticmethod
    def actualizarInformacion(factura):
        estadoAnterior = ''
        if factura.getPedido().getEstado() == "Entregado":
            pedido = factura.getPedido()
            estadoAnterior = factura.getPedido().getEstado()
            pedido.verificarEstado(factura.getHoraSalida(), factura.getHoraLLegada())
            if pedido.getEstado() is not estadoAnterior and pedido.getEstado == "Entregado":
                camion = Camion.buscarCamion(pedido.getTipoProdutos(), pedido.getVehiculo())
                camion.setDisponible(True)
                camion.setCiudadActual(pedido.getDestino())
                camion.getEmpleado().setDisponible(True)
                camion.getEmpleado().setCiudadActual(pedido.getDestino())
