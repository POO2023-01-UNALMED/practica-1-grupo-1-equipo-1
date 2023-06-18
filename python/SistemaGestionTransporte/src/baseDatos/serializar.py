import os
import pathlib
import pickle

from src.gestorAplicaciones.Camion.camion import CamionCisterna, CamionFrigorifico, CamionLona, CamionPortaCoches
from src.gestorAplicaciones.Productos.factura import Factura
from src.gestorAplicaciones.entidades.empleado import Empleado
from src.gestorAplicaciones.entidades.usuario import Usuario


def Serializar(ruta, objeto):

    picklefile = open(ruta, "wb")
    pickle.dump(objeto, picklefile)
    picklefile.close()


def Serializador():
    path = os.path.join(pathlib.Path(__file__).absolute())
    path = os.path.dirname(path)

    # usuarios
    Serializar(path + "\\temp\\usuarios.pkl", Usuario.usuarios)

    # empleados
    Serializar(path + "\\temp\\empleados.pkl", Empleado.getEmpleados())

    # facturas
    Serializar(path + "\\temp\\facturas.pkl", Factura.getFacturas())

    # ID factura
    Serializar(path + "\\temp\\facturaID.pkl", Factura.getIDfactura())

    # camiones
    Serializar(path + "\\temp\\camionCisterna.pkl", CamionCisterna.getCamiones())

    Serializar(path + "\\temp\\camionFrigorifico.pkl", CamionFrigorifico.getCamiones())

    Serializar(path + "\\temp\\camionLona.pkl", CamionLona.getCamiones())

    Serializar(path + "\\temp\\camionPortaCoches.pkl", CamionPortaCoches.getCamiones())
