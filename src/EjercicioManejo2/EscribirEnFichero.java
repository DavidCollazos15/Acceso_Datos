package EjercicioManejo2;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirEnFichero {
    public static void main(String[] args) {
        // Ruta del archivo en el directorio de trabajo
        String rutaArchivo = "FichTexto.txt";

        try {
            // Crear un objeto FileWriter para escribir en el archivo
            FileWriter escritor = new FileWriter(rutaArchivo);

            // Texto que se escribirá en el archivo
            String texto = "Esto es texto escrito en un fichero de texto";

            // Escribir el texto en el archivo
            escritor.write(texto);

            // Cerrar el FileWriter
            escritor.close();

            System.out.println("El texto se ha escrito en el archivo correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

