package br.org.com.controllers.generals;

import br.org.com.model.Enterprise;
import br.org.com.service.EnterpriseService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class ComboTesteController implements Initializable {


    EnterpriseService serviceEnterprise = new EnterpriseService();
    private ObservableList<Enterprise> lista = FXCollections.observableArrayList(serviceEnterprise.getAll());



    @FXML
    private ComboBox comboBox;


    private ComboBox carregaCombo(){

        ArrayList<String> listaNames = new ArrayList<>();

        //Edit combo
        comboBox.setEditable(true);
        //load combo
        for (Enterprise e: serviceEnterprise.getAll()) {
            listaNames.add(e.getFoundationName());
            ObservableList<String> names = FXCollections.observableArrayList(listaNames);
            comboBox.setItems(names);

        }
        //get value comboEdit
        comboBox.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("Digitou:"+newValue);

                ArrayList<String> novoCombo = new ArrayList<>();
                ArrayList<String> novoCombo2 = new ArrayList<>();

                for (Enterprise e: serviceEnterprise.getAll()) {
                    if (e.getFoundationName().toLowerCase(Locale.ROOT).contains(newValue)){
                        System.out.println("Achou>>"+e.getFoundationName());
                        comboBox.getItems().clear();
                        novoCombo.add(e.getFoundationName());
                        ObservableList<String> carregaNovo = FXCollections.observableArrayList(novoCombo);
                        comboBox.setItems(carregaNovo);
                        comboBox.show();
                    }
                    if(newValue.length() == 0){
                        comboBox.getItems().clear();
                        comboBox.hide();
                        for (Enterprise o: serviceEnterprise.getAll()) {
                            novoCombo2.add(o.getFoundationName());
                            ObservableList<String> carregaNovo2 = FXCollections.observableArrayList(novoCombo2);
                            comboBox.getItems().addAll(carregaNovo2);
                            comboBox.show();
                        }

                    }
                }

            }
        });

       /* if(comboBox.getEditor().getText().isEmpty()){
            for (Enterprise e: serviceEnterprise.getAll()) {
                System.out.println("Chegou Aqui");
                ArrayList<String> novoCombo = new ArrayList<>();
                novoCombo.add(e.getFoundationName());
                ObservableList<String> carregaNovo = FXCollections.observableArrayList(novoCombo);
                comboBox.setItems(carregaNovo);
                comboBox.show();
            }
        }*/

        return comboBox;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregaCombo();
    }
}
