module com.mycompany.jurnal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.jurnal to javafx.fxml;
    exports com.mycompany.jurnal;
}
