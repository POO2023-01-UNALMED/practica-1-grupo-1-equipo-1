package gestorAplicaciones.camion;

public class CamionCisterna extends Camion{
    public CamionCisterna(String placa, String tamanio, String capacidad, String costo, String pais) {
        super(placa, tamanio, capacidad, costo, pais);
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
}
