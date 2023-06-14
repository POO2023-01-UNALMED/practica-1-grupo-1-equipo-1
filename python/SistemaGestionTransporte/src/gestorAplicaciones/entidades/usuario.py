import pickle

class Usuario:
    usuarios = []

    def __init__(self, nombre, clave, id, correo):
        self.nombre = nombre
        self.clave = clave
        self.ID = id
        self.correo = correo
        Usuario.usuarios.append(self)

    @classmethod
    def get_usuarios(cls):
        return cls.usuarios

    @classmethod
    def set_usuarios(cls, usuarios):
        cls.usuarios = usuarios

    def get_nombre(self):
        return self.nombre

    def get_clave(self):
        return self.clave

    def set_clave(self, clave):
        self.clave = clave

    def get_ID(self):
        return self.ID

    def get_correo(self):
        return self.correo

    def set_correo(self, correo):
        self.correo = correo

    @staticmethod
    def crear_usuario(nombre, clave, id, correo):
        return Usuario(nombre, clave, id, correo)

    def comprobar_usuario(self, nombre, clave):
        return self.nombre == nombre and self.clave == clave

    def comprobar_usuario_id(self, id, clave):
        return self.ID == id and self.clave == clave

    def comprobar_nombre(self, nombre):
        return self.nombre == nombre

    def comprobar_ID(self, id):
        return self.ID == id

    def comprobar_correo(self, correo):
        return self.correo == correo

    @staticmethod
    def is_nombre_valido(nombre):
        if nombre is None or not all(c == ' ' or c.isalpha() for c in nombre):
            print("El nombre solo debe tener caracteres alfanuméricos.")
            return False
        for usuario in Usuario.usuarios:
            if usuario.comprobar_nombre(nombre):
                print("Nombre ya registrado.")
                return False
        return True

    @staticmethod
    def is_ID_valido(id):
        if id is None or not id.isdigit():
            print("La identificación debe contener solo caracteres numéricos.")
            return False
        for usuario in Usuario.usuarios:
            if usuario.comprobar_ID(int(id)):
                print("Número de identificación ya registrado.")
                return False
        return True

    @staticmethod
    def is_correo_valido(correo):
        if '@' not in correo or correo[-1] == '@':
            print("Correo no válido.")
            return False
        for usuario in Usuario.usuarios:
            if usuario.comprobar_correo(correo):
                print("Correo ya registrado.")
                return False
        return True

    def __str__(self):
        return f"\nnombre:\t{self.nombre}\nid:\t{self.ID}\ncorreo:\t{self.correo}\n"

    def __repr__(self):
        return str(self)


# Clase Empleado
class Empleado(Usuario):
    empleados = []

    def __init__(self, nombre, clave, id, correo, estatus_activo, pais, ciudad_actual):
        super().__init__(nombre, clave, id, correo)
        self.estatus_activo = estatus_activo
        self.disponible = True
        self.pais = pais
        self.ciudad_actual = ciudad_actual
        Empleado.empleados.append(self)

    @classmethod
    def get_empleados(cls):
        return cls.empleados

    @classmethod
    def set_empleados(cls, empleados):
        cls.empleados = empleados

    def is_estatus_activo(self):
        return self.estatus_act
