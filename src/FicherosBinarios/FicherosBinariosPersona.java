package FicherosBinarios;
import java.io.*;

public class FicherosBinariosPersona {

    public static void guardarObjeto(File file, Persona persona) {

        try {
            // Comprueba si el archivo no existe y lo crea si es necesario.
            if (!file.exists()) {
                file.createNewFile();
            }

            // Crea un flujo de salida para escribir en el archivo.
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // Crea un flujo de objeto para escribir objetos en el archivo.
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Escribe el objeto 'persona' en el archivo.
            objectOutputStream.writeObject(persona);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Objeto Persona guardado con exito.");

          // En caso de error, imprime información sobre la excepción.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Persona recuperarObjeto(File file) {

        Persona persona = null;

        try {
            // Crea un flujo de entrada para leer desde el archivo.
            FileInputStream fileInputStream = new FileInputStream(file);
            // Crea un flujo de objeto para leer objetos desde el archivo.
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // Lee un objeto del archivo y realiza un casting a Persona.
            persona = (Persona) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Objeto Persona recuperado con exito.");

            // En caso de error, imprime información sobre la excepción.
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return persona;
    }

    public static void main(String[] args) {

        // Crea un objeto File que representa el archivo "persona1.dat".
        File file = new File("persona1.dat");

        // Crea un objeto Persona.
        Persona persona1 = new Persona(1, "Ejemplo", 30, "12345");

        // Imprime los detalles de la Persona original.
        System.out.println(persona1.toString());

        System.out.println("Guardando el objeto Persona en el archivo...");

        // Llama al método para guardar el objeto en el archivo.
        guardarObjeto(file, persona1);

        System.out.println("Recuperando el objeto Persona del archivo...");

        // Llama al método para recuperar el objeto del archivo.
        Persona personaRecuperada = recuperarObjeto(file);

        if (personaRecuperada != null) {

            // Imprime los detalles de la Persona recuperada.
            System.out.println(personaRecuperada.toString());

            System.out.println("Modificando el objeto Persona y guardandolo de nuevo...");

            // Modifica algunos atributos de la Persona recuperada.
            personaRecuperada.setNombre("Paco");
            personaRecuperada.setId(2);
            personaRecuperada.setEdad(21);
            personaRecuperada.setDni("54321");

            // Imprime los detalles de la Persona modificada.
            System.out.println(personaRecuperada.toString());

            // Llama al método para guardar el objeto modificado en el archivo.
            guardarObjeto(file, personaRecuperada);
        }
    }
}
