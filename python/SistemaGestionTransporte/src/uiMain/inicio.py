import tkinter as tk


class Inicio(tk.Frame):

    def __init__(self, root):
        super().__init__(root, bg="Blue", width=930, height=530)
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

