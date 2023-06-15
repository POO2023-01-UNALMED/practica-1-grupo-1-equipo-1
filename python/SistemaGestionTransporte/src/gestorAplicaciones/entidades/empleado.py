from src.gestorAplicaciones.entidades.usuario import Usuario


class Empleado(Usuario):
    empleados = []

    def __init__(self, nombre, clave, id, correo):
        super().__init__(nombre, clave, id, correo)
        self.estatusActivo = False
        self.disponible = False
        self.pais = ""
        self.ciudadActual = ""

    @classmethod
    def get_empleados(cls):
        return cls.empleados

    def is_estatus_activo(self):
        return self.estatusActivo

    def set_estatus_activo(self, estatusActivo):
        self.estatusActivo = estatusActivo

    def is_disponible(self):
        return self.disponible

    def set_disponible(self, disponible):
        self.disponible = disponible

    def get_pais(self):
        return self.pais

    def set_pais(self, pais):
        self.pais = pais

    def get_ciudad_actual(self):
        return self.ciudadActual

    def set_ciudad_actual(self, ciudadActual):
        self.ciudadActual = ciudadActual

    def elegir_conductor(self, ciudadActual):
        return self.ciudadActual == ciudadActual and self.estatusActivo and self.disponible

    @classmethod
    def seleccionar_empleado(cls, origen):
        for empleado in cls.get_empleados():
            if empleado.elegir_conductor(origen):
                return empleado
        return None

    def __str__(self):
        return "\nnombre:\t" + self.get_nombre() + \
               "\nid:\t" + str(self.get_id()) + \
               "\ncorreo:\t" + self.get_correo() + \
               "\nPais:" + self.get_pais() + \
               "\nCiudad Actual:\t" + self.ciudadActual + \
               "\nActivo:\t" + str(self.estatusActivo) + \
               "\nDisponible:\t" + str(self.disponible) + \
               "\nPais\t" + self.pais + "\n"

    def calcular_pago(self, costoPedido):
        return costoPedido + costoPedido * 0.2

    @classmethod
    def crear_empleado(cls, nombre, clave, id, correo, pais, ciudadActual):
        empleado = Empleado(nombre, clave, id, correo)
        empleado.estatusActivo = True
        empleado.pais = pais
        empleado.ciudadActual = ciudadActual
        empleado.disponible = True
        cls.get_empleados().append(empleado)

    @staticmethod
    def is_nombre_valido(nombre):
        if nombre is None or not nombre.isalpha():
            print("El nombre solo debe tener caracteres alfabéticos.")
            return False
        for empleado in Empleado.get_empleados():
            if empleado.comprobar_nombre(nombre):
                print("Nombre ya registrado.")
                return False
        return True

    @staticmethod
    def is_id_valido(id):
        if id is None or not id.isdigit():
            print("La identificación debe contener solo caracteres numéricos.")
            return False
        for empleado in Empleado.get_empleados():
            if empleado.comprobar_id(int(id)):
                print("Número de identificación ya registrado.")
                return False
        return True

    @staticmethod
    def is_correo_valido(correo):
        if "@" not in correo or correo[-1] == "@":
            print("Correo no válido.")
            return False
