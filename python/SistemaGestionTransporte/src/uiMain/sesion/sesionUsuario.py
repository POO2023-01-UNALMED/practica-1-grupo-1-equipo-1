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

        image = Image.open(SesionUsuario.path + "\\images\\f1.jpg")
        image.resize((930, 530), Image.ANTIALIAS)
        photo = ImageTk.PhotoImage(image)
        fondo = tk.Label(self)
        fondo.image = photo
        fondo.configure(image=photo)
        fondo.place(x=0, y=0, relwidth=1, relheight=1)


"""root = tk.Tk()
root.geometry("930x530")
frame = tk.Frame(root, width=930,height=530)
path = os.path.join(pathlib.Path(__file__).parent.absolute())
path = os.path.dirname(path)
image = Image.open(SesionUsuario.path + "\\images\\f1.jpg")
resize = image.resize((930, 530), Image.LANCZOS)
photo = ImageTk.PhotoImage(resize)
fondo = tk.Label(frame, image=photo)
fondo.image = fondo
fondo.place(x=0, y=0, relwidth=1, relheight=1)
print(path + "\\images\\f_p3.jpg")
root.mainloop()"""
