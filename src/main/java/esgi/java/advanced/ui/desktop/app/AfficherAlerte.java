package esgi.java.advanced.ui.desktop.app;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AfficherAlerte {

    public static void display(String title, String content){

        Stage box = new Stage();
        Scene scene;

        VBox layout = new VBox(15);
        scene = new Scene(layout, 250, 100);
        Label label = new Label(content);
        Button close = new Button("Ok");

        box.initModality(Modality.APPLICATION_MODAL);
        box.setTitle(title);

        layout.getChildren().addAll(label, close);
        layout.setAlignment(Pos.CENTER);

        close.setOnAction(e -> box.close());


        scene.getStylesheets().add(AfficherAlerte.class.getResource("style.css").toExternalForm());
        box.setScene(scene);
        box.setResizable(false);
        box.showAndWait();

    }


}
