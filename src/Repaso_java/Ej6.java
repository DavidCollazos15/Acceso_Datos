package Repaso_java;

import java.util.Scanner;

public class Ej6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("TABLA DE MULTIPLICAR");
        System.out.print("Numero:");
        int numero = sc.nextInt();
        int veces = 0;

        while (veces < 11){
            System.out.println(numero+" * "+veces+" = "+numero*veces);
            veces++;
        }
    }
}
