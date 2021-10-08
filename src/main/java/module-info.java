module com.mycompany.jurnal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.base;
    

    opens com.mycompany.jurnal to javafx.fxml;
    opens com.mycompany.jurnal.db;
    exports com.mycompany.jurnal;
}
