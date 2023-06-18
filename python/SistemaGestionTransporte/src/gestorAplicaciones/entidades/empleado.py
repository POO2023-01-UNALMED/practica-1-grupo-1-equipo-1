from src.gestorAplicaciones.entidades.usuario import Usuario


class Empleado(Usuario):
    empleados = []

    def __init__(self, nombre, clave, id, correo, estatusActivo, pais, ciudadActual):
        super().__init__(nombre, id, correo, clave)
        self.estatusActivo = estatusActivo
        self.pais = pais
        self.ciudadActual = ciudadActual
        self.disponible = True
        Empleado.empleados.append(self)

    @classmethod
    def getEmpleados(cls):
        return cls.empleados

    def isEstatusActivo(self):
        return self.estatusActivo

    def setEstatusActivo(self, estatusActivo):
        self.estatusActivo = estatusActivo

    def isDisponible(self):
        return self.disponible

    def setDisponible(self, disponible):
        self.disponible = disponible

    def getPais(self):
        return self.pais

    def setPais(self, pais):
        self.pais = pais

    def getCiudadActual(self):
        return self.ciudadActual

    def setCiudadActual(self, ciudadActual):
        self.ciudadActual = ciudadActual

    def elegirConductor(self, ciudadActual):
        return self.ciudadActual == ciudadActual and self.estatusActivo and self.disponible

    @classmethod
    def seleccionarEmpleado(cls, origen):
        for empleado in cls.getEmpleados():
            if empleado.elegirConductor(origen):
                return empleado
        return None

    def __str__(self):
        return "\nnombre:\t" + self.get_nombre() + \
            "\nid:\t" + str(self.get_id()) + \
            "\ncorreo:\t" + self.get_correo() + \
            "\nPais:" + self.getPais() + \
            "\nCiudad Actual:\t" + self.ciudadActual + \
            "\nActivo:\t" + str(self.estatusActivo) + \
            "\nDisponible:\t" + str(self.disponible) + \
            "\nPais\t" + self.pais + "\n"

    def calcularPago(self, costoPedido):
        return costoPedido + costoPedido * 0.2

    @classmethod
    def crearEmpleado(cls, nombre, clave, id, correo, pais, ciudadActual):
        empleado = Empleado(nombre, clave, id, correo)
        empleado.estatusActivo = True
        empleado.pais = pais
        empleado.ciudadActual = ciudadActual
        empleado.disponible = True
        cls.getEmpleados().append(empleado)

    @staticmethod
    def isNombreValido(nombre):
        if nombre is None or not nombre.isalpha():
            return False
        for empleado in Empleado.getEmpleados():
            if empleado.comprobar_nombre(nombre):
                return False
        return True

    @staticmethod
    def isIDValido(id):
        if id is None or not id.isdigit():
            print("La identificación debe contener solo caracteres numéricos.")
            return False
        for empleado in Empleado.getEmpleados():
            if empleado.comprobar_id(int(id)):
                print("Número de identificación ya registrado.")
                return False
        return True

    @staticmethod
    def isCorreoValido(correo):
        if "@" not in correo or correo[-1] == "@":
            print("Correo no válido.")
            return False
