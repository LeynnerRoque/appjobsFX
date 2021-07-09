package br.org.com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HomeController implements Initializable {


    @FXML
    private void directEnterprises(){

        System.out.println("Enterprises Pages");

        try {
            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/generals/EnterpriseList.fxml").toUri().toURL();

            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            viewList.setTitle("Enterprise");
            viewList.setScene(scene);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on load objects"+e.getMessage());
        }

    }

    @FXML
    private void directJobs(){
        System.out.println("Jobs Pages");
        try {
            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/generals/JobsList.fxml").toUri().toURL();

            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            viewList.setTitle("Jobs");
            viewList.setScene(scene);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on load objects"+e.getMessage());
        }
    }


    @FXML
    private void directPeoples(){
        System.out.println("Peoples Pages");
        try {
            Stage viewList = new Stage();
            URL url = Paths.get("./src/main/java/br/org/com/views/generals/PeoplesList.fxml").toUri().toURL();

            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            viewList.setTitle("Peoples");
            viewList.setScene(scene);
            viewList.show();

        }catch (Exception e){
            System.out.println("Error on load objects"+e.getMessage());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
