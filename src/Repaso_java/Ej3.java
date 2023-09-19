package Repaso_java;

import javax.swing.*;
import java.awt.*;

public class Ej3 {

    public static void main(String[] args) {
        String valor = JOptionPane.showInputDialog("Ingrese solo un carácter:");
        if (valor != null && valor.length() == 1) {
            char character = valor.charAt(0);
            if (Character.isUpperCase(character)) {
                JOptionPane.showMessageDialog((Component)null, "El carácter ingresado es una letra mayúscula.");
            } else if (Character.isLowerCase(character)) {
                JOptionPane.showMessageDialog((Component)null, "El carácter ingresado es una letra minúscula.");
            } else {
                JOptionPane.showMessageDialog((Component)null, "Entrada no válida. Por favor, ingrese un carácter válido.");
            }
        } else {
            JOptionPane.showMessageDialog((Component)null, "Entrada no válida. Por favor, ingrese un solo carácter.");
        }
    }
}
