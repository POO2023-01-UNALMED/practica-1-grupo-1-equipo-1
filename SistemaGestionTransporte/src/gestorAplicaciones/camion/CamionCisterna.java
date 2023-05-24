package gestorAplicaciones.camion;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *  clase CamionCisterna es una subclase de la clase Camion
 *  Atributos:
 *  Camiones:  ArrayList estático de objetos de tipo CamionCisterna que almacena
 *  todos los camiones cisterna creados.
 */
public class CamionCisterna extends Camion implements Serializable {

    //serializador
    @Serial
    private static final long serialVersionUID = 1L;

    public static ArrayList<CamionCisterna> camiones = new ArrayList<CamionCisterna>();
    public CamionCisterna(String placa, String pais, String CiudadActual, double pesoMaximo, double capacidad) {
        super(placa, pais, CiudadActual, pesoMaximo, capacidad);
        camiones.add(this);
    }

    public CamionCisterna(){}

    public static ArrayList<CamionCisterna> getCamiones(){
        return CamionCisterna.camiones;
    }

    public static void setCamiones(ArrayList<CamionCisterna> camiones){
        CamionCisterna.camiones = camiones;
    }


    @Override
    public void calcularCostoCamion() {
        double factor = 0.005;
        double km = this.getRuta().get(this.getRuta().size()-1).getValue();
        this.setCosto(km * this.getCapacidad() * factor);
    }

    @Override
    public double valocidad() {
        double velocidadBase = 81.857;
        double factor = -0.392957;
        return velocidadBase + this.getCapacidad() * factor;
    }

    @Override
    public String toString() {
        return "\nTipo: Cisterna" +
                "\nPlaca: " + this.getPlaca() +
                "\npais: " + this.getPais() +
                "\nCiudad actual: " + this.getCiudadActual() +
                "\nPeso Maximo: " + this.getPesoMaximo() +
                "\nCapacidad: " + this.getCapacidad() +
                "\nDisponible: " + this.isDisponible() +"\n";
    }
}
