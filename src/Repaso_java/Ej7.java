package Repaso_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ej7 {
    public static void main(String[] args) {

        double[] media = new double[5];
        double suma = 0;

        Scanner sc = new Scanner(System.in);

        for (int i=0;i<media.length;i++){
            System.out.print("Introduce numero "+(i+1)+":");
            media[i]= sc.nextDouble();

        }

        for (int i=0;i<media.length;i++){

            suma = suma+media[i];
        }

        System.out.println("La media es "+suma/media.length);

    }
}
