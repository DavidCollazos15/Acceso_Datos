package Repaso_java;

import java.util.Scanner;

public class Ej5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double n = 100;
        int nrandom = (int) (Math.random()* n);

        System.out.println(nrandom);
        System.out.println("Introduce un numero:");
        int usuario = sc.nextInt();

        while (nrandom != usuario){

            if (nrandom < usuario){
                System.out.println("El numero es menor:");
            }else{
                System.out.println("El numero es mayor:");
            }
            usuario = sc.nextInt();
        }

        System.out.println("Correcto!");

    }
}
