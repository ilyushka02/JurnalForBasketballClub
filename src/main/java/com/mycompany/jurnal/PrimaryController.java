package com.mycompany.jurnal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;

    @FXML
    void switchToSecondary(ActionEvent event) throws IOException{
        App.setRoot("Secondary");
    }
    
    

}

