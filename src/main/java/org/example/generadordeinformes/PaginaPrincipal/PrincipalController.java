package org.example.generadordeinformes.PaginaPrincipal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.generadordeinformes.Ejemplares.EjemplaresController;
import org.example.generadordeinformes.Libros.LibrosController;
import org.example.generadordeinformes.Prestamos.PrestamosController;
import org.example.generadordeinformes.Usuarios.UsuariosController;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * La clase PrincipalController actúa como el controlador para la ventana principal
 * de la aplicación JavaFX. Gestiona los eventos asociados a los botones de la interfaz,
 * permitiendo la navegación hacia otras ventanas específicas relacionadas con libros, usuarios,
 * ejemplares y préstamos.
 *
 * <h2>Responsabilidades principales:</h2>
 * <ul>
 *     <li>Establecer los tooltips para los botones de la interfaz principal.</li>
 *     <li>Cargar las ventanas FXML correspondientes cuando el usuario selecciona una opción.</li>
 *     <li>Cerrar la ventana actual al abrir una nueva para evitar superposiciones.</li>
 * </ul>
 *
 * <h2>Botones de la interfaz:</h2>
 * <ul>
 *     <li>botonLibros: Genera informes de libros.</li>
 *     <li>botonUsuarios: Genera informes de usuarios.</li>
 *     <li>botonEjemplares: Genera informes de ejemplares.</li>
 *     <li>botonPrestamos: Genera informes de préstamos.</li>
 * </ul>
 *
 * @author María López Patón
 * @version 1.0
 */
public class PrincipalController {

    @FXML
    private Button botonLibros;
    @FXML
    private Button botonUsuarios;
    @FXML
    private Button botonEjemplares;
    @FXML
    private Button botonPrestamos;

    Tooltip tooltipLibros = new Tooltip("Generar informe de libros");
    Tooltip tooltipUsuarios = new Tooltip("Generar informe de usuarios");
    Tooltip tooltipEjemplares = new Tooltip("Generar informe de ejemplares");
    Tooltip tooltipPrestamos = new Tooltip("Generar informe de préstamos");

    /**
     * Inicializa el controlador de la ventana principal. Configura los tooltips para los botones
     * de la interfaz, proporcionando una descripción de su funcionalidad al usuario.
     */
    public void initialize() {
        this.botonLibros.setTooltip(tooltipLibros);
        this.botonUsuarios.setTooltip(tooltipUsuarios);
        this.botonEjemplares.setTooltip(tooltipEjemplares);
        this.botonPrestamos.setTooltip(tooltipPrestamos);
    }

    /**
     * Abre la ventana de gestión de usuarios cargando el archivo {@code usuario.fxml}.
     * Cierra la ventana principal mientras la nueva ventana está activa.
     */
    @FXML
    public void ventanaUsuario() {
        try {
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/usuario.fxml"));
            if (cargaLI.getLocation() == null) {
                throw new FileNotFoundException("No se pudo encontrar el archivo FXML.");
            }
            Parent root = cargaLI.load();
            UsuariosController controladorUsuarios = cargaLI.getController();
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            Stage ventanaActual = (Stage) botonUsuarios.getScene().getWindow();
            if (ventanaActual != null) {
                ventanaActual.close();
            }
            escenarioSecundario.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar la ventana de usuarios: " + e.getMessage(), e);
        }
    }

    /**
     * Abre la ventana de gestión de libros cargando el archivo {@code libros.fxml}.
     * Cierra la ventana principal mientras la nueva ventana está activa.
     */
    @FXML
    public void ventanaLibros() {
        try {
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/libros.fxml"));
            Parent root = cargaLI.load();
            LibrosController controladorLibros = cargaLI.getController();
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            Stage ventanaActual = (Stage) botonLibros.getScene().getWindow();
            ventanaActual.close();
            escenarioSecundario.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la ventana de libros: " + e.getMessage(), e);
        }
    }

    /**
     * Abre la ventana de gestión de ejemplares cargando el archivo {@code ejemplares.fxml}.
     * Cierra la ventana principal mientras la nueva ventana está activa.
     */
    @FXML
    public void ventanaEjemplares() {
        try {
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/ejemplares.fxml"));
            Parent root = cargaLI.load();
            EjemplaresController controladorEjemplares = cargaLI.getController();
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            Stage ventanaActual = (Stage) botonEjemplares.getScene().getWindow();
            ventanaActual.close();
            escenarioSecundario.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la ventana de ejemplares: " + e.getMessage(), e);
        }
    }

    /**
     * Abre la ventana de gestión de préstamos cargando el archivo {@code prestamos.fxml}.
     * Cierra la ventana principal mientras la nueva ventana está activa.
     */
    @FXML
    public void ventanaPrestamos() {
        try {
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/prestamos.fxml"));
            Parent root = cargaLI.load();
            PrestamosController controladorPrestamos = cargaLI.getController();
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            Stage ventanaActual = (Stage) botonPrestamos.getScene().getWindow();
            ventanaActual.close();
            escenarioSecundario.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la ventana de préstamos: " + e.getMessage(), e);
        }
    }
}
