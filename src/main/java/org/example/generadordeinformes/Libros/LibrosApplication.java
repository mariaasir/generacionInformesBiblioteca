package org.example.generadordeinformes.Libros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.generadordeinformes.Prestamos.PrestamosApplication;

/**
 * La clase LibrosApplication es la entrada principal de la aplicación JavaFX.
 * Se encarga de inicializar y mostrar la interfaz gráfica para la gestión de Libros,
 * permitiendo la generación de informes relacionados con los Libros.
 *
 * <p> La aplicación representa una interfaz para la gestión de Libros.
 *  La interfaz está definida en el archivo FXML ubicado en el paquete
 * /org/example/generadordeinformes/libros.fxml.
 * </p>
 *
 * <h2>Uso principal:</h2>
 * <ul>
 *   <li> Carga el archivo FXML para construir la interfaz de gestión de informes de Libros.</li>
 *   <li> Establece la escena y el título de la ventana principal.</li>
 * </ul>
 *
 * @author María López Patón
 * @version 1.0
 */
public class LibrosApplication extends Application {
    /**
     * Este método es el punto de entrada de la aplicación JavaFX.
     * Carga la interfaz gráfica desde el archivo FXML, configura la escena
     * y muestra la ventana principal de la aplicación.
     *
     * @param stage El escenario principal de la gestión de Libros
     * @throws Exception Si ocurre un error al cargar el archivo FXML.
     */

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PrestamosApplication.class.getResource("org/example/generadordeinformes/libros.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 399, 557);
        stage.setTitle("Libros");
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Método principal de la aplicación. Llama al método @code launch() de JavaFX
     * para iniciar la aplicación.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
