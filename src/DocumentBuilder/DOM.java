package DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOM {
    public static void main(String[] args) {
        try {
            // Crear una instancia de DOCUMENTO XML con DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Crear un nuevo documento XML
            Document doc = builder.newDocument();

            // Crear el elemento raíz
            Element root = doc.createElement("Libros");
            doc.appendChild(root);

            // Crear un elemento de libro
            Element libro = doc.createElement("Libro");
            root.appendChild(libro);

            // Crear elementos para el título y el autor
            Element titulo = doc.createElement("Titulo");
            Text tituloText = doc.createTextNode("El Gran Gatsby");
            titulo.appendChild(tituloText);
            libro.appendChild(titulo);

            Element autor = doc.createElement("Autor");
            Text autorText = doc.createTextNode("F. Scott Fizgerald");
            autor.appendChild(autorText);
            libro.appendChild(autor);

            // Guardar el documento en un archivo
            javax.xml.transform.TransformerFactory.newInstance().newTransformer()
                    .transform(new javax.xml.transform.dom.DOMSource(doc), new javax.xml.transform.stream.StreamResult(new java.io.File("biblioteca.xml")));
        } catch (ParserConfigurationException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }
}
