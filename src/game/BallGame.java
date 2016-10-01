package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by tommy on 2016/10/02.
 */
public class BallGame extends Application {
    private static String VIEW_FXML = "view.fxml";
    private static String CSS_FILE = "style.css";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(VIEW_FXML));
        Scene scene = SceneBuilder
                .create()
                .root(root)
                .width(500)
                .height(530)
                .fill(Color.GRAY)
                .build();
        scene.getStylesheets().add(CSS_FILE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("title");
        primaryStage.show();
    }

    public static void main(String... args) {
        launch(args);
    }
}
