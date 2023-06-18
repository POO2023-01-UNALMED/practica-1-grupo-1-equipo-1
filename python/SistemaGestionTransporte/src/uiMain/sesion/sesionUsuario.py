import os
import pathlib
import tkinter as tk
from functools import partial
from tkinter import messagebox

from PIL import Image, ImageTk

from src.gestorAplicaciones.Camion.camion import Camion
from src.gestorAplicaciones.Pais.pais import Pais
from src.gestorAplicaciones.Productos.factura import Factura
from src.gestorAplicaciones.Productos.pedido import Pedido
from src.gestorAplicaciones.Productos.producto import Producto
from src.gestorAplicaciones.entidades.empleado import Empleado
from src.gestorAplicaciones.entidades.usuario import Usuario
from src.uiMain.fieldFrame import FieldFrame


class SesionUsuario(tk.Frame):
    path = os.path.join(pathlib.Path(__file__).parent.absolute())
    path = os.path.dirname(path)

    def __init__(self, root):
        self.root = root
        super().__init__(self.root, width=930, height=530)
        self.place(x=10, y=10)
        self.usuario = None
        self.pedido = None
        self.camion = None
        self.factura = None
        self.frame1 = None
        self.padx = 5
        self.pady = 5
        self.font = ("helvetica", 12)
        self.principal()

    def principal(self):
        self.fondoPantalla()
        font = ("ITALIC", 25)
        padx = 355
        pady = 55
        tk.Button(self, text="Iniciar Sesion", font=font, bg="black", fg="white",
                  command=self.ingresar).grid(row=0, column=0, padx=padx, pady=pady)
        tk.Button(self, text="Registrarse", font=font, bg="black", fg="white",
                  command=self.registarUsuario).grid(row=1, column=0, padx=padx, pady=pady)
        tk.Button(self, text="Salir", font=font, bg="black", fg="white",
                  command=self.salir).grid(row=2, column=0, padx=padx, pady=pady)

    def ingresar(self):
        self.destruir(self)
        self.fondoPantalla()
        criterios = ["Nombre/ID", "Clave"]
        datos = FieldFrame(self, "Datos", criterios, "valor")
        tk.Button(datos, text="Aceptar", command=partial(self.validarInformacion, datos), font=self.font).grid(
            row=len(datos.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

        tk.Button(datos, text="Borrar", command=partial(self.borrarRegistro, datos), font=self.font).grid(
            row=len(datos.getWCriterios()) + 1, column=1, padx=self.padx, pady=self.pady)

    def validarInformacion(self, datos):
        valores = datos.aceptar()
        for u in Usuario.usuarios:
            if u.comprobarUsuario(valores[0], valores[1]):
                self.usuario = u
        if self.usuario is not None:
            self.showMenu()
        else:
            self.principal()

    def registarUsuario(self):
        self.destruir(self)
        self.fondoPantalla()
        criterios = ["Nombre", "ID", "Correo", "Clave"]
        registro = FieldFrame(self, "Datos", criterios, "valores")
        tk.Button(registro, text="Aceptar", command=partial(self.aceptarRegistro, registro), font=self.font).grid(
            row=len(registro.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

        tk.Button(registro, text="Borrar", command=partial(self.borrarRegistro, registro), font=self.font).grid(
            row=len(registro.getWCriterios()) + 1, column=1, padx=self.padx, pady=self.pady)

    def aceptarRegistro(self, registro):
        valores = registro.aceptar()
        if self.isRegistroValido(valores):
            self.usuario = Usuario.crearUsuario(valores[0], valores[1], valores[2], valores[3])
            self.showMenu()
        else:
            self.principal()

    def borrarRegistro(self, registro):
        registro.borrar()
        self.principal()

    def salir(self):
        self.destroy()
        self.root.ventanaInicio()

    def destruir(self, frame):
        for children in frame.winfo_children():
            children.destroy()

    def fondoPantalla(self):
        image = Image.open(SesionUsuario.path + "\\images\\f4.jpg")
        image = image.resize((930, 530), Image.ANTIALIAS)
        photo = ImageTk.PhotoImage(image)
        fondo = tk.Label(self)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=0, y=0)

    def isRegistroValido(self, valores):
        if not Usuario.isNombreValido(valores[0]):
            return False
        if not Usuario.isIDValido(valores[1]):
            return False
        if not Usuario.isCorreoValido(valores[2]):
            return False
        return True

    def showMenu(self):
        menuBar = tk.Menu(self.root, activebackground="#4F53CE", activeforeground="white")
        self.root.config(menu=menuBar)
        archivo = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white")
        menuBar.add_cascade(label="Archivo", menu=archivo)
        archivo.add_command(label="Informacion", command=self.informacion)
        archivo.add_command(label="Salir", command=self.salir)

        pyq = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white")
        menuBar.add_cascade(label="Procesos y Consultas", menu=pyq)
        pyq.add_command(label="Realizar pedido", command=self.realizarPedido)
        pyq.add_command(label="Seguir pedido", command=self.seguirPedido)
        pyq.add_command(label="Historial de pedidos", command=self.historialPedidos)

        ayuda = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white")
        menuBar.add_cascade(label="Ayuda", menu=ayuda)
        ayuda.add_command(label="Descripcion del sistema", command=self.autores)

    def informacion(self):
        messagebox.showinfo("Información", "Dentro de esta aplicaciones puedes realizar las opciones de realizar un "
                                           "pedido en tre ciudades de los deferentes pasies (Colombia, "
                                           "Ecuador y Panama), realizar el seguimiento de un pedido ya realizado y"
                                           "ver el historial de pedidos realizados")

    def autores(self):
        messagebox.showinfo("Autores", "Julian Ricardo Salazar Duarte\nMichael Garcia Quincos")

    def realizarPedido(self):
        self.pedido = None
        self.camion = None
        self.factura = None
        self.destruir(self)
        self.fondoPantalla()
        criterios = ["Pais", "Origen", "Destino", "productos tipo"]
        valores = [["Colombia", "Ecuador", "Panama"], '', '', ["Perecederos", "Fragil", "ADR", "coches", "generales"]]
        framePedido = FieldFrame(self, "Datos", criterios, "Valores", valores)
        tk.Button(framePedido, text="Aceptar", command=partial(self.aceptarPedido, framePedido), font=self.font).grid(
            row=len(framePedido.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

        tk.Button(framePedido, text="Borrar", command=partial(self.borrarRegistro, framePedido), font=self.font).grid(
            row=len(framePedido.getWCriterios()) + 1, column=1, padx=self.padx, pady=self.pady)

    def aceptarPedido(self, framePedido):
        valores = framePedido.aceptar()
        self.pedido = Pedido()
        pais = None
        if valores[0] == "Colombia":
            pais = Pais.COLOMBIA
        if valores[0] == "Ecuador":
            pais = Pais.ECUADOR
        if valores[0] == "Panama":
            pais = Pais.PANAMA
        self.pedido.setPais(pais)
        self.pedido.setOrigen(valores[1])
        self.pedido.setDestino(valores[2])
        self.pedido.setTipoProdutos(valores[3])
        self.selecionarProductos()

    def selecionarProductos(self):
        self.destruir(self)
        self.fondoPantalla()
        opciones = [["Ingresar producto", "Ver productos", "Confirmar productos", "Eliminar producto", "Descartar "
                                                                                                       "productos"]]
        frameProductos = FieldFrame(self, "menu", ["Selecione"], "Opciones", opciones)
        tk.Button(frameProductos, text="Aceptar", command=partial(self.opcionProductos, frameProductos),
                  font=self.font).grid(row=len(frameProductos.getWValores()) + 1, column=0, padx=self.padx,
                                       pady=self.pady)

    def opcionProductos(self, frameProductos):
        opcion = frameProductos.aceptar()[0]

        if opcion == "Ingresar producto":
            self.ingresarProducto()
        elif opcion == "Ver productos":
            self.verProductos()
        elif opcion == "Confirmar productos":
            self.confirmarProductos()
        elif opcion == "Eliminar producto":
            self.eliminarProducto()
        elif opcion == "Descartar productos":
            self.descartarProductos()

    def ingresarProducto(self):
        self.destruir(self)
        self.fondoPantalla()
        criterios = ["Nombre", "peso (kg)", "volumen m3", "cantidad"]
        ingresarP = FieldFrame(self, "Datos", criterios, "Valores")
        tk.Button(ingresarP, text="Aceptar", command=partial(self.guardarProducto, ingresarP), font=self.font).grid(
            row=len(ingresarP.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

    def guardarProducto(self, info):
        valores = info.aceptar()
        producto = Producto(valores[0], self.pedido.getTipoProdutos(), float(valores[1]), float(valores[2]),
                            float(valores[3]))
        nuevo = self.pedido.getProductos()
        nuevo.append(producto)
        self.pedido.setProductos(nuevo)
        self.selecionarProductos()

    def verProductos(self):
        self.destruir(self)
        self.fondoPantalla()
        criterios = []
        cantidad = []
        if self.pedido.getProductos() is not None:
            for producto in self.pedido.getProductos():
                criterios.append(producto.getNombre())
                cantidad.append(str(producto.getCantidad()))
        verP = FieldFrame(self, "Nombre", criterios, "Cantidad", cantidad, cantidad)
        tk.Button(verP, text="Aceptar", command=self.selecionarProductos, font=self.font).grid(
            row=len(verP.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

    def confirmarProductos(self):
        self.camion = Camion.seleccionarCamion(self.pedido.getTipoProdutos(), self.pedido.getOrigen(),
                                               self.pedido.calcularpeso(), self.pedido.calcularVolumen())
        if self.camion is None:
            self.camion = self.camionCercano(self.pedido.getTipoProdutos(), self.pedido.getOrigen(),
                                             self.pedido.calcularpeso())
        self.pedido.setVehiculo(self.camion.getPlaca())
        self.camion.setEmpleado(Empleado.seleccionarEmpleado(self.pedido.getOrigen()))
        self.calcularTarifa()
        self.calcularTiempo()
        self.mostrarFactura()

    def calcularTarifa(self):
        self.factura = self.factura(self.pedido, self.usuario)
        self.camion.setRuta(self.pedido.calcularRuta())
        self.camion.calcularCostoCamion()
        costoPedido = self.camion.getCosto()
        costoPedido = self.camion.getEmpleado().calcularPago(costoPedido)
        self.factura.calcularCostoTotal(costoPedido, self.camion.getCapacidad())

    def calcularTiempo(self):
        self.factura.setHoraSalida(self.pedido.calcularHoraSalida())
        self.factura.setHoraLLegada(self.pedido.calcularHoraLlegada(self.camion.calcularTiempo(),
                                                                    self.factura.getHoraSalida()))

    def mostrarFactura(self):
        self.destruir(self)
        self.fondoPantalla()
        mostarF = FieldFrame(self, "mostrarFactura", "Most", "otra", "otra")
        tk.Button(mostarF, text="Aceptar", command=self.confirmarFactura,
                  font=self.font).grid(
            row=len(mostarF.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)
        tk.Button(mostarF, text="Cancelar", command=self.cancelarFactura, font=self.font).grid(
            row=len(mostarF.getWValores()) + 1, column=1, padx=self.padx, pady=self.pady)

    def confirmarFactura(self):
        Factura.agregarFactura(self.factura)
        self.cancelarFactura()

    def cancelarFactura(self):
        self.pedido = None
        self.camion = None
        self.factura = None
        self.showMenu()

    def eliminarProducto(self):
        self.destruir(self)
        self.fondoPantalla()
        eliminarP = FieldFrame(self, "Producto", ["nombre"], "elimnar")
        tk.Button(eliminarP, text="Aceptar", command=partial(self.confirmarEliminacionP, eliminarP),
                  font=self.font).grid(
            row=len(eliminarP.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)
        tk.Button(eliminarP, text="Cancelar", command=self.selecionarProductos, font=self.font).grid(
            row=len(eliminarP.getWValores()) + 1, column=1, padx=self.padx, pady=self.pady)

    def confirmarEliminacionP(self, eliminar):
        nombre = eliminar.aceptar()[0]
        for producto in self.pedido.getProductos():
            if producto.getNombre() == nombre:
                remover = self.pedido.getProductos()
                remover.remove(producto)
                print(remover)
                self.pedido.setProductos(remover)
                break
        self.selecionarProductos()

    def descartarProductos(self):
        self.destruir(self)
        self.fondoPantalla()
        self.pedido.setProductos([])
        self.selecionarProductos()

    def seguirPedido(self):
        pass

    def historialPedidos(self):
        self.destruir(self)
        self.fondoPantalla()
        Factura.historialFacturas(self.usuario)
        criterios = []
        valores = []
        for factura in Factura.getFacturas():
            if factura.getUsuario().getnombre() == self.usuario.getNombre():
                criterios.append(factura.getID())
                valores.append(factura.getPedido().getEstado())
        historial = FieldFrame(self, "No. Factura", criterios, "Estado", valores, valores)
        tk.Button(historial, text="Aceptar", command=partial(self.aceptarOpcion, historial), font=self.font).grid(
            row=len(historial.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

    def aceptarOpcion(self, opcion):
        opcion.destroy()
        self.showMenu()

    def camionCercano(self, tipoCarga, origen, peso):
        if peso <= 1:
            peso = 1
        elif peso <= 8:
            peso = 8
        elif peso <= 17:
            peso = 17
        else:
            peso = 24

        camion = None
        distancia = float('inf')
        pedido = Pedido()
        pedido.setPais(self.pedido.getPais())
        pedido.setDestino(origen)

        for c in Camion.camiones.get(tipoCarga):
            if c.getPesoMaximo() == peso and c.isDisponible() and c.getPais() == pedido.getPais().getNombre():
                pedido.setOrigen(c.getCiudadActual())

                for d in pedido.calcularRuta():
                    if d[0] == origen and d[1] < distancia:
                        distancia = d[1]
                        camion = c

        if camion:
            for empleado in Empleado.getEmpleados():
                if empleado.getCiudadActual() == camion.get_ciudad_actual() and empleado.isEstatusActivo() and empleado.isDisponible():
                    empleado.setCiudadActual(origen)
                    camion.set_ciudad_actual(origen)
                    return camion

        return None
