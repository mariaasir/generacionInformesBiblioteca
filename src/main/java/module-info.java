module org.example.generadordeinformes {
    requires javafx.controls;
    requires javafx.fxml;
    requires net.sf.jasperreports.core;
    requires java.desktop;
    requires java.sql;



    opens org.example.generadordeinformes.PaginaPrincipal to javafx.fxml;
    exports org.example.generadordeinformes.PaginaPrincipal;

    opens org.example.generadordeinformes.Usuarios to javafx.fxml;
    exports org.example.generadordeinformes.Usuarios;

    opens org.example.generadordeinformes.Libros to javafx.fxml;
    exports org.example.generadordeinformes.Libros;

    opens org.example.generadordeinformes.Prestamos to javafx.fxml;
    exports org.example.generadordeinformes.Prestamos;

    opens org.example.generadordeinformes.Ejemplares to javafx.fxml;
    exports org.example.generadordeinformes.Ejemplares;



}