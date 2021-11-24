package com.mycompany.jurnal;

import com.mycompany.jurnal.db.Usergroup;
import com.mycompany.jurnal.db.Users;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javax.persistence.Query;

public class rootController {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_Jurnal_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
     @FXML
    private Button export_btn;

    @FXML
    private Button import_btn;

    @FXML
    private Button backBtn;
    
    //Таблица группы
    @FXML
    private TableView tableViewGroupUser;

    @FXML
    private TableColumn<Usergroup, Integer> idColumnUserGroup;

    @FXML
    private TableColumn<Usergroup, String> nameColumnUserGroup;

    
    //Таблица пользователи
     @FXML
    private TableView tableViewUser;

    @FXML
    private TableColumn<Users, Integer> columnUserId;
     
    @FXML
    private TableColumn<Users, String> columnUserLastName;

    @FXML
    private TableColumn<Users, String> columnUserFirstName;

    @FXML
    private TableColumn<Users, String> columnUserMidllName;

    @FXML
    private TableColumn<Users, String> columnUserGender;

    @FXML
    private TableColumn<Users, String> columnUserUG;

    @FXML
    private TableColumn<Users, Integer> columnUserPhone;

    @FXML
    void backP(ActionEvent event) throws IOException {
        App.setRoot("Primary");
    }
        
    @FXML
    void initialize() {
        uploadUserGroup();
        uploadUser();
        
    }
    
    private void uploadUserGroup(){
        //Заполнение таблицы группы
        Query q = em.createNamedQuery("Usergroup.findAll");
        List<Usergroup> ug = q.getResultList();
        ObservableList tableModeUG = tableViewGroupUser.getItems();
        
        idColumnUserGroup.setCellValueFactory((TableColumn.CellDataFeatures<Usergroup, Integer> cd) -> {
            return new SimpleObjectProperty(cd.getValue().getNumberGroup());
        });
        
        nameColumnUserGroup.setCellValueFactory((TableColumn.CellDataFeatures<Usergroup, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getNameGroup());
        });       
        
        for (Usergroup u : ug) {
            tableModeUG.add(u);
        }
    }
    

    private void uploadUser(){
         //Заполнение таблицы пользователи
        Query q = em.createNamedQuery("Users.findAll");
        List<Users> user = q.getResultList();
        ObservableList tableModeU = tableViewUser.getItems();
        
        columnUserId.setCellValueFactory((TableColumn.CellDataFeatures<Users, Integer> cd) -> {
            return new SimpleObjectProperty(cd.getValue().getIdUser());
        });
        
        columnUserLastName.setCellValueFactory((TableColumn.CellDataFeatures<Users, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getLastName());
        });  
        
        columnUserFirstName.setCellValueFactory((TableColumn.CellDataFeatures<Users, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getName());
        });
       
       columnUserMidllName.setCellValueFactory((TableColumn.CellDataFeatures<Users, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getSecondName());
        });
       
       columnUserGender.setCellValueFactory((TableColumn.CellDataFeatures<Users, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getGender());
        });
       
       columnUserUG.setCellValueFactory((TableColumn.CellDataFeatures<Users, String> cd) -> {
            return new SimpleStringProperty(cd.getValue().getUserGroup());
        });
       
      columnUserPhone.setCellValueFactory((TableColumn.CellDataFeatures<Users, Integer> cd) -> {
            return new SimpleObjectProperty(cd.getValue().getPhone());
        });
      
        for (Users u : user) {
            tableModeU.add(u);
        }
    }

    @FXML
    void exportUser(ActionEvent event) throws IOException {
        System.out.println("Export detected ======");
        
        Query q = em.createNamedQuery("Users.findAll");
        List<Users> user = q.getResultList();
        
        
        FileChooser chooser = new FileChooser();
        File outputFile = chooser.showSaveDialog(App.getStage());
        
        UserFunction.exportUsers(outputFile, user);

    }

    @FXML
    void importUsser(ActionEvent event) {
        System.out.println("Import detected =======");
        
    }   
}

