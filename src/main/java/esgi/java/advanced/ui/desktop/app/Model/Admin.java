package esgi.java.advanced.ui.desktop.app.Model;

public class Admin extends Model <Admin> {

    private String firstname;
    private String lastname;
    private String email;

    public Admin(int id, String firstname, String lastname, String email) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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
}
