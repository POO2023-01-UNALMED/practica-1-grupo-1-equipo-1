import tkinter as tk


class SesionEmpleado(tk.Frame):
    def __init__(self, root):
        super().__init__(root, bg="blue", width=930, height=530)
        self.place(x=10, y=10)