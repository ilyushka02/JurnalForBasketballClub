package com.mycompany.jurnal;

import static com.mycompany.jurnal.PrimaryController.em;
import java.io.IOException;
import com.mycompany.jurnal.db.Users;
import static com.mycompany.jurnal.rootController.em;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

   

public class MainPageController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Jurnal_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private ImageView img;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit_btn;
    @FXML
    private Button uploadBtn;

    @FXML
    private TextField tLName;

    @FXML
    private TextField tFName;

    @FXML
    private TextField tSName;

    @FXML
    private TextField tGenger;

    @FXML
    private TextField tGroup;

    @FXML
    private TextField tPhone;

    @FXML
    private Button btn_save;
    
    @FXML
    void exit(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }

     @FXML
    void uploadImg(ActionEvent event) throws FileNotFoundException{
        FileChooser chooser = new FileChooser();
        File inputFile = chooser.showOpenDialog(App.getStage());
        FileInputStream inputstream = new FileInputStream(inputFile); 
        Image image = new Image(inputstream);
        img.setImage(image);
        img.setFitHeight(110);
        img.setFitWidth(110);
    }
    
    @FXML
    void initialize() throws IOException {
        Query q = em.createNamedQuery("Users.findByIdUser");
        q.setParameter("idUser", 24);
        Users u = (Users) q.getSingleResult();
        tLName.setText(u.getLastName().toString());
        tFName.setText(u.getName());
        tSName.setText(u.getSecondName());
        tGenger.setText(u.getGender());
        tGroup.setText(u.getUserGroup());
        tPhone.setText(u.getPhone());
    }
    
}

