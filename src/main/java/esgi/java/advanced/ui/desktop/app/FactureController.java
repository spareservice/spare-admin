package esgi.java.advanced.ui.desktop.app;

import com.rollbar.api.payload.data.Client;
import esgi.java.advanced.ui.desktop.app.Model.Facture;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import org.asynchttpclient.*;
import org.json.JSONArray;
import org.json.JSONObject;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FactureController implements Initializable {

     static  int WIDTH = 900;
     static  int HEIGHT = 600;
    @FXML private TableView <Facture> tableView;

    public FactureController() throws FileNotFoundException {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            final JSONArray arr = JsonRead.call_me("http://localhost:3000/ALLfacture");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                List <Facture> facure = new ArrayList <>();
                facure.add(new Facture(1, o.getString("_id")));
                this.tableView.getItems().addAll(facure);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void adminPage() {

        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "wellcome.fxml"));
            Main.window.setScene(new Scene(homePage, WellcomeController.WIDTH, WellcomeController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }


    }
    public void employeePage(){
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "employesController.fxml"));
            Main.window.setScene(new Scene(homePage, EmployesController.WIDTH, EmployesController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }

    }
    public void clientPage()  {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "clientcontroller.fxml"));
            Main.window.setScene(new Scene(homePage, Clientcontroller.WIDTH, Clientcontroller.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void servicePage() {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "serviceController.fxml"));
            Main.window.setScene(new Scene(homePage, EmployesController.WIDTH, EmployesController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void facturePage() {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "factureController.fxml"));
            Main.window.setScene(new Scene(homePage, FactureController.WIDTH, FactureController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }

    }
    public void download() {
        try {
            Facture facture = tableView.getSelectionModel().getSelectedItem();
            if (facture != null){
               // Httprequest.get(new URL("http://localhost:3000/facture/"+facture.getSs()+""));
                DownloadFile.download("http://localhost:3000/facture/"+facture.getSs()+"");
            }else {
                System.out.println(" il ya une erreur");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send() {





    }
}
