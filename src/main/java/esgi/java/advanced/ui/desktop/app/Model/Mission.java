package esgi.java.advanced.ui.desktop.app.Model;

public class Mission  extends Model <Admin>{

    private String nom;
    private String type;


    public Mission(int id, String nom, String type) {
        super(id);
        this.nom = nom;
        this.type = type;

    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}

