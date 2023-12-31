package Excepciones_java;

import java.util.*;

public class Ej6_2 {
    public static void main(String[] args) {

        ArrayList<Integer> ordenar = new ArrayList();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce 3 numeros para ordenarlos");
            System.out.print("1ºnumero:");
            int numero1 = sc.nextInt();
            ordenar.add(numero1);
            System.out.print("2ºnumero:");
            int numero2 = sc.nextInt();
            ordenar.add(numero2);
            System.out.print("3ºnumero:");
            int numero3 = sc.nextInt();
            ordenar.add(numero3);

            //Esto lo ordena
            Collections.sort(ordenar);

            System.out.print("Ordenados son:");

            //Imprime por pantalla
            for (int num : ordenar) {
                System.out.print(" ");
                System.out.print(num);
            }
        }catch (Exception e){
            System.out.println("Se produjo un error: " + e.getClass().getName());
            e.printStackTrace();

        }
    }
}
