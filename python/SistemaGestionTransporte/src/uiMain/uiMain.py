import tkinter as tk
from src.uiMain.inicio import Inicio


class UiMain(tk.Tk):

    def __init__(self):
        super().__init__()
        self.title("Transportes Ltda.")
        self.geometry("950x550")
        self.resizable(False, False)
        self.configure(bg="#F8883E")
        self.ventana = None
        self.ventanaInicio()

    def ventanaInicio(self):
        self.ventana = Inicio(self)