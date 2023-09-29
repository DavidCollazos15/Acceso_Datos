package EjercicioManejo;

import java.io.File;
import java.util.Scanner;

public class Ej6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Pedir el directorio
        System.out.println("Introduce el directorio:");
        String directorioString = sc.next();

        File directorioFile = new File(directorioString);

        //Comprueba si existe el directorio solicitado y si es un directorio
        if (directorioFile.exists() && directorioFile.isDirectory()) {

            //Lista de archivos de ese directorio
            File[] archivos = directorioFile.listFiles();

            //Si no es nulo entra en el if
            if (archivos != null) {

                //Un bucle revisando cada archivo
                for (File archivo : archivos) {

                    //Sacar  el nombre del archivo
                    String NombreArchivo = archivo.getName();

                    //Un bucle revisando cada argumento
                    for (String ArgumentoObjetivo : args) {

                        //Comparar si coincide el argumento con el archivo del directorio
                        if (NombreArchivo.equals(ArgumentoObjetivo)) {

                            //Si coincide, te comprueba si es un fichero o directorio
                            if (archivo.isFile()) {
                                System.out.println(NombreArchivo + " es un fichero.");
                            } else if (archivo.isDirectory()) {
                                System.out.println(NombreArchivo + " es un directorio.");
                            }
                        }
                    }
                }
            } else {
                System.out.println("El directorio está vacío o no se pudo acceder a su contenido.");
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio válido.");
        }
    }
}
