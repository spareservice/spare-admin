package esgi.java.advanced.ui.desktop.app.Model;

public class Employe extends Model <Employe> {


    public Employe(int id) {
        super(id);
    }
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;




    public Employe(int id, String firstname, String lastname, String email, String tel) {
        super(id);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = tel;

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


}
