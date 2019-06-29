package esgi.java.advanced.ui.desktop.app.Model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import esgi.java.advanced.ui.desktop.app.Paginator;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Model<T> extends RecursiveTreeObject <T> {

    private SimpleIntegerProperty id;
    private Paginator paginator;

    public Model(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public final SimpleIntegerProperty getId() {
        return id;
    }

    public final void setId(int id) {
        this.id.set(id);
    }

    public final Paginator getPaginator() {
        return paginator;
    }

    public final void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

}