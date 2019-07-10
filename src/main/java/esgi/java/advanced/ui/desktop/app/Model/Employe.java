package esgi.java.advanced.ui.desktop.app.Model;

import com.jfoenix.controls.JFXButton;

public class Employe extends Model <Employe> {
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private boolean status;
    private String statusString;


    public static JFXButton button;

    public Employe(int id, String firstname, String lastname, String email, String tel,JFXButton button,boolean status ) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = tel;
        this.button = button;
        this.status = status;

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setStatusString(String statusString) {
        this.statusString = statusString;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public JFXButton getButton() {
        return new JFXButton("Send Mail");
    }

    public void setButton(JFXButton button) {
        this.button = button;
    }
}
