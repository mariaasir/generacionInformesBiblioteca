package org.example.generadordeinformes.Libros;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.generadordeinformes.Prestamos.PrestamosApplication;

public class LibrosApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PrestamosApplication.class.getResource("libros.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 399, 557);
        stage.setTitle("Libros");
        stage.setScene(scene);
        stage.show();
    }
}
