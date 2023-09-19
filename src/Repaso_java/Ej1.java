package Repaso_java;

import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre");
        String nombre = sc.next();
        System.out.println("Introduce la edad");
        int edad = sc.nextInt();
        System.out.println("Buenos días " + nombre + " tienes " + edad + " años");
    }
}
