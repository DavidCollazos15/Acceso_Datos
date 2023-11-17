package DocumentBuilder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.File;
import java.io.IOException;

public class DTD {
    public static void main(String[] args) {

        // Aquí estás creando algo como un "manejador de errores simple" y lo guardas en errorHandler. Este "manejador de errores" se usará más adelante para lidiar con posibles problemas.
        SimpleErrorHandler errorHandler = new SimpleErrorHandler();

        try {
            // Esto es como una fábrica que te permite crear documentos XML.
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();

            // Le estás diciendo a la fábrica que tenga cuidado con los nombres especiales en el XML, para evitar confusiones.
            fabrica.setNamespaceAware(true);
            // Le estás diciendo a la fábrica que verifique si tu documento XML sigue las reglas específicas que le has establecido.
            fabrica.setValidating(true);

            // Aquí estás creando un constructor que te ayuda a hacer documentos reales (no solo un "plan" como la fábrica).
            DocumentBuilder builder = fabrica.newDocumentBuilder();
            // Estás diciendo al constructor que, si encuentra algún problema al construir el documento, utilice el "manejador de errores" que creaste antes.
            builder.setErrorHandler(errorHandler);

            // Leer y entender un documento XML ubicado en la ruta especificada.(Aunque diga que no se usa se refiere a que no se utiliza, pero como tal el "builder.parse" es lo que comprueba el documento)
            Document documento = builder.parse(new File("C:\\Users\\DavidGonzálezC\\Desktop\\EjDTD2_mal.xml"));

            // Verificar si el documento es válido
            if (errorHandler.isEsValido()) {
                System.out.println("El documento XML es válido con el DTD.");
            } else {
                System.out.println("El documento XML no es válido.");
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            // Capturar excepciones relacionadas con la configuración del parser o errores de análisis
            System.out.println("Error al procesar el documento XML: " + e.getMessage());
        }
    }
}

// Clase SimpleErrorHandler para manejar errores de validación
class SimpleErrorHandler implements ErrorHandler {
    private boolean esValido = true;

    @Override
    public void warning(SAXParseException e) {
        System.out.println("Advertencia: " + e.getMessage());
        esValido = false; // Marcar el documento como no válido
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("Error: " + e.getMessage());
        esValido = false; // Marcar el documento como no válido
    }

    @Override
    public void fatalError(SAXParseException e) {
        System.out.println("Error fatal: " + e.getMessage());
        esValido = false; // Marcar el documento como no válido
    }

    public boolean isEsValido() {
        return esValido;
    }
}



