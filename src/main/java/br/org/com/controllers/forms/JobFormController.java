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
        System.out.println(">>"+fieldEnterprise.getSelectionModel().getSelectedItem());
        Enterprise enterprise = serviceEnterprise.getByfoundationName(
                fieldEnterprise.getSelectionModel().getSelectedItem().toString());

        System.out.println(">>"+enterprise.getId());


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

        }catch (Exception e){
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
