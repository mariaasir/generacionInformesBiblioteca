package org.example.generadordeinformes.AccesoInterfaz;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

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

        // Construcción de la URI
        URI myUri = null;
        try {
            myUri = new URI("https://mariaasir.github.io/generacionInformesBiblioteca/");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "La URL especificada es inválida.", "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return; // Salir si la URI no es válida
        }

        // Cargar contenido manualmente
        try {
            // Convertir URI a URL
            URL myUrl = myUri.toURL();

            // Abrir conexión y configurar encabezados
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
                    + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

            // Leer el contenido si la respuesta es exitosa (código 200)
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();

                // Establecer el contenido en el JTextPane
                textPane.setContentType("text/html"); // Especificar contenido HTML
                textPane.setText(content.toString());
            } else {
                throw new Exception("Respuesta no exitosa: Código " + connection.getResponseCode());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "No se pudo cargar el contenido desde la URL.\n"
                            + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }

        // Hacer visible el marco
        frame.setVisible(true);
    }
}

