package esgi.java.advanced.ui.desktop.app;

import javafx.application.Application;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Screen;
import javafx.stage.Stage;
import org.json.JSONArray;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class Main extends Application {


    public static Stage window;

    public static void main(String... args) throws IOException {

        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = Home.scene();
        primaryStage.setTitle("Spare Service Administartion");
        primaryStage.getIcons().add(new Image(getClass().getResource("spare.png").toExternalForm()));
        primaryStage.setScene(scene);
        primaryStage.show();
        window = primaryStage;

    }


}
