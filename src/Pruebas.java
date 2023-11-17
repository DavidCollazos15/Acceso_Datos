import java.io.File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Pruebas {
    public static void main(String[] args) {
        String rutaArchivo = "ruta";

        // Convierte la ruta en un objeto File
        File archivo = new File(rutaArchivo);

        // Muestra la información de cada apartado
        System.out.println("Nombre del fichero: " + archivo.getName());
        System.out.println("Ruta: " + archivo.getPath());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("Se puede leer: " + archivo.canRead());
        System.out.println("Se puede escribir: " + archivo.canWrite());
        System.out.println("Tamaño: " + archivo.length() + " bytes");
        System.out.println("Es un directorio: " + archivo.isDirectory());
        System.out.println("Es un fichero: " + archivo.isFile());
        System.out.println("Nombre del directorio padre: " + archivo.getParent());

    }

}

