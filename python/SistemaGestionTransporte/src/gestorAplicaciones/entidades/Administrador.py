from gestorAplicaciones.camion import *
from gestorAplicaciones.producto import Factura
from uiMain import Main
from gestorAplicaciones.entidades import Empleado, Usuario

class Administrador(Empleado):
    def __init__(self):
        super().__init__("Administrador", "Clave", 0, "Administrador@egt.com")
        self.camion = None
    
    def mostrarEmpleados(self, pais):
        infoEmpleados = ""
        for empleado in Empleado.getEmpleados():
            if empleado.getPais() == pais:
                infoEmpleados += str(empleado)
        return infoEmpleados
    
    def mostarUsuarios(self):
        infoUsuarios = ""
        for usuario in Usuario.getUsuarios():
            infoUsuarios += str(usuario)
        return infoUsuarios
    
    def mostarCamiones(self, pais, tipoCamion):
        infoCamiones = ""
        camiones = Camion.camiones.get(tipoCamion)
        for camion in camiones:
            if camion.getPais() == pais:
                infoCamiones += str(camion)
        return infoCamiones
    
    def mostrarFacturas(self, pais):
        infoFacturas = ""
        for factura in Factura.getFacturas():
            Main.actualizarInformacion(factura)
            if factura.getPedido().getPais().getNombre() == pais:
                infoFacturas += str(factura)
        return infoFacturas
    
    def registrarEmpleado(self, nombre, clave, id, correo, pais, CiudadActual):
        Empleado.crearEmpleado(nombre, clave, int(id), correo, pais, CiudadActual)
    
    def registarCamion(self, opcion, placa, pais, ciudadActual, pesoMaximo, capacidad):
        if opcion == 1:
            self.camion = CamionCisterna(placa, pais, ciudadActual, pesoMaximo, capacidad)
        elif opcion == 2:
            self.camion = CamionFrigorifico(placa, pais, ciudadActual, pesoMaximo, capacidad)
        elif opcion == 3:
            self.camion = CamionLona(placa, pais, ciudadActual, pesoMaximo, capacidad)
        elif opcion == 4:
            self.camion = CamionPortaCoches(placa, pais, ciudadActual, pesoMaximo, capacidad)
        else:
            print("Opción no válida")
    
    def actualizarFacturas(self):
        for factura in Factura.getFacturas():
            Main.actualizarInformacion(factura)
