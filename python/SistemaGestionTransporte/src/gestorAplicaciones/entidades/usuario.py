import pickle


class Usuario:
    usuarios = []

    def __init__(self, nombre, id, correo, clave):
        self.nombre = nombre
        self.clave = clave
        self.ID = id
        self.correo = correo
        Usuario.usuarios.append(self)

    def getNombre(self):
        return self.nombre

    def getID(self):
        return self.ID

    @classmethod
    def crearUsuario(cls, nombre, clave, id, correo):
        return cls(nombre, clave, id, correo)

    def comprobarUsuario(self, nombre, clave):
        if nombre.isdigit():
            return self.ID == int(nombre) and self.clave == clave
        return self.nombre == nombre and self.clave == clave

    def comprobarNombre(self, nombre):
        return self.nombre == nombre

    def comprobarID(self, id):
        return self.ID == id

    def comprobarCorreo(self, correo):
        return self.correo == correo

    @staticmethod
    def isNombreValido(nombre):
        nombre = nombre.split(' ')
        for i in nombre:
            if i is None or not i.isalpha():
                print("El nombre solo debe tener caracteres alfabéticos.")
                return False
        for usuario in Usuario.usuarios:
            if usuario.comprobarNombre(nombre):
                print("Nombre ya registrado.")
                return False
        return True

    @staticmethod
    def isIDValido(id):
        if id is None or not id.isdigit():
            print("La identificación debe contener solo caracteres numéricos.")
            return False
        for usuario in Usuario.usuarios:
            if usuario.comprobarID(int(id)):
                print("Número de identificación ya registrado.")
                return False
        return True

    @staticmethod
    def isCorreoValido(correo):
        if '@' not in correo or correo.endswith('@') or ' ' in correo:
            print("Correo no válido.")
            return False
        for usuario in Usuario.usuarios:
            if usuario.comprobarCorreo(correo):
                print("Correo ya registrado.")
                return False
        return True

    def __str__(self):
        return f"\nnombre:\t{self.nombre}\nid:\t{self.ID}\ncorreo:\t{self.correo}\n"

    # Métodos para serialización y deserialización de objetos
    def guardarDatos(self, archivo):
        with open(archivo, 'wb') as f:
            pickle.dump(Usuario.usuarios, f)

    @staticmethod
    def cargarDatos(archivo):
        with open(archivo, 'rb') as f:
            Usuario.usuarios = pickle.load(f)

