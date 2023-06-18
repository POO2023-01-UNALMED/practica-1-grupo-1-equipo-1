import os
import pathlib
import pickle

from src.gestorAplicaciones.Camion.camion import CamionCisterna, CamionFrigorifico, CamionLona, CamionPortaCoches
from src.gestorAplicaciones.Productos.factura import Factura
from src.gestorAplicaciones.entidades.empleado import Empleado
from src.gestorAplicaciones.entidades.usuario import Usuario


def Deserializador():
    path = os.path.join(pathlib.Path(__file__).absolute())
    path = os.path.dirname(path)

    # usuarios
    picklefile = open(path + "\\temp\\usuarios.pkl", 'rb')
    Usuario.usuarios = pickle.load(picklefile)
    picklefile.close()

    # empleados
    picklefile = open(path + "\\temp\\empleados.pkl", 'rb')
    Empleado.setEmpleados(pickle.load(picklefile))
    picklefile.close()

    # facturas
    picklefile = open(path + "\\temp\\facturas.pkl", 'rb')
    Factura.setFacturas(pickle.load(picklefile))
    picklefile.close()

    # ID factura
    picklefile = open(path + "\\temp\\facturaID.pkl", 'rb')
    Factura.setIDfactura(pickle.load(picklefile))
    picklefile.close()

    # camiones
    picklefile = open(path + "\\temp\\camionCisterna.pkl", 'rb')
    CamionCisterna.setCamiones(pickle.load(picklefile))
    picklefile.close()

    picklefile = open(path + "\\temp\\camionFrigorifico.pkl", 'rb')
    CamionFrigorifico.setCamiones(pickle.load(picklefile))
    picklefile.close()

    picklefile = open(path + "\\temp\\camionLona.pkl", 'rb')
    CamionLona.setCamiones(pickle.load(picklefile))
    picklefile.close()

    picklefile = open(path + "\\temp\\camionPortaCoches.pkl", 'rb')
    CamionPortaCoches.setCamiones(pickle.load(picklefile))
    picklefile.close()
