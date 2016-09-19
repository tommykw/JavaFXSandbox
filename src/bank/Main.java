package bank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by tommy on 2016/09/19.
 */
public class Main extends Application {
    private static String ui = "ui.fxml";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(ui));
        Scene frame = new Scene(root);
        primaryStage.isResizable();
        primaryStage.setTitle("bank");
        primaryStage.setScene(frame);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
