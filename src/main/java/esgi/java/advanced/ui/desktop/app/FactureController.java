package esgi.java.advanced.ui.desktop.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class FactureController {


    public static final int WIDTH = 900;
    public static final int HEIGHT = 600;




    @FXML
    public void adminPage(javafx.event.ActionEvent actionEvent) {

        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "wellcome.fxml"));
            Main.window.setScene(new Scene(homePage, WellcomeController.WIDTH, WellcomeController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }


    }

    public void employeePage(ActionEvent actionEvent) throws IOException {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "employesController.fxml"));
            Main.window.setScene(new Scene(homePage, EmployesController.WIDTH, EmployesController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }

    }
    public void clientPage(ActionEvent actionEvent) throws IOException {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "clientcontroller.fxml"));
            Main.window.setScene(new Scene(homePage, Clientcontroller.WIDTH, Clientcontroller.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void servicePage(ActionEvent actionEvent) throws IOException {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "serviceController.fxml"));
            Main.window.setScene(new Scene(homePage, EmployesController.WIDTH, EmployesController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void FacturePage(ActionEvent actionEvent) {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "factureController.fxml"));
            Main.window.setScene(new Scene(homePage, FactureController.WIDTH, FactureController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }

    }

}
