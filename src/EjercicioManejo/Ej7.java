package EjercicioManejo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        //Pide el directorio que contiene los archivos que quiere copiar
        System.out.println("Escriba el directorio donde este los archivos que quieras copiar:");
        String directorioCopiar = sc.next();

        //Lo convierte en File
        File directorioCopiarFile = new File(directorioCopiar);

        //Comprueba que es un directorio
        if (directorioCopiarFile.exists() && directorioCopiarFile.isDirectory()) {
            System.out.println("Cuales dos archivos quieres copiar?");
            System.out.print("1:");
            String archivo1 = sc.next();
            System.out.print("2:");
            String archivo2 = sc.next();
            System.out.println("En que directorio lo quieres pegar");
            String directorioPegar = sc.next();

            //combina el origen y el destino con el nombre de los archivos
            String Copiar1 = directorioCopiar+"\\"+archivo1;
            String Copiar2 = directorioCopiar+"\\"+archivo2;
            String Pegar1 = directorioPegar+"\\"+archivo1;
            String Pegar2 = directorioPegar+"\\"+archivo2;

            //Los convierte en File
            File Copiar1File = new File(Copiar1);
            File Copiar2File = new File(Copiar2);
            File Pegar1File = new File(Pegar1);
            File Pegar2File = new File(Pegar2);

            //Hace la funcion de copiar
            try {
                FileUtils.copyFile(Copiar1File,Pegar1File);
                System.out.println("Archivo 1 copiado");
                FileUtils.copyFile(Copiar2File,Pegar2File);
                System.out.println("Archivo 2 copiado");
            }catch (Exception e){
                System.out.println("hubo un error en la copia");
            }

                    
        }else {
            System.out.println("El directorio especificado no existe o no es un directorio válido.");
        }

    }
}
