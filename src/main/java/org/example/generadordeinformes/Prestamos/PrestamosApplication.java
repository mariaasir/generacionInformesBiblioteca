package org.example.generadordeinformes.Prestamos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrestamosApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PrestamosApplication.class.getResource("/org/example/generadordeinformes/prestamos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 342, 437);
        stage.setTitle("Préstamos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
