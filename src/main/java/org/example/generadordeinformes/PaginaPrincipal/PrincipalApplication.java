package org.example.generadordeinformes.PaginaPrincipal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("/org/example/generadordeinformes/paginaPrincipal.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 399, 557);
        stage.setTitle("Biblioteca");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
