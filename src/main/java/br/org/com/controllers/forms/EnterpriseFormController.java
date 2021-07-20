package br.org.com.controllers.forms;

import br.org.com.model.Enterprise;
import br.org.com.service.EnterpriseService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EnterpriseFormController implements Initializable {


    EnterpriseService service = new EnterpriseService();

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldEmail;

    @FXML
    private TextField fieldPhone;

    @FXML
    private Button buttonCancel;


    @FXML
    private void create(){
        Enterprise enterprise = new Enterprise();

        enterprise.setFoundationName(fieldName.getText());
        enterprise.setEmail(fieldEmail.getText());
        enterprise.setPhoneNumber(fieldPhone.getText());

        try {
            service.create(enterprise);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Successful");
            alert.setContentText("Your Enterprise was addicted Successful");
            alert.show();

        }catch (Exception e){

            System.out.println("Error in addicted");

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Create Unsuccessful");
            alert.setContentText("Your Enterprise not addicted");
            alert.show();

        }

    }

    @FXML
    private void cancel(ActionEvent event){

        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}
