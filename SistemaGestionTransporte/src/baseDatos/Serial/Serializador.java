package baseDatos.Serial;

import gestorAplicaciones.camion.CamionCisterna;
import gestorAplicaciones.camion.CamionFrigorifico;
import gestorAplicaciones.camion.CamionLona;
import gestorAplicaciones.camion.CamionPortaCoches;
import gestorAplicaciones.entidades.Empleado;
import gestorAplicaciones.entidades.Usuario;
import gestorAplicaciones.producto.Factura;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializador {


    public static void serializar() {

        FileOutputStream archivoSalida;
        ObjectOutputStream objetoSalida;

        //Serilizar usuario
        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/usuarios.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(Usuario.getUsuarios());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Serilizar Empleados
        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/empleados.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(Empleado.getEmpleados());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Serilizar Facturas
        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/facturas.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(Factura.getFacturas());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/facturaID.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(Factura.getIDfactura());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Serilizar Camionnes
        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/cisternas.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(CamionCisterna.getCamiones());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/frigorificos.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(CamionFrigorifico.getCamiones());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/lonas.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(CamionLona.getCamiones());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            archivoSalida = new FileOutputStream("src/baseDatos/temp/portaCoches.dat");
            objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(CamionPortaCoches.getCamiones());
            objetoSalida.close();
            archivoSalida.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
