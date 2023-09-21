package Excepciones_java;

public class Ej2 {

    public static void main(String[] args) {

        int a;

        try {
            a = 10/0;
        } catch (ArithmeticException e) {
            System.out.println("Se produjo una ArithmeticException: " + e.getMessage());
        }

        System.out.println("Programa continuado después de la excepción.");

    }
}
