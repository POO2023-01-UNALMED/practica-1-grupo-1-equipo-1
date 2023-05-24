package gestorAplicaciones.pais;

import uiMain.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * enumeración que representa diferentes países (Colombia, Panama y Ecuador)
 * //Atrbutos
 * nombre: Es un atributo que almacena el nombre del país.
 * ciudades:  Es un ArrayList que almacena las ciudades asociadas al país.
 *
 * @author Julian Salazar, Michael Garcia
 */
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

    /**
     *
     * @return String con el nombre de las ciudades asociadas al pais.
     */
    public String mostarCiudades() {
        //muesta las ciudades asociadas al pais
        StringBuilder ciudades = new StringBuilder();
        ciudades.append("ciudades de ").append(this.nombre).append("\n");
        for (Ciudad ciudad : this.ciudades) {
            ciudades.append(ciudad).append("\t");
        }
        return ciudades.toString();
    }

    /**
     * Leer un archivo de texto que contiene información sobre las conexiones entre las ciudades
     * y crea el grafo de conexiones.
     */
    private void generarConexiones() {
        String ruta = "../src/baseDatos/temp/paises/" + this.nombre + ".txt";
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

    /**
     *
     * @param nombreCiudad nombre de una ciudad
     * @return si la ciudad pertenece a ciudades retorna true de lo contrario retorna false.
     */
    public boolean isCiudad(String nombreCiudad) {

        for (Ciudad ciudad : this.ciudades) {
            if (ciudad.getNombre().equals(nombreCiudad)) return true;
        }
        return false;
    }

    /**
     * Crea una nueva instancia de Ciudad y la agrega a la lista de ciudades del país.
     * @param nombreCiudad nombre nueva ciudad
     */
    private void agregarCiudad(String nombreCiudad) {

        this.ciudades.add(new Ciudad(nombreCiudad, this.nombre));
        this.conexionesIniciales();

    }

    /**
     * Establece conexiones iniciales entre la nueva ciudad agregada y las ciudades existentes en el país
     * que or defecto es -1 (no coectadas directamente)
     */
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

    /**
     * km entre una ciudad y la otra conectadas directamente
     * @param nombreCiudad1 ciudad1
     * @param nombreCiudad2 ciudad2
     * @param costo km de separacion
     */
    public void costoCiudades(String nombreCiudad1, String nombreCiudad2, double costo) {

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

    /**
     *
     * @param fileName ruta del archivo donde se almacena la lista de ciudades.
     * @return String con la informacion del archivo.
     */
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
}