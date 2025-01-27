package org.example.generadordeinformes.PaginaPrincipal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;

import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.generadordeinformes.Ejemplares.EjemplaresController;
import org.example.generadordeinformes.Libros.LibrosController;
import org.example.generadordeinformes.Prestamos.PrestamosController;
import org.example.generadordeinformes.Usuarios.UsuariosController;

import java.io.FileNotFoundException;
import java.io.IOException;


public class PrincipalController {
    @FXML
    private Button botonLibros;
    @FXML
    private Button botonUsuarios;
    @FXML
    private Button botonEjemplares;
    @FXML
    private Button botonPrestamos;

    @FXML
    public void ventanaUsuario() {
        try {
            // Carga el archivo FXML
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/usuario.fxml"));

            // Verifica si la ruta del archivo FXML es correcta
            if (cargaLI.getLocation() == null) {
                throw new FileNotFoundException("No se pudo encontrar el archivo FXML.");
            }

            // Inicia la carga de la ventana
            Parent root = cargaLI.load();

            // Obtiene el controlador
            UsuariosController controladorUsuarios = cargaLI.getController();

            // Crea un nuevo escenario
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));

            // Cierra la ventana actual si el botón no es null
            Stage ventanaActual = (Stage) botonUsuarios.getScene().getWindow();
            if (ventanaActual != null) {
                ventanaActual.close();
            }

            // Muestra el nuevo escenario
            escenarioSecundario.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();

            throw new RuntimeException("Error al cargar la ventana de usuarios: " + e.getMessage(), e);
        }
    }

    @FXML
    public void ventanaLibros() {
        try {
            //Carga el archivo FXML
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/libros.fxml"));

            //Inicia  la carga de la ventana
            Parent root = cargaLI.load();

            //Inicia el controlador
            LibrosController controladorLibros = cargaLI.getController();

            //Crea un nuevo escenario
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            //Cierra la ventana actual recogiendo un elemento de ella, para saber de que ventana se trata
            Stage ventanaActual = (Stage) botonLibros.getScene().getWindow();
            ventanaActual.close();

            //Muestra el nuevo escenario
            escenarioSecundario.showAndWait();


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void ventanaEjemplares() {
        try {
            //Carga el archivo FXML
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/ejemplares.fxml"));

            //Inicia  la carga de la ventana
            Parent root = cargaLI.load();

            //Inicia el controlador
            EjemplaresController controladorEjemplares = cargaLI.getController();

            //Crea un nuevo escenario
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            //Cierra la ventana actual recogiendo un elemento de ella, para saber de que ventana se trata
            Stage ventanaActual = (Stage) botonEjemplares.getScene().getWindow();
            ventanaActual.close();

            //Muestra el nuevo escenario
            escenarioSecundario.showAndWait();


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void ventanaPrestamos() {
        try {
            //Carga el archivo FXML
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/prestamos.fxml"));

            //Inicia  la carga de la ventana
            Parent root = cargaLI.load();

            //Inicia el controlador
            PrestamosController controladorPrestamos = cargaLI.getController();

            //Crea un nuevo escenario
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            //Cierra la ventana actual recogiendo un elemento de ella, para saber de que ventana se trata
            Stage ventanaActual = (Stage) botonPrestamos.getScene().getWindow();
            ventanaActual.close();

            //Muestra el nuevo escenario
            escenarioSecundario.showAndWait();


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
