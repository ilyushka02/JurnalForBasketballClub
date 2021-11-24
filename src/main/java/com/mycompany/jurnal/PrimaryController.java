package com.mycompany.jurnal;

import com.mycompany.jurnal.db.Users;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrimaryController {
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Jurnal_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginBtn;

    @FXML
    private Button signupBtn;
    
    @FXML
    void switchToSecondary() throws IOException{
        App.setRoot("Secondary");
    }
    
    
    @FXML
    void login() throws IOException {
        Query q = em.createNamedQuery("Users.findByUserName");
        q.setParameter("userName", loginFild.getText());
        
        try {
            // Аутентификация
            Users u = (Users) q.getSingleResult();
            if (u.getUserPassword().equals(passwordField.getText())) {
             
                // Авторизация
                String roleName = u.getUserRole().toString();
                if (roleName.equals("root")) {
                    App.setRoot("rootPage");
                } else {
                    App.setRoot("mainPage");
                }
            } else {
                System.out.println("Неверный логин или пароль");
            }
        } catch (NoResultException e) {
            System.out.println("Неверный логин или пароль");
        }
    }
    
}

