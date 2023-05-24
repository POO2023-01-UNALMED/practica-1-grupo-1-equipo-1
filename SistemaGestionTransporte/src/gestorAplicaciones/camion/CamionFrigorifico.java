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
    public double calcularCostoCamion() {
        return 0;
    }

    @Override
    public boolean comprobarPlaca(String placa) {
        return false;
    }

    @Override
    public String ubicacion() {
        return null;
    }

    @Override
    public String tiempoRestante() {
        return null;
    }

    public boolean elegirCamion(String origen, double peso, double volumen) {
        if(this.getCiudadActual().equals(origen) && peso <= this.getPesoMaximo() && volumen <= this.getCapacidad()){
            return true;
        }
        return false;
    }
}
