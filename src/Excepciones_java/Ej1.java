package Excepciones_java;

public class Ej1 {
    public static void main(String[] args) {
        // Definir las dimensiones de la matriz
        int filas = 2;
        int columnas = 3;

        // Crear la matriz
        int[][] matriz = new int[filas][columnas];

        // Rellenar la matriz con la suma de la posición de la fila y la columna
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas - 1; j++) {
                matriz[i][j] = i + j;
            }
        }

        // Imprimir la matriz
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Cambiar de fila
        }

        //Error de la posicion [2][3]
        try {
            System.out.println(matriz[2][3]);
        }catch (Exception e){
            System.out.print("Da error");
        }

    }
}

