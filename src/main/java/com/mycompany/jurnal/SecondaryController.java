package com.mycompany.jurnal;

import com.mycompany.jurnal.db.Usergroup;
import com.mycompany.jurnal.db.Users;
import static com.mycompany.jurnal.rootController.em;
import java.io.IOException;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.util.StringConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
    private ChoiceBox<String> genderBox;

    @FXML
    private TextField loginFild;

    @FXML
    private PasswordField passwordFild;

    @FXML
    void back(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }

    @FXML
    void initialize() {
        uploadGender();
        System.out.println("GROUP ====== ");
//        uploadUserGroup();
    }

    @FXML
    void createUser(ActionEvent event) {

        em.getTransaction().begin();

        Users u = new Users();
        u.setLastName(lastNameFild.getText());
        u.setName(namefild.getText());
        u.setSecondName(secondNameFild.getText());
        u.setPhone(phone.getText().trim());
        u.setUserRole("user");
        u.setGender(genderBox.getValue());
        u.setUserName(loginFild.getText());
        u.setUserPassword(passwordFild.getText());
        em.persist(u);
        em.getTransaction().commit();

        System.out.println("Account create: user name = " + loginFild.getText() + ", password = " + passwordFild.getText());
        System.out.println("Res ====== " + genderBox.getValue());

    }

    private void uploadGender() {
        String g = null;
        ObservableList<String> gender = FXCollections.observableArrayList("муж", "жен");
        genderBox.setItems(gender);
        g = genderBox.getValue();
        genderBox.setValue(g);
    }

//    public void uploadUserGroup() {
//        Query q = em.createNamedQuery("Usergroup.findAll");
//        List<Usergroup> ug = q.getResultList();
//        ObservableList tableModeUG = .getItems();
//        
//        genderBox.setItems();
//        ((TableColumn.CellDataFeatures<Usergroup, Integer> cd) -> {
//            return new SimpleObjectProperty(cd.getValue().getNumberGroup());
//        });
//        
//        nameColumnUserGroup.setCellValueFactory((TableColumn.CellDataFeatures<Usergroup, String> cd) -> {
//            return new SimpleStringProperty(cd.getValue().getNameGroup());
//        });       
//        
//        for (Usergroup u : ug) {
//            tableModeUG.add(u);
//        }
//        Query q = em.createNamedQuery("Usergroup.findAll");
//        List<Usergroup> ug = q.getResultList();
//        groupBox.setConverter(new StringConverter<Usergroup>(){
//            @Override
//            public String toString(Usergroup t) {
//                return t.getNameGroup();
//            }
//
//            @Override
//            public Usergroup fromString(String string) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//        groupBox.setItems(FXCollections.observableList(ug));
//}
}
