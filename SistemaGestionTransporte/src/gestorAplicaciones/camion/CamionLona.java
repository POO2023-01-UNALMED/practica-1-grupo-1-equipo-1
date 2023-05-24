package gestorAplicaciones.camion;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


/**
*  clase CamionLona es una subclase de la clase Camion*  Atributos:
*  Camiones:  ArrayList estático de objetos de tipo CamionLona que almacena
*  todos los camiones lona creados.
 *
 *  @author Julian Salazar, Michael Garcia
*/

public class CamionLona extends Camion implements Serializable {
    //serializador
    @Serial
    private static final long serialVersionUID = 1L;

    public static ArrayList<CamionLona> camiones = new ArrayList<CamionLona>();

    public CamionLona(String placa, String pais, String CiudadActual, double pesoMaximo, double capacidad) {
        super(placa, pais, CiudadActual, pesoMaximo, capacidad);
        camiones.add(this);
    }

    public CamionLona(){}

    public static ArrayList<CamionLona> getCamiones() {
        return CamionLona.camiones;
    }

    public static void setCamiones(ArrayList<CamionLona> camiones){
        CamionLona.camiones = camiones;
    }

    @Override
    public void calcularCostoCamion() {
        double factor = 0.005;
        double km = this.getRuta().get(this.getRuta().size() - 1).getValue();
        this.setCosto(km * this.getCapacidad() * factor);
    }

    @Override
    public double valocidad() {
        double velocidadBase = 85.7;
        double factor = -0.2857;
        return velocidadBase + this.getCapacidad() * factor;
    }

    @Override
    public String toString() {
        return "\nTipo: Lona" +
                "\nPlaca: " + this.getPlaca() +
                "\npais: " + this.getPais() +
                "\nCiudad actual: " + this.getCiudadActual() +
                "\nPeso Maximo: " + this.getPesoMaximo() +
                "\nCapacidad: " + this.getCapacidad() +
                "\nDisponible: " + this.isDisponible() +"\n";
    }
}