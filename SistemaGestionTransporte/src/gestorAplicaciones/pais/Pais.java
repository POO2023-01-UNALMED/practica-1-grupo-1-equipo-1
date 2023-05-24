package gestorAplicaciones.pais;

import uiMain.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public enum Pais {
    COLOMBIA("Colombia"),
    PANAMA("Panama"),
    ECUADOR("Ecuador");

    //atributos
    private String nombre;
    private ArrayList<Ciudad> ciudades;

    //constructor
    Pais(String nombre) {
        this.nombre = nombre;
        this.ciudades = new ArrayList<Ciudad>();
        this.generarConexiones();
    }

    //metodos getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Ciudad getCiudad(String nombreCiudad) {
        for (Ciudad ciudad : this.ciudades) {
            if (ciudad.getNombre().equals(nombreCiudad)) {
                return ciudad;
            }
        }
        return null;

    }

    public void mostarCiudades() {
        //muesta las ciudades asociadas al pais
        System.out.println("ciudades de " + this.nombre);
        for (Ciudad ciudad : this.ciudades) {
            System.out.print(ciudad.toString()+"\t");
        }
    }

    private void generarConexiones() {
        //generar el grafo de conexiones entre las ciudades
        String ruta = "src/baseDatos/temp" + this.nombre + ".txt";
        String mapa = LeerArchivo(ruta);
        String[] lineas = mapa.split("\n");
        String[] conexion;
        for (String linea : lineas) {
            conexion = linea.split(":");
            if (!this.isCiudad(conexion[0])) agregarCiudad(conexion[0]);
            if (!this.isCiudad(conexion[1])) agregarCiudad(conexion[1]);
            this.costoCiudades(conexion[0], conexion[1], Double.parseDouble(conexion[2]));
        }
    }

    public boolean isCiudad(String nombreCiudad) {
        for (Ciudad ciudad : this.ciudades) {
            if (ciudad.getNombre().equals(nombreCiudad)) return true;
        }
        return false;
    }

    private void agregarCiudad(String nombreCiudad) {
        this.ciudades.add(new Ciudad(nombreCiudad, this.nombre));
        this.conexionesIniciales();

    }

    private void conexionesIniciales() {
        //cada que se añada una nueva ciudad se conecta con las demas opciones con -1 (no conectada)
        Ciudad ciudad = ciudades.get(ciudades.size() - 1);
        for (Ciudad ciudadAdyacente : this.ciudades) {
            if (!ciudad.getNombre().equals(ciudadAdyacente.getNombre())) {
                ciudad.conectarCiudades(ciudadAdyacente.getNombre(), -1);
                ciudadAdyacente.conectarCiudades(ciudad.getNombre(), -1);
            }
        }
    }

    public void costoCiudades(String nombreCiudad1, String nombreCiudad2, double costo) {
        //conecta dos ciudades directamente
        for (Ciudad ciudad1 : this.ciudades) {
            if (ciudad1.getNombre().equals(nombreCiudad1)) {
                for (Ciudad ciudad2 : this.ciudades) {
                    if (ciudad2.getNombre().equals(nombreCiudad2)) {
                        ciudad1.conectarCiudades(ciudad2.getNombre(), costo);
                        ciudad2.conectarCiudades(ciudad1.getNombre(), costo);
                        break;
                    }
                }
                break;
            }
        }
    }

    public String LeerArchivo(String fileName) {
        //cargar grafo de las ciudades.
        StringBuilder texto = new StringBuilder();
        try {
            File archivo = new File(fileName);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                texto.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
        return texto.toString();
    }
    public void EditarArchivo(String fileName, String text) {

    }
}