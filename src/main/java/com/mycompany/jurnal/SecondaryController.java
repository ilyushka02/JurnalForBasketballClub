package com.mycompany.jurnal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SecondaryController {
   
    @FXML
    private TextField lastNameFild;

    @FXML
    private TextField namefild;

    @FXML
    private TextField secondNameFild;

    @FXML
    private TextField phone;

    @FXML
    private ChoiceBox<?> groupBox;

    @FXML
    private Button backBtn;

    @FXML
    private ChoiceBox<?> genderBox;

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordFild;

    @FXML
    void back(ActionEvent event) throws IOException {
      App.setRoot("Primary");  
    }   
    @FXML
    void createUser(ActionEvent event){
    
    }
}
