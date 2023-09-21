package Excepciones_java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un numero:");
        try {
            int numero = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Eso no es un numero");
        }

    }
}
