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
    Enterprise enterpriseEdit;


    public void initObject(Enterprise e){
        enterpriseEdit = e;
        this.setEnterpriseEdit(e);
        if (e != null){
            fieldName.setText(e.getFoundationName());
            fieldEmail.setText(e.getEmail());
            fieldPhone.setText(e.getPhoneNumber());
        }else{
            fieldName.setText(null);
            fieldEmail.setText(null);
            fieldPhone.setText(null);
        }
    }

    public void setEnterpriseEdit(Enterprise enterpriseEdit) {
        this.enterpriseEdit = enterpriseEdit;
    }

    public Enterprise getEnterpriseEdit() {
        return enterpriseEdit;
    }

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

        try {
            Enterprise editada = getEnterpriseEdit();
            if (editada != null){

                editada.setFoundationName(fieldName.getText());
                editada.setEmail(fieldEmail.getText());
                editada.setPhoneNumber(fieldPhone.getText());

                service.update(editada);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Edit Successful");
                alert.setContentText("Your Enterprise was edited Successful");
                alert.show();
            }else {

                Enterprise enterprise = new Enterprise();

                enterprise.setFoundationName(fieldName.getText());
                enterprise.setEmail(fieldEmail.getText());
                enterprise.setPhoneNumber(fieldPhone.getText());

                service.create(enterprise);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create Successful");
                alert.setContentText("Your Enterprise was addicted Successful");
                alert.show();
            }
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
