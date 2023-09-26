package Excepciones_java;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ej7 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));

        } catch (IOException e) {
            System.out.println("Se produjo un error al abrir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
