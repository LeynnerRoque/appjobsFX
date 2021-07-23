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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PeopleFormController implements Initializable {

    PeoplesService service = new PeoplesService();
    JobService serviceJob = new JobService();
    LocationService serviceLocal = new LocationService();
    Peoples people;

    private ObservableList<Location> listaLocal = FXCollections.observableArrayList(serviceLocal.getAll());
    private ObservableList<Job> listaJobs = FXCollections.observableArrayList(serviceJob.getAll());



    public void initObject(Peoples peoples){
        people = peoples;
        ArrayList<String> listaNames = new ArrayList<>();
        ArrayList<String> locals = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();

        if (peoples != null){
            fieldName.setText(peoples.getName());
            fieldEmail.setText(peoples.getEmail());
            fieldPhone.setText(peoples.getPhone());
            fieldAge.setText(peoples.getAge().toString());
            fieldRegion.setText(peoples.getRegionName());

            Job job = peoples.getJobId();
            listaNames.add(job.getTitle());
            ObservableList<String> names = FXCollections.observableArrayList(listaNames);
            comboJob.setItems(names);

            Location location = peoples.getLocationId();
            locals.add(location.getStreetAddress());
            ObservableList<String> local = FXCollections.observableArrayList(locals);
            comboLocal.setItems(local);

            gender.add(peoples.getGender());
            ObservableList<String> genders = FXCollections.observableArrayList(gender);

            comboGender.setItems(genders);


        }else{
            fieldName.setText(null);
            fieldEmail.setText(null);
            fieldPhone.setText(null);
            fieldAge.setText(null);

        }
    }

    public void setPeople(Peoples people) {
        this.people = people;
    }

    public Peoples getPeople() {
        return people;
    }

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

    @FXML
    private Button buttonCancel;


    public ObservableList<String> genders(){
        ArrayList<String> genders = new ArrayList<>();
        genders.add("MA");
        genders.add("FE");

        ObservableList<String> gendersCombo = FXCollections.observableArrayList(genders);
        return  gendersCombo;
    }

    @FXML
    private void save(){

        if (getPeople().getId() != null) {
            Peoples p = getPeople();
            p.setName(fieldName.getText());
            p.setEmail(fieldEmail.getText());
            p.setPhone(fieldPhone.getText());
            p.setAge(Integer.parseInt(fieldAge.getText()));
            p.setRegionName(fieldRegion.getText());

            Location location = serviceLocal.getByStreet(comboLocal.getSelectionModel().getSelectedItem().toString());
            Job job = serviceJob.getByTitle(comboJob.getSelectionModel().getSelectedItem().toString());

            p.setLocationId(location);
            p.setJobId(job);

           if( service.update(p) == true){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Create Successful");
               alert.setContentText("Your People was edited Successful");
               alert.show();
           }else{
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Create Successful");
               alert.setContentText("Your People not edited");
               alert.show();
           }



        }else {

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

            if (service.create(peoples) == true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create Successful");
                alert.setContentText("Your People was addicted Successful");
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Create Successful");
                alert.setContentText("Your People not addicted");
                alert.show();
            }

        }

    }



    @FXML
    private void cancel(){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
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
