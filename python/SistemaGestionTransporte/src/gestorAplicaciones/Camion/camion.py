from abc import ABC, abstractmethod


class Camion(ABC):
    camiones = {}

    def __init__(self, placa, pais, ciudadActual, pesoMaximo, capacidad):
        self.placa = placa
        self.pesoMaximo = pesoMaximo
        self.capacidad = capacidad
        self.costo = 0.0
        self.pais = pais
        self.disponible = True
        self.ciudadActual = ciudadActual
        self.ruta = []
        self.empleado = None

    def setPesoMaximo(self, pesoMaximo):
        self.pesoMaximo = pesoMaximo

    def setCapacidad(self, capacidad):
        self.capacidad = capacidad

    def getPlaca(self) -> str:
        return self.placa

    def setPlaca(self, placa):
        self.placa = placa

    def getPesoMaximo(self):
        return self.pesoMaximo

    def getCapacidad(self):
        return self.capacidad

    def getCosto(self):
        return self.costo

    def setCosto(self, costo):
        self.costo = costo

    def getPais(self):
        return self.pais

    def setPais(self, pais):
        self.pais = pais

    def isDisponible(self):
        return self.disponible

    def setDisponible(self, disponible):
        self.disponible = disponible

    def getCiudadActual(self):
        return self.ciudadActual

    def setCiudadActual(self, ciudadActual):
        self.ciudadActual = ciudadActual

    def getRuta(self):
        return self.ruta

    def setRuta(self, ruta):
        self.ruta = ruta

    def getEmpleado(self):
        return self.empleado

    def setEmpleado(self, empleado):
        self.empleado = empleado

    @abstractmethod
    def calcularCostoCamion(self):
        pass

    def calcularTiempo(self):
        km = self.ruta[-1][1]
        return int(km / self.velocidad())

    @abstractmethod
    def velocidad(self):
        pass

    def comprobarPlaca(self, placa):
        return self.placa == placa

    def distanciaRecorrida(self, tiempo):
        return self.velocidad() * tiempo

    def tiempoRestante(self, tiempo):
        return self.calcularTiempo() - tiempo

    def ubicacionActual(self, tiempo):
        distancia = self.distanciaRecorrida(tiempo)
        aux = 0
        ciudadA = None
        ciudadB = None
        for recorrido in self.ruta:
            aux = recorrido[1]
            ciudadA = ciudadB
            ciudadB = recorrido[0]
            if aux > distancia:
                break
        return f"{ciudadA} - {ciudadB}"

    def camionOptimo(self, origen, peso):
        if self.capacidad == 20 and peso <= self.getPesoMaximo():
            return self.ciudadActual == origen
        elif self.capacidad == 35 and self.getPesoMaximo() >= peso > 1:
            return self.ciudadActual == origen
        elif self.capacidad == 42 and self.getPesoMaximo() >= peso > 8:
            return self.ciudadActual == origen
        elif self.capacidad == 48 and self.getPesoMaximo() >= peso > 17:
            return self.ciudadActual == origen
        else:
            return False

    @classmethod
    def seleccionarCamion(cls, tipoCarga, origen, peso, volumen):
        camiones = cls.camiones[tipoCarga]
        for camion in camiones:
            if camion.camionOptimo(origen, peso):
                return camion
        return None

    @classmethod
    def buscarCamion(cls, tipoCarga, placa):
        camiones = cls.camiones[tipoCarga]
        for camion in camiones:
            if camion.comprobarPlaca(placa):
                return camion
        return None

    @staticmethod
    def verificarPlaca(placa, nombre):
        letras, num = '', ''
        if nombre == "Colombia" and len(placa) == 6:
            letras = placa[:3]
            num = placa[3:]
            return letras.isalpha() and num.isdigit()
        elif nombre == "Panama" and len(placa) == 6 and placa.isdigit():
            return True
        elif nombre == "Ecuador" and len(placa) == 7:
            letras = placa[:3]
            num = placa[3:]
            return letras.isalpha() and num.isdigit()
        return False

    @classmethod
    def isPlacaNueva(cls, placa):
        for camiones in cls.camiones.values():
            for camion in camiones:
                if camion.placa == placa:
                    return False
        return True

    @classmethod
    def datosCamiones(cls):
        cls.camiones["Cisterna"] = CamionCisterna.getCamiones()
        cls.camiones["Frigorifico"] = CamionFrigorifico.getCamiones()
        cls.camiones["Lona"] = CamionLona.getCamiones()
        cls.camiones["PortaCoches"] = CamionPortaCoches.getCamiones()


class CamionCisterna(Camion, ABC):
    camiones = []

    def __init__(self, placa, pais, ciudadActual, pesoMaximo, capacidad):
        super().__init__(placa, pais, ciudadActual, pesoMaximo, capacidad)
        self.camiones.append(self)

    @classmethod
    def getCamiones(cls):
        return cls.camiones

    @classmethod
    def setCamiones(cls, camiones):
        cls.camiones = camiones

    def calcularCostoCamion(self):
        factor = 0.005
        km = self.getRuta()[-1][1]
        self.setCosto(km * self.getCapacidad() * factor)

    def velocidad(self):
        velocidadBase = 81.857
        factor = -0.392957
        return velocidadBase + self.getCapacidad() * factor

    def __str__(self):
        return "\nTipo: Cisterna" \
               "\nPlaca: " + self.getPlaca() + \
            "\nPais: " + self.getPais() + \
            "\nCiudad actual: " + self.getCiudadActual() + \
            "\nPeso Maximo: " + str(self.getPesoMaximo()) + \
            "\nCapacidad: " + str(self.getCapacidad()) + \
            "\nDisponible: " + str(self.isDisponible()) + "\n"


class CamionFrigorifico(Camion, ABC):
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
        km = self.getRuta()[-1][1]
        self.setCosto(km * self.getCapacidad() * factor)

    def velocidad(self):
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


class CamionLona(Camion, ABC):
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
        factor = 0.005
        km = self.getRuta()[-1][1]
        self.setCosto(km * self.getCapacidad() * factor)

    def velocidad(self):
        velocidadBase = 85.7
        factor = -0.2857
        return velocidadBase + self.getCapacidad() * factor

    def __str__(self):
        return "\nTipo: Lona" \
               "\nPlaca: " + self.getPlaca() \
            + "\npais: " + self.getPais() \
            + "\nCiudad actual: " + self.getCiudadActual() \
            + "\nPeso Maximo: " + str(self.getPesoMaximo()) \
            + "\nCapacidad: " + str(self.getCapacidad()) \
            + "\nDisponible: " + str(self.isDisponible()) + "\n"


class CamionPortaCoches(Camion, ABC):
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
        factor = 0.008
        km = self.getRuta()[-1][1]
        self.setCosto(km * self.getCapacidad() * factor)

    def velocidad(self):
        velocidadBase = 80.57
        factor = -0.42857
        return velocidadBase + self.getCapacidad() * factor

    def __str__(self):
        return "\nTipo: Portacoches" \
               "\nPlaca: " + self.getPlaca() \
            + "\npais: " + self.getPais() \
            + "\nCiudad actual: " + self.getCiudadActual() \
            + "\nPeso Maximo: " + str(self.getPesoMaximo()) \
            + "\nCapacidad: " + str(self.getCapacidad()) \
            + "\nDisponible: " + str(self.isDisponible()) + "\n"
