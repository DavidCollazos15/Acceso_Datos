package Repaso_java;

import java.util.Scanner;

public class Ej4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce una nota:");
        int nota = sc.nextInt();

        switch (nota){
            case 1:System.out.println("Insuficiente");break;
            case 2:System.out.println("Insuficiente");break;
            case 3:System.out.println("Insuficiente");break;
            case 4:System.out.println("Insuficiente");break;
            case 5:System.out.println("Suficiente");break;
            case 6:System.out.println("Bien");break;
            case 7:System.out.println("Bien");break;
            case 8:System.out.println("Notable");break;
            case 9:System.out.println("Notable");break;
            case 10:System.out.println("Sobresaliente");break;

        }

    }

}
