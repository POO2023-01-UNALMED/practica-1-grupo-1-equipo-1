import os
import pathlib
import tkinter as tk
from PIL import Image, ImageTk


class SesionUsuario(tk.Frame):
    path = os.path.join(pathlib.Path(__file__).parent.absolute())
    path = os.path.dirname(path)

    def __init__(self, root):
        super().__init__(root, width=930, height=530)
        self.place(x=10, y=10)

