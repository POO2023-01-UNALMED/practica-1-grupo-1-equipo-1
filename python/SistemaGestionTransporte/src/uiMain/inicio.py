import os
import pathlib
import tkinter as tk
from PIL import Image, ImageTk
from tkinter import messagebox

from src.uiMain.sesion.sesionAdministrador import SesionAdministrador
from src.uiMain.sesion.sesionEmpleado import SesionEmpleado
from src.uiMain.sesion.sesionUsuario import SesionUsuario


class Inicio(tk.Frame):
    path = os.path.join(pathlib.Path(__file__).absolute())
    path = os.path.dirname(path)

    def __init__(self, root):
        self.root = root
        super().__init__(self.root, width=930, height=530)
        self.place(x=10, y=10)
        self.hojaVida = None
        self.p6 = None
        self.p5 = None
        self.p4 = None
        self.p3 = None
        self.p2 = None
        self.p1 = None
        self.indice = 0
        self.dev = "julian"
        self.info = []
        self.frames()
        self.menuInicio()

    def bienvenida(self):
        tk.Label(self.p3, text="Bienvenidos a \nTransportes Ltda.", bg=self.p3["bg"],
                 font=("ROMAN", 40)).place(x=25, y=30)
        self.cambiarImagenP4(None)

    def desarrolladores(self):
        # tk.Label(self.p5, text=self.hojaVida[self.dev], bg="#FFE8C6", font=("ROMAN", 15)).place(x=20, y=10)
        self.info = self.info.clear()
        self.info = []
        info = self.hojaVida[self.dev].split(':')
        font = ("Times New Roman", 12)
        bg = self.p5["bg"]
        padx = 60
        pady = 3
        self.info.append(tk.Label(self.p5, text=info[0], bg=bg, font=font))
        self.info[0].grid(row=0, column=0, columnspan=2, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text="Ocupacion:", bg=bg, font=font))
        self.info[1].grid(row=1, column=0, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text=info[1].center(len(info[-1])), bg=bg, font=font))
        self.info[2].grid(row=1, column=1, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text="    Edad:  ", bg=bg, font=font))
        self.info[3].grid(row=2, column=0, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text=info[2].center(len(info[-1])), bg=bg, font=font))
        self.info[4].grid(row=2, column=1, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text="   Fecha:  ", bg=bg, font=font))
        self.info[5].grid(row=3, column=0, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text=info[3].center(len(info[-1])), bg=bg, font=font))
        self.info[6].grid(row=3, column=1, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text="  Email:   ", bg=bg, font=font))
        self.info[7].grid(row=4, column=0, padx=padx, pady=pady)
        self.info.append(tk.Label(self.p5, text=info[4].center(len(info[-1])), bg=bg, font=font))
        self.info[8].grid(row=4, column=1, padx=padx, pady=pady)
        images = []
        for i in range(1, 5):
            imagen = Image.open(Inicio.path + "\\images\\" + self.dev + "\\" + str(i) + ".jpg")
            imagen = imagen.resize((222, 175))
            photo = ImageTk.PhotoImage(imagen)
            fondo = tk.Label(self.p6)
            fondo.image = photo
            fondo.configure(image=photo)
            images.append(fondo)

        i = 0
        for row in range(0, 2):
            for column in range(0, 2):
                images[i].grid(row=row, column=column, padx=5, pady=5)
                i += 1

        if self.dev == "julian":
            self.dev = "Michael"
        else:
            self.dev = "julian"
        print(self.dev)

        for i in self.info:
            i.bind("<Button-1>", self.cambiarInfoP2)

    def tipoSesion(self):
        self.destruir(self.p4)
        self.p4.destroy()
        self.p4 = tk.Frame(self.p1, width=455, height=350)
        self.p4.place(x=0, y=180)
        font = ("ITALIC", 25)
        imagen = Image.open(Inicio.path + "\\images\\orange.jpg")
        imagen = imagen.resize((460, 360))
        photo = ImageTk.PhotoImage(imagen)
        fondo = tk.Label(self.p4)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=-5, y=-5)
        """imagen = tk.PhotoImage(file=Inicio.path + "\\images\\orange.png")
        imagen = imagen.subsample(2)
        fondo = tk.Label(self.p4)
        fondo.image = imagen
        fondo.configure(image=imagen)
        fondo.place(x=-5, y=-5)"""
        tk.Button(self.p4, text="Usuario", font=font, bg="black", fg=self.p3["bg"],
                  command=self.ingresarUsuario).place(x=150, y=60)
        tk.Button(self.p4, text="Empleado", font=font, bg="black", fg=self.p3["bg"],
                  command=self.ingresarEmpleado).place(x=130, y=142)
        tk.Button(self.p4, text="Administrador", font=font, bg="black", fg=self.p3["bg"],
                  command=self.ingresarAdministrador).place(x=100, y=225)

    def ingresarUsuario(self):
        self.destruir(self.root)
        SesionUsuario(self.root)

    def ingresarEmpleado(self):
        self.destruir(self.root)
        SesionEmpleado(self.root)

    def ingresarAdministrador(self):
        self.destruir(self.root)
        SesionAdministrador(self.root)

    def frames(self):
        image = Image.open(Inicio.path + "\\images\\f3.jpg")
        image = image.resize((930, 530), Image.ANTIALIAS)
        photo = ImageTk.PhotoImage(image)
        fondo = tk.Label(self)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=0, y=0, relwidth=1, relheight=1)

        self.p1 = tk.Frame(self, width=455, height=530)
        self.p1.place(x=0, y=0)

        self.p2 = tk.Frame(self, bg="#FDC345", width=455, height=530)
        self.p2.place(x=475, y=0)

        self.p3 = tk.Frame(self.p1, bg="#FEC343", width=455, height=180)
        self.p3.place(x=0, y=0)

        self.p4 = tk.Frame(self.p1, width=455, height=350)
        self.p4.place(x=0, y=180)
        self.p4.bind("<Enter>", self.cambiarImagenP4)

        self.p5 = tk.Frame(self.p2, bg="#f7b21d", width=455, height=150)
        self.p5.place(x=0, y=0)
        # self.p5.bind("<Button-1>", self.cambiarInfoP2)

        self.p6 = tk.Frame(self.p2, bg=self.p2["bg"], width=455, height=380)
        self.p6.place(x=0, y=150)

        self.hojaVida = {"julian": "Julian Ricardo Salazar Duarte:Estudiante:21 años:24 Diciembre "
                                   "2001:jusalazard@unal.edu.co",
                         "Michael": "Nombre:Ocupacion:edad:fecha:email"}

        self.bienvenida()
        self.desarrolladores()

    def cambiarImagenP4(self, event):
        self.indice += 1
        if self.indice > 5:
            self.indice = 1
        self.destruir(self.p4)
        ruta = Inicio.path + "\\images\\f" + str(self.indice) + ".jpg"
        image = Image.open(ruta)
        image = image.resize((455, 350), Image.ANTIALIAS)
        photo = ImageTk.PhotoImage(image)
        fondo = tk.Label(self.p4)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=0, y=0, relwidth=1, relheight=1)
        tk.Button(self.p4, text="ingresar", font=("ITALIC", 25), command=self.tipoSesion,
                  bg="black", fg=self.p3["bg"]).place(x=140, y=140)

    def cambiarInfoP2(self, event):
        self.destruir(self.p5)
        self.destruir(self.p6)
        self.desarrolladores()

    def destruir(self, frame):
        for children in frame.winfo_children():
            children.destroy()

    def menuInicio(self):
        menuBar = tk.Menu(self.root, activebackground="#4F53CE", activeforeground="white")
        self.root.config(menu=menuBar)

        menu = tk.Menu(menuBar, activebackground="#4F53CE", activeforeground="white")
        menuBar.add_cascade(label="Inicio", menu=menu)
        menu.add_command(label="Descripcion del sistema", command=self.descripcion)
        menu.add_command(label="Salir", command=self.salir)

    def descripcion(self):
        messagebox.showinfo("Descripcion del sistema", "Plataforma para administrar de manera efectiva todas "
                                                       "las operaciones relacionadas con el transporte de mercancías "
                                                       "entre ciudades de diferentes países. Garantizando la "
                                                       "puntualidad, seguridad y satisfacción del cliente.")

    def salir(self):
        opcion = messagebox.askokcancel("Salir", "Salir del sistema")
        if opcion:
            self.root.destroy()
