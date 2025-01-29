package org.example.generadordeinformes.PaginaPrincipal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * La clase PrincipalApplication es la entrada principal para la aplicación JavaFX.
 *  Se encarga de inicializar y mostrar la interfaz gráfica basada en el archivo FXML.
 *
 * <p> La aplicación representa una interfaz para la gestión de una biblioteca.
 *  La interfaz está definida en el archivo FXML ubicado en el paquete
 * {/org/example/generadordeinformes/paginaPrincipal.fxml.
 * </p>
 *
 * <h2>Uso principal:</h2>
 * <ul>
 *   <li> Carga el archivo FXML para construir la interfaz de usuario.</li>
 *   <li> Establece la escena y el título de la ventana principal.</li>
 * </ul>
 *
 * @author María López Patón
 * @version 1.0
 */
public class PrincipalApplication extends Application {

    /**
     * Este método es el punto de entrada de la aplicación JavaFX.
     * Carga la interfaz gráfica desde el archivo FXML, configura la escena
     * y muestra la ventana principal de la aplicación.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws Exception Si ocurre un error al cargar el archivo FXML.
     */


    @Override
    public void start(Stage stage) throws Exception {
        // Carga el archivo FXML desde el recurso especificado.
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/paginaPrincipal.fxml"));

        // Crea una nueva escena con dimensiones específicas.
        Scene scene = new Scene(fxmlLoader.load(), 399, 557);

        // Configura el título de la ventana.
        stage.setTitle("Biblioteca");

        // Establece la escena en el escenario principal.
        stage.setScene(scene);

        // Muestra el escenario principal.
        stage.show();
    }

    /**
     * Método principal de la aplicación. Llama al método {@code launch()} de JavaFX
     * para iniciar la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
