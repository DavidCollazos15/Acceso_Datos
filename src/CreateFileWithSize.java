import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreateFileWithSize {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\DavidGonzálezC\\Desktop\\pdfs\\c.pdf"; // Ruta y nombre del archivo que deseas crear
        long fileSizeInKB = 1000; // Tamaño en KB que deseas para el archivo

        try (OutputStream out = new FileOutputStream(filePath)) {
            byte[] data = new byte[1024]; // Un kilobyte
            long bytesWritten = 0;

            while (bytesWritten < fileSizeInKB * 1024) {
                out.write(data);
                bytesWritten += 1024;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Archivo creado con éxito: " + filePath);
    }
}
