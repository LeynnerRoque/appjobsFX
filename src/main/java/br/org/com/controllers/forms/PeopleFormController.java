package br.org.com.controllers.forms;

import br.org.com.model.Job;
import br.org.com.model.Location;
import br.org.com.model.Peoples;
import br.org.com.service.JobService;
import br.org.com.service.LocationService;
import br.org.com.service.PeoplesService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PeopleFormController implements Initializable {

    PeoplesService service = new PeoplesService();
    JobService serviceJob = new JobService();
    LocationService serviceLocal = new LocationService();

    private ObservableList<Location> listaLocal = FXCollections.observableArrayList(serviceLocal.getAll());
    private ObservableList<Job> listaJobs = FXCollections.observableArrayList(serviceJob.getAll());




    @FXML
    private TextField fieldName;

    @FXML
    private ChoiceBox comboGender;


    @FXML
    private TextField fieldAge;

    @FXML
    private TextField fieldRegion;


    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldPhone;

    @FXML
    private ChoiceBox comboJob;

    @FXML
    private ChoiceBox comboLocal;


    public ObservableList<String> genders(){
        ArrayList<String> genders = new ArrayList<>();
        genders.add("MA");
        genders.add("FE");

        ObservableList<String> gendersCombo = FXCollections.observableArrayList(genders);
        return  gendersCombo;
    }

    @FXML
    private void save(){

        Location location = serviceLocal.getByStreet(comboLocal.getSelectionModel().getSelectedItem().toString());
        Job job = serviceJob.getByTitle(comboJob.getSelectionModel().getSelectedItem().toString());

        Peoples peoples = new Peoples();
        peoples.setName(fieldName.getText());
        peoples.setGender(comboGender.getSelectionModel().getSelectedItem().toString());
        peoples.setAge(Integer.parseInt(fieldAge.getText()));
        peoples.setEmail(fieldEmail.getText());
        peoples.setRegionName(fieldRegion.getText());
        peoples.setLocationId(location);
        peoples.setJobId(job);

        if (service.create(peoples) == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Successful");
            alert.setContentText("Your People was addicted Successful");
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Create Successful");
            alert.setContentText("Your People not addicted");
            alert.show();
        }



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<String> jobs = new ArrayList<>();
        ArrayList<String> locals = new ArrayList<>();




        for (Job j: serviceJob.getAll()) {
            jobs.add(j.getTitle());
            ObservableList<String> names = FXCollections.observableArrayList(jobs);
            comboJob.setItems(names);
        }

        for (Location l: serviceLocal.getAll()) {
            locals.add(l.getStreetAddress());
            ObservableList<String> namesL = FXCollections.observableArrayList(locals);
            comboLocal.setItems(namesL);
        }

        comboGender.setItems(genders());


    }
}
