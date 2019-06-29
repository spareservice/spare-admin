package esgi.java.advanced.ui.desktop.app.Model;

public class Client  extends Model <Client> {


    public Client(int id) {
        super(id);
    }
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String passeword;

    public Client(int id, String firstname, String lastname, String email , String phone) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
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

}
