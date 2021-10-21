package com.mycompany.jurnal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


   

public class MainPageController {
    
 @FXML
    private Button exit_btn;

    @FXML
    void exit(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }

}

