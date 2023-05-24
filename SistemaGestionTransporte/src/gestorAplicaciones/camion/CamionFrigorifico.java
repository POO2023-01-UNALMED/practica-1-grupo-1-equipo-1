package gestorAplicaciones.camion;

public class CamionFrigorifico extends Camion{
    public CamionFrigorifico(String placa, String tamanio, String pais) {
        super(placa, tamanio, pais);
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
