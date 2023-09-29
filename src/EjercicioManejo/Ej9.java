package EjercicioManejo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Comparator;

public class Ej9 {
    public static void main(String[] args) {
        // Definir el directorio base
        File baseDirectory = new File("C:\\Users\\DavidGonzálezC\\Desktop\\destino");

        // Crear los directorios DirPDFpeques y DirPDFpequesAZ
        File dirPDFpeques = new File(baseDirectory, "DirPDFpeques");
        File dirPDFpequesAZ = new File(baseDirectory, "DirPDFpequesAZ");
        File dirPDFmayores = new File(baseDirectory, "DirPDFmayores");

        dirPDFpeques.mkdir();
        dirPDFpequesAZ.mkdir();
        dirPDFmayores.mkdir();

        // Obtener una lista de archivos en el directorio base
        File[] files = baseDirectory.listFiles();

        if (files != null) {
            // Ordenar los archivos por nombre
            Arrays.sort(files, Comparator.comparing(File::getName));

            int smallPdfCount = 0;
            int largePdfCount = 0;

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".pdf")) {
                    // Comprobar el tamaño del archivo
                    long fileSize = file.length();
                    if (fileSize <= 1000000) { // 1000 KB
                        // Copiar a DirPDFpeques
                        try {
                            Files.copy(file.toPath(), new File(dirPDFpeques, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            smallPdfCount++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Copiar a DirPDFmayores
                        try {
                            Files.copy(file.toPath(), new File(dirPDFmayores, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                            largePdfCount++;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            // Ordenar los archivos en DirPDFmayores por tamaño
            File[] largePdfFiles = dirPDFmayores.listFiles();
            Arrays.sort(largePdfFiles, Comparator.comparingLong(File::length).reversed());

            for (int i = 0; i < largePdfFiles.length; i++) {
                File file = largePdfFiles[i];
                String fileName = file.getName();
                String newName = i + 1 + fileName.substring(fileName.lastIndexOf('.'));
                file.renameTo(new File(dirPDFmayores, newName));
            }
        }

        // Mover archivos de DirPDFpeques a DirPDFpequesAZ
        File[] smallPdfFiles = dirPDFpeques.listFiles();
        if (smallPdfFiles != null) {
            for (File file : smallPdfFiles) {
                if (file.getName().matches("^[A-N].*")) {
                    try {
                        Files.move(file.toPath(), new File(dirPDFpequesAZ, file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
