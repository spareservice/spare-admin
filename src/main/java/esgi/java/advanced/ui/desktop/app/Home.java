package esgi.java.advanced.ui.desktop.app;

import com.jfoenix.controls.JFXSnackbar;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Home  {

    public  static JFXSnackbar snackbar;
    @FXML private JFXTextField emailField;
    @FXML private JFXPasswordField passwordField;



    public static Scene scene() throws java.io.IOException{
        Parent pane = FXMLLoader.load(Home.class.getResource("Home.fxml"));
        snackbar=new JFXSnackbar((Pane) pane);
        return new Scene(pane);

    }



    @FXML
    public Scene  login() {
        try {
            Parent homePage = FXMLLoader.load(getClass().getResource( "wellcome.fxml"));
            if (this.emailField.getText().equals("root") && this.passwordField.getText().equals("root")) {
              //  snackbar.enqueue(new JFXSnackbar.SnackbarEvent(" vous ete connecter ", "success"));
                Main.window.setScene(new Scene(homePage, WellcomeController.WIDTH, WellcomeController.HEIGHT));

            } else
                snackbar.enqueue(new JFXSnackbar.SnackbarEvent(" vos identifiens son incorrect !", "error"));
                 //snackbar.show("il y'a une erreur d'authetifaication",3000);
                //AfficherAlerte.display("Erreur", "Les identifiants saisis sont incorrects.");
        } catch (IOException e) {
            e.printStackTrace();
            snackbar.enqueue(new JFXSnackbar.SnackbarEvent(" il y' une erreur  !", "error"));


        }
        return null;
    }






}
