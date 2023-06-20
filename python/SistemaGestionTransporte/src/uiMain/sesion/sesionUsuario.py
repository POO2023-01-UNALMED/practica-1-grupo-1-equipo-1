import os
import pathlib
import tkinter as tk
from functools import partial
from tkinter import messagebox

from PIL import Image, ImageTk

from src.excepcion import *
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
        Camion.datosCamiones()
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
        try:
            valores = datos.aceptar()
            for i in valores:
                if i == '':
                    raise CamposVacios("Digite todos los campos para continuar")
            for u in Usuario.usuarios:
                if u.comprobarUsuario(valores[0], valores[1]):
                    self.usuario = u
            if self.usuario is not None:
                self.showMenu()
            else:
                raise DatoNoEncontrado("Usuario/ID o clave no validas.")
        except CamposVacios as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.principal()
        except DatoNoEncontrado as e:
            messagebox.showerror(e.nombre, e.mensaje)
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
        try:
            valores = registro.aceptar()
            for i in valores:
                if i == '':
                    raise CamposVacios("Digite todos los campos para continuar")
            if self.isRegistroValido(valores):
                self.usuario = Usuario.crearUsuario(valores[0], int(valores[1]), valores[2], valores[3])
                self.showMenu()
            else:
                raise DatoInvalido("Datos no validos, asegurese de escribir el nombre solo con caracteres alfebeticos,"
                                   " el ID solo numeros y escribir bien el correo")
        except CamposVacios as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.principal()
        except DatoInvalido as e:
            messagebox.showerror(e.nombre, e.mensaje)
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
        image = image.resize((930, 530), Image.LANCZOS)
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
        self.destruir(self)
        self.fondoPantalla()
        text = self.usuario.getNombre() + " Bienvenido a transportes LTDA!\n en la zona izquierda superior " \
                                          "encontraras tres menus:\n Archivo, donde podras ver informacion del " \
                                          "sistema y salir al inicio,\n Procesos y Consultas, donde podras realizar un " \
                                          "pedido,\n Seguimiento de un pedido ya realizado o ver el histoarial de " \
                                          "pedidos\n y Ayuda, donde se vera el nombre de los autores."

        tk.Label(self, text=text, bg=self.root["bg"], font=("ROMAN", 20)).place(x=50, y=100)
        menuBar = tk.Menu(self.root, activebackground="#4F53CE", activeforeground="white")
        self.root.config(menu=menuBar)
        archivo = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white",  tearoff=False)
        menuBar.add_cascade(label="Archivo", menu=archivo)
        archivo.add_command(label="Informacion", command=self.informacion)
        archivo.add_command(label="Salir", command=self.salir)

        pyq = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white",  tearoff=False)
        menuBar.add_cascade(label="Procesos y Consultas", menu=pyq)
        pyq.add_command(label="Realizar pedido", command=self.realizarPedido)
        pyq.add_command(label="Seguir pedido", command=self.seguirPedido)
        pyq.add_command(label="Historial de pedidos", command=self.historialPedidos)

        ayuda = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white",  tearoff=False)
        menuBar.add_cascade(label="Ayuda", menu=ayuda)
        ayuda.add_command(label="Acerca de", command=self.autores)

    def informacion(self):
        messagebox.showinfo("Información", "Dentro de esta aplicaciones puedes realizar las opciones de realizar un "
                                           "pedido entre ciudades de los deferentes pasies (Colombia, "
                                           "Ecuador y Panama), realizar el seguimiento de un pedido ya realizado y"
                                           " ver el historial de pedidos realizados")

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

        tk.Button(framePedido, text="Borrar", command=self.showMenu, font=self.font).grid(
            row=len(framePedido.getWCriterios()) + 1, column=1, padx=self.padx, pady=self.pady)

    def aceptarPedido(self, framePedido):
        try:
            valores = framePedido.aceptar()
            for i in valores:
                if i == '':
                    raise CamposVacios("Digite todos los campos para continuar")
            self.pedido = Pedido()
            pais = None
            tipo = None
            ciudades = None
            if valores[0] == "Colombia":
                pais = Pais.COLOMBIA
                ciudades = ["Riohacha", "Valledupar", "Barranquilla", "Cucuta", "Monteria", "Bucaramanga",
                            "Irinida", "Medellin", "Boyaca", "Mitu", "Bogota", "Armenia", "Quibdo", "Villavicencio",
                            "Florencia", "Neiva", "Cali", "Pasto"]
            if valores[0] == "Ecuador":
                pais = Pais.ECUADOR
                ciudades = ["Esmeralda", "Ibarra", "PortoViejo", "Quito", "Nueva Loja", "SantoDomingo",
                            "Guayaquil", "Latacunga", "Tena", "Puerto Francisco", "Riobamba", "Cuenca", "Loja", "Puyo",
                            "Macas", "Zamora"]
            if valores[0] == "Panama":
                pais = Pais.PANAMA
                ciudades = ["Bocas de Toro", "Bugle", "Chiriqui", "Colon", "Veraguas", "Cocle", "Wargandi",
                            "Herrera", "Ciudad de Panama", "Embera", "Los Santos", "Darien"]
            if pais is None:
                raise DatoInvalido("Pais no valido, escoga un pais entre los mostrados")
            if valores[1] not in ciudades or valores[2] not in ciudades:
                nombreC = ""
                for i in ciudades:
                    nombreC += i + " "
                raise DatoNoEncontrado("Ciudad no encontrada. Ciudades: " + nombreC)
            if valores[1] == valores[2]:
                raise CiudadRepetida("La ciudad de origen y destino deben ser diferentes.")
            self.pedido.setPais(pais)
            self.pedido.setOrigen(valores[1])
            self.pedido.setDestino(valores[2])
            if valores[3] == "Perecederos":
                tipo = "Frigorifico"
            elif valores[3] == "Fragil" or valores[3] == "generales":
                tipo = "Lona"
            elif valores[3] == "ADR":
                tipo = "Cisterna"
            elif valores[3] == "coches":
                tipo = "PortaCoches"
            if tipo is None:
                raise DatoInvalido("Tipo de producto no valido, escoga uno entre los mostrados")
            self.pedido.setTipoProdutos(tipo)
            self.selecionarProductos()
        except ErrorAplicacion as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.realizarPedido()

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
        try:
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
            else:
                raise DatoInvalido("Opcion no valida, escoga uno entre los mostrados")
        except DatoInvalido as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.selecionarProductos()

    def ingresarProducto(self):
        self.destruir(self)
        self.fondoPantalla()
        criterios = ["Nombre", "peso (kg)", "volumen m3", "cantidad"]
        ingresarP = FieldFrame(self, "Datos", criterios, "Valores")
        tk.Button(ingresarP, text="Aceptar", command=partial(self.guardarProducto, ingresarP), font=self.font).grid(
            row=len(ingresarP.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)

    def guardarProducto(self, info):
        try:
            valores = info.aceptar()
            for i in valores:
                if i == '':
                    raise CamposVacios("Digite todos los campos para continuar")
            for i in range(1, 4):
                if not valores[i].isdigit():
                    raise DatoInvalido("Digite los datos pedidos, peso, volumen y cantidad solo numeros")
            producto = Producto(valores[0], self.pedido.getTipoProdutos(), float(valores[1]), float(valores[2]),
                                float(valores[3]))
            nuevo = self.pedido.getProductos()
            nuevo.append(producto)
            self.pedido.setProductos(nuevo)
            self.selecionarProductos()
        except ErrorAplicacion as e:
            messagebox.showerror(e.nombre, e.mensaje)
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
        try:
            if not self.pedido.getProductos():
                raise ProductosVacios()
            self.camion = Camion.seleccionarCamion(self.pedido.getTipoProdutos(), self.pedido.getOrigen(),
                                                   self.pedido.calcularpeso(), self.pedido.calcularVolumen())
            if self.camion is None:
                self.camion = self.camionCercano(self.pedido.getTipoProdutos(), self.pedido.getOrigen(),
                                                 self.pedido.calcularpeso())
            if self.camion is None:
                raise CamionNodisponible()
            self.pedido.setVehiculo(self.camion.getPlaca())
            self.camion.setEmpleado(Empleado.seleccionarEmpleado(self.pedido.getOrigen()))
            self.calcularTarifa()
            self.calcularTiempo()
            self.mostrarFactura()
        except ErrorAplicacion as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.selecionarProductos()

    def calcularTarifa(self):
        self.factura = Factura(self.pedido, self.usuario)
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
        criterios = ["numero", "Vendio a:", "ID", "Estado", "origen", "destino", "Salida", "LLegada", "Costo $"]
        mostarF = FieldFrame(self, "Inf de.", criterios, "Factura", self.factura.mostrarDatos(),
                             self.factura.mostrarDatos())

        tk.Button(mostarF, text="Aceptar", command=self.confirmarFactura,
                  font=self.font).grid(
            row=len(mostarF.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)
        tk.Button(mostarF, text="Cancelar", command=self.cancelarFactura, font=self.font).grid(
            row=len(mostarF.getWValores()) + 1, column=1, padx=self.padx, pady=self.pady)

    def confirmarFactura(self):
        self.factura.getPedido().setEstado("Confirmado")
        Factura.agregarFactura(self.factura)
        self.showMenu()

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
        try:
            nombre = eliminar.aceptar()[0]
            if nombre == '':
                raise CamposVacios("Digite todos los campos para continuar")
            for producto in self.pedido.getProductos():
                if producto.getNombre() == nombre:
                    remover = self.pedido.getProductos()
                    remover.remove(producto)
                    self.pedido.setProductos(remover)
                    break
            self.selecionarProductos()
        except ErrorAplicacion as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.selecionarProductos()

    def descartarProductos(self):
        self.destruir(self)
        self.fondoPantalla()
        self.pedido.setProductos([])
        self.selecionarProductos()

    def seguirPedido(self):
        self.destruir(self)
        self.fondoPantalla()
        seguirP = FieldFrame(self, "factura", ["Numero"], "ID")
        tk.Button(seguirP, text="Aceptar", command=partial(self.mostrarPedido, seguirP),
                  font=self.font).grid(
            row=len(seguirP.getWValores()) + 1, column=0, padx=self.padx, pady=self.pady)
        tk.Button(seguirP, text="Cancelar", command=self.showMenu, font=self.font).grid(
            row=len(seguirP.getWValores()) + 1, column=1, padx=self.padx, pady=self.pady)

    def mostrarPedido(self, seguirP):
        try:
            id = seguirP.aceptar()[0]
            if not id.isdigit():
                raise DatoInvalido("Ingresar el numero (ID) de la factura a consultar")
            self.destruir(self)
            self.fondoPantalla()
            criterios = []
            valores = []
            # valores = self.factura.mostrarDatos()
            self.factura = Factura.buscarFactura(int(id), self.usuario.getNombre())
            if self.factura is not None:
                criterios = ["numero", "Vendio a:", "ID", "Estado", "Origen", "Destino", "Salida", "LLegada", "Costo $"]
                Factura.actualizarInformacion(self.factura)
                valores = self.factura.mostrarDatos()
                self.pedido = self.factura.getPedido()
                self.camion = Camion.buscarCamion(self.pedido.getTipoProdutos(), self.pedido.getVehiculo())

                if self.pedido.getEstado() == "Enviado":
                    tiempo = self.pedido.tiempoTranscurrido(self.factura.getHoraSalida())
                    ubicacion = self.camion.ubicacionActual(tiempo)
                    tiempo = self.camion.tiempoRestante(tiempo)
                    criterios = criterios + ["ubicacion", "t. restatnte"]
                    valores = valores + self.factura.infoViaje(ubicacion, tiempo)

            else:
                raise DatoNoEncontrado("Numero de factura no encontrado.")
            framePedido = FieldFrame(self, "Datos", criterios, "valores", valores, valores)
            tk.Button(framePedido, text="Aceptar", command=self.showMenu,
                      font=self.font).grid(row=len(framePedido.getWValores()) + 1, column=0,
                                           padx=self.padx, pady=self.pady)

        except ErrorAplicacion as e:
            messagebox.showerror(e.nombre, e.mensaje)
            self.showMenu()

    def historialPedidos(self):
        self.destruir(self)
        self.fondoPantalla()
        Factura.historialFacturas(self.usuario)
        criterios = []
        valores = []
        for factura in Factura.getFacturas():
            if factura.getUsuario().getNombre() == self.usuario.getNombre():
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
                if empleado.getCiudadActual() == camion.getCiudadActual() and empleado.isEstatusActivo() \
                        and empleado.isDisponible():
                    empleado.setCiudadActual(origen)
                    camion.setCiudadActual(origen)
                    return camion

        return None
