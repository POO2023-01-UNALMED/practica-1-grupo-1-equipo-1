from src.uiMain.uiMain import UiMain
from tkinter import messagebox
import importlib

# Verificar si PIL está instalado
try:
    importlib.import_module('PIL')
except ImportError:
    try:
        import pip

        pip.main(['install', 'Pillow'])
    except ImportError:
        messagebox.showerror('Pillow', "No se pudo instalar PIL. Asegúrate de tener pip instalado.")
        exit()


def actualizarInformacion(factura):
    pass


if __name__ == '__main__':
    gui = UiMain()
    gui.mainloop()
