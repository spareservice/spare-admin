package esgi.java.advanced.ui.desktop.app.Model;

public class  Facture extends Model <Facture> {

    private String ss;


    public Facture( int id ,String ss) {
        super(id);
        this.ss = ss;
    }



    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getSs() {
        return ss;
    }



}
