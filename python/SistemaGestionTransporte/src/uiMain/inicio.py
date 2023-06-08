import tkinter as tk
from tkinter.font import Font

from src.uiMain.sesion.sesionAdministrador import SesionAdministrador
from src.uiMain.sesion.sesionEmpleado import SesionEmpleado
from src.uiMain.sesion.sesionUsuario import SesionUsuario


class Inicio(tk.Frame):

    def __init__(self, root):
        self.root = root
        super().__init__(self.root, bg="Blue", width=930, height=530)
        self.place(x=10, y=10)
        self.p1 = tk.Frame(self, bg="green", width=455, height=530)
        self.p1.place(x=0, y=0)
        self.p2 = tk.Frame(self, bg="yellow", width=455, height=530)
        self.p2.place(x=475, y=0)
        self.p3 = tk.Frame(self.p1, bg="red", width=455, height=180)
        self.p3.place(x=0, y=0)
        self.p4 = tk.Frame(self.p1, bg="purple", width=455, height=350)
        self.p4.place(x=0, y=180)
        self.p5 = tk.Frame(self.p2, bg="pink", width=455, height=180)
        self.p5.place(x=0, y=0)
        self.p6 = tk.Frame(self.p2, bg="brown", width=455, height=350)
        self.p6.place(x=0, y=180)
        self.hojaVida = {"Julian": "Nombre:    Julian Salazar.\nEdad:    21 años.\nFecha:    24 Diciembre 2001\n"
                                   "Ocupacion:Estudiante\nemail:    jusalazard@unal.edu.co"}

    def bienvenida(self):
        font = Font(size=40)
        tk.Label(self.p3, text="Bienvenidos a \nTransportes Ltda", font=font).place(x=25, y=30)
        tk.Button(self.p4, text="ingresar", font=font, command=self.tipoSesion).place(x=100, y=120)

    def desarrolladores(self, dev):
        font = Font(size=15)
        tk.Label(self.p5, text=self.hojaVida[dev], font=font).place(x=20, y=10)

    def tipoSesion(self):
        self.p4.winfo_children()[0].destroy()
        font = Font(size=15)
        tk.Button(self.p4, text="Usuario", font=font, command=self.ingresarUsuario).place(x=182, y=70)
        tk.Button(self.p4, text="Empleado", font=font, command=self.ingresarEmpleado).place(x=170, y=130)
        tk.Button(self.p4, text="Administrador", font=font, command=self.ingresarAdministrador).place(x=150, y=190)

    def ingresarUsuario(self):
        self.destroy()
        SesionUsuario(self.root.getWindow())

    def ingresarEmpleado(self):
        self.destroy()
        SesionEmpleado(self.root.getWindow())

    def ingresarAdministrador(self):
        self.destroy()
        SesionAdministrador(self.root.getWindow())
