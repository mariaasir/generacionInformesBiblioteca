package org.example.generadordeinformes.Usuarios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.example.generadordeinformes.PaginaPrincipal.PrincipalController;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UsuariosController {
    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private RadioButton si;
    @FXML
    private RadioButton no;

    @FXML
    private ToggleGroup penalizado;

    String penalizacion;
    Tooltip informacion = new Tooltip("Seleccione si desea filtrar los usuarios Normales o Administradores. \n Además, debe seleccionar si están penalizados o no.");


    @FXML
    public void initialize() {
        comboBox.getItems().addAll("Normal", "Administrador");
        this.comboBox.setTooltip(informacion);

    }


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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informe Generado");
            alert.setHeaderText(null);
            alert.setContentText("El informe se ha generado correctamente.");
            alert.showAndWait();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void volver() {
        try {
            FXMLLoader cargaLI = new FXMLLoader(getClass().getResource("/org/example/generadordeinformes/paginaPrincipal.fxml"));
            Parent root = cargaLI.load();

            // Aquí obtienes la ventana principal
            Stage ventanaPrincipal = (Stage) comboBox.getScene().getWindow();
            ventanaPrincipal.close();  // Cerrar la ventana actual

            // Crear una nueva ventana (modal)
            Stage escenarioSecundario = new Stage();
            escenarioSecundario.initModality(Modality.APPLICATION_MODAL);
            escenarioSecundario.setScene(new Scene(root));
            escenarioSecundario.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



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


}

