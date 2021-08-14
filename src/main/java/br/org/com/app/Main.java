package br.org.com.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.file.Paths;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
               try {
                   URL url = Paths.get("./src/main/java//br/org/com/views/Login.fxml").toUri().toURL();
                   //URL url = Paths.get("./src/main/java//br/org/com/views/generals/comboTeste.fxml").toUri().toURL();


                   Parent root = FXMLLoader.load(url);
                    Scene scene = new Scene(root);
                    primaryStage.setTitle("Login");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }catch (Exception e){
                    System.out.println("Error"+e.getMessage());
                    e.printStackTrace();
                    System.exit(0);
                }


            }

            public static void main(String[] args) {
                launch(args);
            }
        }
