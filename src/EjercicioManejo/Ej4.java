package EjercicioManejo;

import java.io.File;

public class Ej4 {

    public static void main(String[] args) {
        String sCarpAct = System.getProperty("user.dir");

        //Lo convierte en File
        File carpeta = new File(sCarpAct);

        //Muestra la informacion de cada apartado
        System.out.println("Nombre del fichero: "+carpeta.getName());
        System.out.println("Ruta: "+carpeta.getName());
        System.out.println("Ruta absoluta: "+carpeta);
        System.out.println("Se puede leer: "+carpeta.canRead());
        System.out.println("Se puede escribir: "+carpeta.canWrite());
        System.out.println("Tamaño: "+carpeta.length());
        System.out.println("Es un directorio: "+carpeta.isDirectory());
        System.out.println("Es un fichero: "+carpeta.isFile());
        System.out.println("Nombre del directorio padre "+carpeta.getParent());
    }

}
