package esgi.java.advanced.ui.desktop.app.Model;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;



public class Client  extends Model <Client> {

    public Client(int id) {
        super(id);
    }
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean status;
    private String statusString;
    @FXML
    private static JFXButton button;

    public Client(int id, String firstname, String lastname, String email , String phone, boolean status,JFXButton button) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.button = button;


    }

    public String getStatusString() {
        return status ? "Valide" : "Invalide";
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public JFXButton getButton() {
        return new JFXButton("Send Mail");
    }

    public void setButton(JFXButton button) {
        this.button = button;
    }


    public void changeMail(ActionEvent actionEvent) {
        // button.setOnAction((event) -> {
        //  System.out.println("Button clicked");
        //  });
     //   button.getButtonType();

    }


}
