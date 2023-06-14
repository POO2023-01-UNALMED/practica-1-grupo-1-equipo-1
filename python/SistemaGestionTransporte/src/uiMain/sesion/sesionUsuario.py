import os
import pathlib
import tkinter as tk
from functools import partial

from PIL import Image, ImageTk

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
        pass

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

        tk.Button(registro, text="Borrar", command=partial(self.borrarRegistro,registro), font=font).grid(
            row=len(registro.getWCriterios()) + 1,
            column=1, padx=padx, pady=pady)

    def aceptarRegistro(self, registro):
        valores = registro.aceptar()
        if self.isRegistroValido(valores):
            # crear usuario
            self.showMenu()
        else:
            self.principal()


    def borrarRegistro(self, registro):
        registro.borrar()

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
        pass
