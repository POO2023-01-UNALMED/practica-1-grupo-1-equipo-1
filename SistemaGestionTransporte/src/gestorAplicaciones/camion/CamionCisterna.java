package gestorAplicaciones.camion;

import java.util.ArrayList;

public class CamionCisterna extends Camion{

    public final static ArrayList<CamionCisterna> camiones = new ArrayList<CamionCisterna>();
    public CamionCisterna(String placa, String pais, double pesoMaximo, double capacidad) {
        super(placa, pais, pesoMaximo, capacidad);

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
    public String ubicacion() {
        return null;
    }

    @Override
    public String tiempoRestante() {
        return null;
    }
}
