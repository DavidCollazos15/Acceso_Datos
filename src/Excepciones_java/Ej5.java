package Excepciones_java;

public class Ej5 {

    public static void main(String[] args) {
        try {
            B();
        } catch (CustomException e) {
            System.out.println("Excepción capturada en el nivel MAIN: " + e.getMessage());
        }
    }

    public static void B() throws CustomException {

        System.out.println("Función B comienza.");
        C();
        throw new CustomException("Excepción en función B");
    }

    public static void C() throws CustomException {

        System.out.println("Función C comienza.");
        throw new CustomException("Excepción en función C");
    }
}

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }

}
