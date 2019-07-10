package esgi.java.advanced.ui.desktop.app;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import esgi.java.advanced.ui.desktop.app.Model.Client;
import esgi.java.advanced.ui.desktop.app.Model.Employe;
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

public class Clientcontroller  implements Initializable {
    static final int WIDTH = 1000;
    static final int HEIGHT = 600;
    @FXML private TableView <Client> tableView;
    @FXML private JFXTextField firstname;
    @FXML private JFXTextField lastname;
    @FXML private JFXTextField email;
    @FXML private JFXTextField telephone;
    @FXML private JFXTextField passeword;





    @Override
    public void initialize(URL location, ResourceBundle resources) {


        try {

             final JSONArray arr = JsonRead.call_me("http://localhost:3000/client");
             for (int i = 0; i < arr.length(); i++) {
                 JSONObject o = arr.getJSONObject(i);
                 List <Client> client = new ArrayList <>();
                 client.add(new Client(1, o.getString("nom"), o.getString("prenom"), o.getString("email") ,o.getString("tel") ,o.getBoolean("confirmedToken"),new JFXButton("send mail")));
                 this.tableView.getItems().addAll(client);

             }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void adminPage(javafx.event.ActionEvent actionEvent) {
        try {
            Parent homePage = FXMLLoader.load(getClass().getResource( "wellcome.fxml"));
          //  ss = new JFXSnackbar((Pane) homePage);
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


    public void add(ActionEvent actionEvent) throws IOException {
        String firstname= this.firstname.getText();
        String lastname= this.lastname.getText();
        String email= this.email.getText();
        String telephone= this.telephone.getText();
        String passeword= this.passeword.getText();
        boolean status = false;

        Client client = new Client(1,firstname,lastname,email,telephone,status,new JFXButton("send"));

        if (Regex.emailRegex(email)==  true) {
            String[] data = new String[]{firstname,lastname,email,passeword,telephone};
            try {
                Httprequest.postRequest(new URL("http://localhost:3000/client/"+firstname+ "/" +lastname+ "/" +email+ "/" +passeword+ "/" +telephone+"/ajoutClient"),data);
                this.tableView.getItems().addAll(client);

            } catch (Exception e) {
                e.printStackTrace();
               // AfficherAlerte.display("Erreur", "Il y a eu une erreur");
            }

        }else {
            // ss.enqueue(new JFXSnackbar.SnackbarEvent(" vos identifiens son incorrect !", "error"));
            AfficherAlerte.display("Erreur", " il y'a une erreur dans l'un des champ ");
        }


    }

    public void delete(ActionEvent actionEvent) throws IOException {
        Client person = tableView.getSelectionModel().getSelectedItem();
        Httprequest.deleteRequete(new URL("http://localhost:3000/client/"+person.getEmail()+"/supprimerClient"));
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());

    }

    public void mail(ActionEvent actionEvent) throws IOException {
        Client person = tableView.getSelectionModel().getSelectedItem();
        System.out.println(person.getEmail());
        Httprequest.Get(new URL("http://localhost:3000/mail/"+person.getEmail()+"/validate/Client"));


    }
}
