package esgi.java.advanced.ui.desktop.app;

import com.jfoenix.controls.JFXTextField;
import esgi.java.advanced.ui.desktop.app.Model.Mission;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ServiceController implements Initializable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;

    @FXML private JFXTextField type;
    @FXML private JFXTextField nom;
    @FXML private TableView <Mission> tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            final JSONArray arr = JsonRead.call_me("http://localhost:3000/services");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                List <Mission> mission = new ArrayList <>();
                mission.add(new Mission(1, o.getString("typeService"),o.getString("nomService")));
                this.tableView.getItems().addAll(mission);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

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

    public void update(ActionEvent actionEvent) {

    }

    public void add(ActionEvent actionEvent) throws IOException {

        String type= this.type.getText();
        String nom= this.nom.getText();
        Mission mission = new Mission(1,type,nom);
        this.tableView.getItems().addAll(mission);
        String[] data = new String[]{type,nom};
        Httprequest.postRequest(new URL("http://localhost:3000/services/"+nom+"/"+type+"/ajoutService"),data);

    }
    public void delete(ActionEvent actionEvent) throws MalformedURLException {
        Mission person = tableView.getSelectionModel().getSelectedItem();
        Httprequest.deleteRequete(new URL("http://localhost:3000/services/"+person.getNom()+"/deleteService"));
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }

}

