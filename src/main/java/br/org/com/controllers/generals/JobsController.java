package br.org.com.controllers.generals;

import br.org.com.model.Job;
import br.org.com.service.JobService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
