package gestorAplicaciones.camion;

import java.util.ArrayList;

public class CamionLona extends Camion{
    public final static ArrayList<CamionLona> camiones = new ArrayList<CamionLona>();
    public CamionLona(String placa, String pais, double pesoMaximo, double capacidad) {
        super(placa, pais, pesoMaximo, capacidad);
    }

    public static ArrayList<CamionLona> getCamiones(){
        return CamionLona.camiones;
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

    @Override
    public boolean elegirCamion(String origen, double peso, double volumen) {
        if(this.getCiudadActual().equals(origen) && peso <= this.getPesoMaximo() && volumen <= this.getCapacidad()){
            return true;
        }
        return false;
    }
}
