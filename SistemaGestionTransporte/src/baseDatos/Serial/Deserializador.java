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
            archivoEntrada = new FileInputStream("src/baseDatos/temp/usuarios.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //Usuario.setUsuarios((ArrayList<Usuario>) objetoEntrada.readObject());
            ArrayList<Usuario> usuarios = (ArrayList<Usuario>) objetoEntrada.readObject();
            Usuario.setUsuarios(usuarios);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar empleados
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/empleados.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //Empleado.setEmpleados((ArrayList<Empleado>) objetoEntrada.readObject());
            ArrayList<Empleado> empleados = (ArrayList<Empleado>) objetoEntrada.readObject();
            Empleado.setEmpleados(empleados);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar facturas
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/facturas.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //Factura.setFacturas((ArrayList<Factura>) objetoEntrada.readObject());
            ArrayList<Factura> facturas = (ArrayList<Factura>) objetoEntrada.readObject();
            Factura.setFacturas(facturas);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/facturaID.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //Factura.setIDfactura((Long) objetoEntrada.readObject());
            long id = (Long) objetoEntrada.readObject();
            Factura.setIDfactura(id);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //deserializar Camiones
        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/cisternas.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //CamionCisterna.setCamiones((ArrayList<CamionCisterna>) objetoEntrada.readObject());
            ArrayList<CamionCisterna>  camiones = (ArrayList<CamionCisterna>) objetoEntrada.readObject();
            CamionCisterna.setCamiones(camiones);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/frigorificos.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //CamionFrigorifico.setCamiones((ArrayList<CamionFrigorifico>) objetoEntrada.readObject());
            ArrayList<CamionFrigorifico>  camiones = (ArrayList<CamionFrigorifico>) objetoEntrada.readObject();
            CamionFrigorifico.setCamiones(camiones);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/lonas.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //CamionLona.setCamiones((ArrayList<CamionLona>) objetoEntrada.readObject());
            ArrayList<CamionLona>  camiones = (ArrayList<CamionLona>) objetoEntrada.readObject();
            CamionLona.setCamiones(camiones);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoEntrada = new FileInputStream("src/baseDatos/temp/portaCoches.dat");
            objetoEntrada = new ObjectInputStream(archivoEntrada);
            //CamionPortaCoches.setCamiones((ArrayList<CamionPortaCoches>) objetoEntrada.readObject());
            ArrayList<CamionPortaCoches>  camiones = (ArrayList<CamionPortaCoches>) objetoEntrada.readObject();
            CamionPortaCoches.setCamiones(camiones);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
