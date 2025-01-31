package org.example.generadordeinformes.AccesoInterfaz;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Manual {
    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Cargar contenido en JTextPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el JTextPane y configurarlo como no editable
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);

        // Crear un JScrollPane para permitir scroll si el contenido es extenso
        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ruta del archivo HTML en el sistema de archivos
        String filePath = "src/main/java/org/example/generadordeinformes/AccesoInterfaz/index.html";

        // Cargar contenido del archivo local
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Establecer el contenido en el JTextPane
            textPane.setContentType("text/html"); // Especificar contenido HTML
            textPane.setText(content.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "No se pudo cargar el contenido del archivo.\n"
                            + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }

        // Hacer visible el marco
        frame.setVisible(true);
    }
}
