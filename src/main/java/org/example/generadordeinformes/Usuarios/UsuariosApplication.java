package org.example.generadordeinformes.Usuarios;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UsuariosApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(org.example.generadordeinformes.Prestamos.PrestamosApplication.class.getResource("org/example/org.example.generadordeinformes/usuario.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 399, 557);
        stage.setTitle("Préstamos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



