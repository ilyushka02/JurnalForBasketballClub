package com.mycompany.jurnal;

import com.mycompany.jurnal.db.Users;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SecondaryController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Jurnal_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
   
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

        em.getTransaction().begin();
               
        Users u = new Users();
        u.setLastName(lastNameFild.getText());
        u.setName(namefild.getText());
        u.setSecondName(secondNameFild.getText());
        u.setUserGroup("refactoring");
        u.setGender("x");
        u.setPhone(phone.getText().trim());
        u.setUserRole("user");
        u.setUserName(loginFild.getText());
        u.setUserPassword(passwordFild.getText());
        em.persist(u);
        em.getTransaction().commit();
        
        System.out.println("Account create: user name = " + loginFild.getText() + ", password = "+ passwordFild.getText());
    }
}
