package baseDatos.Serial;

import gestorAplicaciones.camion.CamionCisterna;
import gestorAplicaciones.camion.CamionFrigorifico;
import gestorAplicaciones.camion.CamionLona;
import gestorAplicaciones.camion.CamionPortaCoches;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.producto.Factura;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Deserializador {

    @SuppressWarnings("unchecked")
    public static void deserializar(){
        FileInputStream archivoEntrada;
        ObjectInputStream objetoEntrada;

        //deserializar usuarios
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/usuarios.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            Usuario.setUsuarios((ArrayList<Usuario>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar empleados
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/empleados.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            Empleado.setEmpleados((ArrayList<Empleado>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar facturas
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/facturas.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            Factura.setFacturas((ArrayList<Factura>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/facturaID.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            Factura.setIDfactura((Long) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar Camiones
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/cisternas.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            CamionCisterna.setCamiones((ArrayList<CamionCisterna>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/frigorificos.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            CamionFrigorifico.setCamiones((ArrayList<CamionFrigorifico>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/lonas.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            CamionLona.setCamiones((ArrayList<CamionLona>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/portaCoches.txt");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            CamionPortaCoches.setCamiones((ArrayList<CamionPortaCoches>) objetoEntrada.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
