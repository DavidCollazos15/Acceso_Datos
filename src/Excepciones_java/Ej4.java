package Excepciones_java;

import java.util.Scanner;

public class Ej4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una nota:");
        int nota = sc.nextInt();

        switch (nota){
            case 1: case 2: case 3: case 4:System.out.println("Insuficiente"); throw new RuntimeException("Suspendió");
            case 5:System.out.println("Suficiente");break;
            case 6: case 7:System.out.println("Bien");break;
            case 8: case 9:System.out.println("Notable");break;
            case 10:System.out.println("Sobresaliente");break;

        }
    }
}
