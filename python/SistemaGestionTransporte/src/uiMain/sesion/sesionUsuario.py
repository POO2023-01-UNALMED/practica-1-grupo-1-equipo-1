import os
import pathlib
import tkinter as tk
from functools import partial
from tkinter import messagebox

from PIL import Image, ImageTk

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
        padx = 5
        pady = 5
        font = ("helvetica", 12)
        criterios = ["Nombre/ID", "Clave"]
        datos = FieldFrame(self, "Datos", criterios, "valores")
        tk.Button(datos, text="Aceptar", command=partial(self.validarInformacion, datos), font=font).grid(
            row=len(datos.getWValores()) + 1,
            column=0, padx=padx, pady=pady)

        tk.Button(datos, text="Borrar", command=partial(self.borrarRegistro, datos), font=font).grid(
            row=len(datos.getWCriterios()) + 1,
            column=1, padx=padx, pady=pady)

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
        padx = 5
        pady = 5
        font = ("helvetica", 12)
        criterios = ["Nombre", "ID", "Correo", "Clave"]
        registro = FieldFrame(self, "Datos", criterios, "valores")
        tk.Button(registro, text="Aceptar", command=partial(self.aceptarRegistro, registro), font=font).grid(
            row=len(registro.getWValores()) + 1,
            column=0, padx=padx, pady=pady)

        tk.Button(registro, text="Borrar", command=partial(self.borrarRegistro, registro), font=font).grid(
            row=len(registro.getWCriterios()) + 1,
            column=1, padx=padx, pady=pady)

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
        pass

    def seguirPedido(self):
        pass

    def historialPedidos(self):
        pass
