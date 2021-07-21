package br.org.com.controllers.generals;

import br.org.com.controllers.forms.EnterpriseFormController;
import br.org.com.model.Enterprise;
import br.org.com.service.EnterpriseService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class EnterpriseController implements Initializable {

    EnterpriseService service = new EnterpriseService();

    private ObservableList<Enterprise> lista = FXCollections.observableArrayList(service.getAll());
    @FXML
    private TableView tableEnterprise;

    @FXML
    private TableColumn code;

    @FXML
    private TableColumn name;

    @FXML
    private TableColumn email;

    @FXML
    private TableColumn phone;

    @FXML
    private Button buttonEdit;


    @FXML
    private void add(){
        try {
            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/forms/EnterpriseForms.fxml").toUri().toURL();

            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            viewList.setTitle("ADD");
            viewList.setScene(scene);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on call page"+e.getMessage());
        }
    }

    @FXML
    private void edit() {
        //System.out.println(tableEnterprise.getSelectionModel().getSelectedItem());
        Enterprise object = (Enterprise) tableEnterprise.getSelectionModel().getSelectedItem();

        try {

            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/forms/EnterpriseForms.fxml").toUri().toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent tableParent = loader.load();
            Scene formEdit = new Scene(tableParent);

            viewList.setTitle("EDIT");
            EnterpriseFormController editScene = loader.getController();
            editScene.initObject(object);
            viewList.setScene(formEdit);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on call page"+e.getMessage());
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < service.getAll().size(); i++) {

            //tableEnterprise.getItems().add(service.getAll().get(i));

            code.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("id"));
            name.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("foundationName"));
            email.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("email"));
            phone.setCellValueFactory( new PropertyValueFactory<Enterprise, String>("phoneNumber"));

            tableEnterprise.setItems(lista);
            }
    }
}
