package Repaso_java;

import java.util.ArrayList;

public class Ej8 {

    public static void main(String[] args) {
        ArrayList<String> marcas = new ArrayList<>();
        marcas.add("Volvo");
        marcas.add("BMW");
        marcas.add("Ford");
        marcas.add("Mazda");
        marcas.add("Volkswagen");
        marcas.add("Mercedes");
        marcas.add("Subaru");
        marcas.add("Nissan");
        marcas.add("Ferrari");
        marcas.add("Lamborghini");
        marcas.add("Toyota");
        marcas.add("Seat");

        System.out.println("Los pares son:");
        pares(marcas);
    }

    private static void pares(ArrayList<String> marcas) {

        for (int i=0;i<marcas.size();i++){
            if (i%2==0){
                System.out.println(marcas.get(i));
            }
        }

    }

}
