package gestorAplicaciones;

public interface Archivo {
    //Metodos
    public String LeerArchivo(String fileName);
    public void EditarArchivo(String fileName, String text);
}
