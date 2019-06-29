package esgi.java.advanced.ui.desktop.app;

import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Home  {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    @FXML private JFXButton submit;
    @FXML private JFXTextField emailField;
    @FXML private JFXPasswordField passwordField;


    public static Scene scene() throws java.io.IOException{
        Parent pane = FXMLLoader.load(Home.class.getResource("Home.fxml"));
        return new Scene(pane);

    }



    @FXML
    public Scene  login() {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "wellcome.fxml"));

            if (this.emailField.getText().equals("root") && this.passwordField.getText().equals("root")) {
                Main.window.setScene(new Scene(homePage, WellcomeController.WIDTH, WellcomeController.HEIGHT));


            } else
                AfficherAlerte.display("Erreur", "Les identifiants saisis sont incorrects.");
        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
        return null;
    }






}
