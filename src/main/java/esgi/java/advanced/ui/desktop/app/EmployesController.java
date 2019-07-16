package esgi.java.advanced.ui.desktop.app;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import esgi.java.advanced.ui.desktop.app.Model.Employe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployesController implements Initializable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    @FXML private TableView <Employe> tableView;

    @FXML private JFXTextField firstname;
    @FXML private JFXTextField lastname;
    @FXML private JFXTextField email;
    @FXML private JFXTextField telephone;
    @FXML private JFXTextField passeword;
    @FXML private TableColumn <Employe,Button> sendMail;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            final JSONArray arr = JsonRead.call_me("http://localhost:3000/prestataire");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                List <Employe> emloye = new ArrayList <>();
                emloye.add(new Employe(1, o.getString("nom"), o.getString("prenom") ,o.getString("email"),o.getString("tel"),new JFXButton("send mail"),o.getBoolean("confirmedToken")));
                this.tableView.getItems().addAll(emloye);
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
            Main.window.setScene(new Scene(homePage, EmployesController.WIDTH, EmployesController.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void servicePage(ActionEvent actionEvent) throws IOException {
        try {

            Parent homePage = FXMLLoader.load(getClass().getResource( "serviceController.fxml"));
            Main.window.setScene(new Scene(homePage, Clientcontroller.WIDTH, Clientcontroller.HEIGHT));

        } catch (IOException e) {
            e.printStackTrace();
            AfficherAlerte.display("Erreur", "Il y a eu une erreur");
        }
    }
    public void facturePage(ActionEvent actionEvent) {
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
        JFXButton  button= new  JFXButton("button");
        boolean status = false;


        Employe employe = new Employe(1,firstname,lastname,email,telephone,new JFXButton("send"),status
        );
        this.tableView.getItems().addAll(employe);

        String[] data = new String[]{firstname,lastname,email,passeword,telephone};
        Httprequest.postRequest(new URL("http://localhost:3000/prestataire/"+firstname+"/"+lastname+"/"+email+"/"+passeword+"/"+telephone+"/0/ajoutPrestataire"),data);
    }
    public void delete(ActionEvent actionEvent) throws IOException {
        Employe person = tableView.getSelectionModel().getSelectedItem();
        Httprequest.deleteRequete(new URL("http://localhost:3000/prestataire/"+person.getEmail()+"/supprimerPrestataire"));
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
    }
    public void mail(ActionEvent actionEvent) throws IOException{
        Employe person = tableView.getSelectionModel().getSelectedItem();  System.out.println(person.getEmail());
        Httprequest.get(new URL("http://localhost:3000/mail/"+person.getEmail()+"/validate/prestatire"));


    }

}
