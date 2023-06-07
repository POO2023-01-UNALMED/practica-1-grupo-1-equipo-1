import tkinter as tk
from src.uiMain.inicio import Inicio


class UiMain(tk.Tk):

    def __init__(self):
        super().__init__()
        self.title("Transportes LTDA")
        self.geometry("950x550")
        self.resizable(False, False)
        self.ventana = Inicio(self)
        self.ventana.bienvenida()
        self.ventana.desarrolladores()

    def getWindow(self):
        return self
