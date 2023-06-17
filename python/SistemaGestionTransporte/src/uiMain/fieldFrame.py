import os
import pathlib
import tkinter as tk
from PIL import Image, ImageTk
from tkinter import ttk


class FieldFrame(tk.Frame):
    def __init__(self, root, tituloCriterios, criterios, tituloValores, valores=None, habilitado=['-']):
        super().__init__(root, width=400, height=430)
        if habilitado is None:
            habilitado = []
        self.place(x=300, y=100)
        self.tituloCriterios = tituloCriterios
        self.criterios = criterios
        self.tituloValores = tituloValores
        self.valores = valores
        self.habilitado = habilitado
        self.wCriterios = []
        self.wValores = []
        self.implementar()

    def getWCriterios(self):
        return self.wCriterios

    def getWValores(self):
        return self.wValores

    def implementar(self):
        self.grid_propagate(False)
        path = os.path.join(pathlib.Path(__file__).absolute())
        path = os.path.dirname(path)
        image = Image.open(path + "\\images\\orange.jpg")
        image = image.resize((730, 430), Image.LANCZOS)
        photo = ImageTk.PhotoImage(image)
        fondo = tk.Label(self)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=0, y=0)
        padx = 50
        pady = 20
        font = ("helvetica", 20)
        tk.Label(self, text=self.tituloCriterios, font=font, bg="#FEC343").grid(row=0, column=0, padx=padx, pady=pady)
        tk.Label(self, text=self.tituloValores, font=font, bg="#FEC343").grid(row=0, column=1, padx=padx, pady=pady)
        padx = 5
        pady = 5
        font = ("helvetica", 12)
        bg = "#FEC343"
        for criterio in self.criterios:
            self.wCriterios.append(tk.Label(self, text=criterio, font=font, bg=bg))
        if self.valores is not None:
            for valor in self.valores:
                if isinstance(valor, list):
                    self.wValores.append(ttk.Combobox(self, values=valor, justify="center"))
                elif valor in self.habilitado:
                    self.wValores.append(tk.Entry(self, justify="center", bg=bg, state="disabled"))
                    self.wValores[-1].insert(0, valor)
                else:
                    self.wValores.append(tk.Entry(self, justify="center", bg=bg))
                    self.wValores[-1].insert(0, valor)
        else:
            for i in range(len(self.wCriterios)):
                self.wValores.append(tk.Entry(self, justify="center", bg=bg))

        for i in range(len(self.wCriterios)):
            self.wCriterios[i].grid(row=i + 1, column=0, padx=padx, pady=pady)
        for i in range(len(self.wValores)):
            self.wValores[i].grid(row=i + 1, column=1, padx=padx, pady=pady)

    def getValue(self, criterio):
        try:
            pos = self.criterios.index(criterio)
            return self.wValores[pos].get()
        except ValueError:
            return None

    def aceptar(self):
        valores = []
        for valor in self.wValores:
            valores.append(valor.get())
        self.borrar()
        return valores

    def borrar(self):
        for valor in self.wValores:
            valor.delete(0, "end")
        self.destroy()
