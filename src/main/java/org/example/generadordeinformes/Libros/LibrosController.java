package org.example.generadordeinformes.Libros;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase LibrosController actúa como el controlador para la ventana de gestión de Libros
 * de la aplicación JavaFX. Gestiona los eventos asociados a los botones de la interfaz y la selección de un ComboBox
 * permitiendo elegir entre distintos autores para poder generar un informe.
 *
 *
 * <h2>Responsabilidades principales:</h2>
 * <ul>
 *     <li>Establecer los tooltips para los botones de Generación de Informes y Visualización de Informes.</li>
 *     <li>Cargar las ventanas FXML y los archivos PDF correspondientes cuando el usuario selecciona una opción.</li>
 *     <li>Recoger la información introducida en el ComboBox</li>
 *     <li>Muestra una alerta de tipo ERROR si no se ha introducido toda la información</li>
 *     <li>Muestra una alerta de tipo INFORMATION si se ha generado el PDF correctamente</li>
 * </ul>
 *
 * <h2>Botones de la interfaz:</h2>
 * <ul>
 *     <li><strong>botonGenerar: </strong>Genera el informe de los Libros</li>
 *     <li><strong>botonVisualizar:</strong> Visualiza el informe en formato PDF</li>
 * </ul>
 *
 * @author María López Patón
 * @version 1.0
 */
public class LibrosController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button botonGenerar;
    @FXML
    private Button botonVisualizar;
    Tooltip informacion = new Tooltip("Los libros se filtrarán por el nombre del autor para realizar el informe.\n Seleccione el autor por el que desea filtrar.");


    /**
     * Inicializa el controlador de la ventana Libros. Añade las diferentes opciones al ComboBox.
     */
    @FXML
    public void initialize() {
        comboBox.getItems().addAll(
                "Suzanne Collins", "Stieg Larsson", "Stephen King", "Paulo Coelho",
                "Miguel de Cervantes", "Leopoldo Alas", "J.R.R. Tolkien", "J.K. Rowling",
                "Ian McEwan", "Homer", "George R.R. Martin", "George Orwell");
        this.comboBox.setTooltip(informacion);
    }


    /**
     * Realiza la conexión a la BDD a través de JDBC. Realiza un JasperPrint para recoger el archivo .jasper realizado mediante Jaspersoft Studio y
     * lo exporta como un archivo PDF a la ruta /Informes/InformeLibros.pdf.  Muestra una alerta de tipo ERROR si no se ha introducido información en el ComboBox y muestra una alerta de
     * tipo INFORMATION si se ha generado el PDF de forma correcta.
     */
    public void generarInforme() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "maria", "1234");

            Map parametroAutor= new HashMap();
            parametroAutor.put("parametroAutor", comboBox.getSelectionModel().getSelectedItem());

            System.out.println(parametroAutor);
            JasperPrint print = JasperFillManager.fillReport("src/main/resources/Informes/Libros/Libros.jasper", parametroAutor, connection);
            JasperExportManager.exportReportToPdfFile(print, "src/main/resources/Informes/InformeLibros.pdf");
            if (comboBox.getValue() == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Complete los campos");
                alert.setHeaderText(null);
                alert.setContentText("Debe completar los campos para poder generar el informe");
                alert.showAndWait();
            } else if (comboBox.getValue() != null){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informe Generado");
                alert.setHeaderText(null);
                alert.setContentText("El informe se ha generado correctamente.");
                alert.showAndWait();
            }
        }
        catch (Throwable e){
            e.printStackTrace();
        }
    }


    /**
     * Muestra el informe generado y guardado en la ruta /Informes/InformeLibros.pdf
     */
    @FXML
    public void visualizarInforme() {
        // Ruta del archivo PDF generado
        File archivoPDF = new File("src/main/resources/Informes/InformeLibros.pdf");

        if (archivoPDF.exists()) {
            try {

                Desktop desktop = Desktop.getDesktop();
                desktop.open(archivoPDF);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo PDF no se encuentra.");
        }
    }

}


//@FXML
//public void volver() {
//    try {
//        FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("org/example/generadordeinformes/paginaPrincipal.fxml"));
//        Parent root = cargaLI.load();
//
//        // Aquí obtienes la ventana principal
//        Stage ventanaPrincipal = (Stage) comboBox.getScene().getWindow();
//        ventanaPrincipal.close();  // Cerrar la ventana actual
//
//        // Crear una nueva ventana (modal)
//        Stage escenarioSecundario = new Stage();
//        escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
//        escenarioSecundario.setScene(new Scene(root));
//        escenarioSecundario.showAndWait();
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//}
