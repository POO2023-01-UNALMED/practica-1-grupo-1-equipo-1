from src.uiMain.uiMain import UiMain

import importlib

# Verificar si PIL está instalado
try:
    importlib.import_module('PIL')
except ImportError:
    try:
        import pip
        pip.main(['install', 'Pillow'])
    except ImportError:
        print("No se pudo instalar PIL. Asegúrate de tener pip instalado.")


if __name__ == '__main__':
    gui = UiMain()
    gui.mainloop()
