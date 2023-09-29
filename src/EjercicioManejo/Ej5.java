package EjercicioManejo;

import java.io.File;

public class Ej5 {

    public static void main(String[] args) {

        //Ubicacion del directorio
        String dir = System.getProperty("user.dir");
        File directorio = new File(dir);

        //Contadores de cuantos ficheros y directorios hay
        int fileCount = 0;
        int directoryCount = 0;

        //Hace la lista de archivos
        File[] files = directorio.listFiles();

        //Cuenta los archivos que son ficheros y los que son directorios
        for (File file : files) {
            if (file.isFile()) {
                fileCount++;
            } else if (file.isDirectory()) {
                directoryCount++;
            }
        }

        //Muestra el total de cada uno y combinados
        System.out.println("Ficheros en el directorio actual: " + fileCount);
        System.out.println("Directorios en el directorio actual: " + directoryCount);
        System.out.println("Total archivos: "+ (fileCount+directoryCount));

        //Te dice de que tipo es cada archivo
        for (File file : files) {
            System.out.println("Nombre: "+file.getName()+", es fichero?: "+file.isFile()+", es directorio?: "+file.isDirectory());
        }
    }
}
