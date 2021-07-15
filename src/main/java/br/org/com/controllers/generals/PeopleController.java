package br.org.com.controllers.generals;

import br.org.com.model.Enterprise;
import br.org.com.model.Peoples;
import br.org.com.service.PeoplesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class PeopleController implements Initializable {

    PeoplesService service = new PeoplesService();
    private ObservableList<Peoples> lista = FXCollections.observableArrayList(service.getAll());



    @FXML
    private TableView tablePeoples;

    @FXML
    private TableColumn code;

    @FXML
    private TableColumn name;


    @FXML
    private TableColumn email;


    @FXML
    private TableColumn phone;


    @FXML
    private void addNew(){
        try {

            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/forms/PeopleForms.fxml").toUri().toURL();

            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            viewList.setTitle("ADD");
            viewList.setScene(scene);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on call page"+e.getMessage());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i <service.getAll().size() ; i++) {

            code.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("id"));
            name.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("name"));
            email.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("email"));
            phone.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("phone"));

            tablePeoples.setItems(lista);


        }

    }
}
