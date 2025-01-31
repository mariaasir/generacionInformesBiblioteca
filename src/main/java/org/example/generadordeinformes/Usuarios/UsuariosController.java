package org.example.generadordeinformes.Usuarios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
 * La clase UsuariosController actúa como el controlador para la ventana de gestión de Usuarios
 * de la aplicación JavaFX. Gestiona los eventos asociados a los botones de la interfaz y la selección de un ComboBox y un ButtonGroup
 * permitiendo elegir entre distintos tipos de Usuarios y si desea que estén penalizados o no, para poder generar un informe.
 *
 *
 * <h2>Responsabilidades principales:</h2>
 * <ul>
 *     <li>Establecer los tooltips para los botones de Generación de Informes y Visualización de Informes.</li>
 *     <li>Cargar las ventanas FXML y los archivos PDF correspondientes cuando el usuario selecciona una opción.</li>
 *     <li>Recoger la información introducida en el ComboBox</li>
 *     <li>Regoger la información introducida en el ButtonGroup (compuesto por dos RadioButtons)</li>
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
public class UsuariosController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton si;
    @FXML
    private RadioButton no;

    @FXML
    private ToggleGroup penalizado;

    @FXML
    private Button botonGenerar;
    @FXML
    private Button botonVisualizar;

    String penalizacion;
    Tooltip informacion = new Tooltip("Seleccione si desea filtrar los usuarios Normales o Administradores. \n Además, debe seleccionar si están penalizados o no.");

    /**
     * Inicializa el controlador de la ventana Usuarios. Añade las diferentes opciones al ComboBox.
     */
    @FXML
    public void initialize() {
        comboBox.getItems().addAll("Normal", "Administrador");
        this.comboBox.setTooltip(informacion);

    }


    /**
     * Realiza la conexión a la BDD a través de JDBC. Realiza un JasperPrint para recoger el archivo .jasper realizado mediante Jaspersoft Studio y
     * lo exporta como un archivo PDF a la ruta /Informes/InformeUsuarios.pdf.  Muestra una alerta de tipo ERROR si no se ha introducido información en el ComboBox y en el ButtonGroup y muestra una alerta de
     * tipo INFORMATION si se ha generado el PDF de forma correcta.
     */
    public void generarInforme() {
        si.setToggleGroup(penalizado);
        no.setToggleGroup(penalizado);
        if (si.isSelected()) {
            penalizacion = "si";
        } else if (no.isSelected()) {
            penalizacion = "no";
        }
        System.out.println("penalizacion" + penalizacion);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "maria", "1234");

            Map<String, Object> parametros = new HashMap();
            parametros.put("parametroTipo", comboBox.getSelectionModel().getSelectedItem());
            parametros.put("parametroPenalizacion", penalizacion);
            System.out.println(parametros);
            JasperPrint print = JasperFillManager.fillReport("src/main/resources/Informes/Usuarios/Usuarios.jasper", parametros, connection);
            JasperExportManager.exportReportToPdfFile(print, "src/main/resources/Informes/InformeUsuarios.pdf");
            if (comboBox.getValue() == null || penalizado.getSelectedToggle() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Complete los campos");
                alert.setHeaderText(null);
                alert.setContentText("Debe completar los campos para poder generar el informe");
                alert.showAndWait();
            } else if (comboBox.getValue() != null && penalizado.getSelectedToggle().isSelected()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informe Generado");
                alert.setHeaderText(null);
                alert.setContentText("El informe se ha generado correctamente.");
                alert.showAndWait();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }



    /**
     * Muestra el informe generado y guardado en la ruta /Informes/InformeUsuarios.pdf
     */
    @FXML
    public void visualizarInforme() {
        // Ruta del archivo PDF generado
        File archivoPDF = new File("src/main/resources/Informes/InformeUsuarios.pdf");

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
//        FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/org.example.generadordeinformes/paginaPrincipal.fxml"));
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
