package esgi.java.advanced.ui.desktop.app;

import com.jfoenix.controls.*;
import esgi.java.advanced.ui.desktop.app.Model.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WellcomeController implements Initializable {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    @FXML private JFXTextField firstname;
    @FXML private JFXTextField lastname;
    @FXML private JFXTextField email;


    @FXML private TableView<Admin> tableView;
    public static Stage window;



    public static Scene sceneWelcome() throws java.io.IOException{
        FlowPane pane = FXMLLoader.load(Home.class.getResource("wellcome.fxml"));
        return new Scene(pane);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            final JSONArray arr = JsonRead.call_me("http://localhost:3000/Admin");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                List<Admin> admins = new ArrayList <>();
                admins.add(new Admin(1, o.getString("nom"), o.getString("prenom"), o.getString("email")));
                this.tableView.getItems().addAll(admins);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    public void adminPage(ActionEvent actionEvent) {

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

    public void delete(ActionEvent actionEvent) throws MalformedURLException {
        Admin person = tableView.getSelectionModel().getSelectedItem();
        Httprequest.deleteRequete(new URL("http://localhost:3000/"+person.getEmail()+"/supprimerAdmin"));
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());

    }
    public void update(ActionEvent actionEvent) {




    }

    public void add(ActionEvent actionEvent) throws IOException {

         String firstname= this.firstname.getText();
         String lastname= this.lastname.getText();
         String email= this.email.getText();
         Admin admin = new Admin(1,firstname,lastname,email);

         if (Regex.emailRegex(email)==  true) {
             this.tableView.getItems().addAll(admin);
             String[] data = new String[]{firstname,lastname,email};
             Httprequest.postRequest(new URL("http://localhost:3000/"+firstname+"/"+lastname+"/"+email+"/addAdmin"),data);
         }else {
             AfficherAlerte.display("Erreur", "votre email n'est pas correct ");
         }


    }

    public void change(TableColumn.CellEditEvent<Admin,String> cellEditEvent) {
        Admin person = tableView.getSelectionModel().getSelectedItem();
        String data= person.getFirstname();
        System.out.println(data);
    }
}
