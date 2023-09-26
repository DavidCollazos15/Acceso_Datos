package Fileutils;

import org.apache.commons.io.FileUtils;
import java.io.*;


public class crearDir {
    public static void main(String[] args) {

        // Definir los nombres de los archivos
        String nombreArchivo1 = "fichero1.txt";
        String nombreArchivo2 = "fichero2.txt";
        String nombreCopia = "fichero_copia.txt";

        try {
            // Crear ficheros
            File archivo1 = new File(nombreArchivo1);
            File archivo2 = new File(nombreArchivo2);

            //Comprobar si se crean
            boolean creado1 = archivo1.createNewFile();
            boolean creado2 = archivo2.createNewFile();

            //Decir si ya existian o no

            //Archivo1
            if (creado1) {
                System.out.println(nombreArchivo1 + " se ha creado exitosamente.");
            } else {
                System.out.println(nombreArchivo1 + " ya existe.");
            }

            //Archivo2
            if (creado2) {
                System.out.println(nombreArchivo2 + " se ha creado exitosamente.");
            } else {
                System.out.println(nombreArchivo2 + " ya existe.");
            }

            // Verificar si el archivo renombrado existe
            File archivoCopia = new File(nombreCopia);
            if (archivoCopia.exists()) {
                System.out.println(nombreCopia + " ya existe. No se renombrará.");
            } else {
                // Renombrar fichero1.txt a fichero_copia.txt
                archivo1.renameTo(archivoCopia);
                System.out.println(nombreArchivo1 + " se ha renombrado a " + nombreCopia);
            }
        } catch (IOException e) {
            System.err.println("Se produjo un error al trabajar con los archivos.");
            e.printStackTrace();
        }
    }
}
