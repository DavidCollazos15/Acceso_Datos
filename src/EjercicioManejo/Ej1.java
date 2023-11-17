package EjercicioManejo;

import java.io.File;
import java.io.IOException;


public class Ej1 {
    public static void main(String[] args) {


        //Nombre del directorio
        String directorio = "NUEVODIR";

        // Verificar si el directorio existe, si no existe, créalo
        File dir = new File(directorio);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Directorio " + directorio + " se ha creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el directorio " + directorio);
                return; // Salir del programa si no se puede crear el directorio
            }
        }

        // Definir los nombres de los archivos

        String nombreArchivo1 = directorio + File.separator + "fichero1.txt";
        String nombreArchivo2 = directorio + File.separator + "fichero2.txt";
        String nombreCopia = directorio + File.separator + "fichero_copia.txt";

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
