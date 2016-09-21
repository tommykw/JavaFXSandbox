package ex;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by tommy on 2016/09/21.
 */
public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("App demo");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("app.fxml"));
            AnchorPane page = (AnchorPane)loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Error loading EventHandlerDemo");
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        launch(args);
    }
}
