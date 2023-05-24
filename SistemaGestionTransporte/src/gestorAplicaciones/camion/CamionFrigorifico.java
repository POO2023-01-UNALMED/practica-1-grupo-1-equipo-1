package gestorAplicaciones.camion;

import java.util.ArrayList;

public class CamionFrigorifico extends Camion{
    public final static ArrayList<CamionFrigorifico> camiones = new ArrayList<CamionFrigorifico>();
    public CamionFrigorifico(String placa, String pais, double pesoMaximo, double capacidad) {
        super(placa, pais, pesoMaximo, capacidad);

    }

    public static ArrayList<CamionFrigorifico> getCamiones(){
        return CamionFrigorifico.camiones;
    }

    @Override
    public void calcularCostoCamion() {
        double factor = 0.01;
        double km = this.getRuta().get(this.getRuta().size()-1).getValue();
        this.setCosto(km * this.getCapacidad() * factor);
    }

    @Override
    public double valocidad() {
        double velocidadBase = 85.14;
        double factor = -0.357;
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
