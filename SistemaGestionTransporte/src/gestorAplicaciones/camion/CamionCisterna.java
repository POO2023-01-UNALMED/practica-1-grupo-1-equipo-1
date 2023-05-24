package gestorAplicaciones.camion;

import java.util.ArrayList;

public class CamionCisterna extends Camion{

    public final static ArrayList<CamionCisterna> camiones = new ArrayList<CamionCisterna>();
    public CamionCisterna(String placa, String pais, String CiudadActual, double pesoMaximo, double capacidad) {
        super(placa, pais, CiudadActual, pesoMaximo, capacidad);
        camiones.add(this);
    }

    public static ArrayList<CamionCisterna> getCamiones(){
        return CamionCisterna.camiones;
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
                "\nPeso Maximo: " + this.getPesoMaximo() +
                "\nCapacidad: " + this.getCapacidad() +"\n";
    }
}
