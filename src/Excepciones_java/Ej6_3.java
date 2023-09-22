package Excepciones_java;

import javax.swing.*;
import java.awt.*;

public class Ej6_3 {

    public static void main(String[] args) {

        try {
            String valor = JOptionPane.showInputDialog("Ingrese solo un carácter:");
            if (valor != null && valor.length() == 1) {
                char character = valor.charAt(0);
                if (Character.isUpperCase(character)) {
                    JOptionPane.showMessageDialog((Component) null, "El carácter ingresado es una letra mayúscula.");
                } else if (Character.isLowerCase(character)) {
                    JOptionPane.showMessageDialog((Component) null, "El carácter ingresado es una letra minúscula.");
                } else {
                    JOptionPane.showMessageDialog((Component) null, "Entrada no válida. Por favor, ingrese un carácter válido.");
                }
            } else {
                JOptionPane.showMessageDialog((Component) null, "Entrada no válida. Por favor, ingrese un solo carácter.");
            }
        }catch (Exception e){
            System.out.println("Se produjo un error: " + e.getClass().getName());
            e.printStackTrace();
        }
    }

}
