package br.org.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField fieldUsername;

    @FXML
    private TextField fieldPassword;

    @FXML
    private void login(){

        if (fieldUsername.getText().isEmpty() && fieldPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Credentials Invalid");
            alert.setContentText("Enter your Username and your Password");
            alert.show();
        }else if (fieldUsername.getText().equals("LeynnerRoque") &&
        fieldPassword.getText().equals("1989")){
            System.out.println("User Validado");

            try {

                Stage viewHome = new Stage();
                URL url = Paths.get("./src/main/java/br/org/com/views/HomeView.fxml").toUri().toURL();

                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                viewHome.setTitle("Home App Jobs");
                viewHome.setScene(scene);
                viewHome.show();
            }catch (Exception e){
                System.out.println("Error"+e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Direct");
                alert.setContentText("An Error Unexpected");
                alert.show();
            }


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Credentials Invalid");
            alert.setContentText("User not Valid");
            alert.show();
        }

    }

    @FXML
    private void cancel(){
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
