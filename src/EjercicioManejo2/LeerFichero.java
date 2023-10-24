package EjercicioManejo2;

import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    public static void main(String[] args) {
        // Ruta del archivo en el directorio de trabajo
        String rutaArchivo = "FichTexto.txt";

        try {
            // Crear un objeto FileReader para leer el archivo
            FileReader reader = new FileReader(rutaArchivo);

            int caracter;
            StringBuilder contenido = new StringBuilder();

            // Leer el archivo caracter por caracter
            while ((caracter = reader.read()) != -1) {
                contenido.append((char) caracter);
            }

            // Cerrar el FileReader
            reader.close();

            // Mostrar el contenido del archivo
            System.out.println("Contenido del archivo:");
            System.out.println(contenido.toString());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

