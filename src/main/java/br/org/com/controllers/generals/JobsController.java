package br.org.com.controllers.generals;

import br.org.com.controllers.forms.EnterpriseFormController;
import br.org.com.controllers.forms.JobFormController;
import br.org.com.model.Enterprise;
import br.org.com.model.Job;
import br.org.com.service.JobService;
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

public class JobsController implements Initializable {

    JobService service = new JobService();
    private ObservableList<Job> lista = FXCollections.observableArrayList(service.getAll());

    @FXML
    private TableView tableJobs;

    @FXML
    private TableColumn code;

    @FXML
    private TableColumn name;

    @FXML
    private  TableColumn desc;


    @FXML
    private void addNew(){
        try {

            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/forms/JobForms.fxml").toUri().toURL();

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
    private void edit(){

        Job object = (Job) tableJobs.getSelectionModel().getSelectedItem();

        try {

            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/forms/JobForms.fxml").toUri().toURL();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(url);
            Parent tableParent = loader.load();
            Scene formEdit = new Scene(tableParent);

            viewList.setTitle("EDIT");
            JobFormController editScene = loader.getController();
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

            code.setCellValueFactory(new PropertyValueFactory<Job, String>("id"));
            name.setCellValueFactory(new PropertyValueFactory<Job, String>("title"));
            desc.setCellValueFactory(new PropertyValueFactory<Job, String>("description"));

            tableJobs.setItems(lista);
        }

    }
}
