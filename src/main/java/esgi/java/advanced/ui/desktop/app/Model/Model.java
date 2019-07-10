package esgi.java.advanced.ui.desktop.app.Model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Model<T> extends RecursiveTreeObject <T> {

    private SimpleIntegerProperty id;


    public Model(int id) {
        this.id = new SimpleIntegerProperty(id);
    }


    public Model() {

    }
}