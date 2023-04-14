package gestorAplicaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public enum Pais implements Archivo{
    COLOMBIA("Colombia"),
    PANAMA("Panama"),
    ECUADOR("Ecuador");

    private String nombre;
    private ArrayList<Ciudad>ciudades;

    Pais(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ciudad getCiudad(String nombreCiudad) {
        for (Ciudad  ciudad : this.ciudades){
            if (ciudad.getNombre().equals(nombreCiudad)){
                return ciudad;
            }
        }
        return null;

    }

    private void  GenerarConexiones(){
        String mapa = LeerArchivo(this.nombre+".txt");
        String[] lineas = mapa.split("\n");
        String[] conexion;
        for (String linea : lineas){
            conexion = linea.split(" ");
            if(this.isCiudad(conexion[0])) agregarCiudad(conexion[0]);
            if(this.isCiudad(conexion[1])) agregarCiudad(conexion[1]);
            this.costoCiudades(conexion[0],conexion[1],Double.parseDouble(conexion[2]));
        }
    }

    public boolean isCiudad(String nombreCiudad){
        for(Ciudad ciudad : this.ciudades){
            if(ciudad.getNombre().equals(nombreCiudad)) return false;
        }
        return true;
    }

    private void agregarCiudad(String nombreCiudad){
        this.ciudades.add(new Ciudad(nombreCiudad));
        this.conexionesIniciales();

    }

    private void conexionesIniciales(){
        //int indice = this.ciudades.indexOf(nombreCiudad);
        Ciudad ciudad = ciudades.get(ciudades.size() - 1);
        for (Ciudad ciudadAdyacente : this.ciudades){
            if(!ciudad.getNombre().equals(ciudadAdyacente.getNombre())){
                ciudad.conectarCiudades(ciudadAdyacente.getNombre(),-1);
                ciudadAdyacente.conectarCiudades(ciudad.getNombre(),-1);
            }
        }
    }

    public void costoCiudades(String nombreCiudad1, String nombreCiudad2, double costo){
        for(Ciudad ciudad1 : this.ciudades){
            if(ciudad1.getNombre().equals(nombreCiudad1)){
                for(Ciudad ciudad2 : this.ciudades){
                    if(ciudad2.getNombre().equals(nombreCiudad2)){
                        ciudad1.conectarCiudades(ciudad2.getNombre(), costo);
                        ciudad2.conectarCiudades(ciudad1.getNombre(), costo);
                        break;
                    }
                }
                break;
            }
        }
    }

    @Override
    public String LeerArchivo(String fileName) {
        StringBuilder texto = new StringBuilder();
        try{
            File archivo = new File(fileName);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()){
                texto.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
        return texto.toString();
    }

    @Override
    public void EditarArchivo(String fileName, String text) {

    }
}
