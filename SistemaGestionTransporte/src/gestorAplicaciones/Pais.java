package gestorAplicaciones;

import java.util.ArrayList;


public enum Pais {
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
}
