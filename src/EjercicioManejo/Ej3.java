package EjercicioManejo;

import java.io.File;
import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Introducir la ruta
        System.out.println("Introduce la ruta");
        String directorio = sc.next();

        //Hace la lista
        File carpeta = new File(directorio);
        File[] lista = carpeta.listFiles();

        //Muestra
        System.out.println("\n Hay " +  lista.length + " elementos");

    }

}
