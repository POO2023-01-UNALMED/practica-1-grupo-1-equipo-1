from src.gestorAplicaciones.Camion.camion import Camion


class CamionCisterna(Camion):
    camiones = []

    def __init__(self, placa, pais, ciudadActual, pesoMaximo, capacidad):
        super().__init__(placa, pais, ciudadActual, pesoMaximo, capacidad)
        self.camiones.append(self)

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
