package org.example.generadordeinformes.Prestamos;

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
 * La clase PrestamosController actúa como el controlador para la ventana de gestión de Préstamos
 * de la aplicación JavaFX. Gestiona los eventos asociados a los botones de la interfaz y la selección de un ComboBox
 * permitiendo elegir entre distintos estados de los Préstamos para poder generar un informe.
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
public class PrestamosController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button botonGenerar;
    @FXML
    private Button botonVisualizar;

    Tooltip informacion = new Tooltip("Seleccione si desea filtrar los Prestamos devvueltos o los que no han sido devueltos aún.");



    /**
     * Inicializa el controlador de la ventana Préstamos. Añade las diferentes opciones al ComboBox.
     */
    @FXML
    public void initialize() {
        comboBox.getItems().addAll("Devueltos", "No Devueltos");
        this.comboBox.setTooltip(informacion);
    }


    /**
     * Realiza la conexión a la BDD a través de JDBC. Realiza un JasperPrint para recoger el archivo .jasper realizado mediante Jaspersoft Studio y
     * lo exporta como un archivo PDF a la ruta /Informes/InformePrestamos.pdf.  Muestra una alerta de tipo ERROR si no se ha introducido información en el ComboBox y muestra una alerta de
     * tipo INFORMATION si se ha generado el PDF de forma correcta.
     */
    public void generarInforme() {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "maria", "1234");

            Map parametroPrestamos = new HashMap();
            parametroPrestamos.put("parametroPrestamos", comboBox.getSelectionModel().getSelectedItem());

            System.out.println(parametroPrestamos);
            JasperPrint print = JasperFillManager.fillReport("src/main/resources/Informes/Prestamos/Prestamos.jasper", parametroPrestamos, connection);
            JasperExportManager.exportReportToPdfFile(print, "src/main/resources/Informes/InformePrestamos.pdf");
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
     * Muestra el informe generado y guardado en la ruta /Informes/InformePrestamos.pdf
     */
    @FXML
    public void visualizarInforme() {
        // Ruta del archivo PDF generado
        File archivoPDF = new File("src/main/resources/Informes/InformePrestamos.pdf");

        if (archivoPDF.exists()) {
            try {
                // Abre el archivo PDF usando la aplicación predeterminada del sistema
                Desktop desktop = Desktop.getDesktop();
                desktop.open(archivoPDF);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // Si el archivo no existe, muestra un mensaje de error
            System.out.println("El archivo PDF no se encuentra.");
        }
    }
    @FXML
    public void ventanaAyuda() {
        try {
            // Ruta al archivo .java compilado o al .jar que deseas ejecutar
            String rutaJava = "src/main/java/org/example/generadordeinformes/AccesoInterfaz/Manual.java";  // Puedes reemplazar esto con el archivo compilado .class si es necesario

            // Comando para ejecutar el archivo Java
            ProcessBuilder builder = new ProcessBuilder("java", rutaJava); // Esto asume que tienes el archivo .class o .jar y puedes usar "java" para ejecutarlo
            builder.inheritIO();  // Esto permite que la salida de la consola se vea en tu terminal
            Process proceso = builder.start();  // Inicia el proceso

            // Espera a que termine el proceso (si es necesario)
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al ejecutar el archivo Java: " + e.getMessage(), e);
        }
    }
}


//@FXML
//public void volver() {
//    try {
//        FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/paginaPrincipal.fxml"));
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
