package br.org.com.controllers.forms;

import br.org.com.model.Enterprise;
import br.org.com.model.Job;
import br.org.com.service.EnterpriseService;
import br.org.com.service.JobService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class JobFormController implements Initializable {

    EnterpriseService serviceEnterprise = new EnterpriseService();
    JobService service = new JobService();
    private ObservableList<Enterprise> lista = FXCollections.observableArrayList(serviceEnterprise.getAll());

    Job jobEdit;

    public void initObject(Job job){
        jobEdit = job;
        Enterprise enterprise = new Enterprise();
        ArrayList<String> listaNames = new ArrayList<>();

        if (job != null){
            this.setJobEdit(job);

            fieldTitle.setText(job.getTitle());
            fieldDescription.setText(job.getDescription());
            fieldSalary.setText(job.getSalary().toString());

            enterprise = jobEdit.getEnterpriseId();

            listaNames.add(enterprise.getFoundationName());
            ObservableList<String> names = FXCollections.observableArrayList(listaNames);

            fieldEnterprise.setItems(names);
        }else{
            fieldTitle.setText(null);
            fieldDescription.setText(null);
            fieldSalary.setText(null);

            ArrayList<String> listaName = new ArrayList<>();

            for (Enterprise e: serviceEnterprise.getAll()) {
                listaNames.add(e.getFoundationName());
                ObservableList<String> names = FXCollections.observableArrayList(listaName);
                fieldEnterprise.setItems(names);
            }

        }

    }

    public void setJobEdit(Job jobEdit) {
        this.jobEdit = jobEdit;
    }

    public Job getJobEdit() {
        return jobEdit;
    }

    @FXML
    private TextField fieldTitle;


    @FXML
    private TextArea fieldDescription;

    @FXML
    private TextField fieldSalary;

    @FXML
    private ChoiceBox fieldEnterprise;

    @FXML
    private Button buttonCancel;


    @FXML
    private void save(){
        try {
            Job j = getJobEdit();
            if (j != null){
            j.setTitle(fieldTitle.getText());
            j.setDescription(fieldDescription.getText());
            j.setSalary(Double.parseDouble(fieldSalary.getText().toString()));

                Enterprise enterprise = serviceEnterprise.getByfoundationName(
                        fieldEnterprise.getSelectionModel().getSelectedItem().toString());

            j.setEnterpriseId(enterprise);

            service.update(jobEdit);


                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edit Successful");
                alert.setContentText("Your Enterprise was edited Successful");
                alert.show();

            }else {


                Enterprise enterprise = serviceEnterprise.getByfoundationName(
                        fieldEnterprise.getSelectionModel().getSelectedItem().toString());


                Job job = new Job();
                job.setTitle(fieldTitle.getText());
                job.setDescription(fieldDescription.getText());
                double salario = Double.parseDouble(fieldSalary.getText());
                job.setSalary(salario);
                job.setEnterpriseId(enterprise);
                service.create(job);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create Successful");
                alert.setContentText("Your Enterprise was addicted Successful");
                alert.show();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Erro>>"+e.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Create Unsuccessful");
            alert.setContentText("Your Job not addicted");
            alert.show();

        }
    }

    @FXML
    private void cancel(){
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<String> listaNames = new ArrayList<>();

        for (Enterprise e: serviceEnterprise.getAll()) {
            listaNames.add(e.getFoundationName());
            ObservableList<String> names = FXCollections.observableArrayList(listaNames);
            fieldEnterprise.setItems(names);
        }

    }
}
