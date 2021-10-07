package com.mycompany.jurnal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SecondaryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginFild;

    @FXML
    private TextField loginFild1;

    @FXML
    private TextField loginFild2;

    @FXML
    private TextField loginFild3;

    @FXML
    private Button backBtn;

    @FXML
    void back(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }
    
    @FXML
    void styleForDef(MouseEvent event) {
        backBtn.setStyle("-fx-background-color: white");
    }

    @FXML
    void styleForEntered(MouseEvent event) {
        backBtn.setStyle("-fx-background-color: gray");
    }    
}
